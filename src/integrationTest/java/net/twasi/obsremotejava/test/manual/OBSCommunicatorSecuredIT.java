package net.twasi.obsremotejava.test.manual;

import net.twasi.obsremotejava.OBSCommunicator;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Read comment instructions before each test
 */
class OBSCommunicatorSecuredIT {

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
        WebSocketClient client = new WebSocketClient();
        OBSCommunicator obsCommunicator = new OBSCommunicator(true, null);

        AtomicReference<String> testFailedReason = new AtomicReference<>();
        AtomicReference<String> connectionFailedResult = new AtomicReference<>();

        try {
            client.start();

            URI echoUri = new URI(obsAddress);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(obsCommunicator, echoUri, request);
            System.out.printf("(Test) Connecting to : %s%n", echoUri);

            connection.get();

            obsCommunicator.registerOnDisconnect(() -> System.out.println("Disconnected"));

            obsCommunicator.registerOnConnect(response -> {
                testFailedReason.set("Connected without a password to secured server");
                closeConnectionAndStopClient(client, obsCommunicator);
            });

            obsCommunicator.registerOnConnectionFailed(message -> {
                connectionFailedResult.set(message);
                closeConnectionAndStopClient(client, obsCommunicator);
            });

            obsCommunicator.await();

        } finally {
            closeConnectionAndStopClient(client, obsCommunicator);
        }

        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }

        assertEquals("Authentication required by server but no password set by client",
                     connectionFailedResult.get());
    }

    /**
     * Before running this test:
     * - Start OBS locally
     * - Enable websocket authentication
     * - Run test
     */
    @Test
    void testConnectToSecuredServerWithInCorrectPassword() throws Exception {
        String websocketPassword = obsPassword + "giberish";

        WebSocketClient client = new WebSocketClient();
        OBSCommunicator connector = new OBSCommunicator(true, websocketPassword);

        AtomicReference<String> testFailedReason = new AtomicReference<>();
        AtomicReference<String> connectionFailedResult = new AtomicReference<>();

        try {
            client.start();

            URI echoUri = new URI(obsAddress);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(connector, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);

            connection.get();

            connector.registerOnDisconnect(() -> System.out.println("Disconnected"));

            connector.registerOnConnect(response -> {
                testFailedReason.set("Connected with an incorrect password to secured server");
                closeConnectionAndStopClient(client, connector);
            });

            connector.registerOnConnectionFailed(message -> {
                connectionFailedResult.set(message);
                closeConnectionAndStopClient(client, connector);
            });

            connector.await();

        } finally {
            closeConnectionAndStopClient(client, connector);
        }

        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }

        assertEquals("Failed to authenticate with password. Error: Authentication Failed.",
                     connectionFailedResult.get());
    }

    /**
     * Before running this test:
     * - Start OBS locally
     * - Enable websocket authentication
     * - Set password to 'password'
     * - Run test
     */
    @Test
    void testConnectToSecuredServerWithCorrectPassword() throws Exception {

        AtomicReference<String> testFailedReason = new AtomicReference<>();
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
        communicator.registerOnError((message, throwable) -> {
            testFailedReason.set("(Test) Connection failed:" + message);
            closeConnectionAndStopClient(client, communicator);
        });

        // When we connect to OBS
        try {
            client.start();
            URI echoUri = new URI(obsAddress);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(communicator, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);
            System.out.println("Connected at " + connection.get().getRemoteAddress());
            communicator.await();
        } finally {
            closeConnectionAndStopClient(client, communicator);
        }

        // Then there should be no errors
        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }
        // And the client should have been identified
        if (!connectorIdentified.get()) {
            fail("Did not successfully identify the communicator");
        }
    }

    @Test
    void testBadNetworkConnection() {
        fail("to do");
    }

    private void closeConnectionAndStopClient(WebSocketClient client, OBSCommunicator connector) {
        // wait for closed socket connection
        try {
            System.out.println("Closing connection");
            connector.awaitClose(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!client.isStopped() && !client.isStopping()) {
            try {
                System.out.println("Stopping client");
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
