package io.obswebsocket.community.client.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.inputs.GetInputMuteResponse;
import java.io.File;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test should be run manually, following the prompts in the command-line and observing OBS for
 * the desired behavior. Authentication should be disabled. See the README in the obs-resources
 * directory for more information.
 */
public class ObsRemoteE2eObservationIT extends AbstractObsE2ETest {

  @BeforeAll
  static void beforeAll() {
    connectToObs();
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
//    System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Debug");
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
    remote.setCurrentProgramScene(SCENE2, loggingCallback());
    obsShould("Switch back to scene1");
    remote.setCurrentProgramScene(SCENE1, loggingCallback());
  }

  @Test
  void showHideSceneItem() {
    Number squareId = remote.getSceneItemId(SCENE1, SOURCE_RED_SQUARE, 0, 1000)
        .getSceneItemId();

    obsShould("Show the red square");
    remote.setSceneItemEnabled(SCENE1, squareId, true, loggingCallback());
    obsShould("Hide the red square");
    remote.setSceneItemEnabled(SCENE1, squareId, false, loggingCallback());
  }

  @Test
  void setTransition() {
    obsShould("Set current transition to Slide, with transition 2000ms");

    remote.setCurrentSceneTransition(TRANSITION_SLIDE, loggingCallback());
    remote.setCurrentSceneTransitionDuration(2000, loggingCallback());
    obsShould("Set current transition back to 300ms");
    remote.setCurrentSceneTransitionDuration(300, loggingCallback());
    obsShould("Set current transition back to Cut");
    remote.setCurrentSceneTransition(TRANSITION_CUT, loggingCallback());
  }

  @Test
  void changeScenesWithTransition() {
    obsShould("Change to scene2, with the Slide transition");
    remote.setCurrentSceneTransition(TRANSITION_SLIDE, 1000);
    remote.setCurrentProgramScene(SCENE2, loggingCallback());
  }

  @Test
  void setSourceFilterVisibility() {
    Number squareId = remote.getSceneItemId(SCENE1, SOURCE_RED_SQUARE, 0, 1000)
        .getSceneItemId();

    obsShould("Show a blue square (red square colored blue by a filter)");
    remote.setSceneItemEnabled(SCENE1, squareId, true, loggingCallback());
    remote.setSourceFilterEnabled(SOURCE_RED_SQUARE, SOURCE_RED_SQUARE_FILTER, true,
        loggingCallback());
    obsShould("Return the red square to normal");
    remote.setSceneItemEnabled(SCENE1, squareId, false, loggingCallback());
  }

  @Test
  void exerciseStudioMode() {
    obsShould("Enable studio mode");
    remote.setStudioModeEnabled(true, loggingCallback());
    obsShould("Set preview scene to scene2");
    remote.setCurrentPreviewScene(SCENE2, loggingCallback());
    remote.setCurrentSceneTransition(TRANSITION_FADE, loggingCallback());

    obsShould("Fade to scene2");
    remote.triggerStudioModeTransition(loggingCallback());

    obsShould("Disable studio mode");
    remote.setStudioModeEnabled(false, loggingCallback());
  }

  @Test
  void setSourceSettings() {
    obsShould("Curse the 'scene1' text");

    JsonObject setting = new JsonObject();
    setting.addProperty("text", "S̼͚̞̼̩̱̽̓̍̽͊́ͨ̍̀ċͭ̚҉̪̖̤̥ͅȩ͉̣̜̖̖͙͇́̀̒ͥ̓̚͠͞n̦͍͆͑ͤ̕e̶̖̝̗̻͂̑̽̔ͩ̅́͜ͅ ̢͉̬͔͙̺̖͂͂ͣ͢1̮̥͇̏̇͋̈́ͨͥ͝ͅ");
    remote.setInputSettings(SOURCE_TEXT_SCENE1, setting, false, loggingCallback());

    obsShould("Change the 'scene1' text back to normal");
    setting.addProperty("text", "Scene 1");
    remote.setInputSettings(SOURCE_TEXT_SCENE1, setting, false, loggingCallback());
  }

  @Test
  void takeSourceScreenshot() {
    String path = System.getProperty("user.home");
    assertNotNull(path);
    File file = new File(path, "test.png");
    String screenshotPath = file.getAbsolutePath();
    obsShould("Take a screenshot of the current scene, and save it to " + screenshotPath, 1);
    remote.saveSourceScreenshot(
        SCENE1, "png",
        screenshotPath,
        1080, 720,
        1,
        loggingCallback()
    );
  }

  @Test
  void startStopStreaming() {
    obsShould("Start Streaming");
    remote.startStream(loggingCallback());
    obsShould("Stop Streaming");
    remote.stopStream(loggingCallback());
  }

