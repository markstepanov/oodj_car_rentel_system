package oodj_car_rental_system.Entities.users;

public class UserApplication extends User{

    private String firstName;

    private String secondName;

    private String email;

    public UserApplication(String username, String password, String firstName, String secondName, String email) {
        super(username, password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }
}
