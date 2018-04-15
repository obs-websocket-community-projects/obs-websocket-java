package net.diespendendose.obsremotejava.requests.SetSourceSettings;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

import java.util.Map;

public class SetSourceSettingsRequest extends BaseRequest {
    private String sourceName;
    private Map<String, Object> sourceSettings;

    public SetSourceSettingsRequest(OBSCommunicator com, String sourceName, Map<String, Object> settings) {
        super(RequestType.SetSourceSettings);

        this.sourceName = sourceName;
        this.sourceSettings = settings;

        com.messageTypes.put(getMessageId(), SetSourceSettingsResponse.class);
    }
}
