package com.example.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;

    @NotBlank(message = "khong duoc de trong ten sach")
    @Column(columnDefinition = "nvarchar(100)")
    private String nameBook;

    @NotBlank(message = "khong duoc de trong ten tac gia")
    @Column(columnDefinition = "nvarchar(100)")
    private String author;

    @Min(value = 1, message = "gia toi thieu la 1")
    @NotNull(message = "khong duoc de trong")
    private int price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRealese;

    @Min(value = 1,message = "so luong toi thieu la 1")
    private int quantity;

    private String statusBook;

    public Book() {
    }

    public Book(int idBook, String nameBook, String author, int price, Date dateRealese, int quantity, String status) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.author = author;
        this.price = price;
        this.dateRealese = dateRealese;
        this.quantity = quantity;
        this.statusBook = status;
    }

    public Book(int idBook, String nameBook, String author, int price, Date dateRealese, int quantity) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.author = author;
        this.price = price;
        this.dateRealese = dateRealese;
        this.quantity = quantity;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDateRealese() {
        return dateRealese;
    }

    public void setDateRealese(Date dateRealese) {
        this.dateRealese = dateRealese;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatusBook() {
        return statusBook;
    }

    public void setStatusBook(String status) {
        this.statusBook = status;
    }
}
