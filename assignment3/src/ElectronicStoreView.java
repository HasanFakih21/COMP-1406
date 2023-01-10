import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;

import java.util.ArrayList;

public class ElectronicStoreView extends Pane{
    private ElectronicStore model;
    private SummaryPane summary;
    private ListView<String> popItemsList;
    private ListView<String> stockList;
    private ListView<String> currentCartList;
    private Button resetStore;
    private Button addToCart;
    private Button removeFromCart;
    private Button completeSale;
    private Label cartLabel;

    public ElectronicStoreView(ElectronicStore model) {
        this.model = model;
        summary = new SummaryPane();
        summary.relocate(10,10);
        getChildren().add(summary);

        popItemsList = new ListView<String>();
        popItemsList.relocate(10, 180);
        popItemsList.setPrefSize(170, 150);
        getChildren().add(popItemsList);
        Label label1 = new Label("Most Popular Items:");
        label1.setPrefSize(170, 30);
        label1.relocate(10, 150);
        label1.setAlignment(Pos.CENTER);
        getChildren().add(label1);

        stockList = new ListView<String>();
        stockList.relocate(190,45);
        stockList.setPrefSize(285, 285);
        getChildren().add(stockList);
        Label label2 = new Label("Store Stock:");
        label2.setPrefSize(285, 30);
        label2.relocate(190, 10);
        label2.setAlignment(Pos.CENTER);
        getChildren().add(label2);

        currentCartList = new ListView<String>();
        currentCartList.relocate(485,45);
        currentCartList.setPrefSize(285, 285);
        getChildren().add(currentCartList);
        cartLabel = new Label();
        cartLabel.setText("Current Cart:");
        cartLabel.setPrefSize(285, 30);
        cartLabel.relocate(485, 10);
        cartLabel.setAlignment(Pos.CENTER);
        getChildren().add(cartLabel);

        resetStore = new Button("Reset Store");
        resetStore.relocate(35, 340);
        resetStore.setPrefSize(120, 40);
        getChildren().add(resetStore);

        addToCart = new Button("Add to Cart");
        addToCart.relocate(272, 340);
        addToCart.setPrefSize(120, 40);
        getChildren().add(addToCart);

        removeFromCart = new Button("Remove from Cart");
        removeFromCart.relocate(507, 340);
        removeFromCart.setPrefSize(120, 40);
        getChildren().add(removeFromCart);

        completeSale = new Button("Complete Sale");
        completeSale.relocate(627, 340);
        completeSale.setPrefSize(120, 40);
        getChildren().add(completeSale);

        update();
    }

    public SummaryPane getSummary() {
        return summary;
    }

    public ListView<String> getPopItemsList() {
        return popItemsList;
    }

    public ListView<String> getStockList() {
        return stockList;
    }

    public ListView<String> getCurrentCartList() {
        return currentCartList;
    }

    public Button getResetStore() {
        return resetStore;
    }

    public Button getAddToCart() {
        return addToCart;
    }

    public Button getRemoveFromCart() {
        return removeFromCart;
    }

    public Button getCompleteSale() {
        return completeSale;
    }

    public Label getCartLabel() {
        return cartLabel;
    }

    public void update(){
        String[] productsString = turnToString(model.createStockList());
        stockList.setItems(FXCollections.observableArrayList(productsString));
        summary.updateFields(model);
        int stockSelection = stockList.getSelectionModel().getSelectedIndex();
        if(stockSelection>=0) {
            addToCart.setDisable(false);
        }
        else {
            addToCart.setDisable(true);
        }

        int cartSelection = currentCartList.getSelectionModel().getSelectedIndex();
        if(cartSelection>=0) {
            removeFromCart.setDisable(false);
        }
        else {
            removeFromCart.setDisable(true);
        }

        ArrayList<Product> popItems = model.getPopularProducts();
        String[] popItemsString = turnToString(popItems);
        popItemsList.setItems(FXCollections.observableArrayList(popItemsString));
        String[] currentCartToString = turnToString(model.getCart());
        currentCartList.setItems(FXCollections.observableArrayList(currentCartToString));
        if(model.getCart().size()>0) {
            completeSale.setDisable(false);
        }
        else {
            completeSale.setDisable(true);
        }

        double totalCart = 0;
        for(int i = 0; i<model.getCart().size(); i++) {
            totalCart = totalCart + model.getCart().get(i).getPrice();
        }
        getCartLabel().setText(String.format("Current Cart ($%.2f):",totalCart));
    }

    public String[] turnToString(ArrayList<Product> cart) {
        String[] toString = new String[cart.size()];
        for(int i = 0; i<cart.size();i++) {
            toString[i] = cart.get(i).toString();
        }
        return toString;
    }

    public String[] turnToString(Product[] products, int length) {
        String[] toString = new String[length];
        for(int i = 0; i<length;i++) {
            toString[i] = products[i].toString();
        }
        return toString;
    }

}
