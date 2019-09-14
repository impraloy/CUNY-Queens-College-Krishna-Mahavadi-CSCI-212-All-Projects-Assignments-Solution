
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Assignment2 {
	public static void main(String[]args) {
		Account account1 = new Account(1122, 20000.00, 4.5, 2015, 8, 21);
		
		account1.withdraw(2500.0);
		account1.deposit(3000.0);
		System.out.println(account1 + "\n");
		
		
		Account[] accounts = new Account[10];
		
		ATMxxxx.startingBalance(accounts);
		
		System.out.print("Enter an id (1 - 10): ");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		id = ATMxxxx.checkIfIdIsValid(id);
	
		while(true) {
			ATMxxxx.displayMenu(); //displaying the menu & asking for choice
			  System.out.print("Enter a choice: ");
	            int choice = input.nextInt();
	            

	            if (choice == 4) { /*if the using put 4 then the
	                                  program starts from beginning by 
	                                  asking user id*/
	            	ATMxxxx.startingBalance(accounts);
	                System.out.printf("%nEnter an id (1 - 10): ");
	                id = input.nextInt();
	                
	                id = ATMxxxx.checkIfIdIsValid(id); // MODIFIED version 4.0
	                    
		}
	            ATMxxxx.menuChoice(id, choice, accounts);
	            System.out.println ( Account.getCurrentDate());
	}
		
}	
}

class Account{
	private int id;
	private double balance;
	private double annualInterestRate;
	private LocalDate dateCreated;
	static Date currentDate;
	
	Account(){
		id = 1;
		balance = 0.0;
		annualInterestRate = 0.0;
	}
	
	Account(int id,double balance, double annualInterestRate, int year, int month, int day){
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		dateCreated = LocalDate.of(year, month, day);
		currentDate = new Date();
	}
	
	Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}
	public void setId(int newId) {
		id = newId;
	}
	
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double newBalance) {
		balance = newBalance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double newAnnualInterestRate) {
		annualInterestRate = newAnnualInterestRate;
	}
	
	public static Date getCurrentDate()
    {
        return currentDate;
    } 
	
	public LocalDate getDatereate() {
        return dateCreated;
    }
	
	public double getMonthlyIntereste() {
		double monthlyInterste;
		
		monthlyInterste = balance * (annualInterestRate/12);
	    return monthlyInterste;
	}
	public void withdraw(double amount){
	        if (amount > balance)
	            System.out.println("\nWithdrawal amount exceeded account balance");
	        else
	            balance -= amount;
	}
	
	public void deposit(double amount) {
        this.balance += amount;
    }
	
	public String toString() {
	    return ("Id: " + getId()  + "\nbalance: $" + getBalance()+ "\nmonthy interest: $"+ getMonthlyIntereste() +  "\nDate Created: " + getDatereate());
	}
}


 class ATMxxxx{

	private static Scanner input = new Scanner(System.in);
	// MODIFIED version 2.0
	public static void startingBalance(Account[] accounts) {
		double StartingBalance = 100.00;
		for (int i= 0; i<accounts.length;i++) {
			accounts[i] = new Account(i, StartingBalance);
		}
	}
	
	// MODIFIED version 4.0
	public static int checkIfIdIsValid(int id) {
		while(true) {
			if (id >= 1 && id <= 10) break;
			System.out.print("Please,Enter a valid id between (1-10): ");
			id = input.nextInt();
		}
		return id;	
			
	}
	
	public static void displayMenu() {
		  System.out.println("\nMain menu"+"\n1:check balance"+"\n2:withdraw"
	                +"\n3:deposit"+"\n4:exit\n");
    }
	
	public static void menuChoice(int id, int choice, Account[] accounts) {
		switch (choice) {
		case 1: //checking the current balance
				  System.out.println("The balance is " + accounts[id].getBalance());
				  break;
		case 2: // Withdraw money
				  System.out.print("Enter an amount to withdraw: "); 
				  accounts[id].withdraw(input.nextDouble());
				  break;
		case 3: // Deposit money
				  System.out.print("Enter an amount to deposit: "); 
				  accounts[id].deposit(input.nextDouble());
        }
    }
	
}

