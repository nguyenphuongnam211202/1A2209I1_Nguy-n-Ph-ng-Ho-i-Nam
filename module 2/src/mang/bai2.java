package mang;
import java.util.Scanner;
import java.util.Arrays;

public class bai2 {
        public static void main(String[] args) {
            int[] array = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập phần tử cần chèn :");
            int elementX = sc.nextInt();
            System.out.println("Nhập vị trí cần chèn :");
            int index = sc.nextInt();
            System.out.println(Arrays.toString(addElenment(array, index, elementX)));
        }


        public static int[] addElenment(int[] array, int index, int value) {
            for (int i = array.length - 1; i < array.length; i--) {
                array[i] = array[i - 1];
                if (i == index) {
                    array[i] = value;
                    break;
                }
            }
            return array;
        }

    }

