
public class Assignment3 {
	public static void main(String[] args) {
		 Doctor person1 = new Doctor("Dr.Ilya Kleyn, MD", "Dentist", 80);
		 System.out.println(person1);
	     Doctor person2 = new Doctor("Dr.Barry Cohen, MD", "Physician", 120);
	     System.out.println(person2);
	     Patient person3 = new Patient("Christian Bale", "123456789");
	     System.out.println(person3);
	     Patient person4 = new Patient("Tom Hardy", "987654321");
	     System.out.println(person4);
	     Billing person5 = new Billing(person4, person1, person1.getVisitFee());
	     Billing person6 = new Billing(person3, person2, person2.getVisitFee());
	     System.out.println("Record 1:\n" + person5);
	     System.out.println("Record 2:\n" + person6);

	     System.out.println("Total due amount: $" + (person5.getAmount() + person6.getAmount()));
	}
}
//Person class
class Person{
	private String name;
//Constructor without Parameter
	Person(){
		name = null;
	}
//Constructor with Parameter
	Person(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
	    return ("Name: " + getName());
	}
}
//Doctor class
class Doctor extends Person{
	private String Speciality;
	private double visitFee;
//Constructor without Parameter	
	Doctor(){
		super();
		Speciality = null;
		visitFee = 0.0;
	}
//Constructor with Parameter	
	Doctor(String name, String Speciality, double visitFee){
		super(name);
		this.Speciality = Speciality;
		this.visitFee = visitFee;
	}
	
	public String getSpeciality() {
		return Speciality;
	}
	public void setSpeciality(String Speciality) {
		this.Speciality = Speciality;
	}
	public double getVisitFee() {
		return visitFee;
	}
	public void setVisitFee(double visitFee) {
		this.visitFee = visitFee;
	}
	
	public String toString() {
		return ("Doctor's Name: " + getName() + "\nDoctor'S Speciality: " + getSpeciality() + "\nVisit Fee: $"
				+ getVisitFee())+"\n";
	}	
	public boolean equals(Object otherObject) {
        boolean isEquals = false;
        
        if((otherObject != null) && (otherObject instanceof Doctor)) {
            Doctor otherEmp = (Doctor)otherObject;
            isEquals = this.getName().equals(otherEmp.getName())
                    && this.getSpeciality().equals(otherEmp.getSpeciality())
                    && this.getVisitFee() == (otherEmp.getVisitFee());
        }
        return isEquals;
    }  
}
//Patient class
class Patient extends Person{
	private String SSN;
//Constructor without Parameter
	Patient(){
		super();
		SSN = null;
	}
//Constructor with Parameter
	Patient(String name, String SSN){
		super(name);
		this.SSN = SSN;
	}
	
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	
	public String toString() {
	    return ("Patient's Name: " + getName() + "\nPatient's SSN: " + getSSN())+"\n";
	}
	
	public boolean equals(Object otherObject) {
        boolean isEquals = false;
        
        if((otherObject != null) && (otherObject instanceof Patient)) {
            Patient otherEmp = (Patient)otherObject;
            isEquals = this.getName().equals(otherEmp.getName())
                    && this.getSSN().equals(otherEmp.getSSN());
        }
        return isEquals;
    }
}

class Billing{
	private Patient patient;
	private Doctor doctor;
	private double amount;
	
	Billing(){
		patient = new Patient();
		doctor = new Doctor();
		amount = 0;
		}
			
	Billing(Patient patient, Doctor doctor, double amount){
		this.patient = patient;
		this.doctor = doctor;
		this.amount = amount;
		}
	
	public Patient getPatient(){
		return patient;
	}
	public void setPatient(Patient patient){
		this.patient = patient;
		}
	public Doctor getDoctor(){
		return doctor;
	}
	public void setDoctor(Doctor doctor){
				this.doctor = doctor;
				}
	public double getAmount(){
		return amount;
	}
	public void setAmount(double amount){
		this.amount = amount;
		}
	public String toString(){
		return (patient.toString() + doctor.getName() + "\nVisit Fee: $" + amount+"\n");
		}
	
	public boolean equals(Object otherObject) {
        boolean isEquals = false;
        
        if((otherObject != null) && (otherObject instanceof Billing)) {
            Billing otherEmp = (Billing)otherObject;
            isEquals = this.getDoctor().equals(otherEmp.getDoctor())
                    && this.getPatient().equals(otherEmp.getPatient())
                    && this.getAmount() == (otherEmp.getAmount());
        }
        return isEquals;
    }
}