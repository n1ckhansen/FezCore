package com.blackfez.fezcore.utilities.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLUtils {
	
	public static String GetUrlResult( URL url ) throws IOException {
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader( is );
		BufferedReader br = new BufferedReader( isr );
		StringBuilder sb = new StringBuilder();
		String line;
		while( ( line = br.readLine() ) != null ) {
			sb.append( line );
		}
		return sb.toString();
	}

}
