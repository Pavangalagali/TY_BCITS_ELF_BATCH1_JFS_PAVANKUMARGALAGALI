package com.javawork.second;

import java.util.Scanner;

public class WordReverse {
  
    public static String wordReverse(String line) {
    	
    	String newLine= "";
    	char[] ch = line.toCharArray();
    	
    	for (int i = 0; i < ch.length; i++) {
    		
    		int initial = i;
    		int last=i;
    		String newL = "";
    		while((i < ch.length) && (ch[i] != ' ')) {
    			 
    			newL = newL + ch[i];
    			i++;
    			
    			}   	
    	     newLine = newLine + ReverseString.revereString(newL) + " ";
    		}	
    	return newLine;
		}
    
	public static void main(String[] args) {
        
		String line ;
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("enter the line");
		line = sc1.nextLine();
		
		String newLine = wordReverse(line);
		
		System.out.println(newLine);


	}

}
