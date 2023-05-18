package pl.java.bootcamp.shop.objects;

public class Game implements Writable {
    String name;
    double price;
    int quantity;
    int minimumAge;

    public Game(String name, double price, int quantity, int minimumAge) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.minimumAge = minimumAge;
    }

    public Game(String[] vars){
        this(vars[0],Double.parseDouble(vars[1]),Integer.parseInt(vars[2]),Integer.parseInt(vars[3]));
    }

    @Override
    public String toCSV() {
        return new StringBuilder()
                .append(getClass().getSimpleName())
                .append(";")
                .append(this.name)
                .append(";")
                .append(this.price)
                .append(";")
                .append(this.quantity)
                .append(";")
                .append(this.minimumAge)
                .toString();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.name)
                .append(" price: ")
                .append(this.price)
                .append("PLN stock: ")
                .append(this.quantity)
                .append(" minimum age: ")
                .append(this.minimumAge)
                .append("+")
                .toString();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }
}
