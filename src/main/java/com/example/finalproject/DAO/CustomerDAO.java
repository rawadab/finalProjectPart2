package com.example.finalproject.DAO;

import com.example.finalproject.Model.Coupon;
import com.example.finalproject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);

    Optional<Customer> getOneCUstomerById(int id);
}
