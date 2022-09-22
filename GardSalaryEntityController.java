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


import com.demo.entities.GardSalaryEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.GardSalaryServiceInt;


@RestController                                 //rest controller is used to handle the request
@RequestMapping(value="/gardsalaryentity")     //request mapping map specific request path
public class GardSalaryEntityController {
	
@Autowired                                      // enable to get object dependency
GardSalaryServiceInt gardSalaryService;
@GetMapping(value="/show",produces="application/json")
List<GardSalaryEntity> showGardSalaryEntity(){
	System.out.println("gardSalary Entity controller");
	List<GardSalaryEntity> gardSalaryList=gardSalaryService.showGardSalaryEntity();
	return gardSalaryList;
}

@GetMapping(value="/show3",produces="application/json")      // GET //http://localhost:8080/UserApp/gardsalaryentity/show
public ResponseEntity<GardSalaryEntity> findById(@PathVariable("Id")long Id){
  GardSalaryEntity gardSalary=gardSalaryService.findById(Id);
  return new ResponseEntity<GardSalaryEntity>(gardSalary,HttpStatus.OK);
}
@PostMapping(consumes="application/json",produces="application/json")     //POST  //http://localhost:8080/UserApp/gardsalaryentity
ResponseEntity<GardSalaryEntity> add(@RequestBody GardSalaryEntity gardSalary) throws DuplicateRecordException{

	GardSalaryEntity id=gardSalaryService.add(gardSalary);
	if(id.getId()==0) 
	{
		System.out.println("Before exception");
		throw new DuplicateRecordException("GardSalaryEntity with this id already Exist");
		
		
	}
	System.out.println("GardSalaryEntity name in controller is "+id);
	return ResponseEntity.ok(id);
	}
@PutMapping(consumes="application/json",produces="application/json")     //PUT //http://localhost:8080/UserApp/gardsalaryentity
 ResponseEntity<GardSalaryEntity> update(@RequestBody GardSalaryEntity gardSalary)throws RecordNotFoundException{
	
	GardSalaryEntity id=gardSalaryService.update(gardSalary);
	
	if (id==null)
	{
		throw new RecordNotFoundException("DeliveryEntity with this name "+gardSalary.getId()+"already Exist");
		
		
	}
	System.out.println("GardSalaryEntity name in controller is "+id);
	return ResponseEntity.ok(id);
	}
@DeleteMapping(value = "/show2/{GardSalaryId}", produces = "application/json") //DELETE   http://localhost:8080/UserApp/gardsalaryentity/show2/id
public ResponseEntity<GardSalaryEntity> deleteGardSalaryById(@PathVariable("GardSalaryId") long GardSalaryId) throws RecordNotFoundException{
  gardSalaryService.deleteGardSalaryById(GardSalaryId);
    return new ResponseEntity<GardSalaryEntity>(HttpStatus.OK);
}
}
