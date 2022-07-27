package com.iu.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class RegionsDAO {
	
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
			regionsDTO.setRegion_id(rs.getInt("region_id"));;//오라클은 1번부터! 컬럼명이 더 편하다, 인덱스번호는 생각을 해야한다
			regionsDTO.setRegion_name(rs.getString("region_name"));
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
			regionsDTO.setRegion_id(rs.getInt("region_id"));//스트링타입의 컬럼라벨은 컬럼명쓰기
			regionsDTO.setRegion_name(rs.getString("region_name"));
			ar.add(regionsDTO);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		return ar;
		
	}
	
}
