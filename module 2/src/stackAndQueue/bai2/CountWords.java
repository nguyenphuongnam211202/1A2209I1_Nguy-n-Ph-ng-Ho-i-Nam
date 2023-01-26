package stackAndQueue.bai2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWords {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nhập chuỗi bất kì: ");
        String string = sc.nextLine().toLowerCase();

        String[] newString = string.split(" ");

        System.out.println(Arrays.toString(newString));

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < newString.length; i++) {
            if (treeMap.containsKey(newString[i])) {
                treeMap.put(newString[i], treeMap.get(newString[i]) + 1);

            } else {
                treeMap.put(newString[i], 1);
            }
        }
        System.out.println(treeMap);
    }
}
