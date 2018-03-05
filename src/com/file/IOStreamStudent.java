package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOStreamStudent {
	public static File file = new File("stu.txt");

	public static void writeToFile() {
		FileOutputStream fo = null;
		ObjectOutputStream objout = null;
		try {
			fo = new FileOutputStream(file);
			objout = new ObjectOutputStream(fo);
			objout.writeObject(DB.arrStu);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objout.flush();
				objout.close(); 
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Write Student to File" + " " + file);
	}

	@SuppressWarnings({ "resource", "unchecked" })
	public static ArrayList<Student> readFromFile(){
		ArrayList<Student> arr = null;
		ObjectInputStream objin = null;
		FileInputStream fin = null;
		try{
			fin = new FileInputStream(file);
			objin = new ObjectInputStream(fin);
			arr = (ArrayList<Student>) objin.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return arr;
	}
	
}
