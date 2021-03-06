package application;
//Food
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class FILE {
	//读取对象数据，保存到本地文件中
	public static void write(Stu2[] studs,String path) {
	        //声明一个文件（创建文件）
	        File file = null;
	        //声明文件输出字节流
	        FileOutputStream fos = null;
	        //声明对象处理流
	        ObjectOutputStream oos = null;
	        try {
	            file = new File(path);
	            fos = new FileOutputStream(file);
	            oos = new ObjectOutputStream(fos);
	            oos.writeObject(studs);//数组名
	            oos.flush();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                //关闭资源
	                fos.close();
	                oos.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

		//从文件中把对象数据读取出来打印
		public static Stu2[] read(String path) {
		        File file = null;
		        Stu2[] studs=null;
		        FileInputStream fis = null;
		        ObjectInputStream ois = null;
		        try {
		            file = new File(path);
		            fis = new FileInputStream(file);
		            ois = new ObjectInputStream(fis);         
		            //反序列化一组对象。
                    studs= (Stu2[])ois.readObject();//返回的数组名		            
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();		            
		        } 
		          catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		          finally {
		            try {
		                fis.close();
		                ois.close();
		               
		            } catch (IOException e) {
		                e.printStackTrace();
		                
		            }
		        }
		        Arrays.sort(studs);
		        return studs; 
		    }
	     public static void clearFile(String path) {//清空文件（已完成）fileName名字
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
