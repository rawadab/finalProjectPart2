package com.example.finalproject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(schema = "customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     int id;
    public String first_name;
    public String last_name;
    public String email;
    public String password;

    @ManyToOne
        public Company comp;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Coupon> coupons;

        //private ArrayList<Coupon> coupons;


}
