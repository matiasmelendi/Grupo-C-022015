package repositories.protocols;

import model.User;

public interface UsersRepositoryProtocol {

    User find(Integer id);

    void update(User user);

    void save(User user);

    //User findOrCreate(String email);
}
