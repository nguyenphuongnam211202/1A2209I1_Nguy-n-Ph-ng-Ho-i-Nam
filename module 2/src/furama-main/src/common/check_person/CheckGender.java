package common.check_person;

import java.util.Scanner;

public class CheckGender {
    public static String checkGender() {
        String choose;
        String gender = null;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Chọn giới tính" +
                    "\n 1. Nữ" +
                    "\n 2. Nam" +
                    "\n 3.Giới tính khác");
            System.out.println("Chọn giới tính");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    gender = "Nữ";
                    break;
                case "2":
                    gender = "Nam";
                    break;
                case "3":
                   gender = "Giới tính khác";
                   break;
                default:
                    System.out.println("Bạn không đúng xin mời chọn lại");

            }

        } while (gender==null);
        System.out.println(gender);
        return gender;
    }


}
