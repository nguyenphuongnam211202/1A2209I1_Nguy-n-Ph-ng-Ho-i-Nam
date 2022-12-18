package ss1;
import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        double usd;
        System.out.println("Tỷ lệ = 23000 VNG/USD");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền (USD): ");
        usd = sc.nextDouble();
        double change = usd * 23000;
        System.out.println(" VNĐ : " +change);
    }
}
