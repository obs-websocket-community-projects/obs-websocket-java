package net.diespendendose.obsremotejava.requests.GetSourceSettings;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetSourceSettingsRequest extends BaseRequest {
    private String sourceName;

    public GetSourceSettingsRequest(OBSCommunicator com, String sourceName) {
        super(RequestType.GetSourceSettings);

        this.sourceName = sourceName;

        com.messageTypes.put(getMessageId(), GetSourceSettingsResponse.class);
    }
}
