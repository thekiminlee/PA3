package general;

/**
 *
 * @author kimin
 */
public class CartItem {
    private String name;
    private int quantity = 1;
    private String price;
    
    public CartItem(String name, String price){
        this.name = name;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String getPrice(){
        return price;
    }
    
    public void setQuantity(int amount){
        quantity += amount;
    }
    
    
    
}
