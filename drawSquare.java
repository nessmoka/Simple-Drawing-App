package sdapp;
// drawSquare class allows user to create a square by dragging their mouse to desired size
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class drawSquare {

    private GraphicsContext graphicsContext;
    private double startX, startY;

    // Create the method that will be called in the drawingTool class
    public drawSquare(Canvas canvas, Color color) {
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(color); // Uses the color selected in colorpicker
        graphicsContext.setLineWidth(5);

        // Square will begin where user presses mouse down
        canvas.setOnMousePressed((MouseEvent e) -> {
            startX = e.getX();
            startY = e.getY();
        });

        // Square will end where user stops pressing on the mouse
        canvas.setOnMouseReleased((MouseEvent e) -> {
            double endX = e.getX();
            double endY = e.getY();
            double size = Math.max(Math.abs(endX - startX), Math.abs(endY - startY)); // Uses the positions to create square
            graphicsContext.strokeRect(startX, startY, size, size); // Prints out the square created
        });
    }
}
