package net.twasi.obsremotejava.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.atomic.AtomicReference;
import net.twasi.obsremotejava.OBSCommunicator;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.Test;

public class OBSCommunicatorUnsecuredIT extends AbstractObsCommunicatorTest {
    /**
     * - Set these two values before running these tests
     * - Make sure your OBS is running and available for connection
     */
    private final String obsAddress = "ws://localhost:4444";
    private final String obsPassword = null;

    /**
     * Before running this test:
     * - Start OBS locally
     * - Disable websocket authentication
     * - Run test
     */
    @Test
    void testConnectToUnsecureServerWithoutPassword() throws Exception {
        AtomicReference<String> testFailedReason = new AtomicReference<>();
        AtomicReference<Boolean> connectorIdentified = new AtomicReference<>(false);

        // Given we have a websocket client and annotated websocket communicator, with no password
        WebSocketClient client = new WebSocketClient();
        OBSCommunicator communicator = OBSCommunicator.builder()
          .password(null)
          // And given we have registered callbacks to disconnect once connected & identified
          .lifecycle()
            .onIdentified((comm, identified) -> {
                System.out.println("(Test) Authenticated successfully");
                connectorIdentified.set(true);
                closeConnectionAndStopClient(client, comm);
            })
            .onError((message, throwable) -> {
                testFailedReason.set("(Test) Connection failed:" + message);
//                closeConnectionAndStopClient(client, communicator);
            })
          .and()
          .build();


        // When we connect to OBS
        connectToObs(client, communicator, obsAddress);

        // Then there should be no errors
        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }
        // And the client should have been identified
        if (!connectorIdentified.get()) {
            fail("Did not successfully identify the communicator");
        }

    }

}
