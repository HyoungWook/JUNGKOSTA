package jungkosta.commons.util;

import java.util.StringTokenizer;

public class Path {
	
	private static Path path = new Path();
	
	public static Path getInstance(){
		return path;
	}
	
	public String determine_url(String prev_URL) {

		StringTokenizer tok = new StringTokenizer(prev_URL, "/");
		String url = "";
		
		tok = new StringTokenizer(prev_URL, "/");

		for (int i = 0; i < 3; i++)
			tok.nextToken();
		if(!tok.hasMoreTokens()){
			url = "/";
		}
		while (tok.hasMoreTokens()) {
			url += "/" + tok.nextToken();
		}
		
		return url;
	}
}
