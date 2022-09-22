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
import com.demo.controller.SecurityEntityController;
import com.demo.entities.SecurityEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.SecurityService;



@SuppressWarnings("unused")
@ActiveProfiles("test")
@SpringBootTest
public class SecurityEntityControllerTest {



   @Autowired
    private SecurityService securityService;



   @MockBean



   private SecurityEntityController securityCon;



   @Test
    void deleteSecurityTest() throws ParseException, DuplicateRecordException {
        SecurityEntity testSecurityEntity = new SecurityEntity("Come and Help","Emergency");
        SecurityEntity testSecurityEntitySaved = securityService.add(testSecurityEntity);
        long securityEntityTestId = testSecurityEntitySaved.getId();
        securityService.deleteSecurityById(securityEntityTestId);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            securityService.findById(securityEntityTestId);
        });



   }



   @Test
    public void saveSecurityTest() throws ParseException, DuplicateRecordException {



       SecurityEntity testSecurityEntity = new SecurityEntity("Come and Help","Emergency");
        SecurityEntity testSecurityEntitySaved = securityService.add(testSecurityEntity);
        long securityEntityTestId = testSecurityEntitySaved.getId();



       SecurityEntity testSecurityEntityDB = securityService.findById(securityEntityTestId);
        Assertions.assertNotNull(testSecurityEntityDB);



       securityService.deleteSecurityById(securityEntityTestId);
    }



   @Test
    void TestRecordSecurityByIdShouldThrowDelIdException() throws RecordNotFoundException {
        assertThrows(RecordNotFoundException.class, () -> {
            SecurityEntity v = new SecurityEntity();
            securityService.update(v);
        });
    }



   
    
}