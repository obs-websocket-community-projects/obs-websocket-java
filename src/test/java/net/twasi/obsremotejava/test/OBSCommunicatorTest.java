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
class OBSCommunicatorTest {

    /**
     * Before running this test:
     * - Start OBS locally
     * - Disable websocket authentication
     * - Run test
     */
    @Test
    void testConnectToUnsecureServerWithoutPassword() throws Exception {
        String destUri = "ws://localhost:4444";

        WebSocketClient client = new WebSocketClient();
        OBSCommunicator connector = new OBSCommunicator(true);

        AtomicReference<String> testFailedReason = new AtomicReference<>();

        try {
            client.start();

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(connector, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);

            connector.registerOnDisconnect(response -> System.out.println("Disconnected"));

            connector.registerOnConnect(response -> {
                System.out.println("Connected successfully without password!");
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

    /**
     * Before running this test:
     * - Start OBS locally
     * - Enable websocket authentication
     * - Run test
     */
    @Test
    void testConnectToSecuredServerWithoutPassword() throws Exception {
        String destUri = "ws://localhost:4444";
        String websocketPassword = null;

        WebSocketClient client = new WebSocketClient();
        OBSCommunicator connector = new OBSCommunicator(true, websocketPassword);

        AtomicReference<String> testFailedReason = new AtomicReference<>();
        AtomicReference<String> connectionFailedResult = new AtomicReference<>();

        try {
            client.start();

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(connector, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);

            connection.get();

            connector.registerOnDisconnect(response -> System.out.println("Disconnected"));

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

        assertEquals("Authentication required by server but no password set for client",
                     connectionFailedResult.get());
    }

    /**
     * Before running this test:
     * - Start OBS locally
     * - Enable websocket authentication
     * - Make sure websocket password doesn't match websocketPassword below
     * - Run test
     */
    @Test
    void testConnectToSecuredServerWithInCorrectPassword() throws Exception {
        String destUri = "ws://localhost:4444";
        String websocketPassword = "this-is-an-incorrect-password";

        WebSocketClient client = new WebSocketClient();
        OBSCommunicator connector = new OBSCommunicator(true, websocketPassword);

        AtomicReference<String> testFailedReason = new AtomicReference<>();
        AtomicReference<String> connectionFailedResult = new AtomicReference<>();

        try {
            client.start();

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(connector, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);

            connection.get();

            connector.registerOnDisconnect(response -> System.out.println("Disconnected"));

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
     * - Set websocket password to "password" or edit websocketPassword below to correct password
     * - Run test
     */
    @Test
    void testConnectToSecuredServerWithCorrectPassword() throws Exception {
        String destUri = "ws://localhost:4444";
        String websocketPassword = "password";

        WebSocketClient client = new WebSocketClient();
        OBSCommunicator connector = new OBSCommunicator(true, websocketPassword);

        AtomicReference<String> testFailedReason = new AtomicReference<>();

        try {
            client.start();

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(connector, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);

            connection.get();

            connector.registerOnDisconnect(response -> System.out.println("Disconnected"));

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
