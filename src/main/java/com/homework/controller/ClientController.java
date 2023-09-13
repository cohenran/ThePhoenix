package com.homework.controller;

import com.homework.model.AuthenticationMethod;
import com.homework.model.ClientEntity;
import com.homework.model.ProductEntity;
import com.homework.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	/**
	 * Create a new client
	 *
	 * @param isAuthorized         is the client authorized
	 * @param authenticationMethod The authentication method
	 * @return the new client
	 */
	@RequestMapping(value = "/create_client",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ClientEntity createClient(Boolean isAuthorized, AuthenticationMethod authenticationMethod) {
		return clientService.createClient(isAuthorized, authenticationMethod);
	}

	/**
	 * Gets the products of the client
	 *
	 * @param clientId the client
	 * @return the products
	 */
	@RequestMapping(value = "/get_product_list",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Set<ProductEntity> getProductList(Integer clientId) {
		return clientService.getProductList(clientId).getProducts();
	}
}
