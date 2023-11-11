import com.jays.model.price.Price;
import com.jays.service.price.PriceServices;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jays.*"})
@EntityScan(basePackages = {"com.jays.*"})
@EnableJpaRepositories(basePackages = {"com.jays.*"})

public class DEstore extends Application {

    private TextField idField;
    private TextField priceField;
    private TextField nameField;
    private TextField saleTypeField;
    private CheckBox isDeliveryFreeCheckbox;


    private static ConfigurableApplicationContext springContext;
    private Stage primaryStage;

    @Autowired
    private PriceServices priceServices;

    @Override
    public void init() {
        springContext = SpringApplication.run(DEstore.class);
        springContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("DE-Store Management System");

        // GridPane for structured layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // UI Components for Price Management
        Label nameLabel = new Label("Product Name:");
        nameField = new TextField(); // Use the class member, don't redeclare it
        Label priceLabel = new Label("Price:");
        priceField = new TextField(); // Use the class member, don't redeclare it
        Label saleTypeLabel = new Label("Sale Type:");
        saleTypeField = new TextField(); // Use the class member, don't redeclare it
        isDeliveryFreeCheckbox = new CheckBox("Free Delivery"); // Use the class member, don't redeclare it


        Button addButton = new Button("Add Price");
        Button updateButton = new Button("Update Price");
        Button applySaleButton = new Button("Apply Sale Offer");
        Button removeSaleButton = new Button("Remove Sale Offer");

        // Event Handlers
        addButton.setOnAction(event -> handleAddPrice());
       // updateButton.setOnAction(event -> handleUpdatePrice());
       // applySaleButton.setOnAction(event -> handleApplySaleOffer());
       // removeSaleButton.setOnAction(event -> handleRemoveSaleOffer());

        // Add components to GridPane
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(priceLabel, 0, 1);
        gridPane.add(priceField, 1, 1);
        gridPane.add(saleTypeLabel, 0, 2);
        gridPane.add(saleTypeField, 1, 2);
        gridPane.add(isDeliveryFreeCheckbox, 0, 3, 2, 1);
        gridPane.add(addButton, 0, 4);
        gridPane.add(updateButton, 1, 4);
        gridPane.add(applySaleButton, 0, 5);
        gridPane.add(removeSaleButton, 1, 5);

        // TableView for displaying prices
        TableView<Price> priceTableView = new TableView<>();
        // Define columns for the TableView here...

        // Add TableView to GridPane
        gridPane.add(priceTableView, 0, 6, 2, 1);

        // Scene setup
        Scene scene = new Scene(gridPane, 600, 400);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void handleAddPrice() {
        System.out.println("handleAddPrice called"); // Debugging line

        // Validate input fields
        if (nameField.getText().isEmpty() || priceField.getText().isEmpty() || saleTypeField.getText().isEmpty()) {
            showAlert("Please fill in all the fields");
            return;
        }
        try {
            double price = Double.parseDouble(priceField.getText());
            String name = nameField.getText();
            String saleType = saleTypeField.getText();
            boolean isDeliveryFree = isDeliveryFreeCheckbox.isSelected();

            // Create and add price to the database
            addPriceToDatabase(name, price, saleType, isDeliveryFree);

            // Update UI
            updatePriceTableView();

            showAlert("Price added successfully");
        } catch (NumberFormatException e) {
            showAlert("Invalid price format");
            priceField.clear();
            priceField.requestFocus();
        }
    }
    private void addPriceToDatabase(String name, double price, String saleType, boolean isDeliveryFree) {
        int id = priceServices.getNextAvailableId();
        Price newPrice = new Price(id, name, price, saleType, isDeliveryFree);
        priceServices.addPrice(newPrice);
    }
    private void updatePriceTableView() {
        // Logic to update the price table view
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.showAndWait();
    }


    @Override
    public void stop() {
        springContext.close();
    }

    public static void main(String[] args) {
        launch(DEstore.class, args);
    }
}
