package baitap2.views;

import baitap2.services.ProductService;
import baitap2.utils.NotFoundProductException;

import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductService productService = new ProductService();
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        while (true){
            System.out.println("-----------");
            System.out.println("1. Add new");
            System.out.println("2. Remove");
            System.out.println("3. Display all");
            System.out.println("4. Find by id");
            System.out.println("5. Exit");
            System.out.print("Input your choice: ");
            switch (scanner.nextInt()){
                case 1:
                    productService.addNew();
                    break;
                case 2:
                    productService.remove();
                case 3:
                    productService.findAll();
                    break;
                case 4:
                    productService.findById();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
