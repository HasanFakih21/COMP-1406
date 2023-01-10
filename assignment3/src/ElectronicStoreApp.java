import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.input.*;

public class ElectronicStoreApp extends Application {
    ElectronicStoreView view;
    ElectronicStore model;
    public void start(Stage stage) {
        model = ElectronicStore.createStore();
        view = new ElectronicStoreView(model);

        stage.setTitle("Electronic Store Application - " + model.getName());
        stage.setResizable(false);
        stage.setScene(new Scene(view, 800,400)); // Set size of window
        stage.show();

        view.getStockList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                handleStockSelection();
            }
        });

        view.getAddToCart().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleAddButton();
            }
        });

        view.getCurrentCartList().setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                handleCartSelection();
            }
        });

        view.getRemoveFromCart().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleRemoveButton();
            }
        });

        view.getCompleteSale().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleCompleteSale();
            }
        });

        view.getResetStore().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleResetButton();
            }
        });

    }

    public void handleResetButton() {
        for(int i =0;i<model.getCurProducts();i++) {
            model.stock[i].setStockQuantity(10);
            model.stock[i].setAmount(model.stock[i].getStockQuantity());
            model.stock[i].setSoldQuantity(0);
        }
        model.setRevenue(0);
        model.setNumOfSales(0);
        model.getCart().clear();
        view.update();
    }

    public void handleCompleteSale() {
        for(int i = 0; i<model.getCurProducts(); i++) {
            if(model.getStock()[i].getStockQuantity() - model.getStock()[i].getAmount() != 0) {
                model.sellProducts(i,model.getStock()[i].getStockQuantity() - model.getStock()[i].getAmount());
                model.getStock()[i].setAmount(model.getStock()[i].getStockQuantity());
            }
        }
        model.getCart().clear();
        model.setNumOfSales(model.getNumOfSales()+1);
        view.update();
    }

    public void handleCartSelection() {
        view.update();
    }

    public void handleRemoveButton() {
        int index = view.getCurrentCartList().getSelectionModel().getSelectedIndex();
        if(index>=0) {
            model.removeFromCart(model.getCart().get(index));
        }
        view.update();
    }

    public void handleStockSelection() {
        view.update();
    }

    public void handleAddButton() {
        int index = view.getStockList().getSelectionModel().getSelectedIndex();
        if(index>= 0) {
            model.addToCart(model.createStockList().get(index));
        }
        view.update();
    }
}
