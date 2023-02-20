package com.example.finalproject.Serveices;

import com.example.finalproject.DAO.CouponDAO;
import com.example.finalproject.Model.Company;
import com.example.finalproject.Model.Coupon;
import com.example.finalproject.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {

    @Autowired
    CouponDAO couponDAO;

    public Coupon addCoupon(Coupon coupon) {

        if (couponDAO.findByTitleOrCompanyID(coupon.getTitle(), coupon.getCompanyID()) == null)

            return couponDAO.save(coupon);

        return null;

    }
    public void updateCoupon(Coupon coupon){
        Coupon cup = couponDAO.findById(coupon.getId()).orElse(null);
        if (cup != null){
            cup.setAmount(coupon.getAmount());
            cup.setCategory(coupon.getCategory());

            cup.setDescription(coupon.getDescription());
            cup.setStartDate(coupon.getStartDate());
            cup.setEndDate(coupon.getEndDate());
            cup.setImage(coupon.getImage());
            cup.setPrice(coupon.getPrice());
            cup.setTitle(coupon.getTitle());
            couponDAO.save(cup);
        }

    }
    public void deleteCoupon(int id) {
        Coupon cup = couponDAO.findById(id).orElse(null);
        if (cup != null) {
            couponDAO.deleteById(id);

        }

    }

    public List<Coupon> getAllCoupons() {
        return couponDAO.findAll();
    }

    public Optional<Coupon> getOneCoupon(int id){
        return couponDAO.getOneCouponById(id);
    }
}