package accessModifier;

public class Student {
    private String name;
    private String className ;

    public Student(){}

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    void setName(String name) {
        this.name = name;
    }

    void setClassName(String className) {
        this.className = className;
    }
}
class Test {
    public static void main(String[] args) {
        Student s=new Student();
        s.setName("Nam");
        s.setClassName("A09");
        System.out.println(s.getName());
        System.out.println(s.getClassName());
    }
}
