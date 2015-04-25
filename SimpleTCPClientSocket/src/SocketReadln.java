import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.CharBuffer;


public class SocketReadln {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] cbuf = new char[20480];
		CharBuffer target = null;
			      try {
			         Socket skt = new Socket("localhost", 8000);
			         System.out.println("Is the socket connected?:"+skt.isConnected());
			         System.out.println("Is the socket port?:"+skt.getPort());
			         System.out.println("Is the socket send buffer size?:"+skt.getSendBufferSize());
			         System.out.println("Is the socket bound ?:"+skt.isBound());
			         System.out.println("Is the socket recieve buffer size?:"+skt.getReceiveBufferSize());
			         System.out.println("Is the socket toString ?:"+skt.toString());
			         int x =0;
			         while (x<10) {
			        	 System.out.println("In While Loop");
			        	 BufferedReader in = new BufferedReader(new
						            InputStreamReader(skt.getInputStream())); 
			        	 System.out.println("Other side of while loop");
			        	
			        	 in.read(target);
			         System.out.println("Length of cbuf is: "+cbuf.length); // Read one line and output it
			         System.out.print("'\n");
			         in.close();
			         x++;
			         }
			         skt.close();
			      }
			      catch(Exception e) {
			         System.out.print("Whoops! It didn't work!\n");
			      }
			      
			   }
	
	}


