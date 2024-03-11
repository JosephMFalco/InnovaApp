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

public class Gauge {
   
   private double radius = 100;
   private double centerX;
   private double centerY;
   private double startX;
   private double startY;
   private double endX;
   private double endY;
   private double measuredAmount = 0;
   private double maxAmount;
   private double angle = 180;
   private double anglePerUnit;
   private VBox root;
   private Line needle;
   private Label Label;
   private Label nameLabel;

   
   
   public Gauge(double y, double x, double maxAmount, String name) { 
   
      centerX = x;
      centerY = y;
      anglePerUnit = 180 / maxAmount;
      
      Circle outerCircle = new Circle(centerX, centerY, radius);
      outerCircle.setFill(null);
      outerCircle.setStroke(Color.BLACK);
      
      for (int i = 0; i < 360; i += 10) {
         
         startX = centerX + radius * Math.cos(Math.toRadians(i));
         startY = centerY + radius * Math.sin(Math.toRadians(i));
         endX = centerX + (radius - 10) * Math.cos(Math.toRadians(i));
         endY = centerY + (radius - 10) * Math.sin(Math.toRadians(i));
         
         Line line = new Line(startX, startY, endX, endY);
         line.setStroke(Color.BLACK);
         StackPane.setAlignment(line, Pos.CENTER);
         
      }
      
      needle = new Line(centerX, centerY, centerX, centerY - radius + 20);
      needle.setStroke(Color.RED);
      needle.setStrokeWidth(3);
      
      Label = new Label("0");
      Label.setFont(Font.font(24));
      Label.setTextFill(Color.RED);
      StackPane.setAlignment(Label, Pos.BOTTOM_CENTER);
      
      nameLabel = new Label(name);
      Label.setFont(Font.font(24));
      Label.setTextFill(Color.RED);
      StackPane.setAlignment(nameLabel, Pos.TOP_CENTER);
      
      root = new VBox();
      root.getChildren().addAll(outerCircle, needle, Label);
   
   }
   
   public void updateNeedle(double x) {
      
      measuredAmount = x;
      Label.setText(String.valueOf(measuredAmount));
      needle.setRotate(angle + measuredAmount * anglePerUnit);
     
   }
   
   public VBox getRoot() {
      
      return root;
      
   }
   
   public double getMeasuredAmount() {
   
      return measuredAmount;
   
   }

}
   
   