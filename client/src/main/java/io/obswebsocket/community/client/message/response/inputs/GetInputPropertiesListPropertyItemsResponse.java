package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class
GetInputPropertiesListPropertyItemsResponse extends RequestResponse {

  private Data responseData;

  public GetInputPropertiesListPropertyItemsResponse() {
    super(Request.Type.GetInputPropertiesListPropertyItems);
  }

  @Getter
  @ToString
  public static class PropertyItem {

    private String itemName;
    private String itemValue;
    private Boolean itemEnabled;
  }

  @Getter
  @ToString
  public static class Data {

    private String listPropertyFormat;
    private List<PropertyItem> propertyItems;
  }
}
