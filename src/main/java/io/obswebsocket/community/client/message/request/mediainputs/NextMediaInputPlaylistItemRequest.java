package io.obswebsocket.community.client.message.request.mediainputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class NextMediaInputPlaylistItemRequest extends MediaInputRequest {
    private final Data requestData;

    @Builder
    private NextMediaInputPlaylistItemRequest(String inputName) {
        super(Type.NextMediaInputPlaylistItem);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}