package com.coderscampus;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		//creates local variable with the number of users
		int numberOfUsers = UserService.determineNumberOfUsers();
		
		//creates local array with all the users
		User[] users = UserService.userInformation();
		
		Scanner scanner = new Scanner(System.in);
		
		int loginAttempts = 0;
		boolean loginSuccessful = false;
		int maximumLoginAttempts = 5;
		
		while (loginAttempts < maximumLoginAttempts) {
			
			System.out.println("Enter your email: ");
			String inputtedUsername = scanner.nextLine();
			String lowerCaseInputtedUsername = inputtedUsername.toLowerCase();
			
			System.out.println("Enter your password: ");
			String inputtedPassword = scanner.nextLine();
			
			loginSuccessful = UserService.checkUserInformation(numberOfUsers, lowerCaseInputtedUsername, inputtedPassword);

			if (loginSuccessful == false ) {
				loginAttempts++;	
				if (loginAttempts < maximumLoginAttempts){
					System.out.println("Invalid login, please try again");
				}
			} else {
				//System.out.println("Welcome " + users[index].getName()); //need to return index for this to work
				break;
			}
		}
		if (loginSuccessful == false) {
			System.out.println("Invalid Login");
			System.out.println("Maximum login attempts reached. Have a nice day.");
		}
		scanner.close();
		
	}
}
