package mang;
import java.util.Arrays;

public class gopmang {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {9,10,11,12,13,14};
        System.out.println(Arrays.toString(mergeArr(arr1,arr2)));
    }
    public static int [] mergeArr (int[]arr1 , int[]arr2){
        int[] newArray=new int[arr1.length+ arr2.length];
        for (int i = 0; i <arr1.length ; i++) {
            newArray[i]= arr1[i];
        }
        for (int i = 0; i <arr2.length ; i++) {
            newArray[arr1.length+i]=arr2[i];
        }
        return newArray;
    }

}