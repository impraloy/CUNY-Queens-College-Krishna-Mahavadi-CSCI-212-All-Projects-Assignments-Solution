
import java.util.Scanner;
 public class Assignment1 {
	 static Scanner input;
	public static void main(String[] args) {
		quadraticEquation();
		hailstoneSequence();
		decryptsAndEncryptsMessage();
		
	}
		 //         **********Quadratic Equation*********  
	
	
	    public static void quadraticEquation() {
	    double a, b, c, Solution1, Solution2, x;
	    input = new Scanner(System.in);
	    System.out.println("Enter Co-efficient a: ");
	    a = input.nextDouble();
	    System.out.println("Enter Co-efficient b: ");
	    b = input.nextDouble();
	    System.out.println("Enter Co-efficient c: ");
	    c = input.nextDouble();
	    x = b*b - 4*a*c;
	   
	    Solution1= (-b + Math.sqrt(x))/(2*a);
	   
	    Solution2= (-b - Math.sqrt(x))/(2*a);

	   
	    System.out.println("First solution is " + Solution1);
	    System.out.println("Second Solution is " + Solution2);
	    System.out.println("\n");
	   
	    //input.close();
	     
	    }

	    //       ***********Hail stone Sequence**********
	    
	    
	    public static void hailstoneSequence() {
			int n, x = 0,  count= 0;
			//Scanner input = new Scanner (System.in);
			System.out.println("Enter the Number: ");
			n =  input.nextInt();
			while (n>1) {
				if (n%2==0) {
					x= n/2;
					System.out.println(n + " is a even number, So I take half = " + x);
					n=x;
					
					
				}
				else {
					x= 3*n+1;
					System.out.println(n + " is a odd number, So I make 3n+1 = " + x);
					n=x;
					

				}
				count ++;
			}
			System.out.println("The process took " + count + " to reach 1");
			System.out.println("\n");
			//input.close();
		}
	    
	   //     **********Decrypts And Encrypts Message**********
	  //https://www.youtube.com/watch?v=8AID7DKhSoM
	    
	    
	    	public static void decryptsAndEncryptsMessage() {
	    		String DecryptedMessage;
	    		String EncryptedMessage;
	    		
	           Scanner input = new Scanner(System.in);
	    		
	            System.out.print("Enter the decreypted message: \n");
	            
	            DecryptedMessage = input.nextLine();
	            
	            System.out.print("Enter the encreypted message: \n");
	            EncryptedMessage = input.nextLine();
	            
	            for(int i = 1; i <= 100; i++) {
	            	System.out.println(i + " " + encrypt(DecryptedMessage, i));
	            	System.out.println(i + " " + decrypt(EncryptedMessage, i));
	               
	                }
	            }       
	           
	    	
	    	//Encrypting the message
	    	
	    	public static String encrypt(String str, int key) {
	    		String result = "";
	            char EncryptedChar;
	            int OriginalChar;
	            for(int i = 0; i < str.length(); i++) {
	            	EncryptedChar = str.charAt(i);
	            	OriginalChar = (int) EncryptedChar; //converting char to int
	             	if( OriginalChar + key > 127) { //condition is given
	             		//converting back to char
	            		EncryptedChar = (char) (32 + ((EncryptedChar + key) - 127));
	            	}
	                else {
	                	//converting back to char
	                	EncryptedChar = (char)(EncryptedChar + key); 
	                }
	            	result = result + EncryptedChar;
	            }
	            return result;
	        }
	    	
	    	//Decrypting the message
	    	
	    	public static String decrypt(String str, int key) {
	    		 String result = "";
	 	        char DecryptedChar;
	 	        int OriginalChar;
	 	        for(int i = 0; i < str.length(); i++) {
	 	        	DecryptedChar = str.charAt(i);
	 	        	OriginalChar = (int) DecryptedChar;//converting char to int
	 	         	if( OriginalChar - key < 65) {/*Guessing secret message is
	 	         		                           * written in human language(english)
	 	         		                           * English alphabets ascci value is 
	 	         		                           * starting from 65
	 	         		                           * subtracting key value from the 
	 	         		                           * OriginalChar because it is added 
	 	         		                           * in the given condition
	 	         		                           */
	 	         		DecryptedChar = (char) (127 + ((DecryptedChar - key) - 32));
	 	        	}
	 	            else {
	 	            	//converting back to char
	 	            	DecryptedChar = (char)(DecryptedChar - key);
	 	            }
	 	        	result = result + DecryptedChar;
	 	        }
	 	        return result;
	 	    }
	 	
	 	    }
	    	

	
		
		
		
		