package main.java.com.examly.service;

import java.util.*;
import java.sql.*;
import main.java.com.examly.entity.*;
import main.java.com.examly.util.DBConnection;
import main.java.com.examly.Exception.*;

public class OrderServiceImpl implements OrderService{
    MenuService menuService= new MenuServiceImpl();
    @Override
    public boolean customerExists(String customerId){
        String sql="SELECT customerId FROM customer WHERE customerId=?";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,customerId);
            ResultSet rs=ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e){
            e.printStackTrace();
            
        }
        return false;
    }
    @Override
    public boolean itemExists(String itemId){
        String sql="SELECT itemId FROM Menu WHERE itemId=?";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,itemId);
            ResultSet rs=ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e){
            e.printStackTrace();
            
        }
        return false;
    }
    @Override
    public boolean placeOrder(Order order) throws CustomerNotFoundException,ItemNotFoundException{
        if(!customerExists(order.getCustomerId())){
            throw new CustomerNotFoundException("Customer not found");
            
        }
        if(!itemExists(order.getItemid())){
            throw new ItemNotFoundException("Item not found");
            
        }
        Menu item=menuService.getItemById(order.getItemid());
        double price=item.getPrice();
        

        
        String sql="INSERT INTO orders(customerId,itemId,quantity,totalamt,orderdate) VALUES(?,?,?,?,CURDATE())";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            
            ps.setString(1,order.getCustomerId());
            ps.setString(2,order.getItemid());
            ps.setInt(3,order.getQuantity());
            ps.setDouble(4,order.getQuantity()*price);
            
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
    }
    @Override
    public List<Order>getOrdersByCustomer(String customerId){
        String sql="SELECT * FROM orders WHERE customerId=?";
        List<Order> list=new ArrayList<>();

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,customerId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Order m=new Order(
                rs.getInt("orderId"),
                rs.getString("customerId"),
                rs.getString("itemId"),
                rs.getInt("quantity"),
                rs.getDouble("totalamt"),
                rs.getDate("orderdate"));
                list.add(m);
            }
                        
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        return list;
    }


}