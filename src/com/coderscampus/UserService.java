package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;

public class UserService {

	public static int determineNumberOfUsers() {
		String filepath = "data.txt";
		int numberOfUsers = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			while (br.readLine() != null) {
				numberOfUsers++;
			}
		} catch (Exception e) {
			System.out.println("Error reading file; " + e.getMessage());
			return numberOfUsers;
		}
		return numberOfUsers; 
	}
	
}
