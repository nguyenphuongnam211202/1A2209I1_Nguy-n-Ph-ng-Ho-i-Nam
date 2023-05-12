public class Student {
    private int id;
    private String name;
    private String point;

    public Student(int id, String name, String point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public Student(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
