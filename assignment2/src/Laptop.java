public class Laptop extends Computer {
    private double screenSize;

    public Laptop(double price, int Quantity, double cpuSpeed, int ram, boolean ssd, int storage, double screenSize) {
        super(price, Quantity, cpuSpeed, ram, ssd, storage);
        this.screenSize = screenSize;
    }

    public String toString() {
        String output = String.format("%.1f inch Laptop PC with %.1fghz CPU, %dGB RAM, %dGB ", screenSize, getCpuSpeed(), getRam(), getStorage());
        if(hasSSD()) {
            output = output + "SSD drive";
        }
        else {
            output = output + "HDD drive";
        }
        output = output + super.printInfo();
        return output;
    }
}
