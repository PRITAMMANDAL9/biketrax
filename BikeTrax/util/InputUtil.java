package com.BikeTrax.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import com.BikeTrax.dto.BikeDto;
import com.BikeTrax.dto.CoustomerDto;
import com.BikeTrax.enums.Brand;
import com.BikeTrax.enums.Gender;
import com.BikeTrax.enums.Model;
import com.BikeTrax.enums.Type;

public class InputUtil {

	public static int acceptMenuOption(Scanner scanner) {
		System.out.println("Press 1 to add new coustomer details.");
		System.out.println("Press 2 to fetch coustomer details.");
		System.out.println("Press 3 to update bike details of owner.");
		System.out.println("Press 4 to delete coustomer details.");
		System.out.println("Press 5 to fetch bike details.");
		System.out.println("Press 6 to add new bike details.");
		System.out.println("Press 7 to delete bike details.");

		int menuOption = scanner.nextInt();
		if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4 || menuOption == 5
				|| menuOption == 6 || menuOption == 7) {
			return menuOption;
		} else {
			System.out.println("Enter a vaild option..");
			return acceptMenuOption(scanner);
		}
	}

	public static boolean wantToContinue(Scanner scanner) {
		System.out.println("Press Y to continue and N to exit.");
		char choice = scanner.next().toUpperCase().charAt(0);
		return 'Y' == choice;
	}

	public static CoustomerDto acceptCoustomerDetailsToSave(Scanner scanner) {
		System.out.println("Enter id of coustomer:");
		int id = scanner.nextInt();
		System.out.println("Enter first name of coustomer:");
		String firstName = scanner.next();
		System.out.println("Enter last name of coustomer:");
		String lastName = scanner.next();
		System.out.println("Enter gender of coustomerr:" + Arrays.asList(Gender.values()).toString());
		String gender = scanner.next().toUpperCase();
		System.out.println("Enter city of coustomer:");
		String city = scanner.next();
		System.out.println("Enter state of coustomer:");
		String state = scanner.next();
		System.out.println("Enter mobile number of coustomer:");
		String mobileNumber = scanner.next();
		System.out.println("Enter email id of coustomer:");
		String emailId = scanner.next();

		try {
			CoustomerDto coustomerDto = new CoustomerDto();
			coustomerDto.setCoustomerId(id);
			coustomerDto.setFirstName(firstName);
			coustomerDto.setLastName(lastName);
			coustomerDto.setGender(Gender.valueOf(gender));
			coustomerDto.setCity(city);
			coustomerDto.setState(state);
			coustomerDto.setMobileNumber(mobileNumber);
			coustomerDto.setEmailId(emailId);
			return coustomerDto;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return acceptCoustomerDetailsToSave(scanner);
		}
	}

	public static BikeDto acceptBikeDetailsToSave(Scanner scanner) {
		BikeDto bikeDto = new BikeDto();

		// Accept vehicle type safely
		while (true) {
			try {
				System.out.println("Enter the Vehical Type " + Arrays.toString(Type.values()) + ":");
				String vehicalType = scanner.next().toUpperCase();
				bikeDto.setVehicalType(Type.valueOf(vehicalType));
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid vehicle type. Try again.");
			}
		}

		// Registration ID
		System.out.println("Enter registration Id of the vehical:");
		bikeDto.setRegistrationId(scanner.nextInt());

		// Purchase Date
		while (true) {
			System.out.println("Enter Vehical Purches Date (dd-MM-yyyy):");
			String date = scanner.next();
			try {
				bikeDto.setBikePurchesDate(convertStringToDate(date));
				break;
			} catch (Exception e) {
				System.out.println("Invalid date format. Try again (dd-MM-yyyy).");
			}
		}

		// Accept model safely
		while (true) {
			try {
				System.out.println("Enter model of the vehical " + Arrays.toString(Model.values()) + ":");
				String model = scanner.next().toUpperCase();
				bikeDto.setModel(Model.valueOf(model));
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid model. Try again.");
			}
		}

		while (true) {
			try {
				System.out.println("Enter vehical brand " + Arrays.toString(Brand.values()) + ":");
				String brand = scanner.next().toUpperCase();
				bikeDto.setBrand(Brand.valueOf(brand));
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid brand. Try again.");
			}
		}

		// Color
		System.out.println("Enter Vehical color:");
		bikeDto.setColor(scanner.next());

		// Manufacturing Year
		while (true) {
			System.out.println("Enter Vehical manufacturing date (dd-MM-yyyy):");
			String date = scanner.next();
			try {
				bikeDto.setManufacturingYear(convertStringToDate(date));
				break;
			} catch (Exception e) {
				System.out.println("Invalid date format. Try again (dd-MM-yyyy).");
			}
		}

		return bikeDto;
	}

	public static Model accepBikeDetailsToUpdate(Scanner scanner) {
		System.out.println("Enter What you want to update in the bike details:");
		return Model.valueOf(scanner.next());
	}

	public static int acceptCoustomerIdToOperate(Scanner scanner) {
		System.out.println("Enter coustomer id of owner:");
		return scanner.nextInt();
	}

	public static int acceptRegistrationIdToOperate(Scanner scanner) {
		System.out.println("Enter bike registration id :");
		return scanner.nextInt();
	}

	public static LocalDate convertStringToDate(String stringDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(stringDate, format);
	}
}
