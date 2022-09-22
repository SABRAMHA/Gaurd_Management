package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.SecurityEntity;


@SuppressWarnings("unused")
@Repository
public interface SecurityDAOInt extends CrudRepository<SecurityEntity, Long>{

	
}
