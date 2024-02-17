package com.onlineshop.onlineshop.products.repository;

import com.onlineshop.onlineshop.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetweenAndAvailableAndCategory(Float minPrice, Float maxPrice, Boolean available, String category);

    List<Product> findByPriceBetweenAndAvailable(Float minPrice, Float maxPrice, Boolean available);

    List<Product> findByPriceBetweenAndCategory(Float minPrice, Float maxPrice, String category);

    List<Product> findByPriceBetween(Float minPrice, Float maxPrice);

    List<Product> findByAvailableAndCategory(Boolean available, String category);

    List<Product> findByAvailable(Boolean available);

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetweenAndAvailableAndCategoryAndIdIn(Float minPrice, Float maxPrice, Boolean available, String category, List<Long> availableProductIds);

    List<Product> findByPriceBetweenAndAvailableAndIdIn(Float minPrice, Float maxPrice, Boolean available, List<Long> availableProductIds);

    List<Product> findByAvailableAndCategoryAndIdIn(Boolean available, String category, List<Long> availableProductIds);

    List<Product> findByAvailableAndIdIn(Boolean available, List<Long> availableProductIds);

    List<Product> findByIdIn(List<Long> availableProductIds);

    List<Product> findByCategoryAndIdIn(String category, List<Long> availableProductIds);

    List<Product> findByPriceBetweenAndIdIn(Float minPrice, Float maxPrice, List<Long> availableProductIds);

    List<Product> findByPriceBetweenAndCategoryAndIdIn(Float minPrice, Float maxPrice, String category, List<Long> availableProductIds);
    // You can define custom query methods here if needed
}
