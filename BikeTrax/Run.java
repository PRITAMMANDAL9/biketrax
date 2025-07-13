package com.BikeTrax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.BikeTrax.dto.BikeDto;
import com.BikeTrax.dto.CoustomerDto;
import com.BikeTrax.enums.Model;
import com.BikeTrax.service.BikeService;
import com.BikeTrax.service.CoustomerService;
import com.BikeTrax.service.imp.BikeServiceImp;
import com.BikeTrax.service.imp.CoustomerServiceImp;
import com.BikeTrax.util.InputUtil;

public class Run {

	public static void main(String[] args) {
		Run run = new Run();
		run.run();
	}

	public void run() {
		CoustomerService coustomerService = new CoustomerServiceImp();
		BikeService bikeService = new BikeServiceImp();
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Welcome to Biketrax");
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption) {
				case 1:
					CoustomerDto coustomerDto = InputUtil.acceptCoustomerDetailsToSave(scanner);
					BikeDto bikeDto = InputUtil.acceptBikeDetailsToSave(scanner);
					List<BikeDto> bikeDtoList = new ArrayList<>();
					bikeDtoList.add(bikeDto);
					coustomerDto.setBikeDtoList(bikeDtoList);
					coustomerService.saveCoustomer(coustomerDto);
					System.out.println("Coustomer details has been saved successfully.");
					break;
				case 2:
					int coustomerId = InputUtil.acceptCoustomerIdToOperate(scanner);
					coustomerDto = coustomerService.findCoustomer(coustomerId);
					System.out.println("Coustomer details  with bke details has been fetched successfully.");
					System.out.println(coustomerDto);
					coustomerDto = coustomerService.findCoustomewithoutBike(coustomerId);
					System.out.println("Owner without bike details has been fetched successfully.");
					System.out.println(coustomerDto);
					break;
				case 3:
					coustomerId = InputUtil.acceptCoustomerIdToOperate(scanner);
					int registationId = InputUtil.acceptRegistrationIdToOperate(scanner);
					Model model = InputUtil.accepBikeDetailsToUpdate(scanner);
					coustomerService.updateBikeDetails(coustomerId, registationId, model);
					System.out.println("Bike details of owner have been updated successfully.");
					break;
				case 4:
					coustomerId = InputUtil.acceptCoustomerIdToOperate(scanner);
					coustomerService.deleteCoustomer(coustomerId);
					System.out.println("Coustomer has been deleted successfully.");
					break;
				case 5:
					registationId = InputUtil.acceptRegistrationIdToOperate(scanner);
					bikeDto = bikeService.findBike(registationId);
					System.out.println("Bike details has been fetched successfully.");
					System.out.println(bikeDto);
					break;
				case 6:
					coustomerId = InputUtil.acceptCoustomerIdToOperate(scanner);
					bikeDto = InputUtil.acceptBikeDetailsToSave(scanner);
					coustomerService.addBike(coustomerId, bikeDto);
					System.out.println("Bike details has been added successfully.");
					break;
				case 7:
					coustomerId = InputUtil.acceptCoustomerIdToOperate(scanner);
					registationId = InputUtil.acceptRegistrationIdToOperate(scanner);
					coustomerService.removeBike(coustomerId, registationId);
					System.out.println("Bike details has been deleted successfully.");
					break;
				default:
					System.out.println("Invalid option entered.");
				}
			} while (InputUtil.wantToContinue(scanner));
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

}
