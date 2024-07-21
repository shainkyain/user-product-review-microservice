package com.devil.product_service.controller;

import com.devil.product_service.model.Product;
import com.devil.product_service.model.ProductDto;
import com.devil.product_service.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto convertToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setRating(product.getRating());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productRepository.findAll()
                .stream().map(data -> convertToDto(data)).collect(Collectors.toList());
    }
    @PostMapping
    ProductDto addProduct(@RequestBody Product product){
        Product savedProduct = productRepository.save(product);
        return convertToDto(savedProduct);
    }
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        Product savedProduct1 =  productRepository.findById(id).get();
        return convertToDto(savedProduct1);
    }

}
