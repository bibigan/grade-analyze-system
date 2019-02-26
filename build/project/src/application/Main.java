package application;

import java.io.IOException;

import controller.SystemController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;

public class Main extends Application {
	public static Stage stage;//������̨
	@Override
	public void start(Stage primaryStage) {
        try {            
            Parent root=FXMLLoader.load(getClass().getResource("/fxml/System.fxml"));
            Scene scene=new Scene(root);            
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
            primaryStage.setResizable(false);//���ò��ܴ��ڸı�
            primaryStage.setTitle("�ɼ���������");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}