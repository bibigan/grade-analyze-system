package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ZiFuFILE {
	 int rows=0;//行数
	 
     int countRows(String path) throws IOException {
       File file = new File(path);
       BufferedReader input = new BufferedReader(new FileReader(file));
       while (input.readLine() != null) {
           rows++;
       }
       input.close();
       return rows;
   }
     public Stu2[] read(String path) throws IOException{
    	 File file = new File(path);
    	// Stu2[] s=new Stu2[countRows(path)];
    	 Stu2[] s=Stus2.creatStus(countRows(path));
    	 FileReader fr = new FileReader(file);
    	 BufferedReader bufr = null;
    	 bufr=new BufferedReader(fr);
    	 String s1;
         for(int i = 0;i<s.length;i++){
        	 //每次读取一行         	 
        	 s1=bufr.readLine();
        	 String regex = ",";       	 
        	 String[] s2 = s1.split(regex);
        	 //System.out.println("s2:"+s2[0]+","+s2[1]+","+s2[2]);
        	 s[i].setSchoolNumber(s2[0]);//每行的学号
        	 s[i].setName(s2[1]);//每行的姓名
     	     s[i].setGrade(Double.parseDouble(s2[2]));//每行的成绩
         }
         bufr.close();
         fr.close();
         Arrays.sort(s);
    	 return s;
     }
     public void write(Stu2[] s,String path) throws IOException{
    	 File file = new File(path);
    	 FileWriter fw=new FileWriter(file);
    	 BufferedWriter bufw=new BufferedWriter(fw);
    	 for(int i=0;i<s.length;i++){
    		 bufw.write(s[i].getSchoolNumber()+","+s[i].getName()+","+s[i].getGrade());
        	 bufw.newLine();//换行，代替\r\n或\n，各种操作系统通用
        	 bufw.flush();
    	 }
    	 bufw.close();
    	 fw.close();
     }
     public void clearFile(String path) {//清空文件（已完成）fileName名字
 		File file =new File(path);
         try {
             if(!file.exists()) {
                 file.createNewFile();
             }
             FileWriter fileWriter =new FileWriter(file);
             fileWriter.write("");
             fileWriter.flush();
             fileWriter.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
 	}
}
