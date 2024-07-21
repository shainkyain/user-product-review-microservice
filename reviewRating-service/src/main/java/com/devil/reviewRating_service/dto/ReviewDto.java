package com.devil.reviewRating_service.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private int rating;
    private String comment;
    private ProductDto product;
    private UserDto user;
}
