package com.homework.services;

import com.homework.dal.AuthenticationMethodRepository;
import com.homework.dal.ClientRepository;
import com.homework.model.AuthenticationMethodEntity;
import com.homework.model.ClientEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ClientService {
	@Resource
	private ClientRepository clientRepository;
	@Resource
	private AuthenticationMethodRepository authenticationMethodRepository;

	public ClientEntity createClient(Boolean isAuthorized, String authenticationMethodType, String authenticationMethodValue) {
		AuthenticationMethodEntity authenticationMethodEntity = new AuthenticationMethodEntity(authenticationMethodType, authenticationMethodValue);
		authenticationMethodEntity = authenticationMethodRepository.save(authenticationMethodEntity);
		ClientEntity clientEntity = new ClientEntity(isAuthorized, authenticationMethodEntity);

		return clientRepository.save(clientEntity);
	}

	public ClientEntity getProductList(Integer clientId) {
		Optional<ClientEntity> clientEntityOpt = clientRepository.findById(clientId);

		if (clientEntityOpt.isEmpty()) {
			throw new RuntimeException("NO CLIENT FOUND");
		}

		return clientEntityOpt.get();
	}

	public ClientEntity updateClient(ClientEntity clientEntity) {
		return clientRepository.save(clientEntity);
	}
}
