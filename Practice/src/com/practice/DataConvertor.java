package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DataConvertor {

	public static void main(String[] args) {
		String s1 = "saturday";
		String s2 = "sunday";
		List<String> strList =findReplacer(s1,s2);
		String temp ="";
		for(String s : strList) {
			s1 = s1.replaceFirst(s, "");
		}
		
		for(int i=0,j=0;i<s1.length();) {
			if(s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			}else {
				s1 = s1.substring(0, i).concat(s2.charAt(j)+s1.substring(i,s1.length()));
			}
			
		}
		
		
		
		System.out.println(s1+"  "+s2);

	}
	
	private static List<String> findReplacer(String s1,String s2) {
		List<String> strList = new ArrayList<>();
		String temp = "";
		for(int i=0,j=0;i<s1.length();i++) {
			/*if(temp != "" && s1.charAt(i) == s2.charAt(j)) {
				break;
			}*/
			if(s1.charAt(i) == s2.charAt(j)) {
			
				j++;
				if(temp != "") {
					strList.add(temp);
					temp = "";
				}
				
			}else {
				temp = temp+s1.charAt(i);
				char ch = s2.charAt(i);
				if(s1.indexOf(s2.charAt(j)) == -1) {
					j++;
				}
			
			}
			if(s2.length()<j && i<s1.length()) {
				s1 = s1.substring(0, i);
				break;
			}
			
		}
		return strList;
	}

}
