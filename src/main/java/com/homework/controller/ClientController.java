package com.homework.controller;

import com.homework.model.ClientEntity;
import com.homework.model.ProductEntity;
import com.homework.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
	 * @param isAuthorized               is the client authorized
	 * @param authenticationMethodType The authentication method type (like SMS)
	 * @param authenticationMethodValue The authentication method value (like 0524123456)
	 * @return the new client
	 */
	@RequestMapping(value = "/create_client",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ClientEntity createClient(
			@RequestParam(required = true,
					name = "is_authorized")
					Boolean isAuthorized,
			@RequestParam(required = true,
					name = "authentication_method_type")
					String authenticationMethodType,
			@RequestParam(required = true,
					name = "authentication_method_value")
					String authenticationMethodValue) {
		return clientService.createClient(isAuthorized, authenticationMethodType, authenticationMethodValue);
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
	public Set<ProductEntity> getProductList(
			@RequestParam(required = true,
					name = "client_id")
					Integer clientId) {
		return clientService.getProductList(clientId).getProducts();
	}
}
