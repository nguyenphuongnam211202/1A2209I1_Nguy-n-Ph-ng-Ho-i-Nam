package com.example.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBorrow;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date returnDate;

    private String statusBorrow;

    @ManyToOne
    @JoinColumn(name = "id_book",referencedColumnName = "id_book")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    private Person person;

    public Borrow() {
    }

    public Borrow(int idBorrow, Date borrowDate, Date returnDate, String statusBorrow, Book book, Person person) {
        this.idBorrow = idBorrow;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.statusBorrow = statusBorrow;
        this.book = book;
        this.person = person;
    }

    public int getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(int idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatusBorrow() {
        return statusBorrow;
    }

    public void setStatusBorrow(String statusBorrow) {
        this.statusBorrow = statusBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean doBorrow(){
        if(book.getQuantity() >0){
            book.setQuantity(book.getQuantity() -1);
            if(book.getQuantity()==0){
                book.setStatusBook("het sach");
            }else {
                book.setStatusBook("con sach");
            }
            this.statusBorrow = "dang muon";
            return true;
        }else {
            return false;
        }
    }

    public boolean doReturn(){
        book.setQuantity(book.getQuantity() + 1);
        book.setStatusBook("con sach");
        Date currentDate = new Date();

        // Định dạng ngày theo yyyy-MM-dd
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
        Date formattedDateAsDate = null;
        try {
            formattedDateAsDate = dateFormat.parse(formattedDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.returnDate = formattedDateAsDate;
        this.statusBorrow = "da tra";
        return true;
    }
}
