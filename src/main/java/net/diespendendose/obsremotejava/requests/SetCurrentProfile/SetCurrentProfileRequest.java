package net.diespendendose.obsremotejava.requests.SetCurrentProfile;

import com.google.gson.annotations.SerializedName;
import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class SetCurrentProfileRequest extends BaseRequest {
    @SerializedName("profile-name")
    private String profileName;

    public SetCurrentProfileRequest(OBSCommunicator com, String profileName) {
        super(RequestType.SetCurrentProfile);

        com.messageTypes.put(getMessageId(), SetCurrentProfileResponse.class);

        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
