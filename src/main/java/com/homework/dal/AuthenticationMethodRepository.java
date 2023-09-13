package com.homework.dal;

import com.homework.model.AuthenticationMethodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationMethodRepository extends CrudRepository<AuthenticationMethodEntity, Integer> {
}
