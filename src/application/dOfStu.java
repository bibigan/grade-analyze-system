package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class dOfStu {
	private final StringProperty degreeOfStu;
    public dOfStu() {
        this(null);
    }

    public dOfStu(String degreeOfStu) {
        this.degreeOfStu = new SimpleStringProperty(degreeOfStu);
    }
    public String getDegreeOfStu() {
        return degreeOfStu.get();
    }

    public void setDegreeOfStu(String StuName) {
        this.degreeOfStu.set(StuName);
    }

    public StringProperty nameOfStuProperty() {
        return degreeOfStu;
    }
}
