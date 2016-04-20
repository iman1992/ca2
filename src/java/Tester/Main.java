
package Tester;

import Entity.Person;
import Facade.FacadeController;
import Facade.FacadeInterface;


public class Main {
    
    public static void main(String[] args) {
      
        FacadeInterface facade = new FacadeController();
        
        Person p1 = new Person("Cristiano", "Ronalod", "Ronaldo@email.dk", "Madrid street", "2000", "Madrid");
        Person p2 = new Person("Lionel", "Messi", "Messi@email.dk", "Barcelona street", "2300", "Barcelona");
        Person p3 = new Person("Mike", "Tyson", "Tyson@email.dk", "US street", "2400", "LA");
        
        facade.createPerson(p1);
        facade.createPerson(p2);
        facade.createPerson(p3);
    }
}
