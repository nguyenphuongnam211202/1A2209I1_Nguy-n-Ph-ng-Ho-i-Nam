import java.util.ArrayList;

public class ServiceImpl implements Service{

    public static ArrayList<Student> studentList = new ArrayList<>();
    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void edit(Student student) {
        Student st = findById(student.getId());
        if(st != null){
            st.setName(student.getName());
            st.setPoint(student.getPoint());
        }
    }

    @Override
    public void delete(int id) {
        Student st = findById(id);
        if(st != null){

        }
    }

    @Override
    public Student findById(int id) {
        for (Student st: studentList) {
            if(st.getId() == id){
                return st;
            }
        }
        return null;
    }

    @Override
    public void display() {

    }
}
