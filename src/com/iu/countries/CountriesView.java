package com.iu.countries;

import java.util.ArrayList;

public class CountriesView {

	public void view(CountriesDTO countriesDTO) {
		System.out.println("Country_ID\tCountry_Name\tRegion_ID");
		System.out.println("------------------------------------------");
		System.out.print(countriesDTO.getCountry_id()+"\t\t ");
		System.out.print(countriesDTO.getCountry_name()+"\t    ");
		System.out.println(countriesDTO.getRegion_id());
	}
	
	public void view(ArrayList<CountriesDTO> ar) {
		System.out.println("Country_ID\t\t\tCountry_Name\t\t\tRegion_ID");
		System.out.println("-------------------------------------------------------------------------");
		for(CountriesDTO countriesDTO : ar) {
			System.out.print(countriesDTO.getCountry_id()+"\t\t\t\t ");
			System.out.print(countriesDTO.getCountry_name()+"\t\t\t");
			System.out.println(countriesDTO.getRegion_id());
		}
		
	}
	
}
