package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetHotkeyListResponse extends RequestResponse<GetHotkeyListResponse.Data> {
  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<String> hotkeys;
  }
}
