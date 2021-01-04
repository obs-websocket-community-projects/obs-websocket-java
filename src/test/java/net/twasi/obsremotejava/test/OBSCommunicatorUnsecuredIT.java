package net.twasi.obsremotejava.test;

import net.twasi.obsremotejava.OBSCommunicator;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.fail;

public class OBSCommunicatorUnsecuredIT {
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
        WebSocketClient client = new WebSocketClient();
        OBSCommunicator connector = new OBSCommunicator(true);

        AtomicReference<String> testFailedReason = new AtomicReference<>();

        try {
            client.start();

            URI echoUri = new URI(obsAddress);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(connector, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);

            connector.registerOnDisconnect(() -> System.out.println("Disconnected"));

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
