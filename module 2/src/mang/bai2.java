package mang;
import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập độ dài của mảng");
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("nhập phần tử của mảng");
            arr[i]= sc.nextInt();
        }
        System.out.println("nhập số muốn chèn");
        int number = sc.nextInt();
        System.out.println("nhập vị trí muốn chèn");
        int index = sc.nextInt();
        int []newArr = new int[n+1];
        for (int i = 0; i < newArr.length; i++) {
            if(i==index){
                newArr[i]= number;
                for (int j = i+1; j < newArr.length; i++) {
                    newArr[i+1]= arr[i];
                }
                break;
            }else {
                newArr[i]= arr[i];
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i] + " ");
        }

    }
}
