
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import org.w3c.dom.css.Rect;
import javafx.scene.Group;
public class Assignment6 extends Application{
	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {
		
		//prepare to draw
		int CanvasWidth = 600;
		int CanvasHeight = 600;
		Canvas canvas = new Canvas(CanvasWidth, CanvasHeight);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		//prepare to display
		Group root = new Group();
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Rectangle brick = new Rectangle();
		final int BRICK_WIDTH = 30; 
		final int BRICK_HEIGHT = 12;
		final int BRICKS_IN_BASE = 12;
		
		//brick.setWidth(brickWidth);
		//brick.setHeight(12);
		
		double currentX = CanvasWidth/2;
		double currentY = CanvasHeight-(BRICK_HEIGHT*BRICKS_IN_BASE) ;
		for(int i = 1; i <= BRICKS_IN_BASE;i++) {
			for(int j = 0; j < i; j++ ) {
				//Rectangle brick = new Rectangle(currentX,currentY,brickWidth,brickHeight);
				//gc.rect(currentX,currentY,brickWidth,brickHeight);
				//gc.setFill(Color.SANDYBROWN );
				//gc.fillRect(currentX,currentY,BRICK_WIDTH,BRICK_HEIGHT);
				gc.strokeRect(currentX,currentY,BRICK_WIDTH,BRICK_HEIGHT);
				
				currentX += BRICK_WIDTH;
			}
			currentY += BRICK_HEIGHT;
			//currentX = 300- brickWidth;
			currentX = CanvasWidth/2 - (BRICK_WIDTH/2) *i;
			//currentX = 300 - 15*i;
		}
		
	}
	
	/*BRICK_WIDTH} The width of each brick (30 pixels)
	{\bf BRICK_HEIGHT} The height of each brick(12 pixels)
	{\bf BRICKs_IN_BASE} The number of bricks in the base (12)*/


}
