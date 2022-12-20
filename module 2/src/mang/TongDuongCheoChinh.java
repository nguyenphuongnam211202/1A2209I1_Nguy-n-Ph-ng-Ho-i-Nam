package mang;

import java.util.Scanner;

public class TongDuongCheoChinh {
    public static void main(String[] args) {
        int rows;
        int sum=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số dòng của ma trận: ");
        rows = scanner.nextInt();

        int [][] a = new int[rows][rows];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < rows; j++){
                System.out.print("Nhập phần tử thứ ["+ i +","+ j +"]: ");
                a[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <rows ; j++) {
                System.out.print(a[i][j]+"  ");
                if (i==j){
                    sum+=a[i][j];
                }
            }
            System.out.println("\n");
        }
        System.out.println("Tổng đường chéo của ma trận vuông là: "+ sum    );
    }
}