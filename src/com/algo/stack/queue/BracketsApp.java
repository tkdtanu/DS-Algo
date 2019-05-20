package com.algo.stack.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackY{
	private int maxSize;			//size of the stack array
	private char[] stackArray;
	private int top;				//element at top of the stack
	
	//constuctor----------------------------------
	StackY(int size){
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
	
	
}//end of class StackY
///////////////////////////////////////////////////////////////////////////////////////////
class BracketChecker{
	private String input;			//input String;
	//constructor------------------
	BracketChecker(String input){
		this.input=input;
	}
	public void check(){
		int stackSize=input.length();	//getting the size of stack;
		StackY stack=new StackY(stackSize);//create the stack
		boolean checkTrue=true;
		for(int i=0;i<stackSize;i++){		//retrive each character
			char ch=input.charAt(i);		//getting specified character
			switch (ch) {
			case '(':
			case '{':
			case '[':
				stack.push(ch);				//push the character into stack
				break;
			case ')':
			case '}':
			case ']':
				if(!stack.isEmpty()){		//check if the satck is empty or not
					char chx=stack.pop();	//pop the top element of stack and check
					if((ch==')' && chx!='(')||
						(ch=='}' && chx!='{')||
						(ch==']' && chx!='[')){
						System.out.println("Error "+ch+"at "+i);
						checkTrue=false;
					}
					
				}
				else{
					System.out.println("Error "+ch+"at "+i);
					checkTrue=false;
				}
				break;

			default:		//no action on other character
				break;
			}//end of switch
		}//end of fro loop
		//here all the characters have been processed
		if(!stack.isEmpty()){
			System.out.println("Error: missing right delimiter");
			checkTrue=false;
		}
		if(checkTrue==true){
			System.out.println("Given String contain correct order of delimiter");
		}
	}//end check
}//end of class BracketChecker
///////////////////////////////////////////////////////////////////////
public class BracketsApp {

	public static void main(String[] args) throws IOException {
		String input;
		while(true){
			System.out.println("Enter a String  containing delimeter");
			System.out.flush();
			input=getString();
			if(input.equals(""))
				break;
			BracketChecker bcr=new BracketChecker(input);
			bcr.check();
		}//end of while

	}//end of main()
	private static String getString() throws IOException{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		return s;
		
	}//end of getString()

}//end of BracketApp
