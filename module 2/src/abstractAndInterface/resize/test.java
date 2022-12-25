package abstractAndInterface.resize;

public class test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("hinh tron","yellow",true,2);
        shapes[1] = new Rectangle("hinh chu nhat","blue",true,2,3);
        shapes[2] = new Square("hinh vuong","red",true,3);
        System.out.println("BEFORE RESIZE :");
        System.out.println("\n");

        for (Shape a : shapes){
            System.out.println(a);
        }
        System.out.println("\n");

        System.out.println("AFTER RESIZE :");
        for (Shape a : shapes) {
            a.reSize(Math.random() * 1000);
        }
        System.out.println("\n");
        Shape.printShape(shapes);
    }
}
