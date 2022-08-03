package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class CountriesDAO {

	//setCountry
	public int setCountry(CountriesDTO countriesDTO)throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 작성
		String sql = "INSERT INTO COUNTRIES VALUES (?, ?, ?)";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setString(1, countriesDTO.getCountry_id());
		st.setString(2, countriesDTO.getCountry_name());
		st.setInt(3, countriesDTO.getRegion_id());
		
		//5. 최종전송
		//ResultSet은 출력하는 클래스기때문에 INSERT(추가)할때는 안써도 됌 하지만 추가됐는지 안됐는지 알아보기위해 result변수를 선언하는것임
		int result = st.executeUpdate();
		
		//6. 자원해제
		//여기서 ResultSet을 안썼기때문에 자원해제를 안해도 돼서 DBConnector에 새로운 메서드 선언!
		DBConnector.disConnect(st, con);
		return result;
		
	}
	
	public CountriesDTO getDatail(String country_id) throws Exception {
		CountriesDTO countriesDTO = null;
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		//st
		st.setString(1, country_id);//물음표 앞뒤로 홑따옴표를 넣어줌! 그래서 물음표 앞뒤에 홑따옴표를 안해도 됨
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id(rs.getString("country_id"));
			countriesDTO.setCountry_name(rs.getString("country_name"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
		}
		
		//6. 자원 해제
		DBConnector.disConnect(rs, st, con);
		return countriesDTO;
		
	}
	
	public ArrayList<CountriesDTO> getList(String search) throws Exception {
		ArrayList<CountriesDTO> ar = new ArrayList<>();
		//1. DB와 연결
		Connection con = DBConnector.getConnection();
		//2. sql 문 작성
		//String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_NAME LIKE '%'a'%'"; 오라클에서 이렇게쓰면 에러 왜냐하면 a사이에 홑따운표가 앞뒤로 생기기때문!
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_NAME LIKE ?";
		//String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_NAME LIKE '%'||?||'%'; 오라클에서는 문자열로 연결해주는 연산자 ||
		
		//3. sql 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		// ? 있으면 값 세팅
		st.setString(1, "%"+search+"%");
		
		//4. 최종전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			CountriesDTO countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id(rs.getString("country_id"));
			countriesDTO.setCountry_name(rs.getString("country_name"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
			ar.add(countriesDTO);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		return ar;
		
	}
	
}
