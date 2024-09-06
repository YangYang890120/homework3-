package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Employee;

public class cal {
	//存檔
	public static void SaveObject(Object o,String fileName)
	{
		try {
			FileOutputStream fos=new FileOutputStream(fileName);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//讀取
	public static Object ReadObiect(String fileName)
	{
		Object o=null;
		try {
			FileInputStream fis=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}
	
}
