package com.array;

class Person{
	private String lastName;
	private String firstName;
	private int age;
	
	//contructor to initialize the Atrributes
	public Person(String lastName, String firstName, int age) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}
	
	//displaying the fields
	public void displayPerson(){
		System.out.println("Last Name: "+lastName);
		System.out.println("First Name: "+firstName);
		System.out.println("Age: "+age);
	}
	
	//retrive lastName
	public String getLastName(){
		return lastName;
	}
	
	
}//end of Person class
//--------------------------------------------

class ClassDataArray{
	private Person[] persons;		//Array of Persons
	private int noOfPersons;		//No of Persons
	

	public ClassDataArray(int max) {
		super();
		persons=new Person[max];
		noOfPersons=0;
	}
	
	//method for Searching a person
	public Person find(String searchName){
		int i;
		for (i = 0; i < noOfPersons; i++) {
			if(persons[i].getClass().equals(searchName)){
				break;
			}
			
		}
		if(i==noOfPersons){
			return null;
		}else{
			return persons[i];
		}
	}//end of find()
	//-------------------------------------------------------------
	
	//add another person
	public void insert(String lName,String fName,int age){
		persons[noOfPersons]=new Person(lName, fName, age);
		noOfPersons++;		//increment the size
	}//end of insertt()
	//----------------------------------------------------------------
	
	//delete a person from array
	public boolean delete(String searchName){
		int i;
		for(i=0;i<noOfPersons;i++){
			if(persons[i].getLastName().equals(searchName)){
				break;
			}
		}
		if(i==noOfPersons){
			return false;
		}else{
			for(int j=i;j<noOfPersons;j++){
				persons[j]=persons[j+1];
			}
			noOfPersons--;
			return true;
		}
	}//end of delete()
	//-------------------------------------------------------------------
	
	//method for display all persons
	public void displayAll(){
		for(int i=0;i<noOfPersons;i++){
			persons[i].displayPerson();
		}
	}//end of displayAll()
}//end of class ClassDataArray
//--------------------------------------------------------------------------------------------

public class ClassDataApp {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int maxSize = 100; // array size
		ClassDataArray arr; // reference to array
		arr = new ClassDataArray(maxSize); // create the array
		// insert 10 items
		arr.insert("Tarun", "Das", 24);
		arr.insert("Evans", "Patty", 24);
		arr.insert("Smith", "Lorraine", 37);
		arr.insert("Yee", "Tom", 43);
		arr.insert("Adams", "Henry", 63);
		arr.insert("Hashimoto", "Sato", 21);
		arr.insert("Stimson", "Henry", 29);
		arr.insert("Velasquez", "Jose", 72);
		arr.insert("Lamarque", "Henry", 54);
		arr.insert("Vang", "Minh", 22);
		arr.insert("Creswell", "Lucinda", 18);
		arr.displayAll(); // display items
		String searchKey="Stimson";// search for item
		Person found;
		found=arr.find(searchKey);
		if(found != null)
		{
		System.out.print("Found");
		found.displayPerson();
		}
		else
		System.out.println("Can’t find " + searchKey);
		System.out.println("Deleting Smith, Yee, and Creswell");
		arr.delete("Smith"); // delete 3 items
		arr.delete("Yee");
		arr.delete("Creswell");
		arr.displayAll(); // display items again

	}//end of main()

}//end of class ClassDataApp
