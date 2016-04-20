
package Rest;

import DTO.PersonDTO;
import Entity.Address;
import Entity.CityInfo;
import Entity.Person;
import Facade.FacadeController;
import Facade.FacadeInterface;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;


@Path("rest")
public class RestService {

    @Context
    private UriInfo context;
    private Object rand;
    private FacadeInterface facade = new FacadeController();

    private Gson gson = new Gson();

    public RestService() {
    }

    @POST
    @Path("add")
    public String addPerson(String s) {

        PersonDTO pdto = gson.fromJson(s, PersonDTO.class);

        Person p = new Person();

        CityInfo ci = new CityInfo();
        ci.setZipcode(pdto.getZipCode());
        ci.setCity(pdto.getCity());

        Address a = new Address();
        a.setStreet(pdto.getStreet());
        a.setAdditionalinfo("");
        a.setCity(ci);

        p.setFirstName(pdto.getFirstName());
        p.setLastName(pdto.getLastName());
        p.setEmail(pdto.getEmail());
        p.setAddress(a);

        facade.createPerson(p);
        return "{\"result\" : \"Person Created\"}";
    }

    @GET
    @Produces("text/plain")
    public String getAllPersons() {
        List<Person> allPersons = facade.getAllPersons();

        List<PersonDTO> allPersonsDTO = new ArrayList<PersonDTO>();
        for (Person p : allPersons) {
            PersonDTO pdto = new PersonDTO();
            pdto.setId(p.getId());
            pdto.setFirstName(p.getFirstName());
            pdto.setLastName(p.getLastName());
            pdto.setEmail(p.getEmail());
            pdto.setStreet(p.getAddress().getStreet());
            pdto.setZipCode(p.getAddress().getCity().getZipcode());
            pdto.setCity(p.getAddress().getCity().getCity());

            allPersonsDTO.add(pdto);
        }

        String json = gson.toJson(allPersonsDTO);
        return json;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getSinglePerson(@PathParam("id") long id) {

        
        Person p = facade.getPerson(id);

        PersonDTO pdto = new PersonDTO();
        pdto.setId(p.getId());
        pdto.setFirstName(p.getFirstName());
        pdto.setLastName(p.getLastName());
        pdto.setEmail(p.getEmail());
        pdto.setStreet(p.getAddress().getStreet());
        pdto.setZipCode(p.getAddress().getCity().getZipcode());
        pdto.setCity(p.getAddress().getCity().getCity());

        String json = gson.toJson(pdto);
        return json;
    }

    @DELETE
    @Path("delete/{id}")
    public void deletePerson(@PathParam("id") int id) {
        long id1 = (long) id;
        facade.deletePerson(id1);
    }

    @PUT
    @Path("edit/{id}")
    public void editPerson(@PathParam("id") int id, String s) {

        PersonDTO pdto = gson.fromJson(s, PersonDTO.class);

        Person p = new Person();

        CityInfo ci = new CityInfo();
        ci.setZipcode(pdto.getZipCode());
        ci.setCity(pdto.getCity());

        Address a = new Address();
        a.setStreet(pdto.getStreet());
        a.setAdditionalinfo("");
        a.setCity(ci);

        p.setFirstName(pdto.getFirstName());
        p.setLastName(pdto.getLastName());
        p.setEmail(pdto.getEmail());
        p.setAddress(a);
        p.setId((long)id);
        
        facade.createPerson(p);

    }

}