  @Test
  void startStopRecordingAndReplayBuffer() {
    obsShould("Start Recording");
    remote.startRecord(loggingCallback());

    obsShould("Start the replay buffer");
    remote.startReplayBuffer(loggingCallback());

    obsShould("Save the replay buffer");
    remote.saveReplayBuffer(loggingCallback());

    obsShould("Stop the replay buffer");
    remote.stopReplayBuffer(loggingCallback());

    obsShould("Stop Recording");
    remote.stopRecord(loggingCallback());
  }

  @Test
  void setVolumeAndMute() {
    Number mediaId = remote.getSceneItemId(SCENE1, "media", 0, 1000).getSceneItemId();

    obsShould(
        "Set the volume to 50% (note, appears 67% due to log scaling; check % in advanced audio properties)");
    remote.setSceneItemEnabled(SCENE1, mediaId, true, loggingCallback());
    remote.setInputVolume(SOURCE_MEDIA, 0.50, null, loggingCallback());

    obsShould("Mute the volume");
    remote.setInputMute(SOURCE_MEDIA, true, loggingCallback());
    GetInputMuteResponse muteResponse = remote.getInputMute(SOURCE_MEDIA, 1000);
    assertTrue(muteResponse.getInputMuted());

    obsShould("Unmute the volume");
    remote.setInputMute(SOURCE_MEDIA, false, loggingCallback());
    GetInputMuteResponse unmuteResponse = remote.getInputMute(SOURCE_MEDIA, 1000);
    assertFalse(unmuteResponse.getInputMuted());

    obsShould("Set the volume to 100%");
    remote.setInputVolume(SOURCE_MEDIA, 1.00, null, loggingCallback());
  }

  @Test
  void playPauseVlcMedia() {
    Number vlcId = remote.getSceneItemId(SCENE1, SOURCE_VLC_MEDIA, 0, 1000).getSceneItemId();
    obsShould("Play video 1, by showing it (Note, VLC must be installed!)");
    remote.setSceneItemEnabled(SCENE1, vlcId, true, loggingCallback());

    obsShould("Pause video 1");
    remote.triggerMediaInputAction(SOURCE_VLC_MEDIA, "OBS_WEBSOCKET_MEDIA_INPUT_ACTION_PAUSE", loggingCallback());

    // BUG: Toggle Play/Pause does not work in Palakis OBS plugin!
    // see https://github.com/obsproject/obs-websocket/issues/725
    // I've noted we can also replicate the problem
    obsShould("Toggle Play Video 1");
    remote.triggerMediaInputAction(SOURCE_VLC_MEDIA, "OBS_WEBSOCKET_MEDIA_INPUT_ACTION_PLAY", loggingCallback());
    obsShould("Toggle Pause Video 1");
    remote.triggerMediaInputAction(SOURCE_VLC_MEDIA, "OBS_WEBSOCKET_MEDIA_INPUT_ACTION_PAUSE", loggingCallback());

    obsShould("Switch to video 2");
    remote.triggerMediaInputAction(SOURCE_VLC_MEDIA, "OBS_WEBSOCKET_MEDIA_INPUT_ACTION_NEXT", loggingCallback());

    obsShould("Restart, back at video 1 (should auto play)");
    remote.triggerMediaInputAction(SOURCE_VLC_MEDIA, "OBS_WEBSOCKET_MEDIA_INPUT_ACTION_RESTART", loggingCallback());

    obsShould("Stop video 1 (going back to beginning)");
    remote.triggerMediaInputAction(SOURCE_VLC_MEDIA, "OBS_WEBSOCKET_MEDIA_INPUT_ACTION_STOP", loggingCallback());
  }

  @Test
  void triggerHotkey() {
    Number squareId = remote.getSceneItemId(SCENE1, SOURCE_RED_SQUARE, 0, 1000).getSceneItemId();

    obsShould("Show the red square via hotkey name");
    remote.triggerHotkeyByName("libobs.show_scene_item.red_square", loggingCallback());

    obsShould("Hide the square again");
    remote.setSceneItemEnabled(SCENE1, squareId, false, loggingCallback());
  }

  @Test
  void refreshBrowserSource() {
    Number browserId = remote.getSceneItemId(SCENE1, SOURCE_BROWSER, 0, 1000).getSceneItemId();

    obsShould("Show the browser source", 1);
    remote.setSceneItemEnabled(SCENE1, browserId, true, loggingCallback());

    obsShould("Refresh the browser source (new random color and number)");
    remote.pressInputPropertiesButton(SOURCE_BROWSER, "refreshnocache", loggingCallback());

    obsShould("Hide the browser again");
    remote.setSceneItemEnabled(SCENE1, browserId, false, loggingCallback());
  }
}
