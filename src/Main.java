import java.util.*;

import main.java.com.examly.entity.*;
import main.java.com.examly.service.*;

import main.java.com.examly.Exception.*;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService=new CustomerServiceImpl();
        MenuService menuService= new MenuServiceImpl();
        OrderService orderService=new OrderServiceImpl();
        Scanner sc=new Scanner(System.in);
        while(true){
        

        try{
            
        System.out.println("===Welcome to Online Food Ordering System===");
        System.out.println("1.Add customer");
        System.out.println("2.Add menuItem");
        System.out.println("3.Search Items By Category");
        System.out.println("4.Place Order");
        System.out.println("5.View orders of customer");
        System.out.println("6.Exit");
        System.out.print("Enter your choice: ");

        int ch=sc.nextInt();
        sc.nextLine();

        switch(ch){
            case 1:
                System.out.print("Enter customerId: ");
                String customerId=sc.nextLine();
                System.out.print("Enter name: ");
                String name=sc.nextLine();
                System.out.print("Enter email: ");
                String email=sc.nextLine();
                System.out.print("Enter phone: ");
                String phone=sc.nextLine();
                
                Customer customer=new Customer(customerId,name,email,phone);
                System.out.println(customerService.addCustomer(customer) ?"Customer Added Successfully" :"Cannot add customer");
                break;
            case 2:
                System.out.print("Enter itemId: ");
                String itemId=sc.nextLine();
                System.out.print("Enter name: ");
                String iname=sc.nextLine();
                System.out.print("Enter price: ");
                double price=sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter category: ");
                String category=sc.nextLine();
                Menu menu=new Menu(itemId,iname,price,category);
                System.out.println(menuService.addMenuItem(menu) ?"Item Added Successfully" :"Cannot add Item");
                break;
            case 3:
                System.out.print("Enter category: ");
                List<Menu> list=menuService.searchMenuItemsByCategory(sc.nextLine());
                for(Menu mi: list){
                    System.out.println(mi.getItemid()+"\n"+mi.getName()+"\n"+mi.getPrice());
                }
                break;
            case 4:
                System.out.print("Enter customerId: ");
                String cusId=sc.nextLine();
                System.out.print("Enter itemId: ");
                String itId=sc.nextLine();
                System.out.print("Enter Orderquantity: ");
                int quantity=sc.nextInt();
                sc.nextLine();
                Order order=new Order(cusId,itId,quantity);
                System.out.println(orderService.placeOrder(order) ?"Order placed" :"Order cannot be placed");
                break;
            case 5:
                System.out.print("Enter customerId: ");
                List<Order> li=orderService.getOrdersByCustomer(sc.nextLine());
                for(Order oc: li){
                    System.out.println(oc.getOrderId()+"\n"+oc.getItemid()+"\n"+oc.getQuantity()+"\n"+oc.getTotalamt()+"\n"+oc.getOrderdate());
                }
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice!");
            
            sc.close();
            }
        }
            catch (EmailAlreadyExistsException | CustomerNotFoundException | ItemNotFoundException e) {
        System.out.println(e.getMessage());
    }
    

}
            




        }
             
    }

