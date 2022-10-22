package io.obswebsocket.community.client.message.request;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import java.util.UUID;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public abstract class Request<T> extends Message {

  @SerializedName("d")
  private RequestData<T> data;

  protected Request(RequestType type, T requestData) {
    super(OperationCode.Request);
    this.data = RequestData.<T>builder().requestType(type).requestId(UUID.randomUUID().toString())
        .requestData(requestData).build();
  }

  public String getRequestId() {
    return this.data.requestId;
  }

  public RequestType getRequestType() {
    return this.data.requestType;
  }

  @SuperBuilder
  @Getter
  @ToString
  public static class RequestData<T> extends Data {

    protected T requestData;
  }

  @SuperBuilder
  @Getter
  @ToString
  public static abstract class Data {

    protected RequestType requestType;
    protected String requestId;
  }

}
