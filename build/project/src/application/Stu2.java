package application;
import java.io.Serializable;

public class Stu2 implements Serializable,Comparable<Stu2> {
    private String schoolNumber;
    private String name;
    private double grade;
    
    public String getSchoolNumber(){
    	return schoolNumber;
    }
    public double getGrade(){
    	return grade;
    }
    public String getName(){
    	return name;
    }
    public void setSchoolNumber(String schoolNumber){
    	this.schoolNumber=schoolNumber;
    }
    public void setGrade(double grade){
    	this.grade=grade;
    }
    public void setName(String name){
    	this.name=name;
    }
    @Override
    public String toString() {
        return "Table{" +"schoolNumber=" + schoolNumber +
                ", name=" + name +'\'' +
                ", grade='" + grade + '}';
    }
    @Override
    public int compareTo(Stu2 stu) {
        if(this.grade > stu.grade)  {
            return -1;
        } else if(this.grade < stu.grade) {
            return 1;
        } else {
            if(this.name.compareTo(stu.name)==1) {
                return 1;
            } else if(this.name.compareTo(stu.name)==-1) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
