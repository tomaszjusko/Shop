package pl.java.bootcamp.shop.dbs;

import pl.java.bootcamp.shop.objects.Game;
import pl.java.bootcamp.shop.objects.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserDB {
    public Map<String, User> users = new HashMap<>();

    private static final UserDB instance = new UserDB();

    public void addUser(User user){this.users.put(user.getUsername(),user);}

    public User findUser(String login) {
        if (this.users.containsKey(login)) {
            return this.users.get(login);
        } else {
            return null;
        }
    }

    public User addUser(String login, String password,boolean isadmin) {
        if (this.users.containsKey(login)) {
            System.out.println("Given username already exists in the database");
            return null;
        } else {
            System.out.println("Registration successfully");
            return this.users.put(login,new User(login,password,isadmin));
        }
    }

    public void changeAcces(String key){
        if (users.containsKey(key)) {
            this.users.get(key).setAdmin(true);
        }
    }

    public Collection<User> getUsers() {
        return this.users.values();
    }
    public static UserDB getInstance() {
        return instance;
    }
}
