package com.demo.service;



import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entities.SecurityEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.repository.SecurityDAOInt;



@Service("securityservice")                //it provide buisness functionalities 
public class SecurityEntityServiceImp implements SecurityService {
    @SuppressWarnings("rawtypes")
    @Autowired
    SecurityDAOInt securityDao;



   @SuppressWarnings("unchecked")
    @Override
    public List<SecurityEntity> showSecurityEntity() {
	   //security list is created which acts like an in memory database for delivery object .
        System.out.println("Service layer entity called");
        return (List<SecurityEntity>) securityDao.findAll();



   }



   @SuppressWarnings("unchecked")
    @Transactional              // applies as a default to all methods
    @Override
    public SecurityEntity add(SecurityEntity request) throws DuplicateRecordException {
        Optional<SecurityEntity> security = securityDao.findById(request.getId());



    	if(security.isPresent()) {
    		 /*value is present,isPresent()
            save method will return saved entity */
    		
    			throw new DuplicateRecordException("Delivery Entity with this name "+request.getId()+"already Exist");
    		}
    	else
    	{
    		return (SecurityEntity) securityDao.save(request);
    		
    	}
    	}

   @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public SecurityEntity update(SecurityEntity bean)throws RecordNotFoundException {



       Optional<SecurityEntity> security = securityDao.findById(bean.getId());
      
        if(security.isPresent()) {
			return (SecurityEntity) securityDao.save(bean);
		}
		else
		{
			throw new RecordNotFoundException("Security Entity  id "+bean.getId()+"Doesn't Exist");
		}
		
    	}
   @SuppressWarnings("unchecked")
@Transactional
   @Override
   public boolean deleteSecurityById(long SecurityId){
     securityDao.deleteById(SecurityId);
       return false ;
   }
   @Override
   public SecurityEntity findById(long securityEntityTestId) {
       @SuppressWarnings("unchecked")
       Optional <SecurityEntity> security=securityDao.findById(securityEntityTestId);
       return security.get();
   }





public void save(SecurityEntity testSecurityEntity) {
   
   
}

   }
