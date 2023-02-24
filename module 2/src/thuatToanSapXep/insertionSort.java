package thuatToanSapXep;

public class insertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.println("tại i = " + i);
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    System.out.println("đổi chỗ " + arr[j-1] +" và " + arr[j]);
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    System.out.println("mảng hiện tại :");
                    for (int e : arr) {
                        System.out.print(e + ", ");
                    }
                    System.out.println("");

                } else {
                    System.out.println("giữ nguyên vị trí của " + arr[j] + " và " + arr[j-1]);
                    System.out.println("mảng hiện tại :");
                    for (int e : arr) {
                        System.out.print(e + ", ");
                    }
                    System.out.println("");
                    break;
                }
            }
        }


}

    public static void main(String[] args) {
        int [] arr={2,5,4,6,7,2,8};
        System.out.println("mảng ban đầu :");
        for (int e : arr) {
            System.out.print(e + ", ");
        }
        System.out.println("");
        insertionSort(arr);
        System.out.println("mảng sau sắp xếp :");
        for (int e : arr) {
            System.out.print(e + ", ");
        }
    }
}

