package main.java.com.examly.service;

import main.java.com.examly.entity.Menu;
import java.sql.*;
import java.util.*;
import main.java.com.examly.util.DBConnection;


public class MenuServiceImpl implements MenuService{

    @Override
    public boolean addMenuItem(Menu item){
        String sql="INSERT INTO menu(itemId,name,price,category) VALUES(?,?,?,?)";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,item.getItemid());
            ps.setString(2,item.getName());
            ps.setDouble(3,item.getPrice());
            ps.setString(4,item.getCategory());
            return ps.executeUpdate()>0;

        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Menu> searchMenuItemsByCategory(String category){
        String sql="SELECT * FROM menu WHERE category=?";
        List<Menu> list=new ArrayList<>();

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,category);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Menu m=new Menu(
                rs.getString("itemId"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getString("category"));
                list.add(m);
            }
                        
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        return list;
    }

    public Menu getItemById(String itemId){
        String sql="SELECT * FROM menu WHERE itemId=?";
        

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,itemId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Menu(
                rs.getString("itemId"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getString("category"));
                
                
            }
                        
        }
        catch(SQLException e){
            e.printStackTrace();


        }
        return null;
        
    }

}