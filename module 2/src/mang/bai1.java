package mang;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        int [] arr={2,5,4,6,7,2,8};
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập số phần tử cần xóa");
        int number= sc.nextInt();
        int []newArr= new int[arr.length];
        int count=0;

        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]!=number){
                newArr[count]=arr[i];
                count++;
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }
}
