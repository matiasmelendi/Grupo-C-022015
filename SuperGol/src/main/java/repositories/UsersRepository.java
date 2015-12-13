package repositories;

import model.User;
import org.springframework.transaction.annotation.Transactional;
import repositories.protocols.UsersRepositoryProtocol;

public class UsersRepository extends GenericRepository<User> implements UsersRepositoryProtocol {

    protected Class<User> getDomainClass() {
        return User.class;
    }

    @Transactional
    public User findByUsername(String username){
        User user = new User();
        user.setUsername(username);

        try{
            return this.getHibernateTemplate().findByExample(user).get(0);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Transactional
    public User findOrCreate(User user) {
        User userToBeRetrieved = this.findByUsername(user.username());
        if(userToBeRetrieved == null){
            this.save(user);
            userToBeRetrieved = this.findByUsername(user.username());
        }

        return userToBeRetrieved;
    }
}
