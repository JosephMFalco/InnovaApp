import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SpeedGauge extends Application {

    @Override
    public void start(Stage primaryStage) {
        double width = 300;
        double height = 300;
        double radius = 100;
        double centerX = width / 2;
        double centerY = height / 2;

        // Create outer circle representing gauge border
        Circle outerCircle = new Circle(centerX, centerY, radius);
        outerCircle.setFill(null);
        outerCircle.setStroke(Color.BLACK);

        // Create lines for gauge divisions
        for (int i = 0; i < 360; i += 10) {
            double startX = centerX + radius * Math.cos(Math.toRadians(i));
            double startY = centerY + radius * Math.sin(Math.toRadians(i));
            double endX = centerX + (radius - 10) * Math.cos(Math.toRadians(i));
            double endY = centerY + (radius - 10) * Math.sin(Math.toRadians(i));
            Line line = new Line(startX, startY, endX, endY);
            line.setStroke(Color.BLACK);
            StackPane.setAlignment(line, Pos.CENTER);
        }

        // Create needle
        Line needle = new Line(centerX, centerY, centerX, centerY - radius + 20);
        needle.setStroke(Color.RED);
        needle.setStrokeWidth(3);

        // Create label to display speed
        Label speedLabel = new Label("0");
        speedLabel.setFont(Font.font(24));
        speedLabel.setTextFill(Color.RED);
        StackPane.setAlignment(speedLabel, Pos.BOTTOM_CENTER);

        // Create layout
        StackPane root = new StackPane();
        root.getChildren().addAll(outerCircle, needle, speedLabel);

        // Update needle position (simulate speed)
        double speed = 0; // Speed value (0-100)
        double maxSpeed = 100; // Maximum speed
        double angle = 180; // Starting angle for needle (0° is top, 180° is bottom)
        double anglePerUnit = 180 / maxSpeed; // Angle per unit of speed

        // Update needle position based on speed value
        speedLabel.setText(String.valueOf(speed));
        needle.setRotate(angle + speed * anglePerUnit);

        // Create scene
        Scene scene = new Scene(root, width, height);
        primaryStage.setTitle("Speed Gauge");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
