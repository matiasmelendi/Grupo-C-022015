package repositories;

import model.User;
import repositories.protocols.UsersRepositoryProtocol;

public class UsersRepository extends GenericRepository<User> implements UsersRepositoryProtocol {

    protected Class<User> getDomainClass() {
        return User.class;
    }
}
