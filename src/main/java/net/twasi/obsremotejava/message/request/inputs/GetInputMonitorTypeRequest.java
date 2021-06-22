package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputMonitorTypeRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private GetInputMonitorTypeRequest(String inputName) {
        super(Type.GetInputMonitorType);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}
