package application;

public class Analyze {
	private double maxGrade;
	private double minGrade;
	private double averageGrade;
	
	private int excellentAmount;
	private double excellentRate;
	
	private int goodAmount;
	private double goodRate;
	
	private int normalAmount;
	private double normalRate;
	
	private int passAmount;
	private double passRate;
	
	private int noPassAmount;
	private double noPassRate;
    public Analyze(){
    	 
    }
    public Analyze(Stu2[] stus){
    	double max=0;
    	double min=1000;
    	double sum=0;
    	int a=0,b=0,c=0,d=0,e=0;
    	double aa=0,bb=0,cc=0,dd=0,ee=0;
    	for(int i=0;i<stus.length;i++){
    		if(stus[i].getGrade()>max) max=stus[i].getGrade();
    		if(stus[i].getGrade()<min) min=stus[i].getGrade();
    		if(stus[i].getGrade()>=90&&stus[i].getGrade()<=100) a++;
    		else if(stus[i].getGrade()>=80&&stus[i].getGrade()<=89) b++;
    		     else if(stus[i].getGrade()>=70&&stus[i].getGrade()<=79) c++;
    		     else if(stus[i].getGrade()>=60&&stus[i].getGrade()<=69) d++;
    		     else if(stus[i].getGrade()>=0&&stus[i].getGrade()<=59) e++;
    		sum+=stus[i].getGrade();
    	}
    	maxGrade=max;
    	minGrade=min;
    	averageGrade=sum/stus.length;
    	
    	excellentAmount=a;
    	goodAmount=b;
    	normalAmount=c;
    	passAmount=d;
    	noPassAmount=e;
    	
    	double s=stus.length;
		aa=a/s; excellentRate=aa;
		System.out.println("aa:"+aa);
		bb=b/s; goodRate=bb;
		cc=c/s; normalRate=cc;
		dd=d/s; passRate=dd;
		ee=e/s; noPassRate=ee;
    }
    public double getMaxGrade(){
    	return maxGrade;
    }
    public double getMinGrade(){
    	return minGrade;
    }
    public double getAverageGrade(){
    	return averageGrade;
    }
    
    public double getExcellentRate(){
    	return excellentRate;
    }
    public double getGoodRate(){
    	return goodRate;
    }
    public double getNormalRate(){
    	return normalRate;
    }
    public double getPassRate(){
    	return passRate;
    }
    public double getNoPassRate(){
    	return noPassRate;
    }
    
    public int getExcellentAmount(){
    	return excellentAmount;
    }
    public int getGoodAmount(){
    	return goodAmount;
    }
    public int getNormalAmount(){
    	return normalAmount;
    }
    public int getPassAmount(){
    	return passAmount;
    }
    public int getNoPassAmount(){
    	return noPassAmount;
    }
}
