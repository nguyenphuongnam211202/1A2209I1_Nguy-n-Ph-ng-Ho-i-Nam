package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @NotBlank(message = "khong duoc de trong")
    @Size(min = 5, max = 50, message = "ten phai tu 5 den 50 ki tu")
    @Column(columnDefinition = "nvarchar(100)")
    private String name;

    @DecimalMin(value = "100.000", inclusive = true, message = "giá tối thiểu là 100.000 VND")
    private double price;

    @NotBlank(message = "khong duoc de trong")
    @Column(columnDefinition = "nvarchar(100)")
    private String status;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName ="category_id" )
    private Category category;

    public Product() {
    }

    public Product(String name, double price, String status, Category category) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(int idProduct, String name, double price, String status, Category category) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
