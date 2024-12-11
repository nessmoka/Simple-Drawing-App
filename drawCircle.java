package sdapp;// package sdapp;
// class that allows user to create a circle with their mouse
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class drawCircle {

    private GraphicsContext graphicsContext;
    private double startX, startY;

    // Creates method that will be called for in the drawingTool class
    public drawCircle(Canvas canvas, Color color) {
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(color);
        graphicsContext.setLineWidth(5);

        // Circle will start where user pressed down on mouse
        canvas.setOnMousePressed((MouseEvent e) -> {
            startX = e.getX();
            startY = e.getY();
        });

        // Cirlce will end when the mouse is released
        canvas.setOnMouseReleased((MouseEvent e) -> {
            double endX = e.getX();
            double endY = e.getY();
            double radius = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));

            // Creates the circle
            graphicsContext.strokeOval(startX - radius, startY - radius, radius * 2, radius * 2);
        });
    }
}