package io.obswebsocket.community.client.message.request.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetPersistentDataRequest extends PersistentDataRequest {

  @SerializedName("d")
  private final PersistentDataRequest.Data data;

  @Builder
  private GetPersistentDataRequest(String realm, String slotName) {
    super(Request.Data.Type.GetPersistentData);

    this.data = Data.builder().requestId(this.getRequestId()).requestType(this.getRequestType()).requestData(SpecificData.builder().realm(realm).slotName(slotName).build()).build();
  }

}
