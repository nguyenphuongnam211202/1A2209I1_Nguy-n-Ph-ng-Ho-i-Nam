package abstractAndInterface.resize;

public abstract class Shape implements Resizeable {
    private String name;
    private String color = "green";
    private boolean fill = false;

    public Shape() {
    }

    public Shape(String name, String color, boolean fill) {
        this.name = name;
        this.color = color;
        this.fill = fill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        return  getName() + " with color : " +
                getColor() +
                " and is fill : " +
                isFill()
                ;

    }

    public static void printShape(Shape[] shape) {
        for (Shape x : shape) {
            System.out.println(x.toString());
        }

    }
    public abstract double getArea();

}
