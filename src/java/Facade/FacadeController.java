
package Facade;

import Entity.Hobby;
import Entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FacadeController implements FacadeInterface {
    
    private EntityManagerFactory EMF = Persistence.createEntityManagerFactory("CA2NewVersionPU", null);
    private EntityManager EM = EMF.createEntityManager();
    
    private static FacadeController instance = null;
    
    public FacadeController() {
        
    }

    @Override
    public Person getPerson(long id) {
        Person found  = EM.find(Person.class, id);
        return found;
    }

    @Override
    public List<Person> getAllPersons() {
         List<Person> allPersons = new ArrayList();
         Query query = EM.createQuery("SELECT e FROM Person e");
         allPersons = query.getResultList();
         return allPersons;
    }

    @Override
    public void deletePerson(long id) {
        Query query = EM.createQuery("DELETE FROM Person p WHERE p.id = " + id);
        EM.getTransaction().begin();
        query.executeUpdate();
        EM.getTransaction().commit();
    }

    @Override
    public void createPerson(Person p) {
         EM.getTransaction().begin();
         EM.merge(p);
         EM.getTransaction().commit();
    }

    @Override
    public void updatePerson(Person p) {
        EM.getTransaction().begin();
        EM.merge(p);
        EM.getTransaction().commit();
    }
    
}