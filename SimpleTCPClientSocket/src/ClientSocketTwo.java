import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientSocketTwo {
	;
	
			   public static void main(String args[]) throws IOException {
				   Socket socket = null;
				   
				   socket = new Socket("localserver", 8000);
				   
				   BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				    String line;
				    
				 char[] buffer = new char[1024];
				 // This will read UP TO 1024 characters from buffer into the
				 // character array, starting at position 0.
				 // This may read less then 1024 characters if the underlying
				 // stream returns -1 indicating and end of stream from
				 // the read method
				 int charsIn = input.read(buffer, 0, 1024);

				 StringBuilder data = new StringBuilder(charsIn);
				 data.append(buffer, 0, charsIn);
				 System.out.println("The data is "+data);
			   }		
	}

