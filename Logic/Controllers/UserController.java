package Logic.Controllers;

import DataLayer.UserRepository;
import Logic.Models.User;

public class UserController {

     UserRepository userRepo;

    public UserController(UserRepository userRepository){
        userRepo = userRepository;
    }

    public User show(int id){
        return this.userRepo.show(id);
    }

    public boolean create(User user) {
        return this.userRepo.create(user);
    }

    public boolean update(User user) {
        return this.userRepo.update(user);
    }

    public boolean delete (User user) {
        return this.userRepo.delete(user);
    }

    //Don't add user, no need for it. Keep it simple.

    //Decide if we should implement setPassword / logout
    //Maybe just  at the start give the possibility to create a user.
    //Give a list and create order.
    // Are Users even necessary? Why not just create orders without a user. It isn't necessary.
}
