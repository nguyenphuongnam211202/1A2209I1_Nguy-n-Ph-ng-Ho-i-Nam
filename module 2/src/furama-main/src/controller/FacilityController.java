package controller;

import service.FacilityService;
import service.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    private  static FacilityService facilityService ;

    public static void displayFacilityManagement() {
        boolean flag = true;
        do {
            facilityService = new FacilityServiceImpl();
            System.out.println("Menu" +
                    "\n 1.Display list facility" +
                    "\n 2.Add new  facility" +
                    "\n 3.Display list facility maintenance" +
                    "\n 4.Return  main menu");
            Scanner scanner = new Scanner(System.in);
            String choose = (scanner.nextLine());
            switch (choose){
                case "1":
                    facilityService.display();
                    break;
                case "2":
                    facilityService.add();
                    break;
                case "3":
                    facilityService.displayListFacilityMaintenance();
                    break;
                case "4":
                   return;
                default:
                    System.out.println(" choose again");
            }

        } while (flag);
    }
}
