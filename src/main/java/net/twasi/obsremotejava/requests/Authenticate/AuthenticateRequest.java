package net.twasi.obsremotejava.requests.Authenticate;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class AuthenticateRequest extends BaseRequest {
    private String auth;

    public AuthenticateRequest(OBSCommunicator com, String auth) {
        super(RequestType.Authenticate);

        this.auth = auth;

        com.messageTypes.put(getMessageId(), AuthenticateResponse.class);
    }

    public String getAuth() {
        return auth;
    }
}