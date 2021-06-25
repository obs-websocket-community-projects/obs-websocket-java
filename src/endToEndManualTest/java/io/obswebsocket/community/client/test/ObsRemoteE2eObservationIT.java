package io.obswebsocket.community.client.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.*;

/**
 * This test should be run manually, following the prompts in the command-line and
 * observing OBS for the desired behavior. Authentication should be disabled.
 * See the README in the obs-resources directory for more information.
 */
@Disabled
public class ObsRemoteE2eObservationIT extends AbstractObsE2ETest {

//  @BeforeAll
//  static void beforeAll() {
//    connectToObs();
//  }
//
//  @BeforeEach
//  public void beforeEach() {
//    System.out.println("===============================");
//    System.out.println(">> Resetting...");
//    setupObs();
//    System.out.println(">> ...Ready");
//  }
//
//  @AfterAll
//  static void afterAll() {
//    remote.disconnect();
//    System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Debug");
//  }
//
//  @AfterEach
//  public void afterEach() {
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    System.out.println("<< Test Complete");
//
//  }
//
//  @Test
//  void switchScene() {
//    obsShould("Switch to scene2");
//    remote.changeSceneWithTransition(SCENE2, TRANSITION_CUT, loggingCallback);
//    obsShould("Switch back to scene1");
//    remote.setCurrentScene(SCENE1, loggingCallback);
//  }
//
//  @Test
//  void showHideSceneItem() {
//    obsShould("Show the red square");
//    remote.setSourceVisibility(null, SOURCE_RED_SQUARE, true, loggingCallback);
//    obsShould("Hide the red square");
//    remote.setSourceVisibility(null, SOURCE_RED_SQUARE, false, loggingCallback);
//  }
//
//  @Test
//  void setTransition() {
//    obsShould("Set current transition to Slide, with transition 2000ms");
//    remote.setCurrentTransition(TRANSITION_SLIDE, loggingCallback);
//    remote.setTransitionDuration(2000, loggingCallback);
//    obsShould("Set current transition back to 300ms");
//    remote.setTransitionDuration(300, loggingCallback);
//    obsShould("Set current transition back to Cut");
//    remote.setCurrentTransition(TRANSITION_CUT, loggingCallback);
//  }
//
//  @Test
//  void changeScenesWithTransition() {
//    obsShould("Change to scene2, with the Slide transition");
//    remote.changeSceneWithTransition(SCENE2, TRANSITION_SLIDE, loggingCallback);
//  }
//
//  @Test
//  void setSourceFilterVisibility() {
//
//    obsShould("Show a blue square (red square colored blue by a filter)");
//    remote.setSourceVisibility(null, SOURCE_RED_SQUARE, true, loggingCallback);
//    remote.setSourceFilterVisibility(SOURCE_RED_SQUARE, SOURCE_RED_SQUARE_FILTER, true,
//      loggingCallback);
//    obsShould("Return the red square to normal");
//    remote.setSourceFilterVisibility(SOURCE_RED_SQUARE, SOURCE_RED_SQUARE_FILTER, false,
//      loggingCallback);
//
//  }
//
//  @Test
//  void exerciseStudioMode() {
//    obsShould("Enable studio mode");
//    remote.setStudioModeEnabled(true, loggingCallback);
//    obsShould("Set preview scene to scene2");
//    remote.setPreviewScene(SCENE2, loggingCallback);
//    obsShould("Fade to scene2");
//    remote.transitionToProgram(TRANSITION_FADE, 1500, loggingCallback);
//    obsShould("Disable studio mode");
//    remote.setStudioModeEnabled(false, loggingCallback);
//
//  }
//
//  @Test
//  void setSourceSettings() {
//    obsShould("Curse the 'scene1' text");
//    Map<String, Object> settings = new HashMap<>();
//    settings.put("text", "S̼͚̞̼̩̱̽̓̍̽͊́ͨ̍̀ċͭ̚҉̪̖̤̥ͅȩ͉̣̜̖̖͙͇́̀̒ͥ̓̚͠͞n̦͍͆͑ͤ̕e̶̖̝̗̻͂̑̽̔ͩ̅́͜ͅ ̢͉̬͔͙̺̖͂͂ͣ͢1̮̥͇̏̇͋̈́ͨͥ͝ͅ");
//    remote.setSourceSettings(SOURCE_TEXT_SCENE1, settings, loggingCallback);
//    obsShould("Change the 'scene1' text back to normal");
//    settings.put("text", "Scene 1");
//    remote.setSourceSettings(SOURCE_TEXT_SCENE1, settings, loggingCallback);
//  }
//
//  @Test
//  void takeSourceScreenshot() throws Exception {
//    String path = System.getProperty("user.home");
//    assertThat(path).isNotNull();
//    File file = new File(path, "test.png");
//    String screenshotPath = file.getAbsolutePath();
//    obsShould("Take a screenshot of the current scene, and save it to " + screenshotPath, 1);
//    remote.takeSourceScreenshot(
//      SCENE1, "png",
//      screenshotPath,
//      null, 1,
//      1080, 720,
//      loggingCallback
//    );
//  }
//
//  @Test
//  void startStopStreaming() {
//    obsShould("Start Streaming");
//    remote.startStreaming(loggingCallback);
//    obsShould("Stop Streaming");
//    remote.stopStreaming(loggingCallback);
//  }
//
//  @Test
//  void startStopRecordingAndReplayBuffer() {
//    obsShould("Start Recording");
//    remote.startRecording(loggingCallback);
//
//    obsShould("Start the replay buffer");
//    remote.startReplayBuffer(loggingCallback);
//
//    obsShould("Save the replay buffer");
//    remote.saveReplayBuffer(loggingCallback);
//
//    obsShould("Stop the replay buffer");
//    remote.stopReplayBuffer(loggingCallback);
//
//    obsShould("Stop Recording");
//    remote.stopRecording(loggingCallback);
//  }
//
//  @Test
//  void setVolumeAndMute() {
//
//    obsShould("Set the volume to 50% (note, appears 67% due to log scaling; check % in advanced audio properties)");
//    remote.setSourceVisibility(null, "media", true, loggingCallback);
//    remote.setVolume(SOURCE_MEDIA, 0.50, loggingCallback);
//    obsShould("Mute the volume");
//    remote.setMute(SOURCE_MEDIA, true, loggingCallback);
//    remote.getMute(SOURCE_MEDIA, capturingCallback);
//    waitReasonably();
//    assertThat(getPreviousResponseAs(GetMuteResponse.class).isMuted()).isTrue();
//
//    obsShould("Unmute the volume");
//    remote.setMute(SOURCE_MEDIA, false, loggingCallback);
//    remote.getMute(SOURCE_MEDIA, capturingCallback);
//    waitReasonably();
//    assertThat(getPreviousResponseAs(GetMuteResponse.class).isMuted()).isFalse();
//
//    obsShould("Set the volume to 100%");
//    remote.setVolume(SOURCE_MEDIA, 1.00, loggingCallback);
//
//  }
//
//  @Test
//  void playPauseVlcMedia() {
//    obsShould("Play video 1, by showing it (Note, VLC must be installed!)");
//    remote.setSourceVisibility(null, SOURCE_VLC_MEDIA, true, loggingCallback);
//
//    obsShould("Pause video 1");
//    remote.pauseMedia(SOURCE_VLC_MEDIA, loggingCallback);
//
//    // BUG: Toggle Play/Pause does not work in Palakis OBS plugin!
//    // see https://github.com/Palakis/obs-websocket/issues/725
//    // I've noted we can also replicate the problem
//    obsShould("Toggle Play Video 1");
//    remote.toggleMedia(SOURCE_VLC_MEDIA, loggingCallback);
//    obsShould("Toggle Pause Video 1");
//    remote.toggleMedia(SOURCE_VLC_MEDIA, loggingCallback);
//
//    obsShould("Switch to video 2");
//    remote.nextMedia(SOURCE_VLC_MEDIA, loggingCallback);
//
//    obsShould("Restart, back at video 1 (should auto play)");
//    remote.restartMedia(SOURCE_VLC_MEDIA, loggingCallback);
//
//    obsShould("Stop video 1 (going back to beginning)");
//    remote.stopMedia(SOURCE_VLC_MEDIA, loggingCallback);
//
//  }
//
//  @Test
//  void triggerHotkey() {
//    obsShould("Show the red square via hotkey name");
//    remote.triggerHotkeyByName("libobs.show_scene_item.red_square", loggingCallback);
//  }
//
//  @Test
//  void refreshBrowserSource() {
//
//    obsShould("Show the browser source", 1);
//    remote.setSourceVisibility(null, SOURCE_BROWSER, true, loggingCallback);
//
//    obsShould("Refresh the browser source (new random color and number)");
//    remote.refreshBrowserSource(SOURCE_BROWSER, loggingCallback);
//    waitReasonably(1000);
//
//  }

}
