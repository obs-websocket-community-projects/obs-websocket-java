package net.twasi.obsremotejava.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

/**
 * @since 2.0.0
 */
@Getter
@ToString(callSuper = true)
public class GetVideoSettingsRequest extends Request {
    @Builder
    private GetVideoSettingsRequest() {
        super(Type.GetVideoSettings);
    }
}
