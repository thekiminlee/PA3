/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

/**
 *
 * @author kimin
 */
public class RecentProduct {
    private String name;
    private String imagePath;
    private String productNum;
    private int priority;
    
    public RecentProduct(String name, String path, String productNum){
        this.name = name;
        imagePath = path;
        this.productNum = productNum;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPath(){
        return imagePath;
    }
    
    public String getProductNum(){
        return productNum;
    }
    
    public int getPriority(){
        return priority;
    }
    
    public void setPriority(int p){
        priority = p;
    }
    
    public void decPriority(){
        priority--;
    }
}
