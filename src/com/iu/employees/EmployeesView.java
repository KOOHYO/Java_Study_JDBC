package com.iu.employees;

import java.util.ArrayList;

public class EmployeesView {

	public void view(EmployeesDTO employeesDTO) {
		System.out.println("EMPLOYEE_ID\tFIRST_NAME\tLAST_NAME\tEMAIL\tPHONE_NUMBER\tHIRE_DATE\tJOB_ID\tSALARY\tCOMMISSION_PCT\tMANAGER_ID\tDEPARTMENT_ID");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print(employeesDTO.getEmployee_id()+"\t"+"\t");
		System.out.print(employeesDTO.getFirst_name()+"\t");
		System.out.print("  "+employeesDTO.getLast_name()+"\t");
		System.out.print(employeesDTO.getEmail()+"\t"+"\t");
		System.out.print(employeesDTO.getPhone_number()+"\t"+"\t");
		System.out.print(employeesDTO.getHire_date()+"\t"+"\t");
		System.out.print(employeesDTO.getJob_id()+"\t"+"\t");
		System.out.print(employeesDTO.getSalary()+"\t"+"\t");
		System.out.print(employeesDTO.getCommission_pct()+"\t"+"\t");
		System.out.print(employeesDTO.getManager_id()+"\t"+"\t");
		System.out.println(employeesDTO.getDepartment_id());
	}
	
	public void view(ArrayList<EmployeesDTO> ar) {
		System.out.println("EMPLOYEE_ID\tFIRST_NAME\tLAST_NAME\tEMAIL\tPHONE_NUMBER\tHIRE_DATE\tJOB_ID\tSALARY\tCOMMISSION_PCT\tMANAGER_ID\tDEPARTMENT_ID");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(EmployeesDTO employeesDTO : ar) {
			System.out.print(employeesDTO.getEmployee_id()+"\t"+"\t");
			System.out.print(employeesDTO.getFirst_name()+"\t");
			System.out.print("  "+employeesDTO.getLast_name()+"\t");
			System.out.print(employeesDTO.getEmail()+"\t"+"\t");
			System.out.print(employeesDTO.getPhone_number()+"\t"+"\t");
			System.out.print(employeesDTO.getHire_date()+"\t"+"\t");
			System.out.print(employeesDTO.getJob_id()+"\t"+"\t");
			System.out.print(employeesDTO.getSalary()+"\t"+"\t");
			System.out.print(employeesDTO.getCommission_pct()+"\t"+"\t");
			System.out.print(employeesDTO.getManager_id()+"\t"+"\t");
			System.out.println(employeesDTO.getDepartment_id());
		}
		
	}
	
}
