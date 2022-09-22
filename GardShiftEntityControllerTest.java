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

import com.demo.controller.GardShiftEntityController;
import com.demo.entities.GardShiftEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.GardShiftServiceInt;


@ActiveProfiles("test")
@SpringBootTest
public class GardShiftEntityControllerTest {



   @Autowired
    private GardShiftServiceInt gardShiftService;



   @MockBean



   private GardShiftEntityController gardShiftCon;



   @Test
    void deleteGardShiftTest() throws ParseException, DuplicateRecordException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse("15-09-2022");
        GardShiftEntity testGardShiftEntity = new GardShiftEntity(345,"Akshara", "09:30:00-10:30:00", date);
        GardShiftEntity testGardShiftEntitySaved = gardShiftService.add(testGardShiftEntity);
        long gardShiftEntityTestId = testGardShiftEntitySaved.getId();
        gardShiftService.deleteGardShiftById(gardShiftEntityTestId);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
        	gardShiftService.findById(gardShiftEntityTestId);
        });
        
   }



   @Test
    public void saveGardShiftTest() throws ParseException, DuplicateRecordException {

       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse("15-09-2022");

        GardShiftEntity testGardShiftEntity = new GardShiftEntity(345,"Akshara", "09:30:00-10:30:00", date);
        GardShiftEntity testGardShiftEntitySaved = gardShiftService.add(testGardShiftEntity);
        long gardShiftEntityTestId = testGardShiftEntitySaved.getId();



        GardShiftEntity testGardShiftEntityDB = gardShiftService.findById(gardShiftEntityTestId);
        Assertions.assertNotNull(testGardShiftEntityDB);



        gardShiftService.deleteGardShiftById(gardShiftEntityTestId);
    }
   
   @Test
   void TestRecordGardShiftByIdShouldThrowGardShIdException() throws RecordNotFoundException {
       assertThrows(RecordNotFoundException.class, () -> {
    	   GardShiftEntity gs2 = new GardShiftEntity();
    	   gardShiftService.update(gs2);
       });
   }



  
   
}