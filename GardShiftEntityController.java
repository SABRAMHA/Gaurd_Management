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


import com.demo.entities.GardShiftEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.GardShiftServiceInt;


@RestController                                    //rest controller is used to handle the request
@RequestMapping(value="/gardshiftentity")           //request mapping map specific request path
public class GardShiftEntityController {
	
@Autowired                                         // enable to get object dependency
GardShiftServiceInt gardShiftService;
@GetMapping(value="/show",produces="application/json")  // GET //http://localhost:8080/UserApp/gardshiftentity/show
List<GardShiftEntity> showGardSalaryEntity(){
	System.out.println("gardShift Entity controller");
	List<GardShiftEntity> gardShiftList=gardShiftService.showGardShiftEntity();
	return gardShiftList;
}
@GetMapping(value = "/show3", produces = "application/json")
public ResponseEntity<GardShiftEntity> findById(@PathVariable("Id")long Id) {
GardShiftEntity gardShift= gardShiftService.findById(Id);
    return new ResponseEntity<GardShiftEntity>(gardShift,HttpStatus.OK);
}
@PostMapping(consumes="application/json",produces="application/json")   //POST  //http://localhost:8080/UserApp/gardshiftentity
ResponseEntity<GardShiftEntity> add(@RequestBody GardShiftEntity gardShift) throws DuplicateRecordException{

	GardShiftEntity id=gardShiftService.add(gardShift);
	if(id.getId()==0) 
	{
		System.out.println("Before exception");
		throw new DuplicateRecordException("GardShiftEntity with this id already Exist");
		
		
	}

System.out.println("gardShift Entity name in controller is "+id);
return ResponseEntity.ok(id);
}
@PutMapping(consumes="application/json",produces="application/json")  //PUT //http://localhost:8080/UserApp/gardshiftentity
 ResponseEntity<GardShiftEntity> update(@RequestBody GardShiftEntity gardShift)throws RecordNotFoundException{
	GardShiftEntity id=gardShiftService.update(gardShift);
	
	if (id==null)
	{
		throw new RecordNotFoundException("GardShiftEntity with this name "+gardShift.getId()+"already Exist");
		
		
	}
	System.out.println("DeliveryEntity name in controller is "+id);
	return ResponseEntity.ok(id);
	}
@DeleteMapping(value = "/show2/{GardShiftId}", produces = "application/json") //DELETE   http://localhost:8080/UserApp/gardshiftentity/show2/id
public ResponseEntity<GardShiftEntity> deleteGardShiftById(@PathVariable("GardShiftId") long GardShiftId) throws RecordNotFoundException{
  gardShiftService.deleteGardShiftById(GardShiftId);
    return new ResponseEntity<GardShiftEntity>(HttpStatus.OK);
}
}
