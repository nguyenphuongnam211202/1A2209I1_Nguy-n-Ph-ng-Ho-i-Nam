package service.impl;

import common.check_faccility.CheckCustomer;
import common.check_person.*;
import models.person.Customer;
import service.CustomerService;
import util.ReadAndWriteToCSV;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private final String FILE_CUSTOMER = "src/data/DataCustomer.csv";

    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        String code;
        do {
            System.out.println("Nhập mã nhân viên ");
            code = input.nextLine();
        }
        while (!(CheckCode.checkCode(code)));
        String name = null;
        do {
            System.out.println("Nhập tên");
            name = input.nextLine();
        }
        while (!(CheckName.checkName(name)));
        String gender = CheckGender.checkGender();
        String day = null;
        LocalDate birthday = null;
        boolean flag = true;
        do {
          try {
              System.out.println("Nhập ngày sinh");
              day = input.nextLine();
              birthday = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
              int age = birthday.until(LocalDate.now()).getYears();
              if (age < 18 || age > 100) {
                  flag = true;
              } else {
                  flag = false;
              }
          }catch ( Exception e){
              System.out.println("Nhap sai moi nhap ali" );
          }
        } while (flag);

        String id = null;
        do {
            System.out.println("Nhập số CMND");
            id = input.nextLine();
            if (CheckId.checkId(id)) {
                if (CheckCustomer.checkCMND(id)) {
                    break;
                } else {
                    System.out.println("da ton tai");
                }
            } else {
                System.out.println("nhap sai nhai lai");
            }
        } while (true);
        String telephone = null;
        do {
            System.out.println("Nhập số điện thoại");
            telephone = input.nextLine();
        } while (!CheckPhone.checkPhone(telephone));
        String email = null;
        do {
            System.out.println("Nhập email");
            email = input.nextLine();
        } while (!CheckEmail.checkEmail(email));
        String customerType = CheckCustomerType.checkCustomerType();
        System.out.println("Nhập địa chỉ");
        String address = input.nextLine();
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(code, name, birthday, gender, id, telephone, email, customerType, address));
        ReadAndWriteToCSV.writeCustomer(FILE_CUSTOMER, customers, true);
    }

    @Override
    public void edit() {
        List<Customer> customers = ReadAndWriteToCSV.readCustomer(FILE_CUSTOMER);
        System.out.println("EDIT CUSTOMER");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (name.equals(customers.get(i).getName())) {
                System.out.println("Nhập mã nhân viên");
                customers.get(i).setCode(scanner.nextLine());
                System.out.println("Nhâp tên");
                customers.get(i).setName(scanner.nextLine());
                System.out.println("Nhập ngày sinh ");
                customers.get(i).setBirthday(LocalDate.parse(scanner.nextLine()));
                System.out.println("Nhập giới tính");
                customers.get(i).setGender(scanner.nextLine());
                System.out.println("Nhập số CMND");
                customers.get(i).setId(scanner.nextLine());
                System.out.println("Nhập số điện thoại");
                customers.get(i).setPhone(scanner.nextLine());
                System.out.println("Nhập email");
                customers.get(i).setEmail(scanner.nextLine());
                System.out.println("Nhập loại khách hàng");
                customers.get(i).setCustomerType(scanner.nextLine());
                System.out.println("Nhập địa chỉ");
                customers.get(i).setAddress(scanner.nextLine());
                ReadAndWriteToCSV.writeCustomer(FILE_CUSTOMER, customers, true);
            }
        }
    }

    @Override
    public void delete() {
        List<Customer> customers = ReadAndWriteToCSV.readCustomer(FILE_CUSTOMER);
        System.out.println("DELETE CUSTOMER");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên ");
        String code = scanner.nextLine();
        if (!customers.isEmpty()) {
            for (int i = 0; i < customers.size(); i++) {
                if (code.equals(customers.get(i).getCode())) {
                    customers.remove(i);
                }
            }
        } else {
            System.out.println(" customer is empty");
        }
        ReadAndWriteToCSV.writeCustomer(FILE_CUSTOMER, customers, false);

    }

    @Override
    public void display() {
        List<Customer> customers = ReadAndWriteToCSV.readCustomer(FILE_CUSTOMER);
        System.out.println("DISPLAY CUSTOMER");
        if (!customers.isEmpty()) {
            for (Customer customer : customers
            ) {
                System.out.println(customer);
            }
        } else {
            System.out.println("file customer is empty");
        }

    }

    @Override
    public void searchByName() {
        List<Customer> customers = ReadAndWriteToCSV.readCustomer(FILE_CUSTOMER);
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (name.equals(customers.get(i).getName())) ;
            System.out.println(customers.get(i));
        }
        System.out.println("ko tim thay");
    }
}
