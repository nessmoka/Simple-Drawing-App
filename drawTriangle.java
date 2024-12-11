package sdapp;
// drawTriangle class allows user to create a triangle
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class drawTriangle {

    private GraphicsContext graphicsContext;
    private double startX, startY;

    // Creates method that will be called in drawingTool class
    public drawTriangle(Canvas canvas, Color color) {
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(color); // Uses color chosen in colorpicker
        graphicsContext.setLineWidth(5);

        // Triangle begins where user pressed down on mouse
        canvas.setOnMousePressed((MouseEvent e) -> {
            startX = e.getX();
            startY = e.getY();
        });

        // Square ends where user released mouse
        canvas.setOnMouseReleased((MouseEvent e) -> {
            double endX = e.getX();
            double endY = e.getY();
            double midX = (startX + endX) / 2;
            double height = Math.abs(endY - startY);

            // Create the triangle
            graphicsContext.strokePolygon(new double[]{startX, midX, endX},
                    new double[]{endY, startY - height, endY}, 3);
        });
    }
}
