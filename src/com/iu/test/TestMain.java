package com.iu.test;

import java.util.ArrayList;

import com.iu.countries.CountriesDAO;
import com.iu.countries.CountriesDTO;
import com.iu.countries.CountriesView;
import com.iu.employees.EmployeesDAO;
import com.iu.employees.EmployeesDTO;
import com.iu.employees.EmployeesView;
import com.iu.regions.RegionsDAO;
import com.iu.regions.RegionsDTO;
import com.iu.regions.RegionsView;
import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<RegionsDTO> ar = new ArrayList<>();
		ArrayList<CountriesDTO> ar2 = new ArrayList<>();
		ArrayList<EmployeesDTO> ar3 = new ArrayList<>();
		
		RegionsDAO regionsDAO = new RegionsDAO();
		RegionsDTO regionsDTO = new RegionsDTO();
		RegionsView regionsView = new RegionsView();
		
		CountriesDAO countriesDAO = new CountriesDAO();
		CountriesDTO countriesDTO = new CountriesDTO();
		CountriesView countriesView = new CountriesView();
		
		EmployeesDAO employeesDAO = new EmployeesDAO();
		EmployeesDTO employeesDTO = new EmployeesDTO();
		EmployeesView employeesView = new EmployeesView();
		
		try {
			countriesDTO.setCountry_id("KN");
			countriesDTO.setCountry_name("Nolth Korea");
			countriesDTO.setRegion_id(3);
			int result = countriesDAO.setCountry(countriesDTO);
			if(result > 0) {
				System.out.println("성공!");//추가 성공!
			}else {
				System.out.println("실패!");
			}
			
//			regionsDTO.setRegions_name("Nolth America");
//			regionsDTO.setRegions_id(6);
//			int result = regionsDAO.setRegion(regionsDTO);//여기서 DB를 가면 추가가 되어있다!
//			
//			if(result > 0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
			
//			employeesDAO.getSalaryInfo();
			
//			employeesDTO = employeesDAO.getDatail(100);
//			employeesView.view(employeesDTO);
			
//			ar3 = employeesDAO.getList(); 
//			employeesView.view(ar3);
			
//			ar2 = countriesDAO.getList();
//			countriesView.view(ar2);
			
			//countriesDTO= countriesDAO.getDatail("AR");
			//countriesView.view(countriesDTO);
			
			//ar = regionsDAO.getList();
			//regionsView.view(ar);
			
			//regionsDTO = regionsDAO.getDatail(2);
			//regionsView.view(regionsDTO);
			
			//regionsDAO.getList();
			//countriesDAO.getDatail("AR");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
