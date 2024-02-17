package com.onlineshop.onlineshop.products.service;

import com.onlineshop.onlineshop.products.model.Inventory;
import com.onlineshop.onlineshop.products.model.Product;
import com.onlineshop.onlineshop.products.repository.CategoryRepository;
import com.onlineshop.onlineshop.products.repository.InventoryRepository;
import com.onlineshop.onlineshop.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductService() {
    }
    public List<Product> filterProducts(Float minPrice, Float maxPrice, Boolean available, String category) {
        if (minPrice != null && maxPrice != null && available != null && category != null) {
            // Case: minPrice, maxPrice, available, and category are defined
            List<Long> availableProductIds = inventoryRepository.findProductIdsByAvailability(available);
            return productRepository.findByPriceBetweenAndCategoryAndIdIn(minPrice, maxPrice, category, availableProductIds);
        } else if (minPrice != null && maxPrice != null && available != null) {
            // Case: minPrice, maxPrice, and available are defined
            List<Long> availableProductIds = inventoryRepository.findProductIdsByAvailability(available);
            return productRepository.findByPriceBetweenAndIdIn(minPrice, maxPrice, availableProductIds);
        } else if (minPrice != null && maxPrice != null && category != null) {
            // Case: minPrice, maxPrice, and category are defined
            return productRepository.findByPriceBetweenAndCategory(minPrice, maxPrice, category);
        } else if (minPrice != null && maxPrice != null) {
            // Case: minPrice and maxPrice are defined
            return productRepository.findByPriceBetween(minPrice, maxPrice);
        } else if (available != null && category != null) {
            // Case: available and category are defined
            List<Long> availableProductIds = inventoryRepository.findProductIdsByAvailability(available);
            return productRepository.findByCategoryAndIdIn(category, availableProductIds);
        } else if (available != null) {
            // Case: available is defined
            List<Long> availableProductIds = inventoryRepository.findProductIdsByAvailability(available);
            return productRepository.findByIdIn(availableProductIds);
        } else if (category != null) {
            // Case: category is defined
            return productRepository.findByCategory(category);
        } else {
            // Case: No filters are applied, return all products
            return productRepository.findAll();
        }
    }

    public Product addProduct(Product product) {
        // Save the product to the product table
        Product savedProduct = productRepository.save(product);

        // You can also save inventory and category information here if needed
        // For simplicity, let's assume we only save the product

        return savedProduct;
    }

    public void deleteProduct(Long productId) {
        // Delete the product from the product table
        productRepository.deleteById(productId);

        // You can also delete associated inventory and category information here if needed
    }

    public void updateQuantity(Long productId, int quantity) {
        // Update the quantity in the inventory table for the specified product
        Optional<Inventory> optionalInventory = inventoryRepository.findById(productId);
        if (optionalInventory.isPresent()) {
            Inventory inventory = optionalInventory.get();
            inventory.setQuantity(quantity);
            inventoryRepository.save(inventory);
        } else {
            // Handle the case where the inventory for the product does not exist
            // This can be based on your application's requirements
            // For example, you could throw an exception or log a warning
        }
    }

    public void updateProduct(Long productId, Product updatedProduct) {
        // Update the price in the product table for the specified product
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(updatedProduct.getName());
            product.setImageUrl(updatedProduct.getImageUrl());
            product.setPrice(updatedProduct.getPrice());
            product.setDisplayPrice(updatedProduct.getDisplayPrice());
            // Update other fields as needed
            productRepository.save(product);
        } else {
            // Handle the case where the product does not exist
            // This can be based on your application's requirements
            // For example, you could throw an exception or log a warning
        }
    }
}
