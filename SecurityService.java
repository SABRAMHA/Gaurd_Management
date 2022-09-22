package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.GardsTrainingEntity;
import com.demo.entities.SecurityEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;


@SuppressWarnings("unused")
@Service
public interface SecurityService {
List<SecurityEntity> showSecurityEntity();
	public SecurityEntity add(SecurityEntity bean)throws DuplicateRecordException;
	
	public SecurityEntity update(SecurityEntity bean)throws RecordNotFoundException;
	
	public boolean deleteSecurityById(long SecurityId);

	public SecurityEntity findById(long Id);
	
}
