package pl.java.bootcamp.shop.core;

import pl.java.bootcamp.shop.dbs.UserDB;
import pl.java.bootcamp.shop.objects.User;

public class Authenticator {

    private static final Authenticator instance = new Authenticator();
    public Authenticator() {
    }

    public int authenticate(){
        int counter = 0;
        while (counter < 3){
            User userFromGui = GUI.getInstance().getLoginAndPassword();
            User userFromDb = UserDB.getInstance().findUser(userFromGui.getUsername());
            if (userFromDb != null && userFromDb.getPassword().equals(userFromGui.getPassword())){
                if (userFromDb.isAdmin()){
                    return 2;
                }else {
                    return 1;
                }
            }
            System.out.println("Incorrect login or password");
            counter++;
        }
        return 0;
    }



    public Authenticator getInstance(){
        return instance;
    }
}
