package models.person;

import models.person.Person;

import java.time.LocalDate;

public class Customer extends Person {
    private String customerType;
    private String address;

    public Customer(String code, String name, LocalDate birthday, String gender, String id, String phone, String email, String customerType, String address) {
        super(code, name, birthday, gender, id, phone, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString()+
                "customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public String toOfCSV(){
        return this.getCode() +","+ this.getName()+"," +this.getBirthday()+","+this.getGender()+"," + this.getId()+","+this.getPhone()+","+this.getEmail()+"," +this.customerType+","+this.address;
    }
}
