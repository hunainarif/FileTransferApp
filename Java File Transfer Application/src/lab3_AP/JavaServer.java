package lab3_AP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {

	
	  public static void main (String [] args ) throws IOException {
	  }

	  public static void sendFile(int SOCKET_PORT, String FILE_TO_SEND) throws IOException{
		  FileInputStream fis = null;
		    BufferedInputStream bis = null;
		    OutputStream os = null;
		    ServerSocket servsock = null;
		    Socket sock = null;
		    try {
		      servsock = new ServerSocket();
		      servsock.setReuseAddress(false);
		      servsock.bind(new InetSocketAddress(SOCKET_PORT));
		      
		        System.out.println("Waiting...");
		       
		          sock = servsock.accept();
		          System.out.println("Accepted connection : " + sock);
		          // send file
		          File myFile = new File (FILE_TO_SEND);
		          byte [] mybytearray  = new byte [(int)myFile.length()];
		          fis = new FileInputStream(myFile);
		          bis = new BufferedInputStream(fis);
		          bis.read(mybytearray,0,mybytearray.length);
		          os = sock.getOutputStream();
		          System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
		          os.write(mybytearray,0,mybytearray.length);
		          os.flush();
		          System.out.println("Done.");
		       
		          if (bis != null) 
		        	  bis.close();
		          if (os != null) 
		        	  os.close();
		          if (sock!=null) 
		        	  sock.close();
		      
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    finally {
		      if (servsock != null) 
		    	  servsock.close();
		    }
		    
		  
	  }
}
