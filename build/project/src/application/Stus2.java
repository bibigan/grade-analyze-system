package application;


public class Stus2 {
	public static Stu2[] creatStus(int n) {//��������
		   Stu2[] stus=new Stu2[n];
		   int i;
		   for(i=0;i<stus.length;i++){
			   stus[i]=new Stu2();
		   }
		   return stus;
	   }
	public static void outPutStus(Stu2[] stus){
		for(int i=0;i<stus.length;i++){
     	System.out.println(stus[i]);
     }
	}
}
