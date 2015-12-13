package services;

import model.User;
import repositories.UsersRepository;

import javax.ws.rs.*;

@Path("/users")
public class UsersService {

    private UsersRepository repository;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public User find(@PathParam("id") Double id){
        return this.repository.find(id);
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/x-www-form-urlencoded")
    public void create(User user) {
        this.repository.save(user);
    }

    @PUT
    @Path("/")
    @Consumes("application/json")
    @Produces("application/x-www-form-urlencoded")
    public void update(User user) {
        this.repository.update(user);
    }

    @POST
    @Path("/find-or-create")
    @Consumes("application/json")
    @Produces("application/x-www-form-urlencoded")
    public User findOrCreate(User user) {
        return this.repository.findOrCreate(user);
    }

    //*******************************************************
    //           Only used by spring only
    //*******************************************************

    public UsersRepository getRepository() {
        return repository;
    }

    public void setRepository(UsersRepository repository) {
        this.repository = repository;
    }
}
