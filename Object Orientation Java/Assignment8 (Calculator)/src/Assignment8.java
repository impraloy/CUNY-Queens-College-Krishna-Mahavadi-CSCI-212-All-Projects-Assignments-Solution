
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
//import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Assignment8 extends Application {
	
	TextField textField;
	int firstval, scecondval, answer;
	char operation;
	static String tempString ="";
	static String tempString_Recall = "";
	static double lastAnswer = 0;

	

	public static void main(String[]args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = new BorderPane();
		
		//creating TextField and assign it to the HBox
		textField = new TextField();
		HBox hBox = new HBox();
	    hBox.getChildren().add(textField);
	    root.setTop(hBox);
	    
	    ButtonEventHandler eventHandler = new ButtonEventHandler();
	    
		//this part work for the left vbox
		VBox leftVBox = new VBox();
		
		Button AdditionBtn = new Button("+");
		AdditionBtn.setOnAction(eventHandler);
		
		Button SubtractionBtn = new Button("- ");
		SubtractionBtn.setOnAction(eventHandler);
		
		Button MultiplicationBtn = new Button("* ");
		MultiplicationBtn.setOnAction(eventHandler);
		
		Button DivitionBtn = new Button("/ ");
		DivitionBtn.setOnAction(eventHandler);
		
		leftVBox.getChildren().addAll(AdditionBtn, SubtractionBtn, MultiplicationBtn, DivitionBtn);
		root.setLeft(leftVBox);
		//leftVBox.setPrefSize(400, 500);
		//leftVBox.setPrefWidth(30);
		
		
		//this part work for right Vbox
		VBox rightVBox = new VBox();
		
		Button EqualBtn = new Button( "=");
		EqualBtn.setOnAction(eventHandler);
		//buttonRight.setOnAction()
		
		rightVBox.getChildren().add(EqualBtn);
		root.setRight(EqualBtn);
		//rightVBox.setPrefSize(400, 500);
		//rightVBox.setPrefWidth(50);
		
		
		//this pat work for center gridpane
		GridPane digitButtonGridPane = new GridPane();
		
		Button OneBtn = new Button("1");
		OneBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(OneBtn, 0, 0);
		
		Button TwoBtn = new Button("2");
		TwoBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(TwoBtn, 1, 0);
		
		Button ThreeBtn = new Button("3");
		ThreeBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(ThreeBtn, 2, 0);
		
		Button FourBtn = new Button("4");
		FourBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(FourBtn, 0, 1);
		
		Button FiveBtn = new Button("5");
		FiveBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(FiveBtn, 1, 1);
		
		Button SixBtn = new Button("6");
		SixBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(SixBtn, 2, 1);
		
		Button SevenBtn = new Button("7");
		SevenBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(SevenBtn, 0, 2);
		
		Button EightBtn = new Button("8");
		EightBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(EightBtn, 1, 2);
		
		Button NineBtn = new Button("9");
		NineBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(NineBtn, 2, 2);
		
		Button ZeroBtn = new Button("0");
		ZeroBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(ZeroBtn, 1, 3);
		
		Button PointBtn = new Button(".");
		PointBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(PointBtn, 2, 3);
		
		Button ClearBtn = new Button("C");
		ClearBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(ClearBtn, 3, 0);
		
		Button ExitBtn = new Button("E");
		ExitBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(ExitBtn, 3, 3);
		
		Button MemoryBtn = new Button("M");
		MemoryBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(MemoryBtn, 3, 2);
		
		Button RecallBtn = new Button("R");
		RecallBtn.setOnAction(eventHandler);
		digitButtonGridPane.add(RecallBtn, 3, 1);
		
		root.setCenter(digitButtonGridPane);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
//		gridPane.add(new Button("1"), 0, 0);
//		gridPane.add(new Button("2"), 1, 0);
//		gridPane.add(new Button("3"), 2, 0);
//		gridPane.add(new Button("4"), 0, 1);
//		gridPane.add(new Button("5"), 1, 1);
//		gridPane.add(new Button("6"), 2, 1);
//		gridPane.add(new Button("7"), 0, 2);
//		gridPane.add(new Button("8"), 1, 2);
//		gridPane.add(new Button("9"), 2, 2);
//		gridPane.add(new Button("0"), 1, 3);
//		gridPane.add(new Button(" ."), 2, 3);
//		gridPane.add(new Button("C "), 3, 0);
//		//gridPane.add(new Button("C"), 0, 3);
//		gridPane.add(new Button("E "), 3, 3);
//		//gridPane.add(new Button("E"), 2, 3);
//		gridPane.add(new Button("M"), 3, 2);
//		//gridPane.add(new Button("M"), 0, 4);
//		gridPane.add(new Button("R "), 3, 1);
//		//gridPane.add(new Button("R"), 1, 4);
		
		//gridPane.setPrefSize(300, 300);
		
	}
	
	class ButtonEventHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent e) {
			Button pressed = (Button)e.getTarget();
	    	String text = pressed.getText();
	    	System.out.println(text);
	    	if(text == "=") {
	    		String ConvertedString = Double.toString(SplitOperation(tempString));
	    		tempString_Recall = tempString;
	    		tempString = ConvertedString;
	    		textField.setText(ConvertedString);
	    	}else {
	    		if(text == "C" || text == "R" || text == "M" || text == "E") {
	    			SpecialBtnOperation(text);
	    		}else {
	    			tempString+= text;
	    			textField.setText(tempString);
	    		}
	    	}
	    	
//	    	if (text.contentEquals("+")) {
//	    		operation = '+' ;
//	    		   answer = num1 + num2;
//	    		} else if (text.contentEquals("-")) {
//	    			operation = '-' ;
//	    		   answer = num1 - num2;
//	    		} else if (text.contentEquals("*")) {
//	    			operation = '*' ;
//	    		   answer = num1 * num2;
//	    		} else if (text.contentEquals("/")){
//	    			operation = '/' ;
//	    		   answer = num1 / num2;
//	    		} else if (text.contentEquals("C")) {
//	    			operation = 'C' ;
//		    		   answer = num1 - num2;
//		    	} else if (text.contentEquals("E")) {
//		    			operation = 'E' ;
//		    		   answer = num1 * num2;
//		    	} else if (text.contentEquals("R")){
//		    			operation = 'R' ;
//		    		   answer = num1 / num2;
//		    	} else {
//		    		operation = 'M';
//		    	}
//	    	
//	    	if (text.contentEquals("+")) {
//	    		
//	    		operation = '+' ;
//	    		
//	    	}else {
//	    		
//	    		textField .appendText(text);
//	    		
//	    		scecondval = getNumber(text);
//	    	}
//	    	
//	    	
//	    	if (text.contentEquals("=")) {
//	    		
//	    		operation = '=' ;
//	    	}
//	    	
//	    		answer.setText = firstval + scecondval;
//	    	} 
	    	//once know which button was pressed we can decide what to do
	    	
		}
		
	}
	
	public double SplitOperation(String textString) {
		
		System.out.print(textString);
		
		int indexOpr = textString.indexOf("+");
		//System.out.print(indexOpr);
		//System.out.println(textString.split("[-+*/]"));
		String[] rex = textString.split("[-+*/C]");
		double num1 = Double.parseDouble(rex[0]);
		double num2 = Double.parseDouble(rex[1]);
		System.out.println();
		System.out.println(rex[0]);
		
		char Operation = textString.charAt(rex[0].length());
		System.out.println(Operation);
		double answer = 0;
		switch (Operation) {
		
		case '+':
			answer = num1 + num2;
			break;
			
		case '-':
			answer = num1 - num2;
			break;
			
		case '*':
			answer = num1 * num2;
			break;
			
		case '/':
//			if ((-precision < n2) && (n2 < precision));
			answer = num1 / num2;
			break;
			
//		case 'C':
//			textField.clear();
//			
//			break;
//		case 'E':
//			
//			break;
//		case 'M':
//			
//			break;
//		case 'R':
//			
//			break;
			default:
		}
		lastAnswer = answer;
		return answer;
	}
