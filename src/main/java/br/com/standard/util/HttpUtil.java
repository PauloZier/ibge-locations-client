package br.com.standard.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpUtil {
	
	private HttpUtil() {
		
	}
	
	public static String get(String url) throws IOException {
		
		URL get = new URL(url);
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(get.openStream()));
		
		String result = "";
		
		String line = "";
		
		while ((line = reader.readLine()) != null)
			result += line + "\n";
		
		reader.close();
		
		return result;
	}
}
