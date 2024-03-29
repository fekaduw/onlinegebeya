package com.fekadu.onlinegebeya.domain;

import lombok.Data;

@Data
public class ProductInfo {
    private Long id;
    private String name;
    private int rating;
    private String categories;
    private double unitPrice;
    private String picture;
    private Boolean isAnAdd;
}
