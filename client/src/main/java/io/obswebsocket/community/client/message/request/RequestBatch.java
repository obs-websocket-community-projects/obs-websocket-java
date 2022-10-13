package io.obswebsocket.community.client.message.request;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RequestBatch extends Message {

  @SerializedName("d")
  private Data data;

  @Builder
  public RequestBatch(
      Boolean haltOnFailure,
      List<Request> requests
  ) {
    super(OperationCode.RequestBatch);

    this.data = Data.builder()
        .requestId(UUID.randomUUID().toString())
        .haltOnFailure(haltOnFailure)
        .requests(requests)
        .build();
  }

  @Getter
  @Builder
  @ToString
  public static class Data {

    private String requestId;
    private Boolean haltOnFailure;
    private List<Request> requests;
  }
}
