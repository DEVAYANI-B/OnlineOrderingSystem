package main.java.com.examly.entity;
import java.util.Date;

public class Order{

    private int orderId;
    private String customerId;
    private String itemId;
    private int quantity;
    private double totalamt;
    private Date orderdate;

    public Order(){}
    public Order(String customerId, String itemId, int quantity) {
    this.customerId = customerId;
    this.itemId = itemId;
    this.quantity = quantity;
}

    public Order(int orderId,String customerId,String itemId,int quantity,double totalamt,Date orderdate){
        this.orderId=orderId;
        this.customerId=customerId;
        this.itemId=itemId;
        this.quantity=quantity;
        this.totalamt=totalamt;
        this.orderdate=orderdate;
    }
    public int getOrderId(){
        return orderId;
    }
    public void setOrderId(int orderId){
        this.orderId=orderId;
    }
    public String getCustomerId(){
        return customerId;
    }
    public void setCustomerId(String customerId){
        this.customerId=customerId;
    }
    public String getItemid(){
        return itemId;
    }
    public void setItemid(String itemId){
        this.itemId=itemId;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public double getTotalamt(){
        return totalamt;
    }
    public void setTotalamt(double totalamt){
        this.totalamt=totalamt;
    }
    public Date getOrderdate(){
        return orderdate;
    }
    public void setOrderdate(Date orderdate){
        this.orderdate=orderdate;
    }
    @Override
    public String toString(){
        return orderId+" "+customerId+" "+itemId+" "+quantity+" "+totalamt+" "+orderdate;
    }

}