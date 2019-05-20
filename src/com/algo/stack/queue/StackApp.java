package com.algo.stack.queue;

class StackX{
	private int maxSize;			//size of the stack array
	private long[] stackArray;
	private int top;				//element at top of the stack
	
	//constuctor----------------------------------
	StackX(int size){
		maxSize=size;
		stackArray=new long[size];
		top=-1;		
	}
	//end of constructor
//---------------------------------------------------------
	public void push(long pushItem){
		try {
			stackArray[++top]=pushItem;
		} catch (Exception e) {
			System.out.println("Stack is full you can't enter more element");
			top--;
		}
		
	}
	//end of push
//----------------------------------------------------------
	public long pop(){
		return stackArray[top--];	//pop the top element of the stack
	}
	//en of pop
//-----------------------------------------------------------
	public long peek(){
		return stackArray[top];		//giving the top element of the stack;
		
	}//end of the peek()
//------------------------------------------------------------
	public boolean isEmpty(){		//check if the stack is empty or not
		if(top==-1) return true;
		else return false;
	}//end of isEmpty()
//------------------------------------------------------------
	public boolean isFull(){		//check if the stack is full or not

		return (top==maxSize-1);
	}//end of is Full
	
	
}//end of class Stackx

public class StackApp {

	public static void main(String[] args) {
		
		StackX stack=new StackX(3);
		stack.push(20);
		stack.push(30);
		stack.push(240);
		stack.push(200);
		
		System.out.println("Stack is empty?"+stack.isEmpty());
		System.out.println("Top element of the satck is:"+stack.peek());
		System.out.println("Poping all element from Stack:");
		
		while(!stack.isEmpty()){
			long value=stack.pop();
			System.out.println(value+" ");
		}//end of while
		
		System.out.println("Stack is empty?"+stack.isEmpty());
		
		

	}

}
