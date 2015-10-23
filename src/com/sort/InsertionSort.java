package com.sort;

class ArrayIns{
	private long[] elements;
	private int noOfElements;
	
	//constructor to intitialize the array
	public ArrayIns(int max) {
		super();
		elements=new long[max];
		noOfElements=0;			//no of elements is zero
	}//end of constructor
	//---------------------------------------
	
	//method for insert element into array
	
	public void insert(long value){
		elements[noOfElements]=value;
		noOfElements++;
		
	}//end of insert()
//--------------------------------------------------------
	//method for displaying the array elements
	public void display(){
		for(int j=0;j<noOfElements;j++){
			System.out.print(" "+elements[j]);
		}
		System.out.println("");		//for new line
	}//end of display()
//---------------------------------------------------------
	//method for InsertionSort
	public void insertionSort(){
		for(int i=1;i<noOfElements;i++){
			int j=i;long value=elements[i];
			while(j>0 && elements[j-1]>value ){
				swap(j, j-1);
				j--;
			}
			elements[j]=value;
		}
	}//end of InsertionSort()
//---------------------------------------------------------
	//method for swapping two element in array
	public void swap(int one,int two){
		long temp=elements[one];
		elements[one]=elements[two];
		elements[two]=temp;
	}//end of swap()
	
}//end of class ArrayIns
//-------------------------------------------------------------------------------

public class InsertionSort {
	public static void main(String[] args) {
		int maxSize=100;
		ArrayIns arr;
		arr=new ArrayIns(maxSize);
		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();		//display all elements
		
		arr.insertionSort();	//sort the elements 
		
		arr.display();		//display them again
	}//end of main()

}//end of InsertionSort
