package test;

import main.DanhSachSinhVien;
import main.SinhVien;

import java.util.Scanner;

public class testMain {
    public static void main(String[] args) {
        DanhSachSinhVien danhSachSinhVien = new DanhSachSinhVien();
        Scanner sc = new Scanner(System.in);

        DanhSachSinhVien dssv = new DanhSachSinhVien();
        int choice = 0;
        do{
            System.out.println("-------menu-------");
            System.out.println("enter number to select option");
            System.out.println(
                        "1. Add student. \n" +
                        "2. Show information of student. \n" +
                        "3. Edit information of students. \n" +
                        "0. Exit."
            );
            System.out.println("Enter your option here:");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                System.out.println("Enter name of student: "); String name = sc.nextLine();
                System.out.println("Enter id: "); String id =  sc.nextLine();
                System.out.println("Enter date of birth: "); int dob = sc.nextInt();
                System.out.println("Enter average: "); float dtb = sc.nextFloat();

                SinhVien sv = new SinhVien(id, name, dob, dtb);
                danhSachSinhVien.AddStudent(sv);
            } else if (choice == 2) {
                dssv.ShowInfor();
            } else if (choice == 3) {
                dssv.editStudent();
            }

        }while(choice != 0);
    }



}
