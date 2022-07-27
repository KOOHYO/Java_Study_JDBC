package com.iu.regions;

import java.util.ArrayList;

public class RegionsView {

	public void view(ArrayList<RegionsDTO> ar) {
		for(RegionsDTO regionsDTO : ar) {
			System.out.println(regionsDTO.getRegion_id()+"\t\t");
			System.out.println(regionsDTO.getRegion_name()+"\t\t");
		}
		
	}
	
	public void view(RegionsDTO regionsDTO) {
		
		System.out.println("Region_ID\tRegion_Name");
		System.out.println("------------------------------------");
		System.out.print(regionsDTO.getRegion_id()+"\t\t");
		System.out.println(regionsDTO.getRegion_name()+"\t");
		
	}
	
}