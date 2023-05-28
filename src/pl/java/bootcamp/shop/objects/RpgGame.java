package pl.java.bootcamp.shop.objects;

public class RpgGame extends Game {

    int numberOfPages;

    public RpgGame(String name, double price, int quantity, int minimumAge, int numberOfPages) {
        super(name, price, quantity, minimumAge);
        this.numberOfPages = numberOfPages;
    }

    public RpgGame(String[] vars) {
        super(vars);
        this.numberOfPages = Integer.parseInt(vars[4]);
    }

    @Override
    public String toCSV() {
        return new StringBuilder()
                .append(super.toCSV())
                .append(";")
                .append(this.numberOfPages)
                .toString();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(super.toString())
                .append(" pages: ")
                .append(this.numberOfPages)
                .toString();
    }
}
