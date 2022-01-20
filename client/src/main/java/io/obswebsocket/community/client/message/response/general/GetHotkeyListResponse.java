package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetHotkeyListResponse extends RequestResponse {

  private Data responseData;

  public GetHotkeyListResponse() {
    super(Request.Data.Type.GetHotkeyList);
  }

  @Getter
  @ToString
  public static class Data {

    private List<String> hotkeys;
  }
}
