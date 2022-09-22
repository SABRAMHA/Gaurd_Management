package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.GardSalaryEntity;


@SuppressWarnings("unused")
@Repository
public interface GardSalaryDAOInt extends CrudRepository<GardSalaryEntity,Long>{


	
}
