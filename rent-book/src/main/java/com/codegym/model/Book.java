package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(150)")
    @NotBlank(message = "khong duoc de trong")
    private String tittle;

    @Column(columnDefinition = "TEXT")
    private String preface;

    private String author;

    @Column(name ="published_on" )
    private LocalDate publishedOn;

    @Column(name = "img_url")
    private String img_url;

    @Column
    @Min(0)
    private int quantity;

    public Book(){}

    public Book(int id, String tittle, String preface, String author, LocalDate publishedOn, String img_url, int quantity) {
        this.id = id;
        this.tittle = tittle;
        this.preface = preface;
        this.author = author;
        this.publishedOn = publishedOn;
        this.img_url = img_url;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDate publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
