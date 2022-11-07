package io.obswebsocket.community.client.message.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.translator.serialization.RequestBatchResponseResultsDeserialization;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RequestBatchResponse extends Message {

  @SerializedName("d")
  private Data data;

  RequestBatchResponse() {
    super(OperationCode.RequestBatchResponse);
  }

  public boolean isSuccessful() {
    return this.data != null && this.data.results != null && this.data.results.stream()
        .allMatch(data -> Boolean.TRUE.equals(data.requestStatus.result));
  }

  @Getter
  @ToString
  public static class Data {

    private String requestId;
    @JsonAdapter(RequestBatchResponseResultsDeserialization.class)
    private List<RequestResponse.Data> results;
  }
}
