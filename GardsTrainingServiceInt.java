package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.DeliveryEntity;
import com.demo.entities.GardsTrainingEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;

@SuppressWarnings("unused")
@Service

public interface GardsTrainingServiceInt {
List<GardsTrainingEntity> showGardsTrainingEntity();

	public GardsTrainingEntity add(GardsTrainingEntity bean) throws DuplicateRecordException;
	
	public GardsTrainingEntity update(GardsTrainingEntity bean)throws RecordNotFoundException;
	
	public boolean deleteGardsTrainingById(long GardsTrainingId);

	public GardsTrainingEntity findById(long Id);
	
}
