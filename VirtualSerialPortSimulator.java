import java.io.OutputStream;
import java.io.IOException;

public class VirtualSerialPortSimulator {
    public static void main(String[] args) {
        try {
            // Open output stream to COM3 (Change the port name if needed)
            OutputStream outputStream = new java.io.FileOutputStream("COM3");

            // Write data to the virtual serial port
            String dataToSend = "Hello from COM3!";
            outputStream.write(dataToSend.getBytes());
            outputStream.flush();
            System.out.println("Data sent: " + dataToSend);

            // Close the output stream
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}