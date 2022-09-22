package com.demo.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.demo.entities.GardsTrainingEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;

import com.demo.service.GardsTrainingServiceInt;



@RestController                                        //rest controller is used to handle the request
@RequestMapping(value="/gardtrainingentity")           //request mapping map specific request path
public class GardsTrainingEntityController {



     @Autowired                                         // enable to get object dependency
      GardsTrainingServiceInt gardTrainingService;
              @GetMapping(value="/show",produces="application/json")  // GET //http://localhost:8080/UserApp/gardstrainingentity/show
              List<GardsTrainingEntity> showGardsTrainingEntity(){
                  System.out.println("GardTraining entity controller");
                  List<GardsTrainingEntity> gardTrainingList=gardTrainingService.showGardsTrainingEntity();
                  return gardTrainingList;
              }
              @GetMapping(value = "/show3", produces = "application/json")
              public ResponseEntity<GardsTrainingEntity> findById(@PathVariable("Id")long Id) {
            	  GardsTrainingEntity gardsTraining= gardTrainingService.findById(Id);
                  return new ResponseEntity<GardsTrainingEntity>(gardsTraining,HttpStatus.OK);
              }
              @PostMapping(consumes="application/json",produces="application/json")   //POST  //http://localhost:8080/UserApp/gardstrainingentity
              ResponseEntity<GardsTrainingEntity> add(@RequestBody GardsTrainingEntity gardTraining) throws DuplicateRecordException {
          
                  GardsTrainingEntity id=gardTrainingService.add(gardTraining);

                  if(id.getId()==0) 
                  {
                  	System.out.println("Before exception");
                  	throw new DuplicateRecordException("GardsTrainingEntity with this id already Exist");
                  	
                  	
                  }
                  System.out.println("GardsTrainigEntity name in controller is "+id);
                  return ResponseEntity.ok(id);
                  }
              
              @PutMapping(consumes="application/json",produces="application/json")     //PUT //http://localhost:8080/UserApp/gardstrainingentity
             ResponseEntity<GardsTrainingEntity> update(@RequestBody GardsTrainingEntity gardTraining)throws RecordNotFoundException{
            	  GardsTrainingEntity id=gardTrainingService.update(gardTraining);
            		
            		if (id==null)
            		{
            			throw new RecordNotFoundException("DeliveryEntity with this name "+gardTraining.getId()+"already Exist");
            			
            			
            		}
            		System.out.println("DeliveryEntity name in controller is "+id);
            		return ResponseEntity.ok(id);
            		}
              
              @DeleteMapping(value = "/show2/{GardsTrainingId}", produces = "application/json")   //DELETE   http://localhost:8080/UserApp/gardstrainingentity/show2/id
              public ResponseEntity<GardsTrainingEntity> deleteGardsTrainingById(@PathVariable("GardsTrainingId") long GardsTrainingId) throws RecordNotFoundException{
                gardTrainingService.deleteGardsTrainingById(GardsTrainingId);
                  return new ResponseEntity<GardsTrainingEntity>(HttpStatus.OK);
              }
      }