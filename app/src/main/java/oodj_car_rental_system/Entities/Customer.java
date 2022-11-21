package oodj_car_rental_system.Entities;

public class Customer extends User{


    private float balanceRM;

    public Customer(String username, String password, float balanceRM) {
        super(username, password);
        this.balanceRM = balanceRM;
    }

    public Customer(String username, String password){
       super(username, password);
    }

    public float getBalanceRM() {
        return balanceRM;
    }

    public void setBalanceRM(float balanceRM) {
        this.balanceRM = balanceRM;
    }
}
