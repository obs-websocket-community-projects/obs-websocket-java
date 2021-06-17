package net.twasi.obsremotejava.requests.SetSourceFilterSettings;

import java.util.Map;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class SetSourceFilterSettingsRequest extends RequestBase {
    private String sourceName;
    private String filterName;
    private Map<String, Object> filterSettings;

    public SetSourceFilterSettingsRequest(OBSCommunicator com, String sourceName, String filterName, Map<String, Object> settings) {
        super(RequestType.SetSourceFilterSettings);

        this.sourceName = sourceName;
        this.filterName = filterName;
        this.filterSettings = settings;

        // com.messageTypes.put(getMessageId(), SetSourceFilterSettingsResponse.class);
    }
}
