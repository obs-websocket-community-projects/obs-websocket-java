package net.twasi.obsremotejava.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetVideoSettingsRequest extends Request {
    @Builder
    private GetVideoSettingsRequest() {
        super(Type.GetVideoSettings);
    }
}
