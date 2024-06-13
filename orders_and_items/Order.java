import java.util.*;

public class Order {
    // Attributes 
    private String name;
    private double total; 
    private boolean ready;
    private ArrayList <Item> items;

    // Constuctors
    public Order(){
        items = new ArrayList<Item>();
        name = "Guest";
    }

    public Order(String name){
        items = new ArrayList<Item>();
        this.name = name;
    }

    // Getters and Setters 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    
    // Function to add new Item to the object items array
    public void addItem(Item item) {
        this.items.add(item);
        this.total += item.getPrice();   
    }

    // Function to get order status 
    public String getStatusMessage(){
        if (this.ready == true){
            return "Your order is ready";
        } else {
            return "Thank you for wating. Your order will be ready soon.";
        }
    }

    // Function to display order informations
    public String display(){
        String information = "Customer Name: " + this.name + "\n";         
        for(Item item : items) {
            information += item.getName() + "- $" + item.getPrice() ;
        }
        information += "Total: $ " + this.total + "\n";
        return  information;
    }
}



