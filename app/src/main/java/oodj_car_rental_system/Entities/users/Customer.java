package oodj_car_rental_system.Entities.users;

public class Customer extends User {

    private float balanceRM;
    private CustomerDetails userDetail;

    public Customer(String username, String password, float balanceRM, CustomerDetails userDetail) {
        super(username, password);
        this.balanceRM = balanceRM;
        this.userDetail = userDetail;
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
