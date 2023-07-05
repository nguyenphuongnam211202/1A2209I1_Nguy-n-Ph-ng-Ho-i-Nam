package com.codegym.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    private LocalDate orderDate;

    private LocalDate shipDate;

    private LocalDate requireDate;

    private boolean status;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customers customers;

    @OneToMany(mappedBy ="orders")
    private Collection<OrderDetail> orderDetailCollection;
}
