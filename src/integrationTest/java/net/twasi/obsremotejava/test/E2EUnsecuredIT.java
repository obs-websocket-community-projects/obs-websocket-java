package net.twasi.obsremotejava.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import net.twasi.obsremotejava.OBSRemoteController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * This test should be run manually, following the prompts in the command-line and
 * observing OBS for the desired behavior. Authentication should be disabled.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class E2EUnsecuredIT {

  OBSRemoteController remote;

  @BeforeAll
  public void beforeAll() {

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
  public void afterAll() {
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
    remote.changeSceneWithTransition("scene2", "Cut", res -> {});
  }

  @Test
  void showHideSceneItem() {
    obsShould("Show the red square");
    remote.setSourceVisibility(null, "red_square", true, res -> {});
    obsShould("Hide the red square");
    remote.setSourceVisibility(null, "red_square", false, res -> {});
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

  private interface EachTickCallback {
    void run(int i);
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

}
