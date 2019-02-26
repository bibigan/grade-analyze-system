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
    	for(int i=0;i<stus2.length;i++){//将Stu1传递给Stu
    		stus[i].setNumberOfStu(stus2[i].getSchoolNumber());
    		stus[i].setNameOfStu(stus2[i].getName());
    		stus[i].setGradeOfStu(stus2[i].getGrade());
    	}
    	for(int i=0;i<stus.length;i++){
    		StuData.add(stus[i]);//所有文件
    	 }
    	}
    }

    public ObservableList<Stu> getStuData() {
        return StuData;
    }
    public void showHot() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();//fxml文件加载器
            loader.setLocation(SystemController.class.getResource("/fxml/4.2Hot.fxml"));//加载指定的fxml文件
            AnchorPane hotOverview = (AnchorPane) loader.load();//加载到AnchorPane界面
		    Stage stage2=new Stage();//新舞台
            Scene scene=new Scene(hotOverview);//把界面加载到scene里
            stage2.setTitle("成绩统计");//设置scene
            stage2.setScene(scene);//把scene加载到舞台
            AmountController controller=loader.getController();//调用fxml的控制器
            controller.setNameData();//先自动调用控制器的initialize方法
            stage2.showAndWait();//展示舞台
            //stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showRing() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();//fxml文件加载器
            loader.setLocation(SystemController.class.getResource("/fxml/Ring.fxml"));//加载指定的fxml文件
            AnchorPane hotOverview = (AnchorPane) loader.load();//加载到AnchorPane界面
		    Stage stage2=new Stage();//新舞台
            Scene scene=new Scene(hotOverview);//把界面加载到scene里
            stage2.setTitle("成绩统计");//设置scene
            stage2.setScene(scene);//把scene加载到舞台
            RingController controller=loader.getController();//调用fxml的控制器
            //controller.setNameData();先自动调用控制器的initialize方法
            //controller.initialize();
            stage2.showAndWait();//展示舞台
            //stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}

