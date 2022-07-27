package com.iu.test;

import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		try {
			DBConnector.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
