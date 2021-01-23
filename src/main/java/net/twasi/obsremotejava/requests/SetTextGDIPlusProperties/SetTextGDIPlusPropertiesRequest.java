package net.twasi.obsremotejava.requests.SetTextGDIPlusProperties;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class SetTextGDIPlusPropertiesRequest extends BaseRequest {

    private final String source;
    private final boolean read_from_file;
    private final String text;



    public SetTextGDIPlusPropertiesRequest(OBSCommunicator obsCommunicator, String source, boolean read_from_file, String text) {
        super(RequestType.SetTextGDIPlusProperties);
        this.source = source;
        this.read_from_file = read_from_file;
        this.text = text;
    }

}
