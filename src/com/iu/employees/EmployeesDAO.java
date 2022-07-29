package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class EmployeesDAO {

	public void getJoinTest(EmployeesDTO employeesDTO) throws Exception{
		
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		//DB에는 \r\n이 없으니 빼고 띄어쓰기( )한번 해야한다
		//2. SQL문 생성
		String sql = "SELECT E.LAST_NAME, E.SALARY, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "    INNER JOIN "
				+ "    DEPARTMENTS D "
				+ "    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID "
				+ "WHERE E.EMPLOYEE_ID = 178";//마지막 값은 ?로 해야한다
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 세팅
		st.setInt(1, employeesDTO.getEmployee_id());
		
		//5. 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeesDTO = new EmployeesDTO();
			employeesDTO.setLast_name(rs.getString("LAST_NAME"));
			employeesDTO.setSalary(rs.getDouble("SALARY"));
			
			
		}
		
		//6. 연결 해제
		DBConnector.disConnect(rs, st, con);//클래스 메서드 
		
	}
	
	public void getSalaryInfo() throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "SELECT SUM(SALARY), AVG(SALARY), MAX(SALARY) FROM EMPLOYEES";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		//ArrayList<Object> = new ArrayList();로 선언해서 리턴하거나
		//DTO클래스를 하나 더 만든다
		if(rs.next()) {
			int sum = rs.getInt("SUM(SALARY)");//컬럼명 똑같이쓰기 주의!!
			double avg = rs.getDouble(2);
			int max = rs.getInt("MAX(SALARY)");
			System.out.println(sum);
			System.out.println(avg);
			System.out.println(max);
		}
		
		DBConnector.disConnect(rs, st, con);
	}
	
	public EmployeesDTO getDatail(int employee_id) throws Exception{
		EmployeesDTO employeesDTO = null;
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		//String sql = "SELECT SUM(SALARY), AVG(SALARY) FROM EMPLOYEES";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, employee_id);
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			
			employeesDTO = new EmployeesDTO();
			employeesDTO.setEmployee_id(rs.getInt("employee_id"));
			employeesDTO.setFirst_name(rs.getString("first_name"));
			employeesDTO.setLast_name(rs.getString("last_name"));
			employeesDTO.setEmail(rs.getString("email"));
			employeesDTO.setPhone_number(rs.getString("phone_number"));
			employeesDTO.setHire_date(rs.getDate("hire_date"));
			employeesDTO.setJob_id(rs.getString("job_id"));
			employeesDTO.setSalary(rs.getDouble("salary"));
			employeesDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeesDTO.setManager_id(rs.getInt("manager_id"));
			employeesDTO.setDepartment_id(rs.getInt("department_id"));
			
		}
		
		DBConnector.disConnect(rs, st, con);
		return employeesDTO;
		
	}
	
	public ArrayList<EmployeesDTO> getList() throws Exception {
		ArrayList<EmployeesDTO> ar = new ArrayList<>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM EMPLOYEES";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setEmployee_id(rs.getInt("employee_id"));
			employeesDTO.setFirst_name(rs.getString("first_name"));
			employeesDTO.setLast_name(rs.getString("last_name"));
			employeesDTO.setEmail(rs.getString("email"));
			employeesDTO.setPhone_number(rs.getString("phone_number"));
			employeesDTO.setHire_date(rs.getDate("hire_date"));
			employeesDTO.setJob_id(rs.getString("job_id"));
			employeesDTO.setSalary(rs.getDouble("salary"));
			employeesDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeesDTO.setManager_id(rs.getInt("manager_id"));
			employeesDTO.setDepartment_id(rs.getInt("department_id"));
			ar.add(employeesDTO);
			
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
}
