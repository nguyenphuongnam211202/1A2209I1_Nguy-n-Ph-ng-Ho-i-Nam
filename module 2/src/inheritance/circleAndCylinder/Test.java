package inheritance.circleAndCylinder;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(2,"vàng");
        System.out.println(circle.toString());
        Cylinder cylinder = new Cylinder(circle.getRadius(), circle.getColor(), 3);
        System.out.println(cylinder.toString());
    }
}
