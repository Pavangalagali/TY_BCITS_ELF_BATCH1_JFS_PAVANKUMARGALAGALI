package com.javawork.second;

import java.util.Scanner;

public class WordsWithCount {
 
	public static String wordCount(String line) {
		
		String newLine = "";
		char[] ch = line.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			
			String newL = "";
        while((i < ch.length) && (ch[i] != ' ')) {
        	
        	newL = newL + ch[i];
        	i++;
        }
        if(newL.length()>0) {
        	
        	newL = newL + newL.length();
        }
        
			newLine = newLine + newL + " ";
	    }
		
		return newLine;
		
	}
	public static void main(String[] args) {
		
		String line ;
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("enter the line");
		line = sc1.nextLine();
		
		String newLine = wordCount(line);
		
		System.out.println(newLine);
	}

}
