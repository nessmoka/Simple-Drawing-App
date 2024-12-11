package sdapp;// simpledrawingApp that allows user to draw shapes
// Author: Vanessa Padilla
// Main app class that will launch the application
// Creates the canvas and design
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class simpledrawingApp extends Application {

    public void start(Stage stage) throws Exception {

        // CREATE CANVAS
        Canvas canvas = new Canvas(400, 400);

        // Display the buttons
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: white;"); // white background
        vBox.setSpacing(2);
        vBox.getChildren().add(canvas);
        vBox.getChildren().add(getHBox1(canvas));


        stage.setTitle("Simple Drawing App"); // App name
        stage.setScene(new Scene(vBox, 500, 500));
        stage.setResizable(true); // resizable canvas
        // MAKE CANVAS RESIZABLE
        VBox.setVgrow(canvas, Priority.ALWAYS);
        canvas.widthProperty().bind(vBox.widthProperty());
        canvas.heightProperty().bind(vBox.heightProperty().subtract(100));
        // ---------------------
        stage.show();
    }

    // CREATE BUTTONS
    // Displays a choicebox button that allows user to select tool and a colorpicker
    public HBox getHBox1(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        //---- ADD TOOL SELECTION BUTTON ----
        // new instance of drawingTool choicebox
        drawingTool DrawingTool = new drawingTool(canvas);
        ChoiceBox<String> choiceBox = DrawingTool.getChoiceBox();

        // ---- ADD COLORPICKER BUTTON ----
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setOnAction(e -> {
            DrawingTool.toolSelect(canvas, colorPicker.getValue());
            graphicsContext.setStroke(colorPicker.getValue());
        });

        // Displays both buttons side by side
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(choiceBox, colorPicker);
        hBox.setStyle("-fx-border-color: pink; -fx-padding: 5;");
        return hBox;
    }


    // launch application
    public static void main(String[] args) {
        launch(args);
    }
}
