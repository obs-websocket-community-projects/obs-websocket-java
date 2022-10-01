package io.obswebsocket.community.client.message.response.inputs;

import com.google.gson.annotations.SerializedName;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSpecialInputNamesResponse extends RequestResponse<GetSpecialInputNamesResponse.Data> {
  public GetSpecialInputNamesResponse() {
    super(Request.Data.Type.GetSpecialInputNames);
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
  }
}
