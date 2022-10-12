package io.obswebsocket.community.client.message.response.general;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetHotkeyListResponse extends RequestResponse<GetHotkeyListResponse.Data> {
  public GetHotkeyListResponse() {
    super(Request.Data.Type.GetHotkeyList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<String> hotkeys;
  }
}
