package abstractAndInterface.resize;

public class Circle extends Shape {
    private float radius = 0.0f;

    public Circle() {
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    public Circle(String name,String color, boolean fill, float radius) {
        super(name,color, fill);
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public void reSize(double percent) {
        this.radius += this.radius * (float) percent / 100;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return super.toString() +
                " size (radius) : " +
                this.radius +
                " area: " +
                getArea() ;
    }
}
