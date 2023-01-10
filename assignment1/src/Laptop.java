public class Laptop {
    double CPU;
    int RAM;
    int storage;
    boolean SSD;
    int screen_size;

    public Laptop(double CPU, int RAM, int storage, boolean SSD, int screen_size) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.SSD = SSD;
        this.screen_size = screen_size;
    }

    public String toString(){
        String output = String.format("%d\" Laptop PC with %.1fghz CPU, %dGB RAM, %dGB ", screen_size, CPU, RAM, storage);
        if(SSD) {
            output = output + "SSD drive";
        }
        else {
            output = output + "HDD drive";
        }
        return output;
    }
}
