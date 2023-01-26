package stackAndQueue.bai1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseIntNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack <Integer> arrayStack = new Stack<>();
        System.out.print("nhập size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("nhập arr[" + i + "]");
            arr[i] = arrayStack.push(sc.nextInt());
        }
        System.out.println("mảng trước khi đảo");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < size; i++) {
            arr[i] = arrayStack.pop();
        }
        System.out.println("mảng sau khi đảo:");
        System.out.println(Arrays.toString(arr));
    }
}
