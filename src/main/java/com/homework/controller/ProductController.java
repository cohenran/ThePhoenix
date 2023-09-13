package com.homework.controller;

import com.homework.model.ProductEntity;
import com.homework.model.PropertiesEntity;
import com.homework.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	/**
	 * Creating a new product to buy
	 *
	 * @param properties the properties of the product
	 * @return the product
	 */
	@RequestMapping(value = "/buy_new_product",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ProductEntity buyNewProduct(
			@RequestParam(required = true,
					name = "properties")
					List<String> properties) {
		PropertiesEntity propertiesEntity = new PropertiesEntity(properties);
		return productService.buyNewProduct(propertiesEntity);
	}

	/**
	 * Creating a new product to buy
	 *
	 * @param id         the product ID to be updated
	 * @param properties the updated properties of the product
	 * @return the product
	 */
	@RequestMapping(value = "/update_product",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ProductEntity updateProducts(
			@RequestParam(required = true,
					name = "id")
					Integer id,
			@RequestParam(required = true,
					name = "properties")
					List<String> properties) {
		PropertiesEntity propertiesEntity = new PropertiesEntity(properties);
		return productService.updateProdcuts(id, propertiesEntity);
	}
}
