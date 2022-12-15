package oodj_car_rental_system.Entities.users;

public class CustomerDetails {
    private  String fistName;

    private  String secondName;

    private String email;

    private float balanceRM;

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getBalanceRM() {
        return balanceRM;
    }

    public void setBalanceRM(float balanceRM) {
        this.balanceRM = balanceRM;
    }

    public CustomerDetails(String fistName, String secondName, String email, float  balanceRM) {
        this.fistName = fistName;
        this.secondName = secondName;
        this.email = email;
        this.balanceRM = balanceRM;
    }

    public String getFistName() {
        return fistName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }
}
