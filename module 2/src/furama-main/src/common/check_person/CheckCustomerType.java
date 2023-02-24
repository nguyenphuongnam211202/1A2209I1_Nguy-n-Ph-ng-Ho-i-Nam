package common.check_person;

import java.util.Scanner;

public class CheckCustomerType {
    public static String checkCustomerType() {
        String choose;
        String customerType = null;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn loại khách hàng\n" +
                    "1.Diamond\n" +
                    "2.Platinum\n" +
                    "3.Gold\n" +
                    "4.Silver\n" +
                    "5.Member");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    customerType = "Diamond";
                    break;
                case "2":
                    customerType = "Platinum";
                    break;
                case "3":
                    customerType = "Gold";
                    break;
                case "4":
                    customerType = "Silver";
                    break;
                case "5":
                    customerType = "Member";
                default:
                    System.out.println("choose again");
            }
        } while (choose == null);
        return customerType;
    }
}
