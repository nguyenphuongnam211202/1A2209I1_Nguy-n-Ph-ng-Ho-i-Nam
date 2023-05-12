public interface Service {
    public void add(Student student);
    public void edit(Student student);
    public void delete(int id);
    public Student findById(int id);
    public void display();
}
