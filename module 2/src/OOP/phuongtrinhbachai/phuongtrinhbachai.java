package OOP.phuongtrinhbachai;

import java.util.Scanner;

public class phuongtrinhbachai {
    public static void main(String[] args) {
        double a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập a");
        a = sc.nextDouble();
        System.out.println("nhập b");
        b = sc.nextDouble();
        System.out.println("nhập c");
        c = sc.nextDouble();
        QuadraticEquation qe = new QuadraticEquation(a,b,c);
        if(qe.getDiscriminant() < 0){
            System.out.println("phương trình vô nghiệm");
        } else if (qe.getDiscriminant() == 0) {
            System.out.println("phương trình có một nghiệm kép x1 = x2 =" + qe.getRoot1());
    }else {
            System.out.println("phương trình có hai nghiệm : x1 = " + qe.getRoot1() + " và x2= " + qe.getRoot2());
        }
    }
}
