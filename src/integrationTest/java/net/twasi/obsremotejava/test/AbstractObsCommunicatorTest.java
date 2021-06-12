package net.twasi.obsremotejava.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import net.twasi.obsremotejava.OBSCommunicator;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class AbstractObsCommunicatorTest {
  protected void closeConnectionAndStopClient(WebSocketClient client, OBSCommunicator connector) {
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

  protected void connectToObs(WebSocketClient client, OBSCommunicator communicator, String obsAddress) {
    try {
      client.start();
      URI echoUri = new URI(obsAddress);
      ClientUpgradeRequest request = new ClientUpgradeRequest();
      Future<Session> connection = client.connect(communicator, echoUri, request);
      System.out.printf("Connecting to : %s%n", echoUri);
      System.out.println("Connected at " + connection.get().getRemoteAddress());
      communicator.await();
    } catch (Exception e) {
      fail("Could not connect to OBS", e);
    } finally {
      closeConnectionAndStopClient(client, communicator);
    }
  }
}
