package accessModifier;

public class Circle {
    private double radius = 3;
    private String color = "blue";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow(radius, 2) * 3.14;
    }

    public static void main(String[] args) {
            Circle a = new Circle(3);
            System.out.println(a.getArea());
        }
}

