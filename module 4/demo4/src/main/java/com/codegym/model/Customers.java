package com.codegym.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String fullName;
    @NotBlank
    private String address;
    @NotBlank
    @Pattern(regexp = "^\\+\\d{2}\\(\\d{3}\\)-\\d{7}$|^\\+\\d{2}-\\d{3}-\\d{7}$")
    private String phone;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Orders> ordersCollection;


}
