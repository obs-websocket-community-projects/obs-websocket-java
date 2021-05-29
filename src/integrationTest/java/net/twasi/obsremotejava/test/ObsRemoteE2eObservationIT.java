package net.twasi.obsremotejava.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.objects.Scene;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test should be run manually, following the prompts in the command-line and
 * observing OBS for the desired behavior. Authentication should be disabled.
 */
public class ObsRemoteE2eObservationIT {

  static OBSRemoteController remote;

  @BeforeAll
  static void beforeAll() {

    // Connect
    remote = new OBSRemoteController("ws://localhost:4444", false);
    remote.registerConnectionFailedCallback(message -> {
      fail("Failed to connect to OBS: " + message);
    });
    remote.registerOnError((message, throwable) -> {
      fail("Failed to connect to OBS due to error: " + message);
    });
    remote.connect();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @BeforeEach
  public void beforeEach() {
    System.out.println("===============================");
    System.out.println(">> Resetting...");
    setupObs();
    System.out.println(">> ...Ready");
  }

  @AfterAll
  static void afterAll() {
    remote.disconnect();
    System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Debug");
  }

  @AfterEach
  public void afterEach() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("<< Test Complete");

  }

  @Test
  void switchScene() {
    obsShould("Switch to scene2");
    remote.changeSceneWithTransition("scene2", "Cut", loggingConsumer);
  }

  @Test
  void showHideSceneItem() {
    obsShould("Show the red square");
    remote.setSourceVisibility(null, "red_square", true, loggingConsumer);
    obsShould("Hide the red square");
    remote.setSourceVisibility(null, "red_square", false, loggingConsumer);
  }

  @Test
  void setTransition() {
    obsShould("Set current transition to Slide, with transition 2000ms");
    remote.setCurrentTransition("Slide", loggingConsumer);
    remote.setTransitionDuration(2000, loggingConsumer);
    obsShould("Set current transition back to 300ms");
    remote.setTransitionDuration(300, loggingConsumer);
    obsShould("Set current transition back to Cut");
    remote.setCurrentTransition("Cut", loggingConsumer);
  }

  @Test
  void changeScenesWithTransition() {
    obsShould("Change to scene2, with the Slide transition");
    remote.changeSceneWithTransition("scene2", "Slide", loggingConsumer);
  }

  @Test
  void setSourceFilterVisibility() {

    obsShould("Show a blue square (red square colored blue by a filter)");
    remote.setSourceVisibility(null, "red_square", true, loggingConsumer);
    remote.setSourceFilterVisibility("red_square", "Color Correction", true, loggingConsumer);
    obsShould("Return the red square to normal");
    remote.setSourceFilterVisibility("red_square", "Color Correction", false, loggingConsumer);

  }

  @Test
  void exerciseStudioMode() {
    obsShould("Enable studio mode");
    remote.setStudioModeEnabled(true, loggingConsumer);
    obsShould("Set preview scene to scene2");
    remote.setPreviewScene("scene2", loggingConsumer);
    obsShould("Fade to scene2");
    remote.transitionToProgram("Fade", 1500, loggingConsumer);
    obsShould("Disable studio mode");
    remote.setStudioModeEnabled(false, loggingConsumer);

  }

  @Test
  void setSourceSettings() {
    obsShould("Curse the 'scene1' text");
    Map<String, Object> settings = new HashMap<>();
    settings.put("text", "S̼͚̞̼̩̱̽̓̍̽͊́ͨ̍̀ċͭ̚҉̪̖̤̥ͅȩ͉̣̜̖̖͙͇́̀̒ͥ̓̚͠͞n̦͍͆͑ͤ̕e̶̖̝̗̻͂̑̽̔ͩ̅́͜ͅ ̢͉̬͔͙̺̖͂͂ͣ͢1̮̥͇̏̇͋̈́ͨͥ͝ͅ");
    remote.setSourceSettings("scenename1", settings, loggingConsumer);
    obsShould("Change the 'scene1' text back to normal");
    settings.put("text", "Scene 1");
    remote.setSourceSettings("scenename1", settings, loggingConsumer);
  }

  @Test
  void takeSourceScreenshot() throws Exception {
    String path = System.getProperty("user.home");
    assertThat(path).isNotNull();
    File file = new File(path, "test.png");
    String screenshotPath = file.getAbsolutePath();
    obsShould("Take a screenshot of the current scene, and save it to " + screenshotPath, 1);
    remote.takeSourceScreenshot(
      "scene1", "png",
      screenshotPath,
      null, 1,
      1080, 720,
      loggingConsumer
    );
  }

  @Test
  void startStopStreaming() {
    obsShould("Start Streaming");
    remote.startStreaming(loggingConsumer);
    obsShould("Stop Streaming");
    remote.stopStreaming(loggingConsumer);
  }

  @Test
  void startStopRecordingAndReplayBuffer() {
    obsShould("Start Recording");
    remote.startRecording(loggingConsumer);

    obsShould("Start the replay buffer");
    remote.startReplayBuffer(loggingConsumer);

    obsShould("Save the replay buffer");
    remote.saveReplayBuffer(loggingConsumer);

    obsShould("Stop the replay buffer");
    remote.stopReplayBuffer(loggingConsumer);

    obsShould("Stop Recording");
    remote.stopRecording(loggingConsumer);
  }

  @Test
  void setVolumeAndMute() {

    obsShould("Set the volume to 50% (note, appears 67% due to log scaling; check % in advanced audio properties)");
    remote.setSourceVisibility(null, "media", true, loggingConsumer);
    remote.setVolume("media", 0.50, loggingConsumer);
    obsShould("Mute the volume");
    remote.setMute("media", true, loggingConsumer);
    obsShould("Unmute the volume");
    remote.setMute("media", false, loggingConsumer);
    obsShould("Set the volume to 100%");
    remote.setVolume("media", 1.00, loggingConsumer);

  }

  // Private Test Helpers
  private void obsShould(String expected) {
    obsShould(expected, 3);
  }

  private void obsShould(String expected, int secondsTimeout) {
    System.out.println(">>> OBS SHOULD: " + expected);
    countDownFrom(secondsTimeout);
  }

  private void countDownFrom(int seconds) {
    for(int i = seconds; i > 0; i--) {
      System.out.println("> " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void setupObs() {

    // Cleanup all scenes
    cleanupScenes();

    // Change back to base scene
    remote.changeSceneWithTransition("scene1", "Cut", result -> {
      if(result.getError() != null && !result.getError().isEmpty()) {
        fail("Failed to switch to base scene");
      }
    });
  }

  private void cleanupScenes() {
    // Hide all visible elements in all scenes
    remote.getScenes(sceneListResponse -> {
      sceneListResponse.getScenes().forEach(scene -> {
        scene.getSources().forEach(source -> {
          if(!source.getName().startsWith("scenename")) {
            remote.setSourceVisibility(scene.getName(), source.getName(), false, result -> {
              if(result.getError() != null && !result.getError().isEmpty()) {
                fail(String.format("Failed to hide source '%s' on scene '%s'", source.getName(), scene.getName()));
              }
            });
          }
        });
      });
    });
  }

  Consumer loggingConsumer = (obj) -> {
    System.out.println("Received response: " + obj);
  };

}