//	public double evaluate (char op, double n1, double n2) {
//		//n1 = Integer.parseInt(textField.getText());
//		//n2 = Integer.parseInt(textField.getText());
//		
//		op = ' ';
//		double answer = 0;
//		switch (op) {
//		
//		case '+':
//			answer = n1 + n2;
//			break;
//			
//		case '-':
//			answer = n1 - n2;
//			break;
//			
//		case '*':
//			answer = n1 * n2;
//			break;
//			
//		case '/':
////			if ((-precision < n2) && (n2 < precision));
//			answer = n1 / n2;
//			break;
//			
////		case 'C':
////			textField.clear();
////			x="";
////			break;
////		case 'E':
////			
////			break;
////		case 'M':
////			
////			break;
////		case 'R':
////			
////			break;
//			default:
//				return answer;
//		}
//		return answer;
//}
	public void SpecialBtnOperation(String SpecialBtnOperation) {
		switch(SpecialBtnOperation) {
	case "C":
		tempString="";
		textField.clear();
		break;
	case "E":
		Platform.exit();
		//stage.close();
		
		break;
	case "M":
		tempString="";
		textField.setText(Double.toString(lastAnswer));
		break;
	case "R":
		textField.setText(tempString_Recall);
		break;
	default:
		break;
	}
}
//	int getNumber(String text) {
//		return 0;
//	}
	


}
