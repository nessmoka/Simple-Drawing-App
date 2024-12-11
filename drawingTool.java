package sdapp;// package sdapp;
// drawingTool app that allows reader to select the brush they want to use
// creates a freehand brush, circle brush, square brush, triangle brush and an eraser
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;


public class drawingTool {
    // initialize choicebox and eraser
    private ChoiceBox<String> choiceBox;
    private eraserTool eraser;

    // Creates a choicebox that allows user to select a tool
    public drawingTool(Canvas canvas) {
        // choice box with 5 selections
        choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Draw","Circle", "Square", "Triangle", "Erase");
        choiceBox.setValue("Select tool");

        eraser = new eraserTool(canvas);


    }

    public ChoiceBox<String> getChoiceBox() {
        return choiceBox;
    }

    // Sets an action to whichever tool is selected
    public void toolSelect(Canvas canvas, Color color) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(color); // Makes it so the color chosen on colorpicker is used
        graphicsContext.setLineWidth(5);

        // Listen for changes in the choice box selection
        choiceBox.setOnAction(e -> {
            String selectedTool = choiceBox.getValue();

            canvas.setOnMousePressed(null);
            canvas.setOnMouseDragged(null);
            canvas.setOnMouseReleased(null);

            // call the correct method from subclasses when user selects tool from choicebox
                if ("Draw".equals(selectedTool)) {
                    new drawFreehand(canvas, color); // calls method from drawFreehand class
                } else if ("Circle".equals(selectedTool)) {
                        new drawCircle(canvas, color); // calls method from drawCircle class
                } else if ("Square".equals(selectedTool)) {
                    new drawSquare(canvas, color);  // calls method from drawSquare class
                } else if ("Triangle".equals(selectedTool)) {
                    new drawTriangle(canvas, color); // calls method from drawTriangle class
                } else  if ("Erase".equals(selectedTool)) {
                new eraserTool(canvas);
            }

        });
    }

}


