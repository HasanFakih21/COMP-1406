public abstract class KitchenItem extends Product{
    private int wattage;
    private String color;
    private String brand;

    public KitchenItem(double price, int Quantity, int wattage, String color, String brand) {
        super(price, Quantity);
        this.wattage = wattage;
        this.brand = brand;
        this.color = color;
    }

    public int getWattage() {
        return wattage;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }
}
