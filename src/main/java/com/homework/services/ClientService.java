package com.homework.services;

import com.homework.dal.ClientRepository;
import com.homework.model.AuthenticationMethod;
import com.homework.model.ClientEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ClientService {
	@Resource
	private ClientRepository clientRepository;

	public ClientEntity createClient(Boolean isAuthorized, AuthenticationMethod authenticationMethod) {
		ClientEntity clientEntity = new ClientEntity(isAuthorized, authenticationMethod);

		return clientRepository.save(clientEntity);
	}

	public ClientEntity getProductList(Integer clientId) {
		Optional<ClientEntity> clientEntityOpt = clientRepository.findById(clientId);

		if (clientEntityOpt.isEmpty()) {
			throw new RuntimeException("NO CLIENT FOUND");
		}

		return clientEntityOpt.get();
	}
}
