package com.eyali.cupon;

import com.eyali.cupon.entities.Coupon;
import com.eyali.cupon.repo.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("couponapi")
public class CouponController {

    @Autowired
    private CouponRepository couponRepository;

    @PostMapping("/coupons")
    public Coupon create(@RequestBody Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon get(@PathVariable String code) {
        return couponRepository.findByCode(code).orElseThrow(() -> new IllegalArgumentException("code not present"));
    }


    @GetMapping("/coupons/{code}/discount")
    public BigDecimal getDiscountByCode(@PathVariable String code) {
        return couponRepository.findByCode(code).map(Coupon::getDiscount).orElse(BigDecimal.ZERO);
    }


}
