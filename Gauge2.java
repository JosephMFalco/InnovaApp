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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;

/*
Programmer: Joseph Falco
Purpose: The gauge class's purpose is to show a given measured value with a rotating needle. 
*/

public class Gauge2 {
   
   private double radius = 100;
   private double centerX;
   private double centerY;
   private double startX;
   private double startY;
   private double endX;
   private double endY;
   private double measuredAmount = 0;
   private double maxAmount;
   private double angle = 95;
   private double anglePerUnit;
   private VBox root;
   private Line needle;
   private Label measuredAmountLabel;
   private Label nameLabel;
   private Pane canvas;
   private Line line;
   
   public Gauge2(double y, double x, double maxAmount, String name, boolean full) { 
   
      centerX = x;
      centerY = y;
      anglePerUnit = 180 / maxAmount;
      canvas = new Pane();
      
      //create circle for analog gauge
      Circle outerCircle = new Circle(centerX, centerY, radius);
      outerCircle.setFill(null);
      outerCircle.setStroke(Color.BLACK);
      
      //create rec to block bottom of gauge
      Rectangle bottomCirc = new Rectangle(centerX-100, centerY, 200, 110);
      //bottomCirc.setFill(Color.WHITE);
      bottomCirc.setStroke(Color.WHITE);
      
      //set gauge needle
      needle = new Line(centerX, centerY+100, centerX, centerY-100);
      needle.setStroke(Color.RED);
      needle.setStrokeWidth(3);
      
      if (full) {
         
         needle.setRotate(265);
         measuredAmount = maxAmount;
      
      }
      
      
      //create gauge number dsiplay
      measuredAmountLabel = new Label("0");
      measuredAmountLabel.setFont(Font.font(24));
      measuredAmountLabel.setTextFill(Color.RED);
      measuredAmountLabel.setLayoutY(centerY+70);
      measuredAmountLabel.setLayoutX(centerX-10);
      
      //create gauge name label
      nameLabel = new Label(name);
      nameLabel.setFont(Font.font(24));
      nameLabel.setTextFill(Color.RED);
      nameLabel.setLayoutY(centerY-130);
      nameLabel.setLayoutX(centerX-20);
      
      //add all objects to canvas
      canvas.getChildren().add(outerCircle);
      canvas.getChildren().add(needle);
      canvas.getChildren().add(bottomCirc);
      canvas.getChildren().add(measuredAmountLabel);
      canvas.getChildren().add(nameLabel);
   
   }
   
   public Gauge2(double y, double x, double maxAmount, String name) { 
   
      centerX = x;
      centerY = y;
      anglePerUnit = 180 / maxAmount;
      canvas = new Pane();
      
      //create circle for analog gauge
      Circle outerCircle = new Circle(centerX, centerY, radius);
      outerCircle.setFill(null);
      outerCircle.setStroke(Color.BLACK);
      
      //create rec to block bottom of gauge
      Rectangle bottomCirc = new Rectangle(centerX-100, centerY, 200, 110);
      bottomCirc.setStroke(Color.WHITE);
      
      //set gauge needle
      needle = new Line(centerX, centerY+100, centerX, centerY-100);
      needle.setStroke(Color.RED);
      needle.setStrokeWidth(3);
      needle.setRotate(angle);
      
      //create gauge number dsiplay
      measuredAmountLabel = new Label("0");
      measuredAmountLabel.setFont(Font.font(24));
      measuredAmountLabel.setTextFill(Color.RED);
      measuredAmountLabel.setLayoutY(centerY+70);
      measuredAmountLabel.setLayoutX(centerX-10);
      
      //create gauge name label
      nameLabel = new Label(name);
      nameLabel.setFont(Font.font(24));
      nameLabel.setTextFill(Color.RED);
      nameLabel.setLayoutY(centerY-130);
      nameLabel.setLayoutX(centerX-20);
      
      //add all objects to canvas
      canvas.getChildren().add(outerCircle);
      canvas.getChildren().add(needle);
      canvas.getChildren().add(bottomCirc);
      canvas.getChildren().add(measuredAmountLabel);
      canvas.getChildren().add(nameLabel);
   
   }
   
   //@return pane
   public Pane getCanvas() {
   
      return canvas;
   
   }
   
   //Update needle's rotation
   //@param gauges measured value
   public void updateNeedle(double x) {
      
      double rotationAngle = (angle + measuredAmount * anglePerUnit);
      
      measuredAmount = x;
      measuredAmountLabel.setText(String.valueOf(measuredAmount));
      
      needle.setRotate(rotationAngle);

   }
   
   //@return the measured value of the gauge
   public double getMeasuredAmount() {
   
      return measuredAmount;
   
   }
  
}
