import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class socketbyte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] messageByte = new byte[1000];
		int bytesRead=0;
		boolean end = false;
		String messageString = "";
		Socket clientSocket = null;
		try {
			clientSocket = new Socket("localhost", 8000);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try 
		{
		    DataInputStream in = new DataInputStream(clientSocket.getInputStream());

		    while(!end)
		    {System.out.println("In While Loop");
		        bytesRead = in.read(messageByte);
		        System.out.println("After Read");
		        messageString += new String(messageByte, 0, bytesRead);
		        if (messageString.length() == 100)
		        {
		            end = true;
		        }
		    }
		    System.out.println("MESSAGE: " + messageString);
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
	}

}
