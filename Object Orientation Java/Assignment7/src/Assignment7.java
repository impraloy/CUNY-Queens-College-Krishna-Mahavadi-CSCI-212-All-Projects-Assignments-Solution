
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import org.w3c.dom.css.Rect;
import javafx.scene.Group;
public class Assignment7 extends Application{
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage)throws Exception {
		primaryStage.setTitle("Rainbow");
		Pane root = new Pane();
		
		Scene scene = new Scene(root, 600, 300, Color.AQUA);
		//Circle sun = new Circle(100, 100 , 100, Color.ORANGERED);
		Circle circle1 = new Circle(300, 410 , 400, Color.RED);
		Circle circle2 = new Circle(300, 410 , 390, Color.ORANGE);
		Circle circle3 = new Circle(300, 410 , 380, Color.YELLOW);
		Circle circle4 = new Circle(300, 410 , 370, Color.GREEN);
		Circle circle5 = new Circle(300, 410 , 360, Color.BLUE);
		Circle circle6 = new Circle(300, 410 , 350, Color.INDIGO);
		Circle circle7 = new Circle(300, 410 , 340, Color.MAGENTA);
		Circle circle8 = new Circle(300, 410 , 330, Color.AQUA);

		root.getChildren().addAll(/*sun,*/circle1,circle2,circle3,circle4,circle5,circle6,circle7,circle8);
		primaryStage.setScene(scene);
		primaryStage.show();
	}		

}
