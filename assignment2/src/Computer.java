public abstract class Computer extends Product {
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;

    public Computer(double price, int Quantity, double cpuSpeed, int ram, boolean ssd, int storage) {
        super(price, Quantity);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
    }

    public int getStorage() {
        return storage;
    }

    public int getRam() {
        return ram;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public boolean hasSSD() {
        return ssd;
    }
}
