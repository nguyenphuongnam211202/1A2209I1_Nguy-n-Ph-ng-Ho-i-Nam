package abstractAndInterface.resize;

public class Rectangle extends Shape {
    private float width = 0.0f;
    private float length = 0.0f;

    public Rectangle() {
    }

    public Rectangle(float width, float length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String name,String color, boolean fill, float width, float length) {
        super(name, color, fill);
        this.width = width;
        this.length = length;
    }

    @Override
    public void reSize(double percent) {
        this.width += this.width * (float) percent / 100;
        this.length += this.length * (float) percent / 100;
    }

    @Override
    public double getArea() {
        return this.length * this.width;
    }

    @Override
    public String toString() {
        return super.toString() +
                " size (length, width) : " +
                "(" + this.length + "," + this.width + ")" +
                " area: " +
                getArea() ;
    }
}
