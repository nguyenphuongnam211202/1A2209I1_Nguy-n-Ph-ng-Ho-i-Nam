package abstractAndInterface.resize;

public class Square extends Shape {
    private float length;

    public Square() {
    }

    public Square(float length) {
        this.length = length;
    }

    public Square(String name, String color, boolean fill, float length) {
        super(name, color, fill);
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public void reSize(double percent) {
        this.length += this.length * (float) percent / 100;
    }

    @Override
    public double getArea() {
        return Math.pow(length,2);
    }

    @Override
    public String toString() {
        return super.toString() +
                " area: " +
                " size (length) : " +
                this.length +
                getArea() ;
    }
}
