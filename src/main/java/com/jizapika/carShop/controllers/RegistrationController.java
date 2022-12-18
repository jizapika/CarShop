package com.jizapika.carShop.controllers;

import com.jizapika.carShop.domain.Role;
import com.jizapika.carShop.domain.Seller;
import com.jizapika.carShop.repos.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private SellerRepo sellerRepo;
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Seller seller, Map<String, Object> model) {
        Seller sellerFromDB = sellerRepo.findByUsername(seller.getUsername());

        if (sellerFromDB != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        seller.setActive(true);
        seller.setRoles(Collections.singleton(Role.Seller));
        sellerRepo.save(seller);
        return "redirect:/login";
    }
}
