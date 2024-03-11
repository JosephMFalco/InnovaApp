import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import com.fazecast.jSerialComm.*;

public class Dashboard extends Application  {

   private Gauge2 speedometer;
   private Gauge2 flowGauge;
   private Gauge2 gasGauge;
   private FuelFlowRate flowRate;
   private Speed speed;
   private HBox root = new HBox();
   private Scene scene;

   public static void main(String[] args) {
      
      launch(args);     
      
   }
   
   @Override
   public void start(Stage primaryStage) {
      
      double width = 800;
      double height = 800;
      double speed = 0;
      
      speedometer = new Gauge2(200, 100, 60, "Speed");
      flowGauge = new Gauge2(200, 100, 60, "Flow");
      gasGauge = new Gauge2(200, 100, 60, "Gas", true);
      
      root.getChildren().addAll(speedometer.getCanvas(), flowGauge.getCanvas(), gasGauge.getCanvas());
      scene = new Scene(root, width, height);
      
      primaryStage.setTitle("DashBoard");
      primaryStage.setScene(scene);
      primaryStage.show();
      
      Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300), event -> {
            // Update speed and needle
            speedometer.updateNeedle(speedometer.getMeasuredAmount() + 0.5);
            gasGauge.updateNeedle(gasGauge.getMeasuredAmount() - 0.5);
            
      }));
      
      timeline.setCycleCount(100); // Set the number of iterations
      timeline.play();
   
   }
   
}
   