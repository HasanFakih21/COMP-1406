import java.util.Scanner;
public class ElectronicStore {
    private final int MAX_PRODUCTS = 10;
    private String name;
    private double revenue;
    Product[] products = new Product[MAX_PRODUCTS];

    public ElectronicStore(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int findEmpty() {
        int index = -1;
        for(int x = 0; x<products.length;x++) {
            if(products[x] == null) {
                index = x;
                break;
            }
        }
        return index;
    }

    public boolean addProduct(Product p) {
        boolean flag = false;
        int index = findEmpty();
        if (index>-1) {
            products[index] = p;
            flag = true;
        }
        return flag;
    }

    public boolean isValid(int item) {
        if(item<10 && item>=0) {
            if(products[item]!= null) {
                return true;
            }
        }
        return false;
    }

    public void sellProducts(int item, int amount) {
        if(isValid(item)) {
            revenue = revenue + products[item].sellUnits(amount);
        }
    }

    public void sellProducts() {
        Scanner in = new Scanner(System.in);
        printStock();
        System.out.println("Please pick a product");
        int item = in.nextInt();
        System.out.println("Please pick an amount");
        int amount = in.nextInt();
        sellProducts(item,amount);
    }

    public void printStock() {
        int counter = 0;
        for(Product x:products) {
            if (x!= null) {
                System.out.print(counter+". ");
                System.out.println(x);
            }
            counter++;
        }
    }

    public double getRevenue() {
        return revenue;
    }
}
