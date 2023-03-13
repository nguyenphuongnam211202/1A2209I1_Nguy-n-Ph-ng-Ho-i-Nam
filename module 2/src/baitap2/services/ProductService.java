package baitap2.services;

import baitap2.controllers.ProductController;
import baitap2.models.ExportProduct;
import baitap2.models.ImportProduct;
import baitap2.models.Product;
import baitap2.utils.DisplayScanner;
import baitap2.utils.NotFoundProductException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private ProductController repo = new ProductController();
    private Scanner scanner = new Scanner(System.in);

    public void addNew() {
        System.out.println("1. Add import product");
        System.out.println("2. Add export product");
        System.out.print("Input your choice: ");
        int inputData = scanner.nextInt();
        List<String> list = new ArrayList<>();
        if (inputData == 1) {
            list = DisplayScanner.getDataFromConsole(ImportProduct.infoData());
            String[] data = new String[list.size()];
            list.toArray(data);
            repo.add(data);
        } else if (inputData == 2) {
            list = DisplayScanner.getDataFromConsole(ExportProduct.infoData());
            String[] data = new String[list.size()];
            list.toArray(data);
            repo.add(data);
        } else {
            System.out.println("Not match");
        }
    }

    public void findAll() {
        repo.findAll().forEach(System.out::println);
    }

    public void remove() {
        while (true) {
            try {
                System.out.print("Input code product you want to remove: ");
                String removeCode = scanner.next();
                System.out.println("Are you sure to delete (Y/N): ");
                String choice = scanner.next();
                if (choice.toUpperCase().equals("Y")) {
                    if (repo.remove(removeCode)) {
                        System.out.printf("Remove successfully!");
                    } else {
                        throw new NotFoundProductException("Not found product");
                    }
                }
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void findById() {
        System.out.print("Input code product you want to find: ");
        List<Product> list = repo.findByCodeOrName(scanner.next());
        if (list != null) {
            list.forEach(System.out::println);
            return;
        }
        System.out.println("Not found!");
    }
}
