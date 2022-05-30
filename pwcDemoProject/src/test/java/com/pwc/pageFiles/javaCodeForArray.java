package com.pwc.pageFiles;

import java.util.ArrayList;
import java.util.List;



public class javaCodeForArray {
	
	public static void  main (String[]args){
		
		int[] arr = {1,2,3,4,4,6,6};
		
		List<Integer> duplicateItemlist = new ArrayList<Integer>();
		
		
		for (int i = 0; i<arr.length-1; i++)
			for(int j = i+1; j<=arr.length-1; j++) {
				if(arr[i] == arr[j]) {
					duplicateItemlist.add(arr[j]);
				}
			}
		System.out.println("duplicateItemlist>>>>>"+duplicateItemlist);
	}

}
