package com.algo.stack.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Stack{
	private int maxSize;			//size of the stack array
	private char[] stackArray;
	private int top;				//element at top of the stack
	
	//constuctor----------------------------------
	Stack(int size){
		maxSize=size;
		stackArray=new char[size];
		top=-1;		
	}
	//end of constructor
//---------------------------------------------------------
	public void push(char pushItem){
		try {
			stackArray[++top]=pushItem;
		} catch (Exception e) {
			System.out.println("Stack is full you can't enter more element");
			top--;
		}
		
	}
	//end of push
//----------------------------------------------------------
	public char pop(){
		return stackArray[top--];	//pop the top element of the stack
	}
	//en of pop
//-----------------------------------------------------------
	public char peek(){
		return stackArray[top];		//giving the top element of the stack;
		
	}//end of the peek()
//------------------------------------------------------------
	public boolean isEmpty(){		//check if the stack is empty or not
		return (top==-1); 
	}//end of isEmpty()
//------------------------------------------------------------
	public boolean isFull(){		//check if the stack is full or not

		return (top==maxSize-1);
	}//end of is Full
	
	
}//end of class Stackx

class Reverser{
	private String input;
	private String output;
//constructor--------------------------------	
	public Reverser(String input) {
		this.input=input;
		
	}//end of constructor
//---------------------------------------------
	public String doRev(){
		int stackSize=input.length();		//get the max stack Size
		Stack stack=new Stack(stackSize);	//create the stack
		
		for (int i = 0; i < stackSize; i++) {
			char ch=input.charAt(i);
			stack.push(ch);
		}
		output="";
		while(!stack.isEmpty()){
			char ch=stack.pop();		//pop a char from sta
			output=output+ch;			//append the poped char to output string
		}//end of while
		return output;
		
	}//end of doRev

	
}//end of class Reverser

//--------------------------------------------------
public class ReverseApp {

	public static void main(String[] args) throws IOException {
		String input,output;
		while(true){
			System.out.println("Enter a String");
			System.out.flush();
			input=getString();
			if(input.equals(""))
				break;
			Reverser reverser=new Reverser(input);
			output=reverser.doRev();
			System.out.println("Reversed String is: "+output);
		}//end of while

	}//end of main()
	private static String getString() throws IOException{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		return s;
		
	}

}
