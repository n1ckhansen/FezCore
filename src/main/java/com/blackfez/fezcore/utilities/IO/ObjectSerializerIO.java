package com.blackfez.fezcore.utilities.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializerIO {

	public static Object LoadObject( String filename ) throws IOException, ClassNotFoundException {
		File f = new File( filename );
		FileInputStream fis = new FileInputStream( f );
		ObjectInputStream ois = new ObjectInputStream( fis );
		Object o = ois.readObject();
		ois.close();
		fis.close();
		return o;
	}
	
	public static void WriteObject( String filename, Object obj ) throws IOException {
		File f = new File( filename );
		FileOutputStream fos = new FileOutputStream( f );
		ObjectOutputStream oos = new ObjectOutputStream( fos );
		oos.writeObject( obj );
		oos.close();
		fos.close();
	}
	
}
