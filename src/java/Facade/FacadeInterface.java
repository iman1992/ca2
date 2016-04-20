
package Facade;

import Entity.Hobby;
import Entity.Person;
import java.util.List;


public interface FacadeInterface {
    
    public Person getPerson(long id);
    
    public List<Person> getAllPersons();
    
    public void deletePerson(long id);
    
    public void createPerson(Person p);
    
    public void updatePerson(Person p);

    
}
