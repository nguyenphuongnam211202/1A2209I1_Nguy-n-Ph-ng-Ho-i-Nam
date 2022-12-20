package mang;

import java.util.Scanner;

public class DemSoLanKiTu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str="nguyenphuonghoainam";
        System.out.print("Nhập kí tự cần đếm trong chuỗi : ");
        String character = sc.nextLine();
        char temp=character.charAt(0);
        int count=0;
        for (int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)==temp) count++;
        }
        System.out.println("Số lần xuất hiện của kí tự "+ temp +" là : "+count);
    }
}
