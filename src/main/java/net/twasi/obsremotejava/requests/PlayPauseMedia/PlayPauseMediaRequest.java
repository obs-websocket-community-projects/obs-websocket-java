package net.twasi.obsremotejava.requests.PlayPauseMedia;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class PlayPauseMediaRequest extends BaseRequest {
    private String sourceName;
    private Boolean playPause;

    public PlayPauseMediaRequest(OBSCommunicator com, String sourceName, Boolean playPause) {
        super(RequestType.PlayPauseMedia);

        this.sourceName = sourceName;
        this.playPause = playPause;

        com.messageTypes.put(getMessageId(), PlayPauseMediaResponse.class);
    }
}
