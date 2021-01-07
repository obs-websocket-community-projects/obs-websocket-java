package net.twasi.obsremotejava.test;

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
        OBSCommunicator connector = new OBSCommunicator(true, null);

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
                testFailedReason.set("Connected without a password to secured server");
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
     * - Set obsPassword to your OBS websocket's password
     * - Run test
     */
    @Test
    void testConnectToSecuredServerWithCorrectPassword() throws Exception {

        WebSocketClient client = new WebSocketClient();
        OBSCommunicator connector = new OBSCommunicator(true, obsPassword);

        AtomicReference<String> testFailedReason = new AtomicReference<>();

        try {
            client.start();

            URI echoUri = new URI(obsAddress);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(connector, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);

            connection.get();

            connector.registerOnDisconnect(() -> System.out.println("Disconnected"));

            connector.registerOnConnect(response -> {
                System.out.println("Connected successfully with password!");
                closeConnectionAndStopClient(client, connector);
            });

            connector.registerOnConnectionFailed(message -> {
                testFailedReason.set("Connection failed:" + message);
                closeConnectionAndStopClient(client, connector);
            });

            connector.await();

        } finally {
            closeConnectionAndStopClient(client, connector);
        }

        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }
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
