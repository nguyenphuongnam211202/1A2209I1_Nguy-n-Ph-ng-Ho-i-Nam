package models.person;

import java.time.LocalDate;

public class Employee extends Person {
    private String level;
    private String position;
    private String salary;

    public Employee(String code, String name, LocalDate birthday, String gender, String id, String phone, String email, String level, String position, String salary) {
        super(code, name, birthday, gender, id, phone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +super.toString()+
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
    public String toOfCSVFile(){
        return this.getCode() +","+ this.getName()+"," +this.getBirthday()+","+this.getGender()+"," + this.getId()+","+this.getPhone()+","+this.getEmail()+"," +this.level +","+this.position +","+this.salary;
    }
}
