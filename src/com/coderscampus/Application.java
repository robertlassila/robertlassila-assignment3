package com.coderscampus;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		//creates local variable with the number of users
		int numberOfUsers = UserService.determineNumberOfUsers();
		//System.out.println(numberOfUsers);
		
		//creates local array with all the users
		User[] users = UserService.userInformation();
		//System.out.println(users[1].getPassword());
		
		Scanner scanner = new Scanner(System.in);
		
		int loginAttempts = 0;
		boolean loginSuccessful = false;
		
		while (loginAttempts < 5) {
			
			System.out.println("Enter your email: ");
			String inputtedUsername = scanner.nextLine();
			String lowerCaseInputtedUsername = inputtedUsername.toLowerCase();
			
			System.out.println("Enter your password: ");
			String inputtedPassword = scanner.nextLine();
			
			
			int index = 0;
			while (index < numberOfUsers) {
				String checkedUsername = users[index].getUsername();
				String lowerCaseCheckedUsername = checkedUsername.toLowerCase();
				String checkedPassword = users[index].getPassword();
				
				if (lowerCaseInputtedUsername.equals(lowerCaseCheckedUsername)) {
					if (inputtedPassword.equals(checkedPassword)) {
						System.out.println("Welcome " + users[index].getName());
						loginSuccessful = true;
						break;
					} else {
						index++;
					}
				} else {
					index++;
				}
			}
			if (loginSuccessful == false ) {
				loginAttempts++;	
				if (loginAttempts < 5){
					System.out.println("Invalid login, please try again");
				}
			} else {
				break;
			}
		}
		if (loginSuccessful == false) {
			System.out.println("Invalid Login");
			System.out.println("Maximum login attempts reached.");
		}
		scanner.close();
		
		
	}

}
