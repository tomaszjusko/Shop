package pl.java.bootcamp.shop.dbs;

import pl.java.bootcamp.shop.objects.Game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GamesDB {

    private static final GamesDB instance = new GamesDB();
    private final Map<String, Game> games = new HashMap<>();

    private GamesDB() {
    }

    public void buyGames(String key, int order){
        if(games.containsKey(key) && games.get(key).getQuantity() - order >= 0) {
            games.get(key).setQuantity(games.get(key).getQuantity() - order);
        }else{
            System.out.println("Product out of stock");
        }
    }

    public void addGames(String key, int quantity){
        if (games.containsKey(key)) {
            games.get(key).setQuantity(games.get(key).getQuantity() + quantity);
        }else{
            System.out.println("There is no such product");
        }
    }

    public void addGame(Game game){this.games.put(game.getName(),game);}

    public Collection<Game> getGames() {
        return games.values();
    }

    public static GamesDB getInstance() {
        return instance;
    }
}
