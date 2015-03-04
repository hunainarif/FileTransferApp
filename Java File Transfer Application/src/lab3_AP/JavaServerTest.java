package lab3_AP;

import java.io.IOException;
import org.junit.Test;

public class JavaServerTest {
	
	public final static int SOCKET_PORT = 55556;  // you may change this
	public final static String FILE_TO_SEND = "/Users/hunainarif/Desktop/float.txt";  // you may change this


	@Test
	public void testMain() throws IOException {
		JavaServer.sendFile(SOCKET_PORT, FILE_TO_SEND);
	}

}
