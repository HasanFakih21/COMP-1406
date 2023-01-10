//Hassan Fakih 101168868
import java.util.Scanner;
public class ElectronicStoreTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ElectronicStore store1 = new ElectronicStore("Hasan's Electronic Shop");
        store1.printStock();
        System.out.println();
        while (true) {
            System.out.println("Enter a term to search for: ");
            String tosearch = in.nextLine();
            if (tosearch.toLowerCase().equals("quit")) {
                break;
            }
            if(store1.searchStock(tosearch)) {
                System.out.println("A matching item is contained in the store's stock.");
            }
            else {
                System.out.println("No items in the store's stock match that term.");
            }
        }
    }
}
