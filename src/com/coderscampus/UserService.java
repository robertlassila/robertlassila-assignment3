package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;

public class UserService {

	static String filepath = "data.txt";
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
	
	//this is creating the user array with the number of users
	public static User[] users = new User[UserService.determineNumberOfUsers()];
	
	
	//this method reads user information, splits it, stores it to a user, then stores each user to the User[]
	public static User[] userInformation() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))){
			String line;
			int index = 0;
			
			while ((line = br.readLine()) != null) {
				
				String[] userDetails = line.split(",");
				
				String username = userDetails[0];
				String password = userDetails[1];
				String name = userDetails[2];
				
				users[index] = new User(username, password, name);
				index++;
			}
		} catch (Exception e) {
			System.out.println("Error reading file; " + e.getMessage());
		}
		return users;
	}
	
	
}
