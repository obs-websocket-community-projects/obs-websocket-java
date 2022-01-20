package io.obswebsocket.community.client.message.request.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetPersistentDataRequest extends PersistentDataRequest {

  @SerializedName("d")
  private final Data data;

  @Builder
  private SetPersistentDataRequest(String realm, String slotName, Object slotValue) {
    super(Request.Data.Type.SetPersistentData);

    this.data = Data.builder().requestId(this.getRequestId()).requestType(this.getRequestType()).requestData(SpecificData.builder().realm(realm).slotName(slotName).slotValue(slotValue).build()).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  static class SpecificData extends PersistentDataRequest.SpecificData {

    @NonNull
    private final Object slotValue;  // TODO: type might change
  }

}
