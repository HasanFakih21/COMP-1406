public class Fridge {
    double size;
    boolean freezer;
    String color;

    public Fridge(double size, boolean freezer, String color) {
        this.size = size;
        this.freezer = freezer;
        this.color = color;
    }

    public String toString() {
        String output = String.format("%.1f cubic foot Fridge ", size);
        if(freezer) {
            output = output + "with Freezer ";
        }
        output = output + String.format("(%s)", color);
        return output;
    }
}
