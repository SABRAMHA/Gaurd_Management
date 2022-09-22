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
import com.demo.entities.SecurityEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.SecurityService;
@RestController                             //rest controller is used to handle the request
@RequestMapping(value="/securityentity")    //request mapping map specific request path
public class SecurityEntityController {
    
        @Autowired                                  // enable to get object dependency
        private SecurityService SecurityService;
        
        public SecurityService getSecurityServiceInt() {
            return SecurityService;
        }
        @GetMapping(value="/show",produces="application/json")   // GET //http://localhost:8080/UserApp/secutityentity/show
        List<SecurityEntity> showSecurityEntity(){
            System.out.println("Security entity controller");
            List<SecurityEntity> SecurityList=SecurityService.showSecurityEntity();
            return SecurityList;
        }
        
        @GetMapping(value = "/show3", produces = "application/json")
        public ResponseEntity<SecurityEntity> findById(@PathVariable("Id")long Id) {
        SecurityEntity security= SecurityService.findById(Id);
            return new ResponseEntity<SecurityEntity>(security,HttpStatus.OK);
        }
        @PostMapping(consumes="application/json",produces="application/json")   //POST  //http://localhost:8080/UserApp/securityentity
        ResponseEntity<SecurityEntity> add(@RequestBody SecurityEntity security) throws DuplicateRecordException {
     
         SecurityEntity id=SecurityService.add(security);
         if(id.getId()==0)
     	{
        	 System.out.println("Before exception");
        		throw new DuplicateRecordException("SecurityEntity with this id already Exist"); 
     		
     		
     	}
     	System.out.println("SecurityEntity name in controller is "+id);
     	return ResponseEntity.ok(id);
     	}
        @PutMapping(consumes="application/json",produces="application/json")   //PUT //http://localhost:8080/UserApp/securityentity
       ResponseEntity<SecurityEntity> update(@RequestBody SecurityEntity security)throws RecordNotFoundException{
        	SecurityEntity id=SecurityService.update(security);
            if (id==null)
        	{
        		throw new RecordNotFoundException("SecurityEntity with this name "+security.getId()+"already Exist");
        		
        		
        	}
        	System.out.println("SecurityEntity name in controller is "+id);
        	return ResponseEntity.ok(id);
        	}
        @DeleteMapping(value = "/show2/{SecurityId}", produces = "application/json")   //DELETE   http://localhost:8080/UserApp/securityentity/show2/id
        public ResponseEntity<SecurityEntity> deleteSecurityById(@PathVariable("SecurityId") long SecurityId) throws RecordNotFoundException{
          SecurityService.deleteSecurityById(SecurityId);
            return new ResponseEntity<SecurityEntity>(HttpStatus.OK);
        }
}