package Logic.Interfaces;

import Logic.Models.User;

public interface UserControllerInterface {
    User show(int id);

    boolean create(User user);

    boolean update(User user);

    boolean delete(User user);
}
