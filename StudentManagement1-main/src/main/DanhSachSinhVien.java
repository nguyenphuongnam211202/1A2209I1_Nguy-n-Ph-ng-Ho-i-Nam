package main;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSinhVien {
    private static ArrayList<SinhVien> danhsach;
    private Scanner sc;
    public DanhSachSinhVien(){
        danhsach = new ArrayList<SinhVien>();
    }
    public DanhSachSinhVien(ArrayList<SinhVien> danhsach) {
        DanhSachSinhVien.danhsach = danhsach;
    }

    public void AddStudent(SinhVien sv){
        danhsach.add(sv);
    }
    public void ShowInfor() {
        for (SinhVien sinhVien : danhsach) {
            System.out.println(sinhVien);
        }
    }

    public SinhVien findById(String id){
        for (SinhVien sinhVien:danhsach) {
            if(sinhVien.getId().equals(id)){
                return sinhVien;
            }
        }
        return null;
    }
    public void editStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of Student you want to edit: ");
        String idSinhVien = sc.nextLine();
        SinhVien sinhVien = findById(idSinhVien);

        if(sinhVien == null){
            System.out.println("This student does not exist...");
            return;
        }

        System.out.println("which options do you want to edit: \n"
                + "1. Edit id of student. \n"
                + "2. Edit name of student. \n"
                + "3. Edit date of birth. \n"
                + "4. Edit average mark. \n"
        );
        int choice = sc.nextInt();
        sc.nextLine();
        while(choice > 4 || choice < 1){
            System.out.println("Please, enter 1 to 4, again: ");
            choice = sc.nextInt();
            sc.nextLine();
        }
        switch (choice){
            case 1:
                System.out.println("Set id: ");
                String idEdit = sc.nextLine();
                sinhVien.setId(idEdit);
                System.out.println("Edited...");
                break;
            case 2:
                System.out.println("Set name: ");
                String nameEdit = sc.nextLine();
                sinhVien.setName(nameEdit);
                System.out.println("Edited...");
                break;
            case 3:
                System.out.println("Set date of birth: ");
                int dobEdit = sc.nextInt();
                sc.nextLine();
                sinhVien.setDob(dobEdit);
                System.out.println("Edited...");
                break;
            case 4:
                System.out.println("Set average mark: ");
                float dtbEdit = sc.nextFloat();
                sc.nextLine();
                sinhVien.setDtb(dtbEdit);
                System.out.println("Edited...");
                break;
        }
    }

}
