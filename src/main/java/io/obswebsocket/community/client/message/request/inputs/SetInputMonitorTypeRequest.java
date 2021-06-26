package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputMonitorTypeRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private SetInputMonitorTypeRequest(String inputName, Input.MonitorType monitorType) {
        super(Type.SetInputMonitorType);

        this.requestData = Data.builder().inputName(inputName).monitorType(monitorType).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends InputRequest.Data {
        @NonNull
        private final Input.MonitorType monitorType;
    }
}
