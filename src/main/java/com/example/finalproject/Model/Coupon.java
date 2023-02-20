package com.example.finalproject.Model;



import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(schema = "coupons")

public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     int id;
    public int companyID;


    @Enumerated(EnumType.ORDINAL)
    public Category category;
    public String title;
    public String description;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date endDate;
    public int amount;
    public double price;
    public String image;

    @ManyToOne
    public Company company;

   @ManyToMany(cascade = CascadeType.ALL)
    public List<Customer> customers;

}
