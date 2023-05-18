package pl.java.bootcamp.shop.objects;

public class User implements Writable {
    String username;
    String password;
    boolean isAdmin;


    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User (String[] vars){
        this(vars[0],vars[1],Boolean.parseBoolean(vars[2]));
    }

    @Override
    public String toCSV() {
        return new StringBuilder()
                .append(getClass().getSimpleName())
                .append(";")
                .append(this.username)
                .append(";")
                .append(this.password)
                .append(";")
                .append(this.isAdmin)
                .toString();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
