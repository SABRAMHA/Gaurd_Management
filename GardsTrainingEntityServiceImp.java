package com.demo.service;



import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entities.GardsTrainingEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.repository.GardsTrainingDAOInt;




@Service("gardTrainingservice")                  //it provide buisness functionalities 
public class GardsTrainingEntityServiceImp implements GardsTrainingServiceInt {
    @SuppressWarnings("rawtypes")
	@Autowired
    GardsTrainingDAOInt gardTrainingDao;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<GardsTrainingEntity> showGardsTrainingEntity() {
    	 //gards list is created which acts like an in memory database for delivery object .
        System.out.println("GardTraining layer entity called");
        return (List<GardsTrainingEntity>) gardTrainingDao.findAll();



   }
     @SuppressWarnings("unchecked")
	@Transactional                 // applies as a default to all methods
        @Override
        public GardsTrainingEntity add(GardsTrainingEntity request) throws DuplicateRecordException  {
            Optional<GardsTrainingEntity> gardTraining = gardTrainingDao.findById(request.getId());

        	if(gardTraining.isPresent()) {
        		 /*value is present,isPresent()
                save method will return saved entity */
        		
        			throw new DuplicateRecordException("Delivery Entity with this name "+request.getId()+"already Exist");
        		}
        	else
        	{
        		return (GardsTrainingEntity) gardTrainingDao.save(request);
        		
        	}
        	}



     @SuppressWarnings("unchecked")
	@Transactional
        @Override
        public GardsTrainingEntity update(GardsTrainingEntity bean)throws RecordNotFoundException {



           Optional<GardsTrainingEntity> gardTraining = gardTrainingDao.findById(bean.getId());
           if(gardTraining.isPresent()) {
   			return (GardsTrainingEntity) gardTrainingDao.save(bean);
   		}
   		else
   		{
   			throw new RecordNotFoundException("Delivery Entity  id "+bean.getId()+"Doesn't Exist");
   		}
   		
       	}


     @SuppressWarnings("unchecked")
	@Transactional
     @Override
     public boolean deleteGardsTrainingById(long GardsTrainingId) {
       gardTrainingDao.deleteById(GardsTrainingId);
         return false ;
     }
	@SuppressWarnings("unchecked")
	@Override
	public GardsTrainingEntity findById(long gardsTrainingEntityTestId) {
		Optional<GardsTrainingEntity> gardsTraining=gardTrainingDao.findById(gardsTrainingEntityTestId);
		return gardsTraining.get();
	}
	public void save(GardsTrainingEntity testGardsTrainingEntity) {
	}
	}
    