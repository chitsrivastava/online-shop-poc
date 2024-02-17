package com.onlineshop.onlineshop.products.repository;

import com.onlineshop.onlineshop.products.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Long> findProductIdsByAvailability(Boolean available);
    // You can define custom query methods here if needed
}
