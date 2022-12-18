package com.jizapika.carShop.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Seller;

    @Override
    public String getAuthority() {
        return name();
    }
}
