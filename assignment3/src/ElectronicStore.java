//Class representing an electronic store
//Has an array of products that represent the items the store can sell
import java.util.ArrayList;

public class ElectronicStore{
  public final int MAX_PRODUCTS = 10; //Maximum number of products the store can have
  private int curProducts;
  String name;
  Product[] stock; //Array to hold all products
  private double revenue;
  private int numOfSales;
  private double perSale;
  private ArrayList<Product> cart = new ArrayList<Product>();

  public void setRevenue(double revenue) {
    this.revenue = revenue;
  }

  public void setNumOfSales(int numOfSales) {
    this.numOfSales = numOfSales;
  }

  public ArrayList<Product> createStockList() {
    ArrayList<Product> storeList = new ArrayList<Product>();
    for(int i =0; i<curProducts;i++) {
      if(stock[i].getAmount()>0) {
        storeList.add(stock[i]);
      }
    }
    return storeList;
  }

  public ArrayList<Product> getCart() {
    return cart;
  }

  public int getNumOfSales() {
    return numOfSales;
  }

  public double getPerSale() {
    perSale = revenue/numOfSales;
    return perSale;
  }

  public int getCurProducts() {
    return curProducts;
  }

  public ElectronicStore(String initName){
    revenue = 0.0;
    name = initName;
    stock = new Product[MAX_PRODUCTS];
    curProducts = 0;
  }
  
  public String getName(){
    return name;
  }

  public Product[] getStock() {
    return stock;
  }
  
  //Adds a product and returns true if there is space in the array
  //Returns false otherwise
  public boolean addProduct(Product newProduct){
    if(curProducts < MAX_PRODUCTS){
     stock[curProducts] = newProduct;
     curProducts++;
     return true;
    }
    return false;
  }

  public void addToCart(Product item) {
    for(int i =0; i<curProducts; i++) {
      if(item == stock[i]) {
        stock[i].setAmount(stock[i].getAmount() - 1);
      }
    }
    cart.add(item);
  }

  public void removeFromCart(Product item) {
    for(int i =0; i<curProducts; i++) {
      if(item == stock[i]) {
        stock[i].setAmount(stock[i].getAmount() + 1);
      }
    }
    cart.remove(item);
  }
  
  //Sells 'amount' of the product at 'index' in the stock array
  //Updates the revenue of the store
  //If no sale occurs, the revenue is not modified
  //If the index is invalid, the revenue is not modified
  public void sellProducts(int index, int amount){
    if(index >= 0 && index < curProducts){
      revenue += stock[index].sellUnits(amount);
    }
  }
  
  public double getRevenue(){
    return revenue;
  }

  public ArrayList<Product> getPopularProducts() {
    ArrayList<Product> popItems = new ArrayList<Product>();
    for(int i =0; i<getCurProducts();i++) {
      popItems.add(stock[i]);
    }

    while(popItems.size() > 3) {
      int index = 0;
      int min = 10000000;
      for(int i = 0; i<popItems.size();i++) {
        if(popItems.get(i).getSoldQuantity()<min) {
          min = popItems.get(i).getSoldQuantity();
          index = i;
        }
      }
      popItems.remove(index);
    }

    for (int i = 0; i < popItems.size()-1; i++)
      for (int k = 0; k < popItems.size()-i-1; k++)
        if (popItems.get(k).getSoldQuantity() < popItems.get(k+1).getSoldQuantity())
        {
          Product temp = popItems.get(k);
          popItems.set(k,popItems.get(k+1));
          popItems.set(k+1,temp);
        }
    return popItems;
  }
  
  //Prints the stock of the store
  public void printStock(){
    for(int i = 0; i < curProducts; i++){
      System.out.println(i + ". " + stock[i] + " (" + stock[i].getPrice() + " dollars each, " + stock[i].getStockQuantity() + " in stock, " + stock[i].getSoldQuantity() + " sold)");
    }
  }
  
  public static ElectronicStore createStore(){
    ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
    Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
    Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
    Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
    Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
    Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
    Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
    ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
    ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
    store1.addProduct(d1);
    store1.addProduct(d2);
    store1.addProduct(l1);
    store1.addProduct(l2);
    store1.addProduct(f1);
    store1.addProduct(f2);
    store1.addProduct(t1);
    store1.addProduct(t2);
    return store1;
  }
} 