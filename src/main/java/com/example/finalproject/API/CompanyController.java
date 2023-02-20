package com.example.finalproject.API;

import com.example.finalproject.Model.Company;
import com.example.finalproject.Model.Coupon;
import com.example.finalproject.Model.Customer;
import com.example.finalproject.Serveices.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CouponController {
    @Autowired
    CouponService couponService;

    @PostMapping("/Company2/addCoupon")
    public Coupon addCoupon(@RequestBody Coupon coupon) {
        return couponService.addCoupon(coupon);
    }
    @PutMapping ("/Company2/updateCoupon")
    public void updateCompany(@RequestBody Coupon coupon) {
        couponService.updateCoupon(coupon);

    }
        @GetMapping("/Company2/getAllCoupons")
    public List<Coupon> getAllCoupons(){
        return couponService.getAllCoupons();
    }

    @DeleteMapping("/Company2/deleteCoupon")
    public void deleteCoupon(@RequestParam int id){
        couponService.deleteCoupon(id);
    }

    @GetMapping("/Company2/getOneCouponById")
    public Optional<Coupon> getOneCoupon(int id){
        return couponService.getOneCoupon(id);
    }
}
