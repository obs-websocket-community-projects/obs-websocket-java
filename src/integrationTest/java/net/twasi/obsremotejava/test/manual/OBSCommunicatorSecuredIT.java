package net.twasi.obsremotejava.test.manual;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.atomic.AtomicReference;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.test.AbstractObsCommunicatorTest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.Test;

/**
 * Read comment instructions before each test
 */
class OBSCommunicatorSecuredIT extends AbstractObsCommunicatorTest {

    /**
     * - Set these two values before running these tests
     * - Make sure your OBS is running and available for connection
     */
    private final String obsAddress = "ws://localhost:4444";
    private final String obsPassword = "password";

    /**
     * Before running this test:
     * - Start OBS locally
     * - Enable websocket authentication
     * - Run test
     */
    @Test
    void testConnectToSecuredServerWithoutPasswordInvokesConnectionFailedCallback() throws Exception {
        AtomicReference<String> failReason = new AtomicReference<>();
        AtomicReference<Integer> closeCode = new AtomicReference<>();
        AtomicReference<String> closeReason = new AtomicReference<>();

        // Given we have ws client and communicator with no password
        WebSocketClient client = new WebSocketClient();
        OBSCommunicator communicator = OBSCommunicator.builder()
          .password(null)
          .build();

        // Given we register a callback on close
        communicator.registerOnClose((code, reason) -> {
            closeCode.set(code);
            closeReason.set(reason);
        });
        communicator.registerOnHello(hello -> {
            if(hello.getAuthentication() == null) {
                failReason.set("Authentication wasn't enabled");
                closeConnectionAndStopClient(client, communicator);
            }
        });

        // When we connect
        connectToObs(client, communicator, obsAddress);

        // Then authentication was enabled
        if(failReason.get() != null) {
            fail(failReason.get());
        }

        // Then we expect an error
        // Connection closed: 4006 - Your `Identify` payload is missing an `authentication` string, however authentication is required.
        assertThat(closeCode.get()).isEqualTo(4006);
        assertThat(closeReason.get()).containsIgnoringCase("authentication is required");
    }

    /**
     * Before running this test:
     * - Start OBS locally
     * - Enable websocket authentication
     * - Run test
     */
    @Test
    void testConnectToSecuredServerWithInCorrectPassword() throws Exception {
        AtomicReference<String> failReason = new AtomicReference<>();
        AtomicReference<Integer> closeCode = new AtomicReference<>();
        AtomicReference<String> closeReason = new AtomicReference<>();

        // Given we have ws client and communicator with a bad password
        String websocketPassword = obsPassword + "gibberish";

        WebSocketClient client = new WebSocketClient();
        OBSCommunicator communicator = OBSCommunicator.builder()
          .password(websocketPassword)
          .build();

        // Given we register a callback on error
        communicator.registerOnClose((code, reason) -> {
            closeCode.set(code);
            closeReason.set(reason);
        });
        communicator.registerOnHello(hello -> {
            if(hello.getAuthentication() == null) {
                failReason.set("Authentication wasn't enabled");
                closeConnectionAndStopClient(client, communicator);
            }
        });

        // When we connect
        connectToObs(client, communicator, obsAddress);

        // Then authentication was enabled
        if(failReason.get() != null) {
            fail(failReason.get());
        }

        // Then we expect an error
        // Connection closed: 4005 - Authentication failed.
        assertThat(closeCode.get()).isEqualTo(4005);
        assertThat(closeReason.get()).containsIgnoringCase("Authentication failed");

    }

    /**
     * Before running this test:
     * - Start OBS locally
     * - Enable websocket authentication
     * - Set password to 'password'
     * - Run test
     */
    @Test
    void testConnectToSecuredServerWithCorrectPassword() {

        AtomicReference<String> failReason = new AtomicReference<>();
        AtomicReference<Boolean> connectorIdentified = new AtomicReference<>(false);

        // Given we have a websocket client and annotated websocket communicator
        WebSocketClient client = new WebSocketClient();
        OBSCommunicator communicator = OBSCommunicator.builder()
          .password(obsPassword)
          .build();

        // And given we have registered callbacks to disconnect once connected & identified
        communicator.registerOnIdentified(identified -> {
            System.out.println("(Test) Authenticated successfully");
            connectorIdentified.set(true);
            closeConnectionAndStopClient(client, communicator);
        });
        communicator.registerOnHello(hello -> {
            if(hello.getAuthentication() == null) {
                failReason.set("Authentication wasn't enabled");
                closeConnectionAndStopClient(client, communicator);
            }
        });

        // When we connect to OBS
        connectToObs(client, communicator, obsAddress);

        // Then there should be no errors
        if (failReason.get() != null) {
            fail(failReason.get());
        }
        // And the client should have been identified
        if (!connectorIdentified.get()) {
            fail("Did not successfully identify the communicator");
        }
    }

}
