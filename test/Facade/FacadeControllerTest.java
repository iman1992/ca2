
package Facade;

import DTO.PersonDTO;
import Entity.Person;
import org.junit.Test;
import static org.junit.Assert.*;

public class FacadeControllerTest {

    public FacadeControllerTest() {
    }

    @Test
    public void testCreatePerson() {

        FacadeInterface facade = new FacadeController();

        Person p1 = new Person("Test_Name", "Test_LastName", "Test@Test.test", "Teststien 10", "0000", "Testby");
        facade.createPerson(p1);

        for (Person p : facade.getAllPersons()) {
            if (p.getFirstName().equals(p1.getFirstName())) {
                if (p.getLastName().equals(p1.getLastName())) {
                    if (p.getEmail().equals(p1.getEmail())) {
                        if (p.getAddress().getStreet().equals(p.getAddress().getStreet())) {
                            if (p.getAddress().getCity().getCity().equals(p.getAddress().getCity().getCity())) {
                                if (p.getAddress().getCity().getZipcode().equals(p.getAddress().getCity().getZipcode())) {
                                    assertTrue(true);
                                    facade.deletePerson(p.getId()); 
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    @Test
    public void testDeletePerson() {

        FacadeInterface facade = new FacadeController();

        Person p1 = new Person("TestDelete", "TestLastName", "Test@Test.test", "Teststien 1", "1111", "Test");
        facade.createPerson(p1);

        for (Person p : facade.getAllPersons()) {

            if (p.getFirstName().equals(p1.getFirstName())) {
                assertTrue(true);
                facade.deletePerson(p.getId());
            }

        }
        for (Person p : facade.getAllPersons()) {

            if (p.getFirstName().equals(p1.getFirstName())) {
                assertTrue(false);
            }

        }

    }

    
    
       @Test
    public void testEditPerson() {

        FacadeInterface facade = new FacadeController();

        Person p1 = new Person("TestDelete", "TestLastName", "Test@Test.test", "Teststien 1", "1111", "Test");
        facade.createPerson(p1);

        for (Person p : facade.getAllPersons()) {

            if (p.getFirstName().equals(p1.getFirstName())) {
                assertTrue(true);
                p.setFirstName("edited");
               facade.updatePerson(p);
             
            }

        }
        for (Person p : facade.getAllPersons()) {

            if (p.getFirstName().equals(p1.getFirstName())) {
                assertTrue(true);
                facade.deletePerson(p.getId());
               
            }

        }

    }
    
    
    
}
