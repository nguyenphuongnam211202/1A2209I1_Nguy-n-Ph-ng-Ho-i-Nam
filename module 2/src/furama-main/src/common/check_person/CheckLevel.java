package common.check_person;

import java.util.Scanner;

public class CheckLevel {
    public  static String checkLevel(){
        String level = null;
        String choose ;
      do{
          Scanner scanner = new Scanner(System.in);
          System.out.println("Chọn trình độ\n" +
                  "1. trung cấp\n" +
                  "2. cao đẳnng\n" +
                  "3. đai học\n" +
                  "4. sau đại học");
          choose = scanner.nextLine();
          switch (choose){
              case "1":
                  level = "Trung cấp";
                  break;
              case "2":
                  level = "Cao đẳng";
                  break;
              case "3":
                  level = "Đại học";
                  break;
              case "4":
                  level = "Sau đại học";
                  break;
              default:
                  System.out.println("Chọn lại");
          }
      }while (choose == null);
      return level;
    }
}


