package net.twasi.obsremotejava.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSRemoteController;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractObsE2ETest {

  static OBSRemoteController remote;
  BlockingQueue resultQueue = new LinkedBlockingQueue();

  // Scenes
  final static String SCENE1 = "scene1";
  final static String SCENE2 = "scene2";
  final static String SCENE3 = "emptyscene";

  // Sources
  final static String SOURCE_TEXT_SCENE1 = "scenename1";
  final static String SOURCE_TEXT_SCENE2 = "scenename2";
  final static String SOURCE_MEDIA = "media";
  final static String SOURCE_VLC_MEDIA = "vlc-media";
  final static String SOURCE_RED_SQUARE = "red_square";
  final static String SOURCE_RED_SQUARE_FILTER = "Color Correction";
  final static String SOURCE_BROWSER = "browser";
  final static String SOURCE_GROUP = "group";
  final static String SOURCE_GROUP_TEXT = "grouptext";

  // Transitions and other OBS hard-coded names
  final static String TRANSITION_SLIDE = "Slide";
  final static String TRANSITION_CUT = "Cut";
  final static String TRANSITION_FADE = "Fade";
  final static String SOURCE_OBS_MIC = "Mic/Aux";
  final static String SOURCE_OBS_AUDIO = "Desktop Audio";

  @BeforeAll
  static void beforeAll() {

    // Connect to OBS
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

  //  Test Helpers
  void obsShould(String expected) {
    obsShould(expected, 3);
  }

  void obsShould(String expected, int secondsTimeout) {
    System.out.println(">>> OBS SHOULD: " + expected);
    countDownFrom(secondsTimeout);
  }

  void countDownFrom(int seconds) {
    for(int i = seconds; i > 0; i--) {
      System.out.println("> " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static void connectToObs() {
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

  void setupObs() {

    // Cleanup all scenes
    cleanupScenes();

    // Change back to base scene
    remote.changeSceneWithTransition("scene1", "Cut", result -> {
      if(result.getError() != null && !result.getError().isEmpty()) {
        fail("Failed to switch to base scene");
      }
    });
  }

  void cleanupScenes() {
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

  Consumer loggingCallback = (obj) -> {
    System.out.println("Received response: " + obj);
  };

  void waitReasonably() {
    waitReasonably(50);
  }

  void waitReasonably(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  Consumer capturingCallback = (obj) -> {
    System.out.println("Received response: " + obj + "(" + obj.getClass().getSimpleName() + ")");
    resultQueue.add(obj);
  };

  <T> T getResponseAs(Class<T> clazz) {
    return clazz.cast(resultQueue.remove());
  }
  
}
