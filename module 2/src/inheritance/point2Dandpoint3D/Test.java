package inheritance.point2Dandpoint3D;

public class Test {
    public static void main(String[] args) {
        Point2D first2DPoint=new Point2D(3, 4);
        System.out.println(first2DPoint.toString());


        Point3D first3DPoint=new Point3D(first2DPoint.getX(), first2DPoint.getY(), 7);
        System.out.println(first3DPoint.toString());
    }
}
