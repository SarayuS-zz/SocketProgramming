import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.socketprogramming.HelloClient;

@RunWith(JUnit4.class)
public class TestCase {

	@Test
	public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
	    HelloClient client = new HelloClient();
	    client.communicate("127.0.0.1", 7777);
	    String response = client.sendMessage("Hello to server");
	    assertEquals("Hello client", response);
	}

}