package com.devil.reviewRating_service.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private int rating;
    private double price;
}
