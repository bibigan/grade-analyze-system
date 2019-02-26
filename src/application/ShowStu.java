package application;

import java.io.IOException;
import java.util.Arrays;

import controller.AmountController;
import controller.RingController;
import controller.SystemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowStu {
	static Stage primaryStage=new Stage();
	   
    private ObservableList<Stu> StuData = FXCollections.observableArrayList();
    public static int sum=0;
    public void SetStu(Stu2[] stus2) {
    	if(stus2!=null) {
    	
    	sum=stus2.length;
    	//System.out.println("sum1:"+sum);
    	Stu[]  stus;
    	stus=Stus.creatStus(stus2.length);
    	for(int i=0;i<stus2.length;i++){//��Stu1���ݸ�Stu
    		stus[i].setNumberOfStu(stus2[i].getSchoolNumber());
    		stus[i].setNameOfStu(stus2[i].getName());
    		stus[i].setGradeOfStu(stus2[i].getGrade());
    	}
    	for(int i=0;i<stus.length;i++){
    		StuData.add(stus[i]);//�����ļ�
    	 }
    	}
    }

    public ObservableList<Stu> getStuData() {
        return StuData;
    }
    public void showHot() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();//fxml�ļ�������
            loader.setLocation(SystemController.class.getResource("/fxml/4.2Hot.fxml"));//����ָ����fxml�ļ�
            AnchorPane hotOverview = (AnchorPane) loader.load();//���ص�AnchorPane����
		    Stage stage2=new Stage();//����̨
            Scene scene=new Scene(hotOverview);//�ѽ�����ص�scene��
            stage2.setTitle("�ɼ�ͳ��");//����scene
            stage2.setScene(scene);//��scene���ص���̨
            AmountController controller=loader.getController();//����fxml�Ŀ�����
            controller.setNameData();//���Զ����ÿ�������initialize����
            stage2.showAndWait();//չʾ��̨
            //stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showRing() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();//fxml�ļ�������
            loader.setLocation(SystemController.class.getResource("/fxml/Ring.fxml"));//����ָ����fxml�ļ�
            AnchorPane hotOverview = (AnchorPane) loader.load();//���ص�AnchorPane����
		    Stage stage2=new Stage();//����̨
            Scene scene=new Scene(hotOverview);//�ѽ�����ص�scene��
            stage2.setTitle("�ɼ�ͳ��");//����scene
            stage2.setScene(scene);//��scene���ص���̨
            RingController controller=loader.getController();//����fxml�Ŀ�����
            //controller.setNameData();���Զ����ÿ�������initialize����
            //controller.initialize();
            stage2.showAndWait();//չʾ��̨
            //stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}

