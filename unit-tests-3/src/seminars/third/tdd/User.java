package seminars.third.tdd;

public class User {

    public String name;
    public String password;
    private final boolean isAdmin;
    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String name, String password) {
        this(name, password, false);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    //3.6.
    public boolean login(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)) {
            isAuthenticate = true;
            return true;
        }
        return false;
    }

    public boolean logOut(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)) {
            isAuthenticate = false;
            return true;
        }
        return false;
    }
}