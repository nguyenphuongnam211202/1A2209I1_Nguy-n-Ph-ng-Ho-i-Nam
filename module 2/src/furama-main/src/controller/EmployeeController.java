package controller;

import service.EmployeeService;
import service.impl.EmployeeServiceImpl;
import java.util.Scanner;

public class EmployeeController {
    private static EmployeeService employeeService  ;

    public static void displayEmployeeManagement()  {

        String choose;
        do {
            employeeService = new EmployeeServiceImpl();
            System.out.println("Menu" +
                    "\n 1.Display list employees" +
                    "\n 2.Add new employees" +
                    "\n 3.Edit employees" +
                    "\n 4.Return main menu");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu employee");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    employeeService.display();
                    break;
                case "2":
                    employeeService.add();
                    break;
                case "3":
                    employeeService.edit();
                    break;
                case "4":
                 return;
                case "5":
                    employeeService.delete();
                    break;
                default:
                    System.out.println(" choose  again");
            }
        } while (true);
    }
}