package com.algo;

import java.util.Arrays;

public class LeastDifference {

	public static void main(String[] args) {
		int arr[]={23,45,10,2,4,6,56,100,47,89,93};
		System.out.println("Least Difference in the array is:");
		if(arr.length==1){
			System.out.println("Not possible");
		}else{
			Arrays.sort(arr);
			int mindifference=arr[1]-arr[0];
			for(int i=1;i<arr.length-1;i++){
				if(arr[i+1]-arr[i]<mindifference){
					mindifference=arr[i+1]-arr[i];
				}
			}
			System.out.println(mindifference);
		}
		

	}

}
