package mang;

import java.util.Arrays;
import java.util.Scanner;

public class findMin {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Nhập phần tử trong mảng: ");
        int size = sc.nextInt();
        System.out.println(Arrays.toString(arr(size)));
        int[]newarr= arr(size);
        System.out.println((minInArr(newarr)));
    }

    public static int[] arr(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("phần tử thứ " + (i + 1));
            array[i] = sc.nextInt();
        }
        return array;
    }
    public  static int minInArr(int[]array){
        int min= array[0];
        for (int i=0; i<array.length;i++){
            if (array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
}
