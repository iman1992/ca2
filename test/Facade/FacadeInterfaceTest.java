
package Facade;

import Entity.Person;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class FacadeInterfaceTest {
    
    public FacadeInterfaceTest() {
    }

    @Test
    public void testGetPerson() {
    }

    @Test
    public void testGetAllPersons() {
    }

    @Test
    public void testDeletePerson() {
    }

    @Test
    public void testCreatePerson() {
    }

    @Test
    public void testUpdatePerson() {
    }

    public class FacadeInterfaceImpl implements FacadeInterface {

        public Person getPerson(long id) {
            return null;
        }

        public List<Person> getAllPersons() {
            return null;
        }

        public void deletePerson(long id) {
        }

        public void createPerson(Person p) {
        }

        public void updatePerson(Person p) {
        }
    }
    
}
