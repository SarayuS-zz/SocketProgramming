import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	@Test
	public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
	    HelloClient client = new HelloClient();
	    client.communicate("127.0.0.1", 7777);
	    String response = client.sendMessage("Hello to server");
	    assertEquals("Hello client", response);
	}

}