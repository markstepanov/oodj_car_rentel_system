package oodj_car_rental_system.Entities.users;

public class User {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User( String username, String password) {
        this.username = username;
        this.password = password;
    }
}
