package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.GardSalaryEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.repository.GardSalaryDAOInt;




@Service ("salaryservice")                        //it provide buisness functionalities 
public class  GardSalaryEntityServiceImp implements GardSalaryServiceInt{
	@SuppressWarnings("rawtypes")
	@Autowired
	GardSalaryDAOInt gardSalaryDao;
    @SuppressWarnings("unchecked")
	@Override
	public List< GardSalaryEntity> showGardSalaryEntity() {
    	   //gards salary list is created which acts like an in memory database for delivery object .
		System.out.println("Service layer entity called");
		return (List< GardSalaryEntity>) gardSalaryDao.findAll();
		
	}
    @SuppressWarnings("unchecked")
	@Transactional                  // applies as a default to all methods
	@Override
	public GardSalaryEntity add(GardSalaryEntity request) throws DuplicateRecordException {
    	Optional<GardSalaryEntity> gardSalary=gardSalaryDao.findById(request.getId());
    	
    	if(gardSalary.isPresent()) {
    		 /*value is present,isPresent()
            save method will return saved entity */
    		
			throw new DuplicateRecordException("GardSalary Entity with this name "+request.getId()+"already Exist");
		}
	else
	{
		return (GardSalaryEntity) gardSalaryDao.save(request);
		
	}	
	}
	
    @SuppressWarnings("unchecked")
	@Transactional
	@Override
	public  GardSalaryEntity update( GardSalaryEntity bean)throws RecordNotFoundException {
    	
		Optional< GardSalaryEntity> gardSalary=gardSalaryDao.findById(bean.getId());
		if(gardSalary.isPresent()) {
			return (GardSalaryEntity) gardSalaryDao.save(bean);
		}
		else
		{
			throw new RecordNotFoundException("GardSalary Entity  id "+bean.getId()+"Doesn't Exist");
		}
		
    	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
    public boolean deleteGardSalaryById(long GardSalaryId) {
      gardSalaryDao.deleteById(GardSalaryId);
        return false ;
}
	@SuppressWarnings("unchecked")
	@Override
	public GardSalaryEntity findById(long GardSalaryEntityTestId) {
		Optional<GardSalaryEntity> gardSalary=gardSalaryDao.findById(GardSalaryEntityTestId);
		return gardSalary.get();
	}
	public void save(GardSalaryEntity testGardSalaryEntity) {
		
	}
}