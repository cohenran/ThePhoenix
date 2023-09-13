package com.homework.controller;

import com.homework.Application;
import com.homework.model.AuthenticationMethodEntity;
import com.homework.model.ClientEntity;
import com.homework.model.ProductEntity;
import com.homework.model.PropertiesEntity;
import com.homework.services.ClientService;
import com.homework.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ClientControllerTest {
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProductService productService;

	@Test
	public void clientCreationTest() {
		ClientEntity clientEntity = createClient(true, "SMS", "0524123456");

		assertEquals(clientEntity.getIsAuthorized(), true);
		assertEquals(clientEntity.getAuthenticationMethod().getAuthenticationMethodType(), "SMS");
		assertEquals(clientEntity.getAuthenticationMethod().getAuthenticationMethodValue(), "0524123456");
	}

	@Test
	public void getProductsListTest() {
		ClientEntity clientEntity = createClient(true, "SMS", "0524123456");
		
		Set<ProductEntity> productEntities = new HashSet<>();
		productEntities.add(productService.buyNewProduct(new PropertiesEntity(Arrays.asList("TV", "23Inch"))));
		productEntities.add(productService.buyNewProduct(new PropertiesEntity(Arrays.asList("TV", "24Inch"))));
		productEntities.add(productService.buyNewProduct(new PropertiesEntity(Arrays.asList("Basketball"))));
		
		productEntities.forEach(p -> productService.buyNewProduct(p));
		
		clientEntity.setProducts(productEntities);
		
		ClientEntity returnClient = clientService.updateClient(clientEntity);
		assertEquals(returnClient.getProducts().size(), 3);
	}

	private ClientEntity createClient(Boolean isAuthorized, String authenticationMethodType, String authenticationMethodValue) {
		AuthenticationMethodEntity authenticationMethod = new AuthenticationMethodEntity(authenticationMethodType, authenticationMethodValue);
		return clientService.createClient(isAuthorized, authenticationMethod.getAuthenticationMethodType(),
				authenticationMethod.getAuthenticationMethodValue());
	}
}
