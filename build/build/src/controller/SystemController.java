package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.io.IOException;
import application.Analyze;
import application.FILE;
import application.ShowStu;
import application.Stu;
import application.Stu2;
import application.Stus2;
import application.Warning_Pane;
import application.ZiFuFILE;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class SystemController {
	public static int sum=0;
	public static String link;
	@FXML
	private TableView<Stu> stus;
	@FXML
	private TableColumn<Stu,String> schoolNumber;
	@FXML
	private TableColumn<Stu,String> name;
	@FXML
	private TableColumn<Stu,Number> grade;
	@FXML
	private TextField max;
	@FXML
	private TextField average;
	@FXML
	private TextField orpay00;
	@FXML
	private TextField min;
	@FXML
	private TextField orpay10;
	@FXML
	private TextField orpay01;
	@FXML
	private TextField orpay11;
	@FXML
	private TextField orpay21;
	@FXML
	private TextField orpay20;
	@FXML
	private TextField orpay31;
	@FXML
	private TextField orpay30;
	@FXML
	private TextField orpay41;
	@FXML
	private TextField orpay40;
	@FXML
	private Button rf;
	@FXML
	private Button showZhu;
	@FXML
	private Button showBing;
	@FXML
	private TextField in;
	@FXML
	private MenuItem inputFile;
	@FXML
	private MenuItem openWFile;
	@FXML
	private MenuItem saveWFile;
	@FXML
	private MenuItem openDFile;
	@FXML
	private MenuItem saveDFile;
	@FXML
	private MenuItem cleanOut;
	@FXML
	private Text condition;
	private ShowStu test;
	public static Stu2[] s;
	public SystemController(){
		
	}
    @FXML
    private void initialize() {
    	//��ʼ��
        schoolNumber.setCellValueFactory(cellData -> cellData.getValue().numberOfStuProperty());
        name.setCellValueFactory(cellData->cellData.getValue().nameOfStuProperty());
        grade.setCellValueFactory(cellData->cellData.getValue().gradeOfStuProperty());     
        //showStuDetails(null);
        // Listen for selection changes and show the Table details when changed.
        /*stus.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showStuDetails(newValue));*/
    }

    public void setTest1(ShowStu test) {
       this.test = test;
       stus.setItems(test.getStuData());//��ȡfoods
   	   sum=ShowStu.sum;
   	   //System.out.println("sum2:"+sum);
    }   
    public void getNowPath(){
    	Stage primaryStage=new Stage();
        FileChooser fileChooser = new FileChooser();     
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("SCORE","*.score")
            );       
        File file = fileChooser.showOpenDialog(primaryStage);
        link=file.getAbsolutePath();//link��ѡ����ļ���·��    	
    }
    public void inputFile1() throws IOException{
    	
    }
    public void setWOnAction1() throws IOException{//���ı��ļ�
    	ZiFuFILE ziFile=new ZiFuFILE();
    	//���ļ�
    	Stage primaryStage=new Stage();
        FileChooser fileChooser = new FileChooser();     
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt")
            );       
        File file = fileChooser.showOpenDialog(primaryStage);
        link=file.getAbsolutePath();//link��ѡ����ļ���·��
        try{
        	 s=ziFile.read(link);
        	Warning_Pane.err1();
    	}
    	catch(ArrayIndexOutOfBoundsException ex){
    		Warning_Pane.err2();
    	}
        
        //����ɼ�
        ShowStu showStu=new ShowStu();
        showStu.SetStu(s);
        setTest1(showStu);
        //״̬��
        condition.setText(link+" ��"+sum+"�ˡ�");
        //�ɼ�����
        Analyze ana=new Analyze(s);
        //max.setText(ana.getMaxGrade()+"");
        max.setText(String.format("%.2f", ana.getMaxGrade()));
        min.setText(String.format("%.2f", ana.getMinGrade()));
        average.setText(String.format("%.2f", ana.getAverageGrade()));
        orpay00.setText(ana.getExcellentAmount()+"");
        orpay01.setText(String.format("%.2f", ana.getExcellentRate()*100));
        orpay10.setText(ana.getGoodAmount()+"");
        orpay11.setText(String.format("%.2f", ana.getGoodRate()*100));
        orpay20.setText(ana.getNormalAmount()+"");
        orpay21.setText(String.format("%.2f", ana.getNormalRate()*100));
        orpay30.setText(ana.getPassAmount()+"");
        orpay31.setText(String.format("%.2f", ana.getPassRate()*100));
        orpay40.setText(ana.getNoPassAmount()+"");
        orpay41.setText(String.format("%.2f", ana.getNoPassRate()*100));  
    }
    @FXML
    private void saveWOnAction1() throws IOException{//����Ϊ�ı��ļ�
    	reFresh();//ˢ��
    	if(link.contains(".score")){//������ַ�
    		//�Ӷ�����ı��������read,��������ַ���write
    		Stu2[] s=FILE.read(link);
    		ZiFuFILE ziFile=new ZiFuFILE();
    		String l;
    		l=link.replace(".score", ".txt");
    		ziFile.write(s,l);
    	}
    	else{
            	ZiFuFILE ziFile=new ZiFuFILE();
            	ziFile.write(s, link);
            }
    }
    @FXML
    public void setDOnAction1() throws ArrayIndexOutOfBoundsException {//�򿪶����ļ�
    	
    	//���ļ�
    	Stage primaryStage=new Stage();
        FileChooser fileChooser = new FileChooser();     
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("SCORE","*.score")
            );       
        File file = fileChooser.showOpenDialog(primaryStage);
        link=file.getAbsolutePath();//link��ѡ����ļ���·��
        try{
        	s=FILE.read(link);
        	Warning_Pane.err1();
    	}
    	catch(ArrayIndexOutOfBoundsException ex){
    		Warning_Pane.err2();
    	}
                
    	//����ɼ�
               ShowStu showStu=new ShowStu();
               showStu.SetStu(s);
               setTest1(showStu);
               //״̬��
               condition.setText(link+" ��"+sum+"�ˡ�");
               //�ɼ�����
               Analyze ana=new Analyze(s);
               max.setText(String.format("%.2f", ana.getMaxGrade()));
               min.setText(String.format("%.2f", ana.getMinGrade()));
               average.setText(String.format("%.2f", ana.getAverageGrade()));
               orpay00.setText(ana.getExcellentAmount()+"");
               orpay01.setText(String.format("%.2f", ana.getExcellentRate()*100));
               orpay10.setText(ana.getGoodAmount()+"");
               orpay11.setText(String.format("%.2f", ana.getGoodRate()*100));
               orpay20.setText(ana.getNormalAmount()+"");
               orpay21.setText(String.format("%.2f", ana.getNormalRate()*100));
               orpay30.setText(ana.getPassAmount()+"");
               orpay31.setText(String.format("%.2f", ana.getPassRate()*100));
               orpay40.setText(ana.getNoPassAmount()+"");
               orpay41.setText(String.format("%.2f", ana.getNoPassRate()*100));               
    }
    @FXML
    private void saveDOnAction1() throws IOException{//����Ϊ�����ļ�
    	reFresh();//ˢ��
    	if(link.contains(".txt")){//���ַ��ļ�ת����
    		//���ַ��ļ�ת�������ַ���read������stu���������write(stu)
    		ZiFuFILE ziFile=new ZiFuFILE();
    		Stu2[] s=ziFile.read(link);
    		String l;
    		l=link.replace(".txt", ".score");
    		FILE.write(s, l);
        }
    	else{//���󱣴����
    		FILE.write(s, link);
            }
    }
    public void clean() throws IOException{//�������
		if(s==null){
			Warning_Pane.err();
		}
		else {
        Stu2[] s=null;
        ShowStu showStu=new ShowStu();
        showStu.SetStu(s);
        setTest1(showStu);  
        max.setText("");
        min.setText("");
        average.setText("");
        orpay00.setText("");
        orpay01.setText("");
        orpay10.setText("");
        orpay11.setText("");
        orpay20.setText("");
        orpay21.setText("");
        orpay30.setText("");
        orpay31.setText("");
        orpay40.setText("");
        orpay41.setText("");
		}
  }
    public void cleanOut() throws IOException{
        Stu2[] s=null;
        ShowStu showStu=new ShowStu();
        showStu.SetStu(s);
        setTest1(showStu); 
    }
    public void reFresh(){
		if(s==null){
			Warning_Pane.err();
		}
		else {
    	//ˢ��
        ShowStu showStu=new ShowStu();
        showStu.SetStu(s);
        setTest1(showStu);
        //�ɼ�����
        Analyze ana=new Analyze(s);
        max.setText(String.format("%.2f", ana.getMaxGrade()));
        min.setText(String.format("%.2f", ana.getMinGrade()));
        average.setText(String.format("%.2f", ana.getAverageGrade()));
        orpay00.setText(ana.getExcellentAmount()+"");
        orpay01.setText(String.format("%.2f", ana.getExcellentRate()*100));
        orpay10.setText(ana.getGoodAmount()+"");
        orpay11.setText(String.format("%.2f", ana.getGoodRate()*100));
        orpay20.setText(ana.getNormalAmount()+"");
        orpay21.setText(String.format("%.2f", ana.getNormalRate()*100));
        orpay30.setText(ana.getPassAmount()+"");
        orpay31.setText(String.format("%.2f", ana.getPassRate()*100));
        orpay40.setText(ana.getNoPassAmount()+"");
        orpay41.setText(String.format("%.2f", ana.getNoPassRate()*100));   
		}
    }
    @FXML
    public void onEnter(ActionEvent ae) throws IOException{//����
		if(s==null){
			Warning_Pane.err();
		}
		else {
    	//ˢ��
        ShowStu showStu=new ShowStu();
        showStu.SetStu(s);
        setTest1(showStu);
    	
    	String key=in.getText();    	
    	Stu stu=new Stu();
    	int i;
    	int m=0;//���ϵĸ���
    	for(i=sum-1;i>=0;i--){
    		stu=stus.getItems().get(i);
    		if(stu.getNameOfStu().contains(key)){ m++;}
    		else if(stu.getNumberOfStu().contains(key)) {m++;}
    	}System.out.println("m:"+m);
    	int j=0;
    	Stu2[] st;
    	st=Stus2.creatStus(m);
    	
    	for(i=sum-1;i>=0&&m>=0;i--){
    		stu=stus.getItems().get(i);
    		if(stu.getNameOfStu().contains(key)){
    			System.out.println("stu:"+stu);
    			m=m-1;
    			st[m].setSchoolNumber(stu.getNumberOfStu());
    			st[m].setName(stu.getNameOfStu());
    			st[m].setGrade(stu.getGradeOfStu());
    		}
    		else if(stu.getNumberOfStu().contains(key)) {
    			System.out.println("stu:"+stu);
    			m=m-1;
    			st[m].setSchoolNumber(stu.getNumberOfStu());
    			st[m].setName(stu.getNameOfStu());
    			st[m].setGrade(stu.getGradeOfStu());
    		}
    	}
    	//���
    	cleanOut();
               //����ɼ�
               ShowStu showStu1=new ShowStu();
               showStu1.SetStu(st);
               setTest1(showStu1);
		}       
    }
	public void hot() {
		if(s!=null){
			test.showHot();
		}
		else Warning_Pane.err();
    }
	public void Ring() {
		if(s!=null){
			test.showRing();
		}
		else Warning_Pane.err();
    }
}