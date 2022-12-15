package oodj_car_rental_system.Entities.users;

public class Admin implements  IApplicationUser{
    private String username;
    private String password;

    private int id;
    public Admin(int id,String username, String password) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean getAdminStatus() {
        return true;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
