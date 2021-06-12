package net.twasi.obsremotejava.test.manual;

import net.twasi.obsremotejava.OBSRemoteController;
import org.junit.jupiter.api.Test;

public class CallbackObservationTest {

  private final String obsAddress = "ws://localhost:4444";
  private final String obsPassword = null;

  @Test
  void test() {
    final OBSRemoteController controller = new OBSRemoteController(obsAddress, false, null);

    if (controller.isFailed()) {
      System.out.println("UPS DAS GET NET HÜLFEEE!");
    }

    controller.registerDisconnectCallback(() -> System.out.println("Disconnected"));

    controller.registerConnectCallback(response -> {
      System.out.println("Connected!");
//      System.out.println(response.getObsStudioVersion());

      controller.registerReplayStartedCallback(event -> System.out.println("Replay started"));

      controller.registerReplayStartingCallback(event -> System.out.println("Replay starting"));

      controller.registerReplayStoppedCallback(event -> System.out.println("Replay stopped"));

      controller.registerReplayStoppingCallback(event -> System.out.println("Replay stopping"));

      controller.startReplayBuffer(res -> System.out.println("Should start replay buffer"));

      controller.saveReplayBuffer(res -> System.out.println("Should save replay buffer"));

      controller.stopReplayBuffer(res -> System.out.println("Should stop replay buffer"));

      controller.registerSwitchScenesCallback(event -> System.out.println("Switched to scene: " + event.getEventData().getSceneName()));

      controller.registerScenesChangedCallback(event -> System.out.println("Scenes changed"));

      controller.registerSwitchTransitionCallback(event -> System.out.println("Switched active transition to: " + event.getEventData().getTransitionName()));

      controller.registerTransitionListChangedCallback(event -> System.out.println("Transition list changed"));

      controller.registerTransitionBeginCallback(event -> System.out.println("Transition started from scene: '" + event.getEventData().getFromScene() + "' to scene: '" + event.getEventData().getToScene() + "'"));

      controller.registerTransitionEndCallback(event -> System.out.println("Transition ended with scene: " + event.getEventData().getToScene()));

      controller.registerSourceFilterVisibilityChangedCallback(event -> System.out.println(String.format(
        "Source Filter visibility changed on filter '%s' in source '%s'", event.getEventData().getFilterName(), event.getEventData().getSourceName()
      )));

      controller.registerPreviewSceneChangesCallback(event -> System.out.println("Preview Scene changed to: " + event.getEventData().getSceneName()));

      controller.registerStreamStartedCallback(event -> System.out.println("Stream Started"));

      controller.registerStreamStoppedCallback(event -> System.out.println("Stream Stopped"));

      controller.registerRecordingStartedCallback(event -> System.out.println("Recording Started"));

      controller.registerRecordingStoppedCallback(event -> System.out.println("Recording Stopped"));

      controller.registerOnMediaPlaying(event -> System.out.println("Media Playing source: " + event.getEventData().getSourceName()));

      controller.registerOnMediaPaused(event-> System.out.println("Media Paused source: " + event.getEventData().getSourceName()));

      controller.registerOnMediaRestarted(event-> System.out.println("Media Restarted source: " + event.getEventData().getSourceName()));

      controller.registerOnMediaStopped(event-> System.out.println("Media Stopped source: " + event.getEventData().getSourceName()));

      controller.registerOnMediaNext(event-> System.out.println("Media Next source: " + event.getEventData().getSourceName()));

      controller.registerOnMediaPrevious(event-> System.out.println("Media Previous source: " + event.getEventData().getSourceName()));

      controller.registerOnMediaStarted(event-> System.out.println("Media Started source: " + event.getEventData().getSourceName()));

      controller.registerOnMediaEnded(event-> System.out.println("Media Ended source: " + event.getEventData().getSourceName()));

      controller.registerOnSourceVolumeChanged(event-> System.out.println("Volume Changed source: " + event.getEventData().getSourceName()));
    });

    try {
      controller.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
