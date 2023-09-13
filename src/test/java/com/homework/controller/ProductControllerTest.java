package com.homework.controller;

import com.homework.Application;
import com.homework.model.ProductEntity;
import com.homework.model.PropertiesEntity;
import com.homework.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductControllerTest {
	@Autowired
	private ProductService productService;

	@Test
	@Transactional
	public void buyNewProductTest() {
		PropertiesEntity propertiesEntity = new PropertiesEntity(Arrays.asList("TV", "52Inch"));
		ProductEntity productEntity = buyANewProduct(propertiesEntity);

		assertEquals(productEntity.getProperties(), propertiesEntity);				
	}

	@Test
	@Transactional
	public void updateProductsTest() {
		PropertiesEntity propertiesEntity = new PropertiesEntity(Arrays.asList("TV", "52Inch"));
		ProductEntity productEntity = buyANewProduct(propertiesEntity);

		PropertiesEntity newPropertiesEntity = new PropertiesEntity(Arrays.asList("TV", "110Inch"));
		productEntity = productService.updateProdcuts(productEntity.getId(), newPropertiesEntity);

		assertEquals(productEntity.getProperties().getProperties().size(), 2);
		assertEquals(productEntity.getProperties().getProperties().get(1), "110Inch");
	}

	private ProductEntity buyANewProduct(PropertiesEntity propertiesEntity) {
		ProductEntity productEntity = productService.buyNewProduct(propertiesEntity);
		return productService.buyNewProduct(productEntity);
	}
}
