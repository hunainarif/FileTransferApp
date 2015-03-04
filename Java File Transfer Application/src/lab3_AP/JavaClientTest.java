package lab3_AP;

import java.io.IOException;
import org.junit.Test;

public class JavaClientTest {
	
	  public final static int SOCKET_PORT = 55555;      // you may change this
	  //public final static String SERVER = "172.16.163.235";  // vm ip
	  
	  public final static String SERVER = "127.0.0.1";  // local host
	  public final static String FILE_TO_RECEIVED = "/Users/hunainarif/Desktop/new.txt";  // you may change this
	  
	
	@Test
	public void testMain() throws IOException {
		JavaClient.recieveFile(SOCKET_PORT, SERVER, FILE_TO_RECEIVED);
	}

}
