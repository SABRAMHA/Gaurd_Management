package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.GardShiftEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.repository.GardShiftDAOInt;





@Service ("shiftservice")                         //it provide buisness functionalities 
public class  GardShiftEntityServiceImp implements GardShiftServiceInt{
	@SuppressWarnings("rawtypes")
	@Autowired
	GardShiftDAOInt gardShiftDao;
    @SuppressWarnings("unchecked")
	@Override
	public List< GardShiftEntity> showGardShiftEntity() {
    	  //gards shift list is created which acts like an in memory database for delivery object .
		System.out.println("Service layer entity called");
		return (List< GardShiftEntity>) gardShiftDao.findAll();
		
	}
    @SuppressWarnings("unchecked")
	@Transactional                       // applies as a default to all methods
	@Override
	public GardShiftEntity add( GardShiftEntity request) throws DuplicateRecordException{
    	Optional< GardShiftEntity> gardShift=gardShiftDao.findById(request.getId());
    	

    	if(gardShift.isPresent()) {
    		 /*value is present,isPresent()
            save method will return saved entity */
    		
    			throw new DuplicateRecordException("Delivery Entity with this name "+request.getId()+"already Exist");
    		}
    	else
    	{
    		return (GardShiftEntity) gardShiftDao.save(request);
    		
    	}
    	}
    @SuppressWarnings("unchecked")
	@Transactional
	@Override
	public  GardShiftEntity update( GardShiftEntity bean) throws RecordNotFoundException{
    	
		Optional< GardShiftEntity> gardShift=gardShiftDao.findById(bean.getId());
		if(gardShift.isPresent()) {
			return (GardShiftEntity) gardShiftDao.save(bean);
		}
		else
		{
			throw new RecordNotFoundException("GardShift Entity  id "+bean.getId()+"Doesn't Exist");
		}
		
    	}
    @SuppressWarnings("unchecked")
	@Transactional
    @Override
    public boolean deleteGardShiftById(long gardShiftId) {
        gardShiftDao.deleteById(gardShiftId);
        return false ;
    }
	@SuppressWarnings("unchecked")
	@Override
	public GardShiftEntity findById(long gardShiftEntityTestId) {
		Optional<GardShiftEntity> gardShift=gardShiftDao.findById(gardShiftEntityTestId);
		
		return gardShift.get();
	}
	public void save(GardShiftEntity testGardShiftEntity){
	}
}
