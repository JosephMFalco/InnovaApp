import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ArduinoConnection {

   public static void main(String[] args) {
   
      SerialPort[] ports = SerialPort.getCommPorts();
      SerialPort arduinoPort = null;
      
      for (SerialPort port : ports) {
      
         if (port.getDescriptivePortName().contains("COM4")) {
         
            arduinoPort = port;
            break;
         
         }
      
      }
      
      if (arduinoPort != null) {
         
         System.out.println("Found Arduino Port: " + arduinoPort.getDescriptivePortName());
         
         if (arduinoPort.openPort()) {
            
            System.out.println("Port opened successfully.");
            
            arduinoPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 5000, 0);
            
            try {
               
               InputStream inputStream = arduinoPort.getInputStream();
               OutputStream outputStream = arduinoPort.getOutputStream();
               
               String message = "Hello Arduino!";
               outputStream.write(message.getBytes());
               outputStream.flush();
               
               byte[] buffer = new byte[1024];
               int bytesRead;
               
               StringBuilder response = new StringBuilder();
               
               while ((bytesRead = inputStream.read(buffer)) != -1) {
                  
                  response.append(new String(buffer, 0, bytesRead));
               
               }
               
               System.out.println("Arduino response: " + response.toString());
               
               inputStream.close();
               outputStream.close();
            
            } catch (IOException e) {
            
               e.printStackTrace();
            
            }
            
            arduinoPort.closePort();
            System.out.println("Port closed.");
         
         } else {
            
            System.err.println("Failed to open port.");
         
         }
      
      } else {
         
         System.err.println("Arduino port not found.");
      
      }
   
   }

}