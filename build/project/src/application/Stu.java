package application;
import java.io.Serializable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Stu implements Serializable {
	
    private final StringProperty nameOfStu;
    private final StringProperty numberOfStu;
    private final DoubleProperty gradeOfStu;

    public Stu() {
        this(null);
    }

    public Stu(String nameOfStu) {
        this.nameOfStu = new SimpleStringProperty(nameOfStu);
        this.numberOfStu = new SimpleStringProperty("0");
        this.gradeOfStu=new SimpleDoubleProperty(0);
    }

    
    public String getNameOfStu() {
        return nameOfStu.get();
    }

    public void setNameOfStu(String StuName) {
        this.nameOfStu.set(StuName);
    }

    public StringProperty nameOfStuProperty() {
        return nameOfStu;
    }

    public String getNumberOfStu() {
        return numberOfStu.get();
    }

    public void setNumberOfStu(String numberOfStu) {
        this.numberOfStu.set(numberOfStu);
    }

    public StringProperty numberOfStuProperty() {
        return numberOfStu;
    }

    public double getGradeOfStu() {
        return gradeOfStu.get();
    }

    public void setGradeOfStu(double gradeOfStu) {
        this.gradeOfStu.set(gradeOfStu);
    }

    public DoubleProperty gradeOfStuProperty() {
        return gradeOfStu;
    }
	@Override
    public String toString() {
        return "Stu{ , nameOfStu=" + nameOfStu +
                ", numberOfStu='" + numberOfStu + '\'' +
                ", gradeOfStu='" + gradeOfStu + '\'' +
                ", introduceOfStu= '}'";
    }

}
