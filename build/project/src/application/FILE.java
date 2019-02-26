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
	//��ȡ�������ݣ����浽�����ļ���
	public static void write(Stu2[] studs,String path) {
	        //����һ���ļ��������ļ���
	        File file = null;
	        //�����ļ�����ֽ���
	        FileOutputStream fos = null;
	        //������������
	        ObjectOutputStream oos = null;
	        try {
	            file = new File(path);
	            fos = new FileOutputStream(file);
	            oos = new ObjectOutputStream(fos);
	            oos.writeObject(studs);//������
	            oos.flush();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                //�ر���Դ
	                fos.close();
	                oos.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

		//���ļ��аѶ������ݶ�ȡ������ӡ
		public static Stu2[] read(String path) {
		        File file = null;
		        Stu2[] studs=null;
		        FileInputStream fis = null;
		        ObjectInputStream ois = null;
		        try {
		            file = new File(path);
		            fis = new FileInputStream(file);
		            ois = new ObjectInputStream(fis);         
		            //�����л�һ�����
                    studs= (Stu2[])ois.readObject();//���ص�������		            
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
	     public static void clearFile(String path) {//����ļ�������ɣ�fileName����
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
