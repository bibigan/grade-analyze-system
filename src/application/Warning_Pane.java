package application;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class Warning_Pane {
	public static void err() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("�ļ������ڣ�");
		warning.show();
	}
	public static void err1() {
		Alert warning = new Alert(Alert.AlertType.INFORMATION);
		warning.setContentText("�ļ��򿪳ɹ���");
		warning.show();
	}
	public static void err2() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("�ļ����ݸ�ʽ����ȷ��");
		warning.show();
	}
}
