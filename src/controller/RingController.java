package controller;

import application.Analyze;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;


public class RingController {
	@FXML
	private PieChart chart;
	@FXML
	public void initialize() {
	    // TODO
	Analyze a=new Analyze(SystemController.s);
	ObservableList<PieChart.Data> pieChartData =
	            FXCollections.observableArrayList(
	            		new PieChart.Data("����Լ"+(int)(a.getExcellentRate()*100)+"%", a.getExcellentAmount()),
	    	            new PieChart.Data("����Լ"+(int)(a.getGoodRate()*100)+"%", a.getGoodAmount()),
	    	            new PieChart.Data("�е�Լ"+(int)(a.getNormalRate()*100)+"%", a.getNormalAmount()),
	    	            new PieChart.Data("����Լ"+(int)(a.getPassRate()*100)+"%", a.getPassAmount()),
	    	            new PieChart.Data("������Լ"+(int)(a.getNoPassRate()*100)+"%",a.getNoPassAmount()));
	chart.setData(pieChartData);
	}	 
}
