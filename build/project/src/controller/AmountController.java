package controller;

import application.Analyze;
import application.FILE;
import application.Stu;
import application.Stu2;
import application.Stus;
import application.dOfStu;
import application.dOfStus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class AmountController {
	//private  static String  names1;
    private Stage dialogStage;
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    
    private ObservableList<String> namesOfFood=FXCollections.observableArrayList() ;
    
    @FXML
    private void initialize() {
    	String[] degreeOfStu={"优秀","良好","中等","及格","不及格"};
    	dOfStu[] dfs;
    	dfs=dOfStus.creat(degreeOfStu.length);
    	for(int i=0;i<degreeOfStu.length;i++){//将food1传递给food
    		dfs[i].setDegreeOfStu(degreeOfStu[i]);
    	}
    	for(int i=0;i<degreeOfStu.length;i++){
    		namesOfFood.add(dfs[i].getDegreeOfStu());
    	}
       xAxis.setCategories(namesOfFood);       
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
   
	public void setNameData() {
		Analyze a=new Analyze(SystemController.s);
		String[] degreeOfStu={"优秀","良好","中等","及格","不及格"};
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(degreeOfStu[0],a.getExcellentAmount()));
        series.getData().add(new XYChart.Data<>(degreeOfStu[1],a.getGoodAmount()));
        series.getData().add(new XYChart.Data<>(degreeOfStu[2],a.getNormalAmount()));
        series.getData().add(new XYChart.Data<>(degreeOfStu[3],a.getPassAmount()));
        series.getData().add(new XYChart.Data<>(degreeOfStu[4],a.getNoPassAmount()));	
        barChart.getData().add(series);
    }
}