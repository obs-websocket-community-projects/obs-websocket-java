package io.obswebsocket.community.client.message.request.mediaInputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PreviousMediaInputPlaylistItemRequest extends MediaInputRequest {
    private final Data requestData;

    @Builder
    private PreviousMediaInputPlaylistItemRequest(String inputName) {
        super(Type.PreviousMediaInputPlaylistItem);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}