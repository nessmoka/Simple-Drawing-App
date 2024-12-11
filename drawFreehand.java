package sdapp; // package sdapp
// drawFreehand class allows user to draw with their mouse
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class drawFreehand {

    private GraphicsContext graphicsContext;
    private double startX, startY;

    // Create method that will be called for in the drawingTool class
    public drawFreehand(Canvas canvas, Color color) {
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(5);
        graphicsContext.setStroke(color); // Uses color selected

        // Drawing begins when mouse is pressed down
        canvas.setOnMousePressed((MouseEvent e) -> {
            startX = e.getX();
            startY = e.getY();
            graphicsContext.beginPath();
            graphicsContext.moveTo(startX, startY);
        });

        // Continues drawing wherever mouse is dragged (still pressed down)
        canvas.setOnMouseDragged((MouseEvent e) -> {
            graphicsContext.lineTo(e.getX(), e.getY());
            graphicsContext.stroke();
        });

        // Drawing is stopped when mouse is released
        canvas.setOnMouseReleased((MouseEvent e) -> {
            graphicsContext.closePath(); // Close the drawing path when the mouse is released
        });
    }
}
