package com.jizapika.carShop.repos;

import com.jizapika.carShop.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Long> {
    Seller findByUsername(String username);
}
