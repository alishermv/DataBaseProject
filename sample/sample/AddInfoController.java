package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddInfoController implements Initializable {

    @FXML
    private TextField markField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField mileageField;
    @FXML
    private TextField driveField;
    @FXML
    private TextField priceField;

    String query = null;
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement;
    Feedback feedback = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    @FXML
    public void save(MouseEvent event){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();
        String brand = markField.getText();
        String laptopName = modelField.getText();
        String size = yearField.getText();
        String processor = mileageField.getText();
        String graphic = driveField.getText();
        String disk = priceField.getText();

        if(brand.isEmpty() || laptopName.isEmpty() || size.isEmpty() || processor.isEmpty() || graphic.isEmpty() || disk.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Толықтай толтыруыңызды өтінеміз");
            alert.showAndWait();
        } else{
            qetQuery();
            insert();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("   Ақпарат енгізілді.");
            alert.showAndWait();

        }
    }

    private void qetQuery() {
        query = "INSERT INTO car (mark ,model, year, mileage, drive, price) " +
                "VALUES(?,?,?,?,?,?) ";
    }
    private void insert() {

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, markField.getText());
            preparedStatement.setString(2, modelField.getText());
            preparedStatement.setString(3, yearField.getText());
            preparedStatement.setString(4, mileageField.getText());
            preparedStatement.setString(5, driveField.getText());
            preparedStatement.setString(6, priceField.getText());
            preparedStatement.execute();
        } catch (SQLException e){
            Logger.getLogger(feedbackController.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}

