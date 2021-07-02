package io.obswebsocket.community.client.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

import io.obswebsocket.community.client.message.response.scenes.GetSceneListResponse;
import io.obswebsocket.community.client.model.Scene;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * This test relies on your OBS instance having the expected scene collection installed; See the
 * README in the obs-resources directory for more information.
 */
public class ObsRemoteE2eIT extends AbstractObsE2ETest {

  @BeforeAll
  static void beforeAll() {
    connectToObs();
  }

  @BeforeEach
  public void beforeEach() {
    setupObs();
    resultQueue.clear();
  }

  @AfterAll
  static void afterAll() {
    remote.disconnect();
    System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Debug");
  }

  @Test
  void getScenes() {

    // Given expected scenes and sources
    List<Scene> expectedScenes = Arrays.asList(
        new Scene(SCENE1, 2, false),
        new Scene(SCENE2, 1, false),
        new Scene(SCENE3, 0, false)
    );
    GetSceneListResponse.Data expectedResponseData = new GetSceneListResponse.Data(
        SCENE1,
        null,
        expectedScenes
    );

    // When retrieved
    remote.getSceneList(capturingCallback);
    waitReasonably();

    // Then scenes match as expected
    GetSceneListResponse res = getPreviousResponseAs(GetSceneListResponse.class);
    assertThat(res.getResponseData())
        .usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expectedResponseData);

  }

  @Disabled
  @Test
  void getSourcesList() {

    // Given expected sources (all custom sources + mic and desktop audio default obs sources)
    List<String> expectedNames = Arrays.asList(
        SOURCE_TEXT_SCENE1,
        SOURCE_TEXT_SCENE2,
        SOURCE_RED_SQUARE,
        SOURCE_MEDIA,
        SOURCE_VLC_MEDIA,
        SOURCE_BROWSER,
        SOURCE_GROUP,
        SOURCE_GROUP_TEXT,
        "Mic/Aux",
        "Desktop Audio"
    );

    // When retrieved
//    remote.getSourcesList(capturingCallback);
    fail("getSourcesList not implemented");
    waitReasonably();

    // Then it matches as expected
//    GetSourcesListResponse res = getPreviousResponseAs(GetSourcesListResponse.class);
//    List<Source> sources = res.getSources();
//    List<String> actualNames = sources.stream().map(Source::getName).collect(Collectors.toList());
//    assertThat(actualNames.size()).isEqualTo(sources.size());
//    assertThat(actualNames).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expectedNames);

  }

}
