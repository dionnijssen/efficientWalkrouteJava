package DataLayer;

import Logic.Models.User;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users;
    public UserRepository() {
        ArrayList<User> users = new ArrayList<User>();
    }

    public ArrayList<User> get(){
        return this.users;
    }

    public User show(int userId){
        ArrayList<User> users = this.get();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).id == userId){
                return users.get(i);
            }
        }
        return null;
    }

    public boolean create(User user) {
        return this.users.add(user);
    }

    public boolean update(User user){
        for (int i = 0; i < this.users.size(); i++) {
            if (users.get(i).id == user.id){
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean delete(User user){
        return this.users.remove(user);
    }
}
