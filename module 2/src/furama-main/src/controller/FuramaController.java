package controller;

import java.util.Scanner;

public class FuramaController {

    public static void displayMainMenu() {
        boolean flag = true;
        do {
            System.out.println("MENU " +
                    "\n 1.Employee Management" +
                    "\n 2.Customer Management" +
                    "\n 3.Facility Management" +
                    "\n 4.Booking Management" +
                    "\n 5.Promotion Management" +
                    "\n 6. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("MENU");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                        EmployeeController.displayEmployeeManagement();
                        break;
                case "2":
                    CustomerController.displayCustomerManager();
                    break;

                case "3":
                    FacilityController.displayFacilityManagement();
                    break;

                case "4":
                    BookingController.displayBookingManagement();
                    break;
                case "5":
                    PromotionController.displayPromotionManagement();
                    break;
                case "6":
                    System.exit(6);
                    break;

                default:
                    System.out.println("choose again");
                    flag = false;
            }
        } while (flag);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }

}
