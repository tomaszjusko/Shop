package pl.java.bootcamp.shop.objects;

public class Boardgame extends Game{
    int maxNumberOfPlayers;

    public Boardgame(String name, double price, int quantity, int minimumAge, int maxNumberOfPlayers) {
        super(name, price, quantity, minimumAge);
        this.maxNumberOfPlayers = maxNumberOfPlayers;
    }

    public Boardgame(String[] vars) {
        super(vars);
        this.maxNumberOfPlayers = Integer.parseInt(vars[4]);
    }

    @Override
    public String toCSV() {
        return new StringBuilder()
                .append(super.toString())
                .append(";")
                .append(this.maxNumberOfPlayers)
                .toString();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(super.toString())
                .append(" Max players: ")
                .append(this.maxNumberOfPlayers)
                .toString();
    }
}
