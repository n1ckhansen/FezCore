package com.blackfez.fezcore.utilities.IO;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ObjectSerializerIO {

	public static Object LoadObject( String filename ) throws IOException, ClassNotFoundException {
		File f = new File( filename );
		return LoadObject( f );
	}
	
	public static Object LoadObject( File file ) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream( file );
		XMLDecoder decoder = new XMLDecoder( fis );
		Object o = decoder.readObject();
		decoder.close();
		fis.close();
		return o;
	}
	
	public static void WriteObject( String filename, Object obj ) throws IOException {
		File f = new File( filename );
		WriteObject( f, obj);
	}
	
	public static void WriteObject( File file, Object obj ) throws IOException {
		FileOutputStream fos = new FileOutputStream( file );
		XMLEncoder encoder = new XMLEncoder( fos );
		encoder.writeObject( obj );
		encoder.close();
		fos.close();
	}
	
}
