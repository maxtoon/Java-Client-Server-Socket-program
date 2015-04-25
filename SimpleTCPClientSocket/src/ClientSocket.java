import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;


public class ClientSocket {
	private Socket socket = null;
	   private BufferedReader reader = null;
	   private BufferedWriter writer = null;

	   public ClientSocket(InetAddress address, int port) throws IOException
	   {
	      socket = new Socket(address, port);
	      System.out.println("Is the Input Stream Available??:"+socket.getInputStream().available());
	      reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	      
	      writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	   }

	   public void send(String msg) throws IOException
	   {
	      writer.write(msg, 0, msg.length());
	      writer.flush();
	   }

	   public String recv() throws IOException
	   {
		   StringBuffer sb = new StringBuffer();
		   System.out.println("Is reader ready??:"+reader.ready());
	   //while (reader.ready()) {
		   int y =0;
		   while (y<20){
		    char[] c = new char[] { 1024 };
		    System.out.println("Above Reader    ");
		    reader.read(c);
		    System.out.println("Is reader readybelow:  "+reader.ready());
		    System.out.println("Char is   :"+c+"\n");
		    sb.append(c);
		    y++;
		}
	      //String message=reader.readLine();
	      //return message;
	   return sb.toString();
	   
	   }

	   public static void main(String[] args)
	   {
	      try {
	         InetAddress host = InetAddress.getByName("127.0.0.1");
	         ClientSocket client = new ClientSocket(host, 8000);
	         int x = 0;
	         while(x<10){
	         //client.send("Hello server.\n");
	         String response = client.recv();
	         System.out.println("Client received: " + response);
	         x++;
	      }}
	      catch (IOException e) {
	         System.out.println("Caught Exception: " + e.toString());
	      }
	   }
	
}		
	



   


