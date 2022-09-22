package com.demo.controller.test;



import static org.junit.jupiter.api.Assertions.assertThrows;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import org.springframework.test.context.ActiveProfiles;

import com.demo.controller.GardSalaryEntityController;
import com.demo.entities.GardSalaryEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.GardSalaryServiceInt;


@ActiveProfiles("test")
@SpringBootTest
public class GardSalaryEntityControllerTest {



   @Autowired
    private GardSalaryServiceInt gardSalaryService;



   @MockBean



   private GardSalaryEntityController gardSalaryCon;



  @Test
    void deleteGardSalaryTest() throws ParseException, DuplicateRecordException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse("19-09-2022");
        GardSalaryEntity testGardSalaryEntity = new GardSalaryEntity("Aditya", "89",(long) 1200.20,"Remaining", date);
        GardSalaryEntity testGardSalaryEntitySaved = gardSalaryService.add(testGardSalaryEntity);
        long gardSalaryEntityTestId = testGardSalaryEntitySaved.getId();
        gardSalaryService.deleteGardSalaryById(gardSalaryEntityTestId);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
        	gardSalaryService.findById(gardSalaryEntityTestId);
        });
        
   }



   @Test
    public void saveGardSalaryTest() throws ParseException, DuplicateRecordException {

       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse("19-09-2022");

        GardSalaryEntity testGardSalaryEntity = new GardSalaryEntity("Aditya", "89",(long) 1200.20,"Remaining", date);
        GardSalaryEntity testGardSalaryEntitySaved = gardSalaryService.add(testGardSalaryEntity);
        long gardSalaryEntityTestId = testGardSalaryEntitySaved.getId();



        GardSalaryEntity testGardSalaryEntityDB = gardSalaryService.findById(gardSalaryEntityTestId);
        Assertions.assertNotNull(testGardSalaryEntityDB);



        gardSalaryService.deleteGardSalaryById(gardSalaryEntityTestId);
    }
   
   @Test
   void TestRecordGardSalaryByIdShouldThrowGardSIdException() throws RecordNotFoundException {
       assertThrows(RecordNotFoundException.class, () -> {
    	   GardSalaryEntity gs = new GardSalaryEntity();
    	   gardSalaryService.update(gs);
       });
   }



  
   
}