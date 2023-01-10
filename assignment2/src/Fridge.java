public class Fridge extends KitchenItem {
    private double cubicFeet;
    private boolean hasFreezer;

    public Fridge(double price, int Quantity, int wattage, String color, String brand, double cubicFeet, boolean hasFreezer) {
        super(price, Quantity, wattage, color, brand);
        this.cubicFeet = cubicFeet;
        this.hasFreezer = hasFreezer;
    }

    public String toString() {
        String output = String.format("%.1f cu. ft. %s Fridge ", cubicFeet, getBrand());
        if(hasFreezer) {
            output = output + "with Freezer ";
        }
        output = output + String.format("(%s, %d watts)", getColor(), getWattage());
        output = output + super.printInfo();
        return output;
    }
}
