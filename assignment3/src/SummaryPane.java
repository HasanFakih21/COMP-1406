import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SummaryPane extends Pane{
    private TextField numSales;
    private TextField revenue;
    private TextField perSale;

    public SummaryPane() {
        Label label1 = new Label("# Sales:");
        label1.relocate(10, 35);
        label1.setPrefSize(60, 30);
        Label label2 = new Label("Revenue:");
        label2.relocate(10, 70);
        label2.setPrefSize(60, 30);
        Label label3 = new Label("$ / Sale:");
        label3.relocate(10, 105);
        label3.setPrefSize(60, 30);
        label1.setAlignment(Pos.CENTER_RIGHT);
        label2.setAlignment(Pos.CENTER_RIGHT);
        label3.setAlignment(Pos.CENTER_RIGHT);

        numSales = new TextField();
        numSales.relocate(80, 35);
        numSales.setPrefSize(90, 30);
        revenue = new TextField();
        revenue.relocate(80, 70);
        revenue.setPrefSize(90, 30);
        perSale = new TextField();
        perSale.relocate(80, 105);
        perSale.setPrefSize(90, 30);

        Label title = new Label("Store Summary:");
        title.relocate(50, 0);
        title.setPrefSize(120, 30);

        getChildren().addAll(label1,label2,label3,numSales,revenue,perSale,title);
    }

    public TextField getNumSales() {
        return numSales;
    }

    public TextField getRevenue() {
        return revenue;
    }

    public TextField getPerSale() {
        return perSale;
    }

    public void updateFields(ElectronicStore newStore) {
        numSales.setText(newStore.getNumOfSales()+"");
        revenue.setText(String.format("%.2f",newStore.getRevenue()));
        if(newStore.getNumOfSales()==0) {
            perSale.setText("N/A");
        }
        else {
            perSale.setText(String.format("%.2f",newStore.getPerSale()));
        }
    }
}
