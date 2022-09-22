package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.GardSalaryEntity;
import com.demo.entities.GardShiftEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;


@SuppressWarnings("unused")
@Service
public interface GardShiftServiceInt {
List<GardShiftEntity> showGardShiftEntity();
	public GardShiftEntity add(GardShiftEntity bean)throws DuplicateRecordException;
	
	public GardShiftEntity update(GardShiftEntity bean)throws RecordNotFoundException;
	
	public boolean deleteGardShiftById(long GardShiftId);

	public GardShiftEntity findById(long Id);
	
	
}
