package main.java.com.examly.service;
import main.java.com.examly.entity.Customer;
import main.java.com.examly.Exception.EmailAlreadyExistsException;

public interface CustomerService{

    boolean addCustomer(Customer customer) throws EmailAlreadyExistsException;
    boolean emailexists(String email);
    
}

