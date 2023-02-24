package controller;

import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    private static CustomerService customerService ;
    public static void displayCustomerManager() {
        boolean flag = true;
        String choose;
        do {
            customerService = new CustomerServiceImpl();
            System.out.println("Menu" +
                    "\n 1.Display list customers" +
                    "\n 2.Add new  customers" +
                    "\n 3.Edit  customers" +
                    "\n 4.Search name  customers" +
                    "\n 5.Return main menu");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu customer");
            choose = (scanner.nextLine());
            switch (choose){
                case "1":
                   customerService.display();
                   break;
                case "2":
                    customerService.add();
                    break;
                case "3":
                    customerService.edit();
                    break;
                case "4":
                    customerService.searchByName();
                    break;
                case "5":
                 return;
                case "6":
                    customerService.delete();
                    break;
                default:
                    System.out.println("choose again");
            }

        } while (flag);
    }
}