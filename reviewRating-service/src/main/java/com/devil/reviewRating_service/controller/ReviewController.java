//package com.devil.reviewRating_service.controller;
//
//import com.devil.reviewRating_service.dto.ProductDto;
//import com.devil.reviewRating_service.dto.ReviewDto;
//import com.devil.reviewRating_service.dto.UserDto;
//import com.devil.reviewRating_service.model.Review;
//import com.devil.reviewRating_service.repository.ReviewRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/reviews")
//public class ReviewController {
//    private final ReviewRepository reviewRepository;
//    private final ProductClient productClient;
//    private final UserClient userClient;
//
//    public ReviewController(ReviewRepository reviewRepository, ProductClient productClient, UserClient userClient) {
//        this.reviewRepository = reviewRepository;
//        this.productClient = productClient;
//        this.userClient = userClient;
//    }
//
//    public ReviewDto convertToReviewDto(Review review){
//        ReviewDto reviewDto = new ReviewDto();
//        reviewDto.setId(review.getId());
//        reviewDto.setUser(userClient.getUserById(review.getUserId()));
//        reviewDto.setProduct(productClient.getProductById(review.getProductId()));
//        reviewDto.setComment(review.getComment());
//        reviewDto.setRating(review.getRating());
//        return  reviewDto;
//    }
//
//    @GetMapping
//    public List<ReviewDto> getAllReviews(){
//        return reviewRepository.findAll()
//                .stream().map(this::convertToReviewDto).collect(Collectors.toList());
//    }
//    @PostMapping
//    public ReviewDto addReview(@RequestBody Review review){
//        reviewRepository.save(review);
//        return convertToReviewDto(review);
//    }
//    @GetMapping("/{id}")
//    public UserDto allUser(@PathVariable Long id){
//        return userClient.getUserById(id);
//    }
//    @GetMapping("/p/{id}")
//    public ProductDto allProduct(@PathVariable Long id){
//    return  productClient.getProductById(id);
//    }
//}
package com.devil.reviewRating_service.controller;

import com.devil.reviewRating_service.dto.ProductDto;
import com.devil.reviewRating_service.dto.ReviewDto;
import com.devil.reviewRating_service.dto.UserDto;
import com.devil.reviewRating_service.model.Review;
import com.devil.reviewRating_service.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewRepository reviewRepository;
    private final WebClient.Builder webClientBuilder;

    public ReviewController(ReviewRepository reviewRepository, WebClient.Builder webClientBuilder) {
        this.reviewRepository = reviewRepository;
        this.webClientBuilder = webClientBuilder;
    }

    private ReviewDto convertToReviewDto(Review review) {
        UserDto user = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/users/{id}", review.getUserId())
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();

        ProductDto product = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/products/{id}", review.getProductId())
                .retrieve()
                .bodyToMono(ProductDto.class)
                .block();

        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setUser(user);
        reviewDto.setProduct(product);
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());
        return reviewDto;
    }

    @GetMapping
    public List<ReviewDto> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(this::convertToReviewDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ReviewDto addReview(@RequestBody Review review) {
        reviewRepository.save(review);
        return convertToReviewDto(review);
    }

    @GetMapping("/{id}")
    public ReviewDto getReviewById(@PathVariable Long id) {
        return reviewRepository.findById(id)
                .map(this::convertToReviewDto)
                .orElse(null); // Handle not found case properly in a real application
    }

//    @GetMapping("/user/{id}")
//    public UserDto getUserById(@PathVariable Long id) {
//        return webClientBuilder.build()
//                .get()
//                .uri("http://localhost:8081/users/{id}", id)
//                .retrieve()
//                .bodyToMono(UserDto.class)
//                .block();
//    }

//    @GetMapping("/product/{id}")
//    public ProductDto getProductById(@PathVariable Long id) {
//        return webClientBuilder.build()
//                .get()
//                .uri("http://localhost:8082/products/{id}", id)
//                .retrieve()
//                .bodyToMono(ProductDto.class)
//                .block();
//    }
}
