package io.obswebsocket.community.client.message.response.ui;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.ui.GetMonitorListResponse.Data;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetMonitorListResponse extends RequestResponse<Data> {

  @Getter
  @ToString
  public static class Data {

    private List<Monitor> monitors;

    @Getter
    @ToString
    public static class Monitor {
      private Integer monitorIndex;
      private String monitorName;
      private Integer monitorWidth;
      private Integer monitorHeight;
      private Integer monitorPositionX;
      private Integer monitorPositionY;
    }
  }
}
