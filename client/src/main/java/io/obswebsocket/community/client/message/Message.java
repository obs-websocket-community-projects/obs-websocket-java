package io.obswebsocket.community.client.message;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class Message {

  @SerializedName("op")
  protected OperationCode operationCode;

  @Getter
  public enum OperationCode {
    @SerializedName("0")
    Hello(0L, io.obswebsocket.community.client.message.authentication.Hello.class),

    @SerializedName("1")
    Identify(1L, io.obswebsocket.community.client.message.authentication.Identify.class),

    @SerializedName("2")
    Identified(2L, io.obswebsocket.community.client.message.authentication.Identified.class),

    @SerializedName("3")
    Reidentify(3L, io.obswebsocket.community.client.message.authentication.Reidentify.class),

    @SerializedName("5")
    Event(5L, io.obswebsocket.community.client.message.event.Event.class),

    @SerializedName("6")
    Request(6L, io.obswebsocket.community.client.message.request.Request.class),

    @SerializedName("7")
    RequestResponse(7L, io.obswebsocket.community.client.message.response.RequestResponse.class),

    @SerializedName("8")
    RequestBatch(8L, io.obswebsocket.community.client.message.request.RequestBatch.class),

    @SerializedName("9")
    RequestBatchResponse(9L, io.obswebsocket.community.client.message.response.RequestBatchResponse.class),
    ;

    private final long rawCode;
    private final Class<? extends Message> messageClass;

    OperationCode(Long rawCode, Class<? extends Message> messageClass) {
      this.rawCode = rawCode;
      this.messageClass = messageClass;
    }

    static OperationCode fromRawCode(long rawCode) {
      return Arrays.stream(OperationCode.values()).filter(operationCode -> operationCode.rawCode == rawCode).findFirst().orElse(null);
    }
  }
}
