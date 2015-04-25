import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//mated to SerSocket.java

public class ClientSocketOne {
	static double gaugeData;
	 static double crossLevelData;
	 static double loadedGaugeData;
	 static double alignmentData;
	 static int distance;

 public static void main(String args[]) throws IOException {
	 
	 			String st = null;	
			     // Open your connection to a server, at port 1254
			     Socket s1 = new Socket("localhost",8000);
			     // Get an input file handle from the socket and read the input
			     InputStream s1In = s1.getInputStream();
			     DataInputStream dis = new DataInputStream(s1In);

			     st = new String (dis.readUTF());			     
			     while (!st.contains("EOF"))		///This is a value I stick in the server data stream at end
			    	 
			     { 	
			    	System.out.println(st);
			     	st = new String (dis.readUTF());
			    	parseSensorData(st);
			     }
			     // When done, just close the connection and exit
			     dis.close();
			     s1In.close();
			     s1.close();
 }

 public static void parseSensorData(String message) {
	 	System.out.println("parseSensorData :"+message);
	    String[] parts = message.split(",");

	    gaugeData = Double.parseDouble(parts[0]);
	    loadedGaugeData = Double.parseDouble(parts[1]);
	    crossLevelData = Double.parseDouble(parts[2]);
	    alignmentData = Double.parseDouble(parts[3]);
	    distance = Integer.parseInt(parts[4]);
	    System.out.println("gaugeData is :"+gaugeData);
	    System.out.println("loadedGaugeData is :"+loadedGaugeData);
	    System.out.println("crossLevelData is :"+crossLevelData);
	    System.out.println("alignmentData is :"+alignmentData);
	    System.out.println("distance is :  "+distance);
	 
	}


}
