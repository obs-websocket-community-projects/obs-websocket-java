// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputPropertiesListPropertyItemsResponse extends RequestResponse<GetInputPropertiesListPropertyItemsResponse.SpecificData> {
  /**
   * Array of items in the list property
   *
   * @return the propertyItems
   */
  public List<Input.PropertyItem> getPropertyItems() {
    return getMessageData().getResponseData().getPropertyItems();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of items in the list property
     */
    @Singular
    private List<Input.PropertyItem> propertyItems;
  }
}
