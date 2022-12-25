package abstractAndInterface.color;

public class Square extends Shape{
    private float length = 0.0f;

    public Square(){}

    public Square(float length) {
        this.length = length;
    }

    public Square(boolean fill, String name, float length) {
        super(fill, name);
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }


    @Override
    public String color() {
        if(isFill()==false){
            return " Color all four sides..";
        }
        return null;
    }
}
