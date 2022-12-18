package ss2;

public class bai2 {
    public static void main(String[] args) {
        System.out.println("cac so nguyen to be hon 100 la :");
        int i = 0;
        while (i++ < 100) {
            if (isPrime(i)) {
                System.out.print(i + "  ");
            }
        }
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % 2 == 0) {
                return false;
            }

        }
        return true;
    }


    }







