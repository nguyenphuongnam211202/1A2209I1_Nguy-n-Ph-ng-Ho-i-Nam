package common.check_person;

import java.util.Scanner;

public class  CheckPosition {
    public static  String checkPosition( ){
        String choose;
        String position = null;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn vị trí\n" +"1.Lễ tân\n" +
                    "2.Phục vụ\n" +
                    "3.Chuyên viên\n" +
                    "4.Giám sát\n" +
                    "5.Quản lý\n" +
                    "6.Giám đốc");
            choose = scanner.nextLine();
            switch (choose){
                case "1":
                    position = "Lễ tân";
                    break;
                case "2":
                    position = "Phục vụ";
                    break;
                case "3":
                    position = "Chuyên viên";
                    break;
                case "4":
                    position = "Giám sát";
                    break;
                case "5":
                    position = "Quản lý";
                    break;
                case "6":
                    position = "Giám đốc";
                    break;
                default:
                    System.out.println("Chọn lại vị trí");
            }
    }while (choose == null);
        return position;

    }
}
