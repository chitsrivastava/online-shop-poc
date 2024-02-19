package com.selimhorri.app.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private String productTitle;
	private String imageUrl;
	private Double priceUnit;
	private Integer quantity;

	@JsonProperty("category")
	@JsonInclude(Include.NON_NULL)
	private CategoryDto categoryDto;

	@JsonProperty("inventory")
	@JsonInclude(Include.NON_NULL)
	private InventoryDto inventoryDto;
}










