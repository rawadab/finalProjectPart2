
package com.example.finalproject.Model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@Entity
@Table(schema = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

     int id;

    public String name;

    public String email;

    public String password;

    @OneToMany(mappedBy = "comp", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Customer> customers;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Coupon> coupons;




}

