package net.twasi.obsremotejava.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Input;

@Getter
@ToString(callSuper = true)
public class GetInputMonitorTypeResponse extends RequestResponse {
    private Data responseData;

    public GetInputMonitorTypeResponse() {
        super(Request.Type.GetInputMonitorType);
    }

    @Getter
    @ToString
    public static class Data {
        private Input.MonitorType monitorType;
    }
}
