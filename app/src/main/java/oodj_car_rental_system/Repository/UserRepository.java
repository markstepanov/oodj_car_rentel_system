package oodj_car_rental_system.Repository;

import oodj_car_rental_system.Entities.users.*;
import oodj_car_rental_system.Models.CustomerDetailsDAO;
import oodj_car_rental_system.Models.UserApplicationDAO;
import oodj_car_rental_system.Models.UserDAO;
import oodj_car_rental_system.ORMdeep.BaseClass;
import oodj_car_rental_system.ORMdeep.TableReader;
import oodj_car_rental_system.ORMdeep.TableRecordDeleter;
import oodj_car_rental_system.ORMdeep.TableWriter;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Optional;

public class UserRepository {

    private TableWriter tableWriter;
    private TableReader tableReader;
    private TableRecordDeleter tableRecordDeleter;


    public void checkIfAdminPresent() throws Exception{

            UserDAO admin = (UserDAO) tableReader.readById(new UserDAO(),0);
            if (!(admin.username == "admin") && !admin.isAdmin){
                throw  new Exception();
            }

    }

    public void addAdmin (){
        try {
            tableWriter.writeNew(new UserDAO("admin", "admin", true));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public UserRepository(TableWriter tableWriter, TableReader tableReader, TableRecordDeleter tableRecordDeleter) {
        this.tableWriter = tableWriter;
        this.tableReader = tableReader;
        this.tableRecordDeleter = tableRecordDeleter;
    }


    public Optional<IApplicationUser> getAplicationUser(User user) {
        BaseClass[] records;
        try {
            records = this.tableReader.readAll(new UserDAO());
        } catch (Exception e) {
            return Optional.empty();
        }

        for (BaseClass record : records) {
            UserDAO currentUser = (UserDAO) record;
            if (currentUser.password.equals(user.getPassword()) || currentUser.username.equals(user.getUsername())) {
                if (currentUser.isAdmin) {
                    return Optional.of(new Admin(currentUser.getId(), currentUser.username, currentUser.password));
                } else {
                    System.out.println(currentUser.getId());
                    return Optional.of(new Customer(currentUser.getId(), currentUser.username, currentUser.password));
                }
            }
        }
        return Optional.empty();
    }


    public void addNewApplication(UserApplication userApplication) throws Exception {
        BaseClass[] applicationRecords = tableReader.readAll(new UserApplicationDAO());
        BaseClass[] userRecords = tableReader.readAll(new UserDAO());

        for (BaseClass applicationRecord : applicationRecords) {
            if (((UserApplicationDAO) applicationRecord)
                    .username.equals(userApplication.getUsername())) {
                throw new Exception("Application already submitted for this username");
            }
        }

        for (BaseClass userRecord : userRecords) {
            if (((UserDAO) userRecord)
                    .username.equals(userApplication.getUsername())) {
                throw new Exception("User with username this username already exist");
            }
        }


        tableWriter.writeNew(new UserApplicationDAO(userApplication.getUsername(), userApplication.getPassword(),
                userApplication.getFirstName(), userApplication.getSecondName(), userApplication.getEmail()));


    }

    public Optional<ArrayList<UserApplication>> getAllUserApplications() {

        ArrayList<UserApplication> userApplications = new ArrayList<>();
        BaseClass[] records;
        try {
            records = tableReader.readAll(new UserApplicationDAO());
        } catch (Exception e) {
            return Optional.empty();
        }

        for (BaseClass record : records) {

            UserApplicationDAO applicationDAO = (UserApplicationDAO) record;
            userApplications.add(new UserApplication(applicationDAO.username,
                    applicationDAO.password, applicationDAO.firstName,
                    applicationDAO.secondName, applicationDAO.email));
        }

        return Optional.of(userApplications);
    }

    public boolean acceptUserApplicationByUsername(String username) {
        BaseClass[] records;
        try {
            records = tableReader.readAll(new UserApplicationDAO());
        } catch (Exception e) {
            return false;
        }

        for (BaseClass record : records) {
            UserApplicationDAO userApplication = (UserApplicationDAO) record;

            if (userApplication.username.equals(username)) {

                if (!addNewCustomer(userApplication)) return false;
                return this.deleteUserApplicationById(userApplication.getId());
            }
        }
        return false;
    }

    public Optional<Customer> getCustomerByUserId(int id){
        BaseClass record;
        try {
            record = tableReader.readById(new UserDAO(), id);
        } catch (Exception e){
            return Optional.empty();
        }

        UserDAO userDAO = (UserDAO) record;
        if (userDAO.isAdmin) {
            return Optional.empty();
        }
        return  Optional.of(new Customer(userDAO.getId(), userDAO.username, userDAO.password));
    }


    public Optional<CustomerDetails> getCustomerDetailsByCustomer(Customer customer){
        int id = customer.getId();
        BaseClass[] records;

        try {
            records = tableReader.readAll(new CustomerDetailsDAO());
        } catch (Exception e){
            return  Optional.empty();
        }

        for (BaseClass record: records){
            CustomerDetailsDAO customerDetailsDAO = (CustomerDetailsDAO) record;
            if (customerDetailsDAO.relatedToUser == customer.getId()){
                return Optional.of(new CustomerDetails(
                        customerDetailsDAO.firstName,
                        customerDetailsDAO.secondName,
                        customerDetailsDAO.email,
                        customerDetailsDAO.balanceRM
                ));
            }
        }
        return Optional.empty();
    }
    public boolean toUpCustomerBalance(Customer customer, float amount) {
        BaseClass[] records;
        try {
            records = tableReader.readAll(new CustomerDetailsDAO());
        } catch (Exception e) {
            return false;
        }

        for (BaseClass record: records){
            CustomerDetailsDAO customerDetailsDAO = (CustomerDetailsDAO) record;

            if (customerDetailsDAO.relatedToUser == customer.getId()){
               return   increaseCustomerDetailsBalance(customerDetailsDAO,amount);
            }
        }

        return false;
    }

    private boolean increaseCustomerDetailsBalance(CustomerDetailsDAO customerDetailsDAO, float amount){
        if(amount <= 0){
            return false;
        }
        customerDetailsDAO.balanceRM += amount;
        try {
            tableWriter.writeToID(customerDetailsDAO);
        } catch (Exception e){
            return  false;
        }
        return true;
    }


    public boolean withdrawalCustomerBalance(Customer customer, float amountToWithdrawal){
        BaseClass[] records;
        try{
            records = tableReader.readAll(new CustomerDetailsDAO());
        } catch (Exception e){
            return false;
        }

        for (BaseClass record: records){
            CustomerDetailsDAO customerDetailsDAO = (CustomerDetailsDAO) record;
            if (customerDetailsDAO.relatedToUser == customer.getId()){

                return  decreaseCustomerDetailsBalance(customerDetailsDAO, amountToWithdrawal);
            }
        }
        return false;
    }

    private boolean decreaseCustomerDetailsBalance(CustomerDetailsDAO customerDetailsDAO, float amount){
        if(amount <= 0){
            return false;
        }
        customerDetailsDAO.balanceRM -= amount;
        try {
            tableWriter.writeToID(customerDetailsDAO);
        } catch (Exception e){
            return  false;
        }
        return true;
    }

    private boolean addNewCustomer(UserApplicationDAO userApplication) {
        int userID = addNewUser(new User(userApplication.username, userApplication.password), false);
        if (userID == -1) return false;
        return addCustomerDetail(new CustomerDetails(userApplication.firstName,
                userApplication.secondName, userApplication.email, 0f), userID);

    }

    private boolean addCustomerDetail(CustomerDetails customerDetails, int userID) {
        try {
            tableWriter.writeNew(new CustomerDetailsDAO(
                    customerDetails.getFistName(), customerDetails.getSecondName(),
                    customerDetails.getEmail(), 0f, userID));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private int addNewUser(User user, boolean isAdmin) {
        /**
         *  RETURNS -1 IF NOT CREATED
         * **/
        try {
            return tableWriter.writeNew(new UserDAO(user.getUsername(), user.getPassword(), isAdmin));
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean deleteUserApplicationByUsername(String username) {
        BaseClass[] records;
        try {
            records = tableReader.readAll(new UserApplicationDAO());
        } catch (Exception e) {
            return false;
        }

        int idToDelete = -1;

        for (BaseClass record : records) {
            UserApplicationDAO userApplication = ((UserApplicationDAO) record);
            if (userApplication.username.equals(username)) {
                idToDelete = userApplication.getId();
            }
        }

        if (idToDelete == -1 || !deleteUserApplicationById(idToDelete)) {
            return false;
        }
        return true;
    }

    private boolean deleteUserApplicationById(int id) {
        try {
            tableRecordDeleter.deleteRecordById(new UserApplicationDAO(), id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}



