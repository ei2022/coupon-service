package com.eyali.cupon.repo;

import com.eyali.cupon.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {


   Optional<Coupon> findByCode(String code);

}