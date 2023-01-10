public class ToasterOven extends KitchenItem{
    private int width;
    private boolean convection;

    public ToasterOven(double price, int Quantity, int wattage, String color, String brand, int width, boolean convection) {
        super(price, Quantity, wattage, color, brand);
        this.width = width;
        this.convection = convection;
    }

    public String toString() {
        String output = String.format("%d inch %s Toaster ", width, getBrand());
        if(convection) {
            output = output + "with convection ";
        }
        output = output + String.format("(%s, %d watts)", getColor(), getWattage());
        output = output + super.printInfo();
        return output;
    }
}
