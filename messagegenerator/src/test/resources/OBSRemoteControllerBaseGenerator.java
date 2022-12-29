// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.null.OtherTypeRequest;
import io.obswebsocket.community.client.message.request.null.SomeTypeRequest;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.null.OtherTypeResponse;
import io.obswebsocket.community.client.message.response.null.SomeTypeResponse;
import io.obswebsocket.community.client.model.Input;
import io.obswebsocket.community.client.model.Scene;
import java.util.List;
import java.util.function.Consumer;

public abstract class OBSRemoteControllerBase {
  public abstract <R extends Request, RR extends RequestResponse> void sendRequest(R request,
      Consumer<RR> callback);

  /**
   * Description
   *
   * @param callback Consumer&lt;SomeTypeResponse&gt;
   */
  public void someType(Consumer<SomeTypeResponse> callback) {
    this.sendRequest(SomeTypeRequest.builder().build(), callback);
  }

  /**
   * Description
   *
   * @param timeout long timeout in ms
   * @return the SomeTypeResponse, null if the request timed out
   */
  public SomeTypeResponse someType(long timeout) {
    BlockingConsumer<SomeTypeResponse> callback = new BlockingConsumer<SomeTypeResponse>();
    this.sendRequest(SomeTypeRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Other description
   *
   * @param stringField stringField description
   * @param booleanField booleanField description
   * @param booleanList booleanList description
   * @param stringList stringList description
   * @param audioTracks audioTracks description
   * @param jsonObject jsonObject description
   * @param sceneList sceneList description
   * @param callback Consumer&lt;OtherTypeResponse&gt;
   */
  public void otherType(String stringField, Boolean booleanField, List<Boolean> booleanList,
      List<String> stringList, Input.AudioTracks audioTracks, JsonObject jsonObject,
      List<Scene> sceneList, Consumer<OtherTypeResponse> callback) {
    this.sendRequest(OtherTypeRequest.builder().stringField(stringField).booleanField(booleanField).booleanList(booleanList).stringList(stringList).audioTracks(audioTracks).jsonObject(jsonObject).sceneList(sceneList).build(), callback);
  }

  /**
   * Other description
   *
   * @param stringField stringField description
   * @param booleanField booleanField description
   * @param booleanList booleanList description
   * @param stringList stringList description
   * @param audioTracks audioTracks description
   * @param jsonObject jsonObject description
   * @param sceneList sceneList description
   * @param timeout long timeout in ms
   * @return the OtherTypeResponse, null if the request timed out
   */
  public OtherTypeResponse otherType(String stringField, Boolean booleanField,
      List<Boolean> booleanList, List<String> stringList, Input.AudioTracks audioTracks,
      JsonObject jsonObject, List<Scene> sceneList, long timeout) {
    BlockingConsumer<OtherTypeResponse> callback = new BlockingConsumer<OtherTypeResponse>();
    this.sendRequest(OtherTypeRequest.builder().stringField(stringField).booleanField(booleanField).booleanList(booleanList).stringList(stringList).audioTracks(audioTracks).jsonObject(jsonObject).sceneList(sceneList).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }
}
