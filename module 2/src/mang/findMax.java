package mang;

import java.util.Arrays;
import java.util.Scanner;


public class findMax {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("nhập x :");
        int x = sc.nextInt();
        System.out.println("nhập y :");
        int y = sc.nextInt();
        int [][]newarr = returnArr(x,y);
        System.out.println(findMax(newarr));;
    }

    public static int[][] returnArr(int x, int y) {
        int[][] array2d = new int[x][y];
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                System.out.println("Nhập phần tử " + i + " " + j);
                array2d[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(array2d));
        return array2d;
    }

    public static String findMax(int[][] arr) {
        int max = arr[0][0];
        int column = 0, row = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    column = i;
                    row = j;
                }
            }
        }
        return "Giá trị lớn nhất trong mảng là "+ max + " ở cột " +column + " hàng " +row;
    }


}