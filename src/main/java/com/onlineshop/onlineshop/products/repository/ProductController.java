package com.onlineshop.onlineshop.products.repository;

import com.onlineshop.onlineshop.products.model.Product;
import com.onlineshop.onlineshop.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> listProducts(
            @RequestParam(name = "minPrice", required = false) Float minPrice,
            @RequestParam(name = "maxPrice", required = false) Float maxPrice,
            @RequestParam(name = "available", required = false) Boolean available,
            @RequestParam(name = "category", required = false) String category) {

        List<Product> products = productService.filterProducts(minPrice, maxPrice, available, category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateQuantity(
            @PathVariable Long productId,
            @RequestParam(name = "quantity") int quantity) {
        productService.updateQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productId,
            @RequestBody Product product) {
        productService.updateProduct(productId, product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // Other API endpoints can be defined here
}