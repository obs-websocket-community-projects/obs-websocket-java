package net.twasi.obsremotejava.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.objects.Scene;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test should be run manually, following the prompts in the command-line and
 * observing OBS for the desired behavior. Authentication should be disabled.
 */
public class ObsRemoteE2eIT {

  static OBSRemoteController remote;

  BlockingQueue resultQueue = new LinkedBlockingQueue();

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
    resultQueue.clear();
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
  void getScenes() {

    remote.getScenes(capturingConsumer);

    waitMs(50);

    GetSceneListResponse res = (GetSceneListResponse)resultQueue.remove();
    assertThat(res.getScenes().size()).isEqualTo(3);

    Scene scene1 = res.getScenes().get(0);
    assertThat(scene1.getSources().size()).isEqualTo(5);
    assertThat(scene1.getSourcesIncludingGroupChildren().size()).isEqualTo(6);

    Scene emptyScene = res.getScenes().get(2);
    assertThat(emptyScene.getSources().size()).isZero();

  }

  // Private Test Helpers

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

  void waitMs(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  Consumer capturingConsumer = (obj) -> {
    System.out.println("Received response: " + obj + "(" + obj.getClass().getSimpleName() + ")");
    resultQueue.add(obj);
  };

}
