package com.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.dao.AddressDao;
import com.model.Address;

/**
*
* @author Yvan GAKUBA Created On: March 19, 2018 
* Description: Address Loader
* This class read all the state and city of US from a notepad and load them to the database
* It is a helper class run once.
*/ 
public class AddressLoader {
	private static final String fileName = "C:\\Users\\Yvan GAKUBA\\eclipse-workspace\\exercise\\WebContent\\ajax\\cities.txt";

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String sCurrentLine;
			String state = "";	
			AddressDao adao=new AddressDao();
			Address ad=new Address();
			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.contains("@")) {
					state = sCurrentLine;
				} else {
					ad.setState(state);
					ad.setCity(sCurrentLine.split("@")[1]);
					System.out.println(adao.insert(ad));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
