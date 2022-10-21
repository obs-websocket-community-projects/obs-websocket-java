package io.obswebsocket.community.generator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.spy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ExpectedGeneratorTest {

  /**
   * Use this to re-generate the output when the generator changes. Be sure that the expected
   * results are what they are supposed to be!
   *
   * @throws Exception Should not be thrown
   */
  @Test
  @Disabled("Enable this to re-generate the expected results")
  void generateOutputs() throws Exception {
    generateOutput(EventGeneratorTest.class);
    generateOutput(EventTypeGeneratorTest.class);

    generateOutput(RequestGeneratorTest.class);
    generateOutput(ResponseGeneratorTest.class);
    generateOutput(RequestTypeGeneratorTest.class);

    generateOutput(OBSRemoteControllerBaseGeneratorTest.class);
  }

  private <T extends AbstractTestBase> void generateOutput(Class<T> base) throws Exception {
    AbstractTestBase instance = spy(base);
    doAnswer(m -> {
      String path = m.getArgument(0);
      ByteArrayOutputStream bar = m.getArgument(1);
      FileUtils.write(new File("src/test/resources/" + path), bar.toString(),
          StandardCharsets.UTF_8);
      return null;
    }).when(instance).assertResult(any(), any());
    instance.withoutParams();
    instance.withParams();
  }
}
