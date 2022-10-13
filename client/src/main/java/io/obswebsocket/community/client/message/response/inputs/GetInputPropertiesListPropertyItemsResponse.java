package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetInputPropertiesListPropertyItemsResponse extends RequestResponse<GetInputPropertiesListPropertyItemsResponse.Data> {
  public GetInputPropertiesListPropertyItemsResponse() {
    super();
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
  @SuperBuilder
  public static class Data {
    private String listPropertyFormat;
    private List<PropertyItem> propertyItems;
  }
}
