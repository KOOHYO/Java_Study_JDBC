package com.iu.test;

import com.iu.countries.CountriesDAO;
import com.iu.regions.RegionsDAO;
import com.iu.regions.RegionsDTO;
import com.iu.regions.RegionsView;
import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		RegionsDAO regionsDAO = new RegionsDAO();
		CountriesDAO countriesDAO = new CountriesDAO();
		RegionsView regionsView = new RegionsView();
		RegionsDTO regionsDTO = new RegionsDTO();
		try {
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
