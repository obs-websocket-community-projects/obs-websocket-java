package io.obswebsocket.community.client.test;

import static org.assertj.core.api.Assertions.fail;

import io.obswebsocket.community.client.OBSRemoteController;
import java.util.function.Consumer;

public abstract class AbstractObsE2ETest {

  protected static OBSRemoteController remote;

  // Scenes
  protected final static String SCENE1 = "scene1";
  protected final static String SCENE2 = "scene2";
  protected final static String SCENE3 = "emptyscene";

  // Sources
  protected final static String SOURCE_TEXT_SCENE1 = "scenename1";
  protected final static String SOURCE_TEXT_SCENE2 = "scenename2";
  protected final static String SOURCE_MEDIA = "media";
  protected final static String SOURCE_VLC_MEDIA = "vlc-media";
  protected final static String SOURCE_RED_SQUARE = "red_square";
  protected final static String SOURCE_RED_SQUARE_FILTER = "Color Correction";
  protected final static String SOURCE_BROWSER = "browser";
  protected final static String SOURCE_GROUP = "group";
  protected final static String SOURCE_GROUP_TEXT = "grouptext";

  // Transitions and other OBS hard-coded names
  protected final static String TRANSITION_SLIDE = "Slide";
  protected final static String TRANSITION_CUT = "Cut";
  protected final static String TRANSITION_FADE = "Fade";

  // Test Helpers
  protected void obsShould(String expected) {
    obsShould(expected, 3);
  }

  protected void obsShould(String expected, int secondsTimeout) {
    System.out.println(">>> OBS SHOULD: " + expected);
    countDownFrom(secondsTimeout);
  }

  protected void countDownFrom(int seconds) {
    for (int i = seconds; i > 0; i--) {
      System.out.println("> " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  protected static void connectToObs() {
    remote = OBSRemoteController.builder()
        .lifecycle()
        .onControllerError(((reasonThrowable) -> fail("An error occurred: " + reasonThrowable.getReason(), reasonThrowable)))
        .onCommunicatorError(e -> fail("Unable to connect", e))
        .and()
        .build();
    remote.connect();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void setupObs() {

    // Cleanup all scenes
    cleanupScenes();

    // Change back to base scene
    remote.setCurrentProgramScene("scene1", result -> {
      if (!result.isSuccessful()) {
        fail("Failed to switch to base scene");
      }
    });
  }

  protected void cleanupScenes() {
    // Hide all visible elements in all scenes
    remote.getSceneList(sceneListResponse -> {
      sceneListResponse.getScenes().forEach(scene -> {
        // TODO: This data isn't actually there
//        scene.getSources().forEach(source -> {
//          if (!source.getName().startsWith("scenename")) {
//            remote.setSourceVisibility(scene.getName(), source.getName(), false, result -> {
//              if (result.getError() != null && !result.getError().isEmpty()) {
//                fail(String.format("Failed to hide source '%s' on scene '%s'", source.getName(),
//                    scene.getName()));
//              }
//            });
//          }
//        });
      });
    });
  }

  protected <T> Consumer<T> loggingCallback() {
    return obj -> System.out.println("Received response: " + obj);
  }
}
