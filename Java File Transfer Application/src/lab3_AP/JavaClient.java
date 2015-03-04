package lab3_AP;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class JavaClient {

	  public static void main (String [] args ) throws IOException {
		
	  }
	  
	  public static void recieveFile(int SOCKET_PORT, String SERVER, String FILE_TO_RECEIVED ) throws IOException{
		  int FILE_SIZE = 6022386;
			int bytesRead;
		    int current = 0;
		    FileOutputStream fos = null;
		    BufferedOutputStream bos = null;
		    Socket sock = null;
		    try {
		      sock = new Socket(SERVER, SOCKET_PORT);
		      System.out.println("Connecting...");

		      // receive file
		      byte [] mybytearray  = new byte [FILE_SIZE];
		      InputStream is = sock.getInputStream();
		      fos = new FileOutputStream(FILE_TO_RECEIVED);
		      bos = new BufferedOutputStream(fos);
		      bytesRead = is.read(mybytearray,0,mybytearray.length);
		      current = bytesRead;

		      do {
		         bytesRead = is.read(mybytearray, 0, mybytearray.length);
		         if(bytesRead >= 0) current += bytesRead;
		      } while(bytesRead > -1);

		      bos.write(mybytearray, 0 , current);
		      bos.flush();
		      System.out.println("File " + FILE_TO_RECEIVED
		          + " downloaded (" + current + " bytes read)");
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    finally {
		      if (fos != null) 
		    	  fos.close();
		      if (bos != null) 
		    	  bos.close();
		      if (sock != null) 
		    	  sock.close();
		    }
	  }
	
}
