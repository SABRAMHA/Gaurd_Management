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

import com.demo.controller.GardsTrainingEntityController;
import com.demo.entities.GardsTrainingEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.GardsTrainingServiceInt;


@ActiveProfiles("test")
@SpringBootTest
public class GardsTrainingEntityControllerTest {



   @Autowired
    private GardsTrainingServiceInt gardTrainingService;

   @MockBean
   private GardsTrainingEntityController gardTrainingCon;

   @Test
    void deleteGardsTrainingTest() throws ParseException, DuplicateRecordException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse("09-09-2022");
        GardsTrainingEntity testGardsTrainingEntity = new GardsTrainingEntity(3256,"Akshay", "9874456678", "Completed","12:00:00",date);
        GardsTrainingEntity testGardsTrainingEntitySaved = gardTrainingService.add(testGardsTrainingEntity);
        long gardsTrainingEntityTestId = testGardsTrainingEntitySaved.getId();
        gardTrainingService.deleteGardsTrainingById(gardsTrainingEntityTestId);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
        	gardTrainingService.findById(gardsTrainingEntityTestId);
        });
        
   }



   @Test
    public void saveGardsTrainingTest() throws ParseException, DuplicateRecordException {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse("09-09-2022");

        GardsTrainingEntity testGardsTrainingEntity = new GardsTrainingEntity(3256,"Akshay", "9874456678", "Completed","12:00:00",date);
        GardsTrainingEntity testGardsTrainingEntitySaved = gardTrainingService.add(testGardsTrainingEntity);
        long gardsTrainingEntityTestId = testGardsTrainingEntitySaved.getId();



        GardsTrainingEntity testGardsTrainingEntityDB = gardTrainingService.findById(gardsTrainingEntityTestId);
        Assertions.assertNotNull(testGardsTrainingEntityDB);



        gardTrainingService.deleteGardsTrainingById(gardsTrainingEntityTestId);
    }
   
   @Test
   void TestRecordGardsTrainingByIdShouldThrowGardTIdException() throws RecordNotFoundException {
       assertThrows(RecordNotFoundException.class, () -> {
    	   GardsTrainingEntity gt = new GardsTrainingEntity();
    	   gardTrainingService.update(gt);
       });
   }



  
   
}