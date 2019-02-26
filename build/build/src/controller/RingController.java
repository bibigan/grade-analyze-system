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
	            		new PieChart.Data("优秀约"+(int)(a.getExcellentRate()*100)+"%", a.getExcellentAmount()),
	    	            new PieChart.Data("良好约"+(int)(a.getGoodRate()*100)+"%", a.getGoodAmount()),
	    	            new PieChart.Data("中等约"+(int)(a.getNormalRate()*100)+"%", a.getNormalAmount()),
	    	            new PieChart.Data("及格约"+(int)(a.getPassRate()*100)+"%", a.getPassAmount()),
	    	            new PieChart.Data("不及格约"+(int)(a.getNoPassRate()*100)+"%",a.getNoPassAmount()));
	chart.setData(pieChartData);
	}	 
}
