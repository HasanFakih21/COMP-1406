public abstract class Product {
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    public Product(double price, int Quantity) {
        this.price = price;
        stockQuantity = Quantity;
        soldQuantity = 0;
    }

    public double sellUnits(int amount) {
        double revenue = 0;
        if(amount <= stockQuantity && amount>0) {
            revenue = amount * price;
            stockQuantity = stockQuantity - amount;
            soldQuantity = soldQuantity + amount;
        }
        return revenue;
    }

    public String printInfo() {
        String output =  String.format("\n(%.1f dollars each, %d in stock, %d sold)", price, stockQuantity, soldQuantity);
        return output;
    }

    public abstract String toString();

}
