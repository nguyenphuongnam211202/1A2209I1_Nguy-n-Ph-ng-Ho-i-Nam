package service.impl;

import common.check_faccility.CheckCustomer;
import common.check_faccility.CheckEmployee;
import common.check_person.*;
import models.person.Employee;
import service.EmployeeService;
import util.ReadAndWriteEmployeeToCSV;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private final String FILE_EMPLOYEE = "src/data/DataEmployee.csv";

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        String code;
        do {
            System.out.println("Nhập mã nhân viên ");
            code = scanner.nextLine();
        }
        while (!(CheckCode.checkCode(code)));
        String name = null;
        do {
            System.out.println("Nhập tên");
            name = scanner.nextLine();
        }
        while (!(CheckName.checkName(name)));
        String gender = CheckGender.checkGender();
        String day = null;
        LocalDate birthday = null;
        boolean flag = true;
        do {
            System.out.println("Nhập ngày sinh");
            day = scanner.nextLine();
            birthday = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int age = birthday.until(LocalDate.now()).getYears();
            if (age < 18 || age >100){
                flag = true;
            } else {
                flag = false;
            }
        }while (flag);
        String id = null;
        do {
            System.out.println("Nhập số CMND");
            id = scanner.nextLine();
            if (CheckId.checkId(id)){
                if (CheckEmployee.checkCMND1(id)){
                    break;
                }else {
                    System.out.println("Da ton tai");
                }
            }
            else {
                System.out.println("nhap sai");
            }
        } while (true);
        String telephone = null;
        do {
            System.out.println("Nhập số điện thoại");
            telephone = scanner.nextLine();
        } while (!CheckPhone.checkPhone(telephone));
        String email = null;
        do {
            System.out.println("Nhập email");
            email = scanner.nextLine();
        } while (!CheckEmail.checkEmail(email));
        String level = CheckLevel.checkLevel();
        String position = CheckPosition.checkPosition();
        System.out.println("Nhập lương");
        String salary = scanner.nextLine();
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee(code, name, birthday, gender, id, telephone, email, level, position, salary));
        ReadAndWriteEmployeeToCSV.writeFile(FILE_EMPLOYEE, employee, true);
    }
    @Override
    public void edit() {
        List<Employee> employee = ReadAndWriteEmployeeToCSV.readFile(FILE_EMPLOYEE);
        System.out.println(" EDIT EMPLOYEE");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        for (int i = 0; i < employee.size(); i++) {
            if (name.equals(employee.get(i).getName())) {
                System.out.println("Nhập mã nhân viên");
                employee.get(i).setCode(scanner.nextLine());
                System.out.println("Nhâp tên");
                employee.get(i).setName(scanner.nextLine());
                System.out.println("Nhập ngày sinh ");
                employee.get(i).setBirthday(LocalDate.parse(scanner.nextLine()));
                System.out.println("Nhập giới tính");
                employee.get(i).setGender(scanner.nextLine());
                System.out.println("Nhập số CMND");
                employee.get(i).setId(scanner.nextLine());
                System.out.println("Nhập số điện thoại");
                employee.get(i).setPhone(scanner.nextLine());
                System.out.println("Nhập email");
                employee.get(i).setEmail(scanner.nextLine());
                System.out.println("Nhập trình độ");
                employee.get(i).setLevel(scanner.nextLine());
                System.out.println("Nhập vị trí");
                employee.get(i).setPosition(scanner.nextLine());
                System.out.println("Nhập lương");
                employee.get(i).setSalary(scanner.nextLine());
                ReadAndWriteEmployeeToCSV.writeFile(FILE_EMPLOYEE, employee, false);
            }
        }
    }
    @Override
    public void delete() {
        List<Employee> employee = ReadAndWriteEmployeeToCSV.readFile(FILE_EMPLOYEE);
        System.out.println("DELETE EMPLOYEE");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên ");
        String code = scanner.nextLine();
        for (int i = 0; i < employee.size(); i++) {
            if (code.equals(employee.get(i).getCode())) {

            }
               do{
                   System.out.println("ban chac chan muon xoa" +
                           "\n 1.Yes" +
                           "\n 2. No");
                   String choose = scanner.nextLine();
                   switch (choose){
                       case "1":
                           System.out.println(employee.get(i));
                           employee.remove(i);
                           ReadAndWriteEmployeeToCSV.writeFile(FILE_EMPLOYEE, employee, false);
                           return;
                       case "2" :
                           System.out.println("ban da huy xoa");
                           return;
                       default:
                           System.out.println("NHAP LAI");
                   }
            }while (true);
        }

    }
    @Override
    public void display() {
        List<Employee> employee = ReadAndWriteEmployeeToCSV.readFile(FILE_EMPLOYEE);
        System.out.println("DISPLAY EMPLOYEE");
        if (!employee.isEmpty()){
        for (Employee employees : employee
        ) {
            System.out.println(employees);
        }
        }else {
            System.out.println("File employee is empty");
        }
    }
}
