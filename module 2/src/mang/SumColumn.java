package mang;
import java.util.Scanner;
public class SumColumn {
    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);
        int rows;
        int Columns;
        int sum = 0;
        int cot;

        System.out.println("Mời nhập số dòng của mảng: ");
        rows = scanner1.nextInt();
        System.out.println("Mời nhập số cột của mảng: ");
        Columns = scanner1.nextInt();
        int[][] A = new int[rows][Columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < Columns; j++) {
                System.out.print("Nhập phần tử thứ [" + i + ", " + j + "]: ");
                A[i][j] = scanner1.nextInt();
            }
        }

        System.out.println("nhap so hang cua cot can tinh: ");
        Scanner scanner = new Scanner(System.in);
        cot = scanner.nextInt();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < Columns; j++) {
                if (j == cot) {
                    sum = sum + A[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
