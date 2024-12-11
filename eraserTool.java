package sdapp;
// eraserTool class creates an eraser that erases the users' drawings when selected
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class eraserTool {
    private final GraphicsContext graphicsContext;

// Create method that will be called in the drawingTool class
    public eraserTool(Canvas canvas) {
        graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setLineWidth(40);
        graphicsContext.setStroke(Color.WHITE); // Set color to white because canvas is white

        // Mouse event handlers erase are where user drags their mouse
        canvas.setOnMousePressed((MouseEvent e) -> {
            graphicsContext.beginPath();
            graphicsContext.moveTo(e.getX(), e.getY());
            graphicsContext.stroke();
        });

        canvas.setOnMouseDragged((MouseEvent e) -> {
            graphicsContext.lineTo(e.getX(), e.getY());
            graphicsContext.stroke();
        });
        // Stops erasing when mouse is not being pressed
        canvas.setOnMouseReleased((MouseEvent e) -> graphicsContext.closePath());
    }

}
