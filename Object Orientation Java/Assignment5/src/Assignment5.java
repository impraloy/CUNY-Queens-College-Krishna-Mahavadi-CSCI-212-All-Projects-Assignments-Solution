
import java.util.Scanner;
import java.time.LocalDate;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.ArrayList;

public class Assignment5 {
	public static void main(String [] args) throws SSNLengthException, SSNCharacterException{
		Scanner userInput = new Scanner(System.in);
		//making sure how many employee user wanna use
		System.out.print("How many Employee? ");
		int employee = userInput.nextInt();

		MainClass mainClass = new MainClass(employee);
		mainClass.EmployeeRecord();


//		try {
//			record();
//		}catch(Exception e) {
//			record();
//		}
		
//		try{
//				record();
//		}catch(SSNCharacterException e) {
//			System.out.println("Please don't use any character- Social Security number must be a number ");
//			record();
//		}catch(SSNLengthException e) {
//			System.out.println("Enter the Social Security number without any hyphenes and It can't be more or less than 9 digits");
//			record();
//		}
	}
		
}

class MainClass {

	int employee;
	Scanner input = new Scanner(System.in);

	public MainClass() { }

	public MainClass(int employee) {
		this.employee = employee;
	}

	public void EmployeeRecord() throws SSNLengthException, SSNCharacterException {
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		for (int i= 0; i<employee; i++){
			System.out.print("Enter a name: ");
			String name = input.next();
			
			
			String SSNumber = "";
			SSNumber = SocialSecurityNumberValidation();
			
			System.out.print("Enter the year: ");
			int year = Integer.parseInt(input.next());
			
			System.out.print("Enter the month: ");
			int month = Integer.parseInt(input.next());
			
			System.out.print("Enter the day: ");
			int day = Integer.parseInt(input.next());
			
			System.out.print("Enter the Salary: ");
			double salary = Double.parseDouble(input.next());
			
			System.out.print("Enter the position: ");
			String position = input.next();
			
			System.out.print("Enter the Address: ");
			String Address = input.next();
			
			Employee one = new Employee(name, SSNumber, year, month, day, salary, position, Address);
			
			list.add(one);
			System.out.println();
		}
		
		//calculating total salary
		double totalSalary = 0;

		for(int i = 0; i<list.size(); i++){
			//list.size()
			System.out.print(" " +list.get(i) );
			totalSalary+= list.get(i).getSalary();
		}

		//calculating average salary
		double aveSalary = totalSalary/list.size();
		System.out.println("The average salay is " + aveSalary );	
	}
	public String SocialSecurityNumberValidation() throws SSNLengthException, SSNCharacterException {
		try{
			System.out.print("Enter the Social Security Number: ");
			String SSNumber = input.next();
			EmployeeRecord newEmployee = new EmployeeRecord();
			SSNumber = newEmployee.isValidLength(SSNumber); // return social security number without "-"
			SSNumber = newEmployee.isValidDigits(SSNumber); // return social security number if all number are digits

			return SSNumber; // return social secirty number if all validation passed
		} 
		catch (Exception e){
			System.out.println(e.toString());
			System.out.println("\nPlease try again....");
			return SocialSecurityNumberValidation();
		}
	}
}

class Address{
	private String address;
	
	public Address(){
		address = null;
	}
	public Address(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
}

class Person extends Address{
	private String name;
	private String SSNumber;
	private LocalDate dateHired;
	
	public Person(){
		super();
		name = null;
		SSNumber = null;
		dateHired = null;
	}

	public Person (String name,String SSNumber, int year, int month, int day, String address){
		super(address);
		this.name = name;
		this.SSNumber= SSNumber;
		dateHired = LocalDate.of(year, month, day);
	}
	
	
	public String getName(){
	    return name;
	}
	public void setName(String name){
	    this.name = name;
	}
	public String getSSNumber(){
	    return SSNumber;
	}
	public LocalDate getDateHired(){
	    return dateHired;
	}	 
	public String toString(){
	    return ("Name: " + name  + "\nSocial Security Number: " + SSNumber + "\nDate Hired: " + dateHired);
	}	
}

class Employee extends Person{
	private double salary;
	private String position;
	
	public Employee(){
		super();
		salary = 0.0;
		position = null;
	}
	public Employee(String name, String SSNumber, int year, int month, int day,double salary, String position, String Address){
		super(name, SSNumber, year, month, day, Address);
		this.salary = salary; 
		this.position = position;
	}
	public double getSalary(){
	    return salary;
	} 
	public String getPosition(){
		return position;
	}
	public String toString(){
	    return ("Employee\n"+ "Name: " + getName()  + "\nSocial Security Number: " + getSSNumber() + "\nDate Hired: " + getDateHired() + "\nSalary: $" + salary + "\nPosition: " + position + "\nAddress: " + getAddress()+ "\n\n");
	}
}


class EmployeeRecord{
	// public static String isValidLength(String SSNumber)throws SSNLengthException {
	// 	String pattern = "^(?!000|666)[0-9]{3}([ -]?)(?!00)[0-9]{2}\\1(?!0000)[0-9]{4}$";

	//       // Create a Pattern object
	//       Pattern r = Pattern.compile(pattern);

	//       // Now create matcher object.
	//       Matcher m = r.matcher(SSNumber);
	//       if (m.find( )) {
	//          //return true;
	//       }//else {
	// 	   //      return false;
	//       //}
	      
	//       throw new SSNLengthException(); 
	// }

	public String isValidLength(String SSNumber) throws SSNLengthException {
		String modifiedSSN = "";

		for(int i = 0; i<SSNumber.length();i++){
			char c = SSNumber.charAt(i);
			if  (c != '-'){
				modifiedSSN += c;	
			}
			//else return "Not a SSN";
		}

		if(modifiedSSN.length() == 9)
			return modifiedSSN;

		throw new SSNLengthException();
		//System.out.print("Social Security number can't be more or less than 9 digits ");
	}
	
	public String isValidDigits(String SSNumber) throws SSNCharacterException{
		// if(SSNumber == null ||SSNumber.trim().isEmpty()) 
		// {
		// 	throw new SSNCharacterException();
	    //     return false;
		// }

		   
		for (int i = 0; i < SSNumber.length(); i++){
			if(!Character.isDigit(SSNumber.charAt(i))) {
	        	throw new SSNCharacterException();
	        } 
	    }
	    return SSNumber;
	}
	
}

class SSNLengthException extends Exception{
	public SSNLengthException(){
		super("\nEnter the Social Security number without any hyphenes and It can't be more or less than 9 digits");
	}
}

class SSNCharacterException extends Exception{
	public SSNCharacterException(){
		super("Please don't use any character- Social Security number must be a number ");
	}
}