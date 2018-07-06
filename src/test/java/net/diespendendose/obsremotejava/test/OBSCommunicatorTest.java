package net.diespendendose.obsremotejava.test;

import net.diespendendose.obsremotejava.Callback;
import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.objects.Scene;
import net.diespendendose.obsremotejava.requests.ResponseBase;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

class OBSCommunicatorTest {

    @Test
    void test() {
        String destUri = "ws://localhost:4444";

        WebSocketClient client = new WebSocketClient();
        OBSCommunicator connector = new OBSCommunicator(true);
        try {
            client.start();

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(connector, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);

            // wait for closed socket connection.
            connector.awaitClose(1, TimeUnit.SECONDS);

            /* connector.getScenes(new Callback() {
                @Override
                public void run(ResponseBase response) {
                    System.out.println(response);
                }
            });*/

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
