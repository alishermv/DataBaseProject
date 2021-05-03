package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MazdaController implements Initializable {
    @FXML
    private TableColumn<Car_Info, String> column_mark;
    @FXML
    private TableColumn<Car_Info, String> column_model;
    @FXML
    private TableColumn<Car_Info, String> column_year;
    @FXML
    private TableColumn<Car_Info, String> column_mileage;
    @FXML
    private TableColumn<Car_Info, String> column_engine;
    @FXML
    private TableColumn<Car_Info, String> column_transmission;
    @FXML
    private TableColumn<Car_Info, String> column_drive;
    @FXML
    private TableColumn<Car_Info, String> column_hand;
    @FXML
    private TableColumn<Car_Info, String> column_fuel;
    @FXML
    private TableColumn<Car_Info, String> column_price;
    @FXML
    private TableView<Car_Info> cars_table;
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private TextField searchField;
    @FXML
    private ImageView acer_icon;
    ObservableList<Car_Info> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File file = new File("images/acer_icon.png");
        Image image = new Image(file.toURI().toString());
        acer_icon.setImage(image);

        column_mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        column_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        column_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        column_mileage.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        column_engine.setCellValueFactory(new PropertyValueFactory<>("engine"));
        column_transmission.setCellValueFactory(new PropertyValueFactory<>("transmission"));
        column_drive.setCellValueFactory(new PropertyValueFactory<>("drive"));
        column_hand.setCellValueFactory(new PropertyValueFactory<>("hand"));
        column_fuel.setCellValueFactory(new PropertyValueFactory<>("fuel"));
        column_price.setCellValueFactory(new PropertyValueFactory<>("price"));



        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String query = "SELECT mark, model, year, mileage, engine_capacity, transmission, drive, hand_drive, fuel, price FROM car WHERE mark = 'mazda'";

            ResultSet rs = connection.createStatement().executeQuery(query);

            while(rs.next()){
                observableList.add(new Car_Info(rs.getString("mark"), rs.getString("model"), rs.getString("year"),
                        rs.getString("mileage"),rs.getString("engine_capacity"), rs.getString("transmission") , rs.getString("drive") ,
                        rs.getString("hand_drive") , rs.getString("fuel") , rs.getString("price")));
            }

        } catch (SQLException e){
            Logger.getLogger(MazdaController.class.getName()).log(Level.SEVERE, null, e);
        }



        cars_table.setItems(observableList);

        FilteredList<Car_Info> filteredList = new FilteredList<>(observableList, e -> true);


        searchField.setOnKeyReleased( e->  {
            searchField.textProperty().addListener((observable, oldValue, newValue) -> {

                filteredList.setPredicate((Predicate<? super Car_Info>) car_info->{

                    if(newValue == null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                    if(car_info.getMark().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(car_info.getModel().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(car_info.getYear().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(car_info.getMileage().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(car_info.getEngine().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(car_info.getTransmission().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(car_info.getDrive().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(car_info.getHand().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(car_info.getFuel().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(car_info.getPrice().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }





                    return false;
                });
            });
            SortedList<Car_Info> sortedList = new SortedList<>(filteredList);

            sortedList.comparatorProperty().bind(cars_table.comparatorProperty());

            cars_table.setItems(sortedList);
        });






    }
}
