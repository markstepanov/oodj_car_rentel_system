package oodj_car_rental_system.Entities.users;

public class Customer implements IApplicationUser{

    private int id;

    private String username;

    private String password;


    public Customer(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean getAdminStatus() {
        return false;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
