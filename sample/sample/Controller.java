package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Button close_button;
    @FXML
    private ImageView closeImageView;

    public void closeOnAction(ActionEvent event){
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void goToMainPageOnAction(ActionEvent event){
        MainPage();
    }

    public void MainPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/CarMainPage.fxml"));
            Stage registerStage = new Stage();
           //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToAudiPageOnAction(ActionEvent event){
        audiPage();
    }
    public void audiPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/audiPage.fxml"));
            Stage registerStage = new Stage();
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void goToNissanPageOnAction(ActionEvent event){
        nissanPage();
    }

    public void nissanPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/nissanPage.fxml"));
            Stage registerStage = new Stage();
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToBMWPageOnAction(ActionEvent event){
        bmwPage();
    }

    public void bmwPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/bmwPage.fxml"));
            Stage registerStage = new Stage();
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToCitroenPageOnAction(ActionEvent event){
        citroenPage();
    }

    public void citroenPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/citroenPage.fxml"));
            Stage registerStage = new Stage();
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToFordPageOnAction(ActionEvent event){
        fordPage();
    }

    public void fordPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/fordPage.fxml"));
            Stage registerStage = new Stage();
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToHyundaiPageOnAction(ActionEvent event){
        hyundaiPage();
    }

    public void hyundaiPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/hyundaiPage.fxml"));
            Stage registerStage = new Stage();
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToJaguarPageOnAction(ActionEvent event){
        jaguarPage();
    }

    public void jaguarPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/jaguarPage.fxml"));
            Stage registerStage = new Stage();
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToLandRoverPageOnAction(ActionEvent event){
        landroverPage();
    }

    public void landroverPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/landroverPage.fxml"));
            Stage registerStage = new Stage();
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToMazdaPageOnAction(ActionEvent event){
        mazdaPage();
    }

    public void mazdaPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/mazdaPage.fxml"));
            Stage registerStage = new Stage();
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToMersPageOnAction(ActionEvent event){
        mersPage();
    }

    public void mersPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/mersPage.fxml"));
            Stage registerStage = new Stage();
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToMitsubishiPageOnAction(ActionEvent event){
        mitsubishiPage();
    }

    public void mitsubishiPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/mitsubishiPage.fxml"));
            Stage registerStage = new Stage();
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToOpelPageOnAction(ActionEvent event){
        opelPage();
    }

    public void opelPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/opelPage.fxml"));
            Stage registerStage = new Stage();
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }    public void goToPeugeotPageOnAction(ActionEvent event){
        peugeotPage();
    }

    public void peugeotPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/peugeotPage.fxml"));
            Stage registerStage = new Stage();
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToSubaruPageOnAction(ActionEvent event){
        subaruPage();
    }

    public void subaruPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/subaruPage.fxml"));
            Stage registerStage = new Stage();
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToVolkswagenPageOnAction(ActionEvent event){
        volkswagenPage();
    }

    public void volkswagenPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/volkswagenPage.fxml"));
            Stage registerStage = new Stage();
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToToyotaPageOnAction(ActionEvent event){
        toyotaPage();
    }

    public void toyotaPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/sample/toyotaPage.fxml"));
            Stage registerStage = new Stage();
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 773, 397));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    @FXML
    public void getAddView(MouseEvent event){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/feedbackPage.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void getAddLaptopView(MouseEvent event){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/addInfoPage.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File exitFile = new File("images/close_icon.png");
        Image exitImage = new Image(exitFile.toURI().toString());
        closeImageView.setImage(exitImage);
    }
}
