package com.codegym.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "khong duoc de trong")
    @Column(columnDefinition = "nvarchar(100)")
    private String name;

    @Min(value = 1,message = "số lượng tối thiểu là 1")
    private int quantity;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRelease;


    @DecimalMin(value = "1.0", inclusive = true, message = "giá tối thiểu là 1")
    private double price;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName ="category_id" )
    private Category category;

    public Product() {
    }

    public Product(String name, int quantity, Date dateRelease, double price, Category category) {
        this.name = name;
        this.quantity = quantity;
        this.dateRelease = dateRelease;
        this.price = price;
        this.category = category;
    }

    public Product(int id, String name, int quantity, Date dateRelease, double price, Category category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.dateRelease = dateRelease;
        this.price = price;
        this.category = category;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
