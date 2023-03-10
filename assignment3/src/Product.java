//Base class for all products the store will sell
public class Product{
 private double price;
 private int stockQuantity;
 private int soldQuantity;
 private int amount;

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Product(double initPrice, int initQuantity){
   price = initPrice;
   stockQuantity = initQuantity;
   amount = initQuantity;
 }

 public void setStockQuantity(int stockQuantity) {
     this.stockQuantity = stockQuantity;
 }

    public int getStockQuantity(){
   return stockQuantity;
 }
 
 public int getSoldQuantity(){
   return soldQuantity;
 }
 
 public double getPrice(){
    return price;
 }

 public int getAmount() {
     return amount;
 }

 public void setAmount(int amount) {
     this.amount = amount;
 }

    //Returns the total revenue (price * amount) if there are at least amount items in stock
 //Return 0 otherwise (i.e., there is no sale completed)
 public double sellUnits(int amount){
   if(amount > 0 && stockQuantity >= amount){
     stockQuantity -= amount;
     soldQuantity += amount;
     return price * amount;
   }
   return 0.0;
 }
}