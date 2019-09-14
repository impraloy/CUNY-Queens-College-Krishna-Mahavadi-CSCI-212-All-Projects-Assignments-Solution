import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator3 extends Application {
	
	private TextField textField;
	private String memory;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		//root node
		BorderPane root = new BorderPane();
		
		//top
		textField = new TextField();
		textField.setEditable(false);
		root.setTop(textField);
		
		//left
		VBox leftOperatorsVBox = createLeftOperatorsVBox(); 
		root.setLeft(leftOperatorsVBox);
		
		//center
		GridPane numericButtonGridPane = createNumericButtonGridPane();
		root.setCenter(numericButtonGridPane);
		
		//right
		VBox rightOperatorsVBox = createRightOperatorsVBox();
		root.setRight(rightOperatorsVBox);
		
		//display
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculator");
		primaryStage.show();
	}
	
	private GridPane createNumericButtonGridPane() {
		
		GridPane pane = new GridPane();
		
		NumericButtonHandler handler = new NumericButtonHandler();
		
		int digit = 1;
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++) {
				Button btn = new Button(Integer.toString(digit++));
				btn.setOnAction(handler);
				pane.add(btn, col, row);
			}
		Button zeroBtn = new Button("0");
		zeroBtn.setOnAction(handler);
		pane.add(zeroBtn, 1, 3);
		
		return pane;
	}
	
	private VBox createLeftOperatorsVBox() {
		
		VBox box = new VBox();
		
		ArithmeticOperatorButtonHandler handler = new ArithmeticOperatorButtonHandler();
		
		Button addBtn = new Button("+");
		Button subBtn = new Button("-");
		Button mulBtn = new Button("*");
		Button divBtn = new Button("/");
		
		Button[] operatorButtons = {addBtn, subBtn, mulBtn, divBtn};
		
		for (Button button : operatorButtons) {
			button.setOnAction(handler);
		}
			
		box.getChildren().addAll(operatorButtons); 
		
		return box;
	}
	
	private VBox createRightOperatorsVBox() {
		
		VBox box = new VBox();
		
		OtherButtonHandler handler = new OtherButtonHandler();
		
		Button eqBtn = new Button("=");
		Button acBtn = new Button("AC");
		Button memBtn = new Button("M");
		Button recallBtn = new Button("R");
		Button exitBtn = new Button("X");
		
		Button[] rightButtons = {eqBtn, acBtn, memBtn, recallBtn, exitBtn};
		
		for (Button button : rightButtons) {
			button.setOnAction(handler);
			button.setMaxWidth(Double.MAX_VALUE);
		}
			
		box.getChildren().addAll(rightButtons);
		
		return box;
	}
	
	class NumericButtonHandler implements EventHandler<ActionEvent> {
	    @Override
	    public void handle(ActionEvent e) {
	    	
	    	//append number to text field
	    	Button pressed = (Button) e.getTarget();
	    	String txt = pressed.getText();
	    	textField.appendText(txt);
	    	
	    }
	}
	
	class ArithmeticOperatorButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			
			//get and clear text contents
			String currentValString = textField.getText();
			textField.setText("");
			
			//perform operation using previous number, previous operator, and new number
			Calculation.setOperand(currentValString);
			int result = Calculation.evaluate();
			
			//store result of calculation
			Calculation.setTotal(result);
			
			//set new operator that was just pressed
			Button pressed = (Button) e.getTarget();
	    	String btnText = pressed.getText();   	
	    	Calculation.setOperator(btnText);
			
		}
	}
	
	class OtherButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			
			//always get and clear text contents
			String currentText = textField.getText();
			textField.setText("");
			
			//always get button just pressed
			Button pressed = (Button) e.getTarget();
	    	String btnText = pressed.getText();  
	    	
			if (btnText.equals("=")) {
				
				//perform operation using previous number, previous operator, and new number
				Calculation.setOperand(currentText);
				int result = Calculation.evaluate();
				
				//store result of calculation, reset calculator start state
				Calculation.reset(result);
				
				//display result
				textField.setText(Integer.toString(result));
				
			} else if (btnText.equals("AC")) {
				
				Calculation.reset(0);
				
			} else if (btnText.equals("M")){
				
				memory = currentText;
				
			} else if (btnText.equals("R")) {
				
				textField.setText(memory);
				
			} else if (btnText.equals("X")) {
				
				System.exit(0);
				
			} else {
				
				System.err.println("Unknown button");
				System.exit(1);
				
			}
				
			
		}
	}
	
	static class Calculation {
		
		private static int total = 0, operand = 0;
		private static char operator = '+';
		
		public static void setTotal(int v) {
			total = v;
		}
		
		public static void setTotal(String v) {
			try {
				total = Integer.parseInt(v);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				total = 0;
			}
		}
		
		public static void setOperand(int v) {
			operand = v;
		}
		
		public static void setOperand(String v) {
			try {
				operand = Integer.parseInt(v);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				operand = 0;
			}
		}
		
		public static void setOperator(char o) {
			if (o == '+' || o == '-' || o == '*' || o == '/') 
				operator = o;
			else
				System.exit(1); //TODO: throw exception
		}
		
		public static void setOperator(String s) {
			if (s.length() != 1)
				System.exit(1); //TODO: throw exception
			else {
				setOperator(s.charAt(0));
			}
				
		}
		
		public static int evaluate() {
			
			int result = 0;
			
			switch (operator) {
			case '+':
				result = total + operand;
				break;
			case '-':
				result = total - operand;
				break;
			case '*':
				result = total * operand;
				break;
			case '/':
				try {
					result = total / operand;
				} catch (ArithmeticException e) {
					e.printStackTrace();
				}				
			}
			
			System.out.println("calulating: " + total + " " + operator + " " + operand + " = " + result);
			
			return result;
		}
		
		public static void reset(int newVal) {
			total = 0;
			operator = '+';
			operand = newVal;
		}
	}
}


