
import java.time.LocalDate;
public class Assignment4 {
	public static void main(String[]args) {
		SalariedEmployee googleCeo = new SalariedEmployee("Sundar Pichai", "S454gfg", 2015, 9, 23, 650000 );
		//boss.getsalary(650000);
		googleCeo.raiseTheSalary(7);
        System.out.println (googleCeo);
        System.out.println();
		
        SalariedEmployee facebookCeo = new SalariedEmployee("Mark Zuckerberg", "M6hbh34", 2004, 4, 8, 8852366 );
        facebookCeo.raiseTheSalary(9);
        System.out.println (facebookCeo);
        System.out.println();
        
        FulltimeEmployee googleManager = new FulltimeEmployee("Raven Adler","A7yeh3e3", 2017, 5, 12,60,52 );
        System.out.println (googleManager);
        System.out.println();
        FulltimeEmployee faceboolManager = new FulltimeEmployee("Gary Mchinnon","T38ehb3", 2016, 3,6, 75, 60 );
        System.out.println (faceboolManager);
        System.out.println();
		
        ParttimeEmployee googleParttimeEmployee = new ParttimeEmployee("Charles ED","C72yhx73", 2018, 9, 21, 20, 43);
        System.out.println (googleParttimeEmployee);
        System.out.println();
        ParttimeEmployee facebookParttimeEmployee = new ParttimeEmployee("Ying Cracker","Y387fh47", 2017, 1, 17, 20, 41);
        System.out.println (facebookParttimeEmployee);
        System.out.println();
	}
}

abstract class Employee{
	private String EmployeeName;
	private String EmployeeId;
	private LocalDate dateHired;
	//LocalDate hireDate;
	
	public Employee(){
		EmployeeName = null;
		EmployeeId = null;
		//this.hireDate = null;
		dateHired = null;
	}
	public Employee(String EmployeeName,String EmployeeId, int year, int month, int day)
	{
		this.EmployeeName = EmployeeName;
		this.EmployeeId = EmployeeId;
		dateHired = LocalDate.of(year, month, day);
	    }
	
	
	 public String getName() {
	        return EmployeeName;
	    }
	    
	 public void setName(String name) {
	    	EmployeeName = name;
	    }
	 public String getId() {
	        return EmployeeId;
	    }
	 
	 public LocalDate getDateHired() {
	        return dateHired;
	    }
	 
	 public abstract double pay();
	 
	 
	 public String toString() {
	        return ("Name: " + EmployeeName  + "\nEmployee Id: " + EmployeeId + "\nDate Hired: " + dateHired);
	    }

	
}


class SalariedEmployee extends Employee{
	private double salary;
	
	public SalariedEmployee() {
		super();
		salary = 0.0;
	}
	
	public SalariedEmployee(String EmployeeName,String EmployeeId, int year, int month, int day,double salary){
		super(EmployeeName, EmployeeId, year, month, day);
		this.salary = salary; 
	}
	
	 
	 
	 public double getsalary() {
	        return salary;
	    }
	 
	 public void raiseTheSalary(double raise) {
	         raise = salary * 0.07;
	        salary += raise;
	    }
	 
	 @Override
		public double pay() {
			return salary;
		}
	
	 
	 public String toString() {
	        return ("\nSalaried Employee\n"+ "Name: " + getName()  + "\nEmployee Id: " + getId() + "\nDate Hired: " + getDateHired() + "\nSalary: $" + salary);
	    }
	
}

class FulltimeEmployee extends Employee{
	double payRate;
	int hoursWorked;
	double totalPayment;
	
	public FulltimeEmployee() {
		super();
		payRate = 0.0;
		hoursWorked = 0;	
	}
	
	public FulltimeEmployee(String EmployeeName,String EmployeeId, int year, int month, int day,double payRate, int hoursWorked){
		super(EmployeeName, EmployeeId, year, month, day);
		
		this.payRate = payRate; 
		this.hoursWorked = hoursWorked;
	}
	
	public double getpayRate() {
        return payRate;
    }
	
	public double setpayRate() {
		return payRate;
	}
	
	public double gethoursWorked() {
        return hoursWorked;
    }
	
	public void sethoursWorked(int hoursWorked) {
		 hoursWorked = hoursWorked;
	}
	
	private int overTime() {
		if(hoursWorked < 40)
			return 0;
		return hoursWorked - 40; 
	}
	

	@Override
	public double pay() {
		if (overTime() > 0) {
			totalPayment = (payRate * 40) + (overTime() * 1.5);
		}
		else 
			totalPayment = payRate * hoursWorked;
			
		return totalPayment;
	}
	
	public String toString() {
	    return ("\nFullTime Employee\n"+"Name: " + getName()  + "\nEmployee Id: " + getId() + "\nDate Hired: " + getDateHired() + "\nHours Workes: "+ 
	hoursWorked +"\nOver Time: "+ overTime() + "\nPay Rate: $" + payRate + "\nTotal Payment: $" + pay());
	}

}

class ParttimeEmployee extends FulltimeEmployee{
	public ParttimeEmployee(String EmployeeName,String EmployeeId, int year, int month, int day,double payRate, int hoursWorked){
		super(EmployeeName, EmployeeId, year, month, day, payRate, hoursWorked);
	}
		

	@Override
	public double pay() {
		double totalPayment = payRate * hoursWorked;
		return totalPayment;
	}
	public String toString() {
	    return ("\nPartTime Employee\n"+ "Name: " + getName()  + "\nEmployee Id: " + getId() + "\nDate Hired: " + getDateHired() + "\nHours Workes: "+ hoursWorked + "\nPay Rate: $" + payRate + "\nTotal Payment: $" + pay());
	}
	
}
