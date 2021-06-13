package net.twasi.obsremotejava.test.manual;

import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.message.event.Event.Category;
import org.junit.jupiter.api.Test;

public class CallbackObservationTest {

//  private final String obsAddress = "ws://localhost:4444";
  private final String host = "localhost";
  private final int port = 4444;
  private final String obsPassword = null;

  @Test
  void test() {
//    final OBSRemoteController controller = new OBSRemoteController(obsAddress, false, null);
    final OBSRemoteController controller = OBSRemoteController.builder()
      .host(host)
      .port(port)
      .password(obsPassword)
      .autoConnect(true)
      .eventSubscription(Category.All)
      .build();

    if (controller.isFailed()) {
      System.out.println("UPS DAS GET NET HÜLFEEE!");
    }

    controller.registerDisconnectCallback(() -> System.out.println("Disconnected"));

    controller.registerConnectCallback(response -> {
      System.out.println("Connected!");
//      System.out.println(response.getObsStudioVersion());

      controller.registerReplayBufferStateChanged(event -> System.out.println("Replay state changed: " + event));

//      controller.startReplayBuffer(res -> System.out.println("Should start replay buffer"));
//
//      controller.saveReplayBuffer(res -> System.out.println("Should save replay buffer"));
//
//      controller.stopReplayBuffer(res -> System.out.println("Should stop replay buffer"));

      controller.registerCurrentSceneChanged(event -> System.out.println("Current Scene Changed: " + event));

      controller.registerCurrentPreviewSceneChanged(event -> System.out.println("Preview Scene changed to: " + event.getEventData().getSceneName()));

      controller.registerStreamStateChanged(event -> System.out.println("Stream State Changed: " + event));

      controller.registerRecordStateChanged(event -> System.out.println("Record State Changed: " + event));

      controller.registerMediaInputActionTriggered(event -> System.out.println("Media Input Action Triggered: " + event));

      controller.registerOnInputVolumeChanged(event-> System.out.println("Volume Changed source: " + event));
    });

    try {
      controller.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
