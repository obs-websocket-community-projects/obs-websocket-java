package io.obswebsocket.community.client.message.response.inputs;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSpecialInputsResponse extends RequestResponse<GetSpecialInputsResponse.Data> {

  public GetSpecialInputsResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {

    @SerializedName("desktop-1")
    private String desktop1;
    @SerializedName("desktop-2")
    private String desktop2;
    @SerializedName("mic-1")
    private String mic1;
    @SerializedName("mic-2")
    private String mic2;
    @SerializedName("mic-3")
    private String mic3;
    @SerializedName("mic-4")
    private String mic4;
  }
}
