package application;

public class dOfStus {
	public static dOfStu[] creat(int n) {//��������
		dOfStu[] foods=new dOfStu[n];
		   int i;
		   for(i=0;i<foods.length;i++){
			   foods[i]=new dOfStu();
		   }
		   return foods;
	   }
	public static void outPut(dOfStu[] foods){
		for(int i=0;i<foods.length;i++){
        	System.out.println(foods[i]);
        }
	}
}
