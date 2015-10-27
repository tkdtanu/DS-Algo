package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextLargerNumber {
	private static List<Integer> digits=new ArrayList<Integer>();
	private static int firstSmallDigitPosFromRight=0;
	private static int secondSmallDigitPosFromRight=0;

	public static void main(String[] args) throws IOException {
		long number=getNum();			//get the number from user input
		
		if(number!=-1){					
		System.out.println("Next larger number is: ");
		findNextLarger(number);
		}

	}
//-------------------------------------------------------------------------------------
	private static long getNum() throws IOException {		//receive the input from console
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String input=br.readLine();
		try {
			long number=Long.parseLong(input);				//check whether the input is a valid number or not
			return number;
		} catch (Exception e) {  //
			System.out.println("Not a valid number");
			
		}
		
		return -1;
	}
//---------------------------------------------------------------------------------------------------

	private static void findNextLarger(long number) {
		if(!checkIfAllDigitUnique(number))			//if all digits are not unique it can't be possible
			return;
		if(number+"".length()==1 || isInDecreasingOrder(number)){		//if the number is of one digit or all the digits are in decreasing order then next higer number can't possible
			System.out.println("no large number possible");
			System.out.println(number+" is largest");
			return;
		}
		else{
			int x=digits.get(firstSmallDigitPosFromRight),smallest=digits.get(secondSmallDigitPosFromRight);
			int j;
			for(j=secondSmallDigitPosFromRight+1;j<digits.size();j++){
				if(digits.get(j)>x && digits.get(j)<smallest){
					smallest=digits.get(j);
					secondSmallDigitPosFromRight=j;
				}
				
			}
			//swap the above two number
			swap(firstSmallDigitPosFromRight,secondSmallDigitPosFromRight);
			sort(firstSmallDigitPosFromRight,digits.size()-1);
			
			for (Integer num : digits) {
				System.out.print(num);
				
			}
		}
		
	}
	
//------------------------------------------------------------------------------
private static void swap(int i,int j) {
		Integer temp=digits.get(i);
		digits.set(i, digits.get(j));
		digits.set(j, temp);
		
	}
//------------------------------------------------------------------------------
private static void sort(int startIndex, int endIndex) {
	if (startIndex == endIndex)
		return;
	for(int k=startIndex+1;k<=endIndex;++k)
		for (int l = k + 1; l <= endIndex; ++l)
			if (digits.get(k) > digits.get(l))
				swap(k, l);

}
	//--------------------------------------------------------------------------------------------------
	private static boolean checkIfAllDigitUnique(long number) {
		for(int i=0;i<((number+"").length());i++){  
			int temp=Integer.parseInt((number+"").charAt(i)+"");
			if(digits.contains(temp)){		//check if all digits are unique or not
				System.out.println("All digits are not unique");
				return false;
			}else{
				digits.add(temp);
				
			}
			
		}
		return true;		//at this position all numbers will be processed and all are unique
		
	}
//-----------------------------------------------------------------------

	private static boolean isInDecreasingOrder(long number) {
		int count=0;int i=0;
		for(i=digits.size()-1;i>0;i--){
			if(digits.get(i)<digits.get(i-1))
				count++;
			else break;
		}
		firstSmallDigitPosFromRight=i-1;
		secondSmallDigitPosFromRight=i;
		return (count==digits.size()-1);
	}

	

}
