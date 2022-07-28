package com.iu.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class RegionsDAO {
	
	//3. Regions에 데이터 추가
	public int setRegion(RegionsDTO regionsDTO) throws Exception{
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 생성
		String sql ="INSERT INTO REGIONS VALUES(?,?)";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 세팅
		st.setInt(1, regionsDTO.getRegions_id());
		st.setString(2, regionsDTO.getRegions_name());
		
		//5. 최종 전송 후 결과 처리
		//ResultSet은 출력하는 클래스기때문에 INSERT(추가)할때는 안써도 됌 하지만 추가됐는지 안됐는지 알아보기위해 result변수를 선언하는것임
		int result = st.executeUpdate();
		
		
		//6. 자원해제
		//여기서 ResultSet을 안썼기때문에 자원해제를 안해도 돼서 DBConnector에 새로운 메서드 선언!
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//2. Regions에서 하나의 결과(row)
	public RegionsDTO getDatail(int region_id) throws Exception{
		RegionsDTO regionsDTO = null;
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL 문 작성
		//String sql = "SELECT * FROM REGIONS WHERE REGION_ID ="+region_id; 이렇게 절대 하면 안됀다! 해킹당함
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID =?";//변수로 들어갈 부분은 ?로 처리한다
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?의 값을 세팅
		// WHERE NUM BETEEN ?(1번째) AND ?(2번째);
		// st.setInt(1, 변수명);
		// st.setInt(2, 변수명);
		st.setInt(1, region_id);//몇번째의 인덱스번호(오라클은 1번부터)
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			regionsDTO = new RegionsDTO();
			regionsDTO.setRegions_id(rs.getInt("region_id"));;//오라클은 1번부터! 컬럼명이 더 편하다, 인덱스번호는 생각을 해야한다
			regionsDTO.setRegions_name(rs.getString("region_name"));
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		return regionsDTO;
		
	}

	//1. Regions 의 모든 데이터 가져오기
	public ArrayList<RegionsDTO> getList() throws Exception {
		ArrayList<RegionsDTO> ar = new ArrayList<>();
		
		//1. DB 연결 DBConnertor에 이미 연결하는 메서드 만듬
		Connection con = DBConnector.getConnection();
		
		//2. Query 문 작성
		String sql ="SELECT * FROM REGIONS";//자바에선 ;를 생략해도 된다.
		
		//3. Query 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);//쿼리문을 미리 보내면 데이터베이스에서 준비중

		//4.
		
		//5. 최종 전송 후 결과를 처리 (데이터를 받아서 출력을 하든 뭘 하든 한다)
		ResultSet rs = st.executeQuery();
		
		// rs.next();한줄 읽어서 내려오는 방식 토큰과 비슷한 형식 그래서 next의 타입이 boolean이다
		while(rs.next()) {
			RegionsDTO regionsDTO = new RegionsDTO();
			regionsDTO.setRegions_id(rs.getInt("region_id"));//스트링타입의 컬럼라벨은 컬럼명쓰기
			regionsDTO.setRegions_name(rs.getString("region_name"));
			ar.add(regionsDTO);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		return ar;
		
	}
	
}
