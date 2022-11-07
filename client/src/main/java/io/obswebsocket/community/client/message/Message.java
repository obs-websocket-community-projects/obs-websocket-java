package io.obswebsocket.community.client.message;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.translator.serialization.MessageSerialization;
import io.obswebsocket.community.client.translator.serialization.OperationCodeSerialization;
import java.util.Arrays;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@JsonAdapter(MessageSerialization.class)
public abstract class Message {

  @SerializedName("op")
  protected OperationCode operationCode;

  @Getter
  @JsonAdapter(OperationCodeSerialization.class)
  public enum OperationCode {
    Hello(0L, io.obswebsocket.community.client.message.authentication.Hello.class),

    Identify(1L, io.obswebsocket.community.client.message.authentication.Identify.class),

    Identified(2L, io.obswebsocket.community.client.message.authentication.Identified.class),

    Reidentify(3L, io.obswebsocket.community.client.message.authentication.Reidentify.class),

    Event(5L, io.obswebsocket.community.client.message.event.Event.class),

    Request(6L, io.obswebsocket.community.client.message.request.Request.class),

    RequestResponse(7L, io.obswebsocket.community.client.message.response.RequestResponse.class),

    RequestBatch(8L, io.obswebsocket.community.client.message.request.RequestBatch.class),

    RequestBatchResponse(9L, io.obswebsocket.community.client.message.response.RequestBatchResponse.class),
    ;

    private final long rawCode;
    private final Class<? extends Message> messageClass;

    OperationCode(Long rawCode, Class<? extends Message> messageClass) {
      this.rawCode = rawCode;
      this.messageClass = messageClass;
    }

    public static OperationCode fromRawCode(long rawCode) {
      return Arrays.stream(OperationCode.values()).filter(operationCode -> operationCode.rawCode == rawCode).findFirst().orElse(null);
    }
  }
}
