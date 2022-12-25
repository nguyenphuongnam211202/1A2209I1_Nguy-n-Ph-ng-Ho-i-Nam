package inheritance.circleAndCylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(){
        super();
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getTotalArea(){
        return super.getArea()*height;
    }
    public String toString(){
        return "diện tích hình trụ có màu " + super.getColor() + " là " + getTotalArea() + " ";
    }
}
