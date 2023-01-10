public class Desktop extends Computer {
    private String profile;

    public Desktop(double price, int Quantity, double cpuSpeed, int ram, boolean ssd, int storage, String profile) {
        super(price, Quantity, cpuSpeed, ram, ssd, storage);
        this.profile = profile;
    }

    public String toString() {
        String output = String.format("%s Desktop PC with %.1fghz CPU, %dGB RAM, %dGB ", profile, getCpuSpeed(), getRam(), getStorage());
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
