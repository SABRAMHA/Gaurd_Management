package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.GardShiftEntity;

@SuppressWarnings("unused")
@Repository

public interface GardShiftDAOInt extends CrudRepository<GardShiftEntity,Long>{

	
}
