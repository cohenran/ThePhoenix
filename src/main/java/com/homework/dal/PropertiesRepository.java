package com.homework.dal;

import com.homework.model.PropertiesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends CrudRepository<PropertiesEntity, Integer> {
}
