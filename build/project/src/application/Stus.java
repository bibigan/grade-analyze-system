package application;


public class Stus {
	public static Stu[] creatStus(int n) {//创建数组
		   Stu[] stus=new Stu[n];
		   int i;
		   for(i=0;i<stus.length;i++){
			   stus[i]=new Stu();
		   }
		   return stus;
	   }
	public static void outPutStus(Stu[] stus){
		for(int i=0;i<stus.length;i++){
     	System.out.println(stus[i]);
     }
	}
}
