package pl.java.bootcamp.shop.core;

import pl.java.bootcamp.shop.dbs.GamesDB;
import pl.java.bootcamp.shop.dbs.UserDB;
import pl.java.bootcamp.shop.objects.Game;
import pl.java.bootcamp.shop.objects.User;

import java.util.Scanner;

public class GUI {

    private static final GUI instance = new GUI();

    private final Scanner scanner = new Scanner(System.in);
    public String mainMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        return scanner.nextLine();
    }

    public String userMenu() {
        System.out.println("1. Show products");
        System.out.println("2. Buy product");
        System.out.println("3. Logout");

        return scanner.nextLine();
    }

    public String adminMenu() {
        System.out.println("1. Show products");
        System.out.println("2. Buy product");
        System.out.println("3. Logout");
        System.out.println("4. Add product");
        System.out.println("5. Give admin access");

        return scanner.nextLine();
    }

    public User getLoginAndPassword(){
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj haslo");
        return new User(login,scanner.nextLine(),false);
    }

public void ListGames(){
        for(Game game : GamesDB.getInstance().getGames()) {
            if (game.getQuantity() > 0) {
                System.out.println(game);
            }
        }
}

public String pickProduct(){
    System.out.println("Give product name");
        return scanner.nextLine();
}

    public int pickQuantity(){
        System.out.println("How many?");
        return Integer.parseInt(scanner.nextLine());
    }

    public String pickUser(){
        System.out.println("What user do you want to change to admin?");
        return scanner.nextLine();
    }

    public static GUI getInstance() {
        return instance;
    }
}
