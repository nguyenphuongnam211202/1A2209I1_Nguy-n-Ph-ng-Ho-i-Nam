package abstractAndInterface.color;

public abstract class Shape implements howToColor {
    private boolean fill;

    private String name;

    public Shape(){}

    public Shape(boolean fill, String name) {
        this.fill = fill;
        this.name = name;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName() +
                " and is fill : " +
                isFill() ;
    }
}
