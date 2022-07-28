package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class EmployeesDAO {

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
