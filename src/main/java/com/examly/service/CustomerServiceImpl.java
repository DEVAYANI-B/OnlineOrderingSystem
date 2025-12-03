package main.java.com.examly.service;

import main.java.com.examly.entity.Customer;
import main.java.com.examly.util.DBConnection;
import main.java.com.examly.Exception.*;

import java.sql.*;

public class CustomerServiceImpl implements CustomerService{
    @Override
    public boolean emailexists(String email){
        String sql="SELECT email FROM customer WHERE email=?";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e){
            e.printStackTrace();
            
        }
        return false;
    }

    @Override
    public boolean addCustomer(Customer customer) throws EmailAlreadyExistsException{
        if(emailexists(customer.getEmail())){
            throw new EmailAlreadyExistsException("Email already registered");
            

        }
        String sql="INSERT INTO customer(customerId,name,email,phone) VALUES(?,?,?,?)";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,customer.getCustomerId());
            ps.setString(2,customer.getName());
            ps.setString(3,customer.getEmail());
            ps.setString(4,customer.getPhone());

            return ps.executeUpdate()>0;

        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }

     
        
    }
}

