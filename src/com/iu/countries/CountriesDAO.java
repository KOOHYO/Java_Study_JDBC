package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnector;

public class CountriesDAO {

	public void getDatail(String country_id) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		//st
		st.setString(1, country_id);
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			String counId = rs.getNString("country_id");
			String counName = rs.getString("country_name");
			int regId = rs.getInt("region_id");
			System.out.println(counId);
			System.out.println(regId);
			System.out.println(counName);
		}
		
		//6. 자원 해제
		DBConnector.disConnect(rs, st, con);
		
	}
	
	public void getList() throws Exception {
		//1. DB와 연결
		Connection con = DBConnector.getConnection();
		//2. sql 문 작성
		String sql = "SELECT * FROM COUNTRIES";
		//3. sql 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. 최종전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String countryId = rs.getString("Country_id");
			String countryName = rs.getString("Country_name");
			int regionId = rs.getInt("Region_id");
			System.out.println(countryId);
			System.out.println(countryName);
			System.out.println(regionId);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
	}
	
}
