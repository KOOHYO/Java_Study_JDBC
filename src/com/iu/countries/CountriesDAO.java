package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class CountriesDAO {

	public CountriesDTO getDatail(String country_id) throws Exception {
		CountriesDTO countriesDTO = null;
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		//st
		st.setString(1, country_id);
		
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
	
	public ArrayList<CountriesDTO> getList() throws Exception {
		ArrayList<CountriesDTO> ar = new ArrayList<>();
		//1. DB와 연결
		Connection con = DBConnector.getConnection();
		//2. sql 문 작성
		String sql = "SELECT * FROM COUNTRIES";
		//3. sql 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
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
