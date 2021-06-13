package net.twasi.obsremotejava.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import net.twasi.obsremotejava.model.Scene;
import net.twasi.obsremotejava.model.Source;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import net.twasi.obsremotejava.requests.GetSourcesList.GetSourcesListResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test relies on your OBS instance having the expected scene collection installed;
 * See the README in the obs-resources directory for more information.
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
    List<String> scenes = Arrays.asList(SCENE1, SCENE2, SCENE3);
    List<String> scene1Sources = Arrays.asList(
      SOURCE_TEXT_SCENE1,
      SOURCE_RED_SQUARE,
      SOURCE_MEDIA,
      SOURCE_VLC_MEDIA,
      SOURCE_BROWSER,
      SOURCE_GROUP
    );
    List<String> scene1SourcesWithChildren = new ArrayList<>(scene1Sources);
    scene1SourcesWithChildren.add(SOURCE_GROUP_TEXT);
    List<String> scene2Sources = Arrays.asList(SOURCE_TEXT_SCENE2);

    // When retrieved
    remote.getSceneList(capturingCallback);
    waitReasonably();

    // Then scenes match as expected
    GetSceneListResponse res = getPreviousResponseAs(GetSceneListResponse.class);
    assertThat(res.getScenes().stream().map(Scene::getName).collect(Collectors.toList()))
      .usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(scenes);

    // And their sources match as expected
    Scene scene1 = res.getScenes().get(0);
    assertThat(scene1.getSources().stream().map(Source::getName).collect(Collectors.toList()))
      .usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(scene1Sources);
    assertThat(scene1.getSourcesIncludingGroupChildren().stream().map(Source::getName).collect(Collectors.toList()))
      .usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(scene1SourcesWithChildren);

    Scene scene2 = res.getScenes().get(1);
    assertThat(scene2.getSources().stream().map(Source::getName).collect(Collectors.toList()))
      .usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(scene2Sources);

    Scene emptyScene = res.getScenes().get(2);
    assertThat(emptyScene.getSources().size()).isZero();

  }

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
    GetSourcesListResponse res = getPreviousResponseAs(GetSourcesListResponse.class);
    List<Source> sources = res.getSources();
    List<String> actualNames = sources.stream().map(Source::getName).collect(Collectors.toList());
    assertThat(actualNames.size()).isEqualTo(sources.size());
    assertThat(actualNames).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expectedNames);

  }

}
