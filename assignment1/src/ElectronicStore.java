import java.util.ArrayList;
public class ElectronicStore {
    ArrayList<Object> desktops = new ArrayList();
    ArrayList<Object> laptops = new ArrayList();
    ArrayList<Object> fridges = new ArrayList();
    ArrayList[] items = {desktops, laptops, fridges};
    String name;

    public ElectronicStore(String name) {
        this.name = name;
        items[0].add(new Desktop(3.4, 6, 600, true));
        items[0].add(new Desktop(3, 16, 900, false));
        items[0].add(new Desktop(3.9, 32, 1200, true));
        items[1].add(new Laptop(3.4, 8, 600, true, 12));
        items[1].add(new Laptop(3.5, 6, 300, false, 9));
        items[1].add(new Laptop(3.9, 16, 800, true, 11));
        items[2].add(new Fridge(13.4, true, "Black"));
        items[2].add(new Fridge(14.3, false, "White"));
        items[2].add(new Fridge(15, true, "Grey"));
    }

    public void printStock() {
        System.out.println("The store stock includes:");
        for(ArrayList<Object> x:items){
            for(Object y:x) {
                System.out.println(y);
            }
        }
    }

    public boolean searchStock(String substring) {
        substring = substring.toUpperCase();
        boolean output = false;
        for(ArrayList<Object> x:items) {
            for(Object y:x) {
                if (y.toString().toUpperCase().contains(substring)){
                    output = true;
                    break;
                }
            }
        }
        return output;
    }

}
