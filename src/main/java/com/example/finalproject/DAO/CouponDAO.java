package com.example.finalproject.DAO;

import com.example.finalproject.Model.Company;
import com.example.finalproject.Model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponDAO extends JpaRepository<Coupon, Integer> {
    Coupon findByTitleOrCompanyID(String title, int companyID);

    Optional<Coupon> getOneCouponById(int id);
}
