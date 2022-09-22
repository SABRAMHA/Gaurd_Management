package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.GardSalaryEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;


@Service
public interface GardSalaryServiceInt {
	List<GardSalaryEntity> showGardSalaryEntity();

	public GardSalaryEntity add(GardSalaryEntity bean) throws DuplicateRecordException;
	
	public GardSalaryEntity update(GardSalaryEntity bean)throws RecordNotFoundException;
	
	public boolean deleteGardSalaryById(long GardSalaryId);

	public GardSalaryEntity findById(long Id);
	
	
}
