public class Desktop {
    double CPU;
    int RAM;
    int storage;
    boolean SSD;

    public Desktop(double CPU, int RAM, int storage, boolean SSD){
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.SSD = SSD;
    }

    public String toString(){
        String output = String.format("Desktop PC with %.1fghz CPU, %dGB RAM, %dGB ", CPU, RAM, storage);
        if(SSD) {
            output = output + "SSD drive";
        }
        else {
            output = output + "HDD drive";
        }
        return output;
    }
}
