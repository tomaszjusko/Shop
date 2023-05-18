package pl.java.bootcamp.shop.core;

import pl.java.bootcamp.shop.dbs.FileLoader;
import pl.java.bootcamp.shop.dbs.GamesDB;
import pl.java.bootcamp.shop.dbs.UserDB;
import pl.java.bootcamp.shop.objects.User;

import java.io.IOException;

public class Core {

    private static final Core instance = new Core();
    private final Authenticator authenticator = new Authenticator().getInstance();

    public void Start(){

        try {
            FileLoader.getInstance().readDataFromFile();
        } catch (IOException e) {
            System.out.println("Database is malformed !!");
            return;
        }

        mainloop:
        while (true){

            switch (GUI.getInstance().mainMenu()){
                case "1":
                    int logged = authenticator.authenticate();
                    if (logged == 0){
                        System.out.println("bledne logowanie");
                        return;
                    }else{
                        loggedloop:
                        while (true){
                            switch ((logged == 2) ? GUI.getInstance().adminMenu() : GUI.getInstance().userMenu()){
                                case "1":
                                    GUI.getInstance().ListGames();
                                    break;
                                case "2":
                                    GamesDB.getInstance().buyGames(GUI.getInstance().pickProduct(),GUI.getInstance().pickQuantity());
                                    break;
                                case "3":
                                    break loggedloop;
                                case "4":
                                    if (logged == 2){
                                        GamesDB.getInstance().addGames(GUI.getInstance().pickProduct(),GUI.getInstance().pickQuantity());
                                    }else {
                                        System.out.println("Access denied");
                                    }
                                    break;
                                case "5":
                                    UserDB.getInstance().changeAcces(GUI.getInstance().pickUser());
                                    break;
                                default:
                                    System.out.println("Wrong chose");
                                    break;
                            }
                        }
                    }
                    break;
                case "2":
                    User userFromGui = GUI.getInstance().getLoginAndPassword();
                    UserDB.getInstance().addUser(userFromGui.getUsername(),userFromGui.getPassword(),false);
                    break;
                case "3":
                    try {
                        FileLoader.getInstance().saveDataToFile();
                        break mainloop;
                    } catch (IOException e) {
                        System.out.println("Database Error !!");
                    }
            }
        }
    }

    public static Core getInstance(){
        return instance;
    }
}
