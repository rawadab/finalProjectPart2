package com.example.finalproject;

import com.example.finalproject.DAO.CouponDAO;
import com.example.finalproject.Model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class MyTask implements Runnable {

    @Autowired
    private CouponDAO couponDAO;

    @Override
    public void run() {
        // get all coupons from the database
        List<Coupon> coupons = couponDAO.findAll();

        // iterate through the coupons and check the expiration date
        for (Coupon coupon : coupons) {
            if (coupon.getEndDate().before(new Date())) {
                // if the coupon is expired, delete it from the database
                couponDAO.delete(coupon);
            }
        }
    }
}

