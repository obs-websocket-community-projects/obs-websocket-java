package io.obswebsocket.community.client.message.request;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RequestBatch extends Message {

  @SerializedName("d")
  private Data data;

  @Builder
  public RequestBatch(
      Boolean haltOnFailure,
      RequestBatchExecutionType executionType,
      @Singular List<Request> requests
  ) {
    super(OperationCode.RequestBatch);

    this.data = Data.builder()
        .requestId(UUID.randomUUID().toString())
        .haltOnFailure(haltOnFailure)
        .executionType(executionType)
        .requests(requests.stream().map(Request::getData).collect(Collectors.toList()))
        .build();
  }

  @Getter
  @Builder
  @ToString
  public static class Data {

    private String requestId;
    private Boolean haltOnFailure;
    protected RequestBatchExecutionType executionType;
    private List<Object> requests;
  }

  public enum RequestBatchExecutionType {
    @SerializedName("0")
    SerialRealtime,
    @SerializedName("1")
    SerialFrame,
    @SerializedName("2")
    Parallel
  }
}
