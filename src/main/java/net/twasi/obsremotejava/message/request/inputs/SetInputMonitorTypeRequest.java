package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import net.twasi.obsremotejava.model.InputMonitor;

@Getter
@ToString(callSuper = true)
public class SetInputMonitorTypeRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private SetInputMonitorTypeRequest(String inputName, InputMonitor.Type monitorType) {
        super(Type.SetInputMonitorType);

        this.requestData = Data.builder().inputName(inputName).monitorType(monitorType).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends InputRequest.Data {
        private final InputMonitor.Type monitorType;
    }
}
