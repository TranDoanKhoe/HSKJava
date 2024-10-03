package tuan04_Sach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class fileDocVaGhi {
	private static final String tenFile = "data/DuLieu.txt";
	public static void writeToFile(Sach_Collection listSach, String file) throws Exception {
		ObjectOutputStream out = null;
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(listSach);
			out.close();
	}
	
	public Object readFromFile(String file) throws Exception {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
		Object list = input.readObject();
		input.close();
		return list;
	}
}
