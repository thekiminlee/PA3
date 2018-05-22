
package general;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kimin
 */
public class ShoppingCart {
    List<CartItem> itemList;
    
    public ShoppingCart(){
        itemList = new ArrayList<>();
    }
    
    public void addItem(CartItem item){
        itemList.add(item);
    }
    
    public List<CartItem> getItems(){
        return itemList;
    }
    
    public boolean updateItem(String itemName){
        for(CartItem item : itemList){
            if(item.getName().equals(itemName)){
                item.setQuantity(1);
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty(){
        return itemList.isEmpty();
    }
    
    public void clearCart(){
        itemList.clear();
    }
    
    public void removeItem(String removeItem){
        CartItem remove = null;
        for(CartItem item : itemList){
            if(item.getName().equals(removeItem))
                remove = item;          
        }
        if (remove != null)
            itemList.remove(remove);
    }
}
