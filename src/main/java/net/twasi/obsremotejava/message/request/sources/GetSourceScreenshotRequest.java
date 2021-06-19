package net.twasi.obsremotejava.message.request.sources;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetSourceScreenshotRequest extends Request {
    private final Data requestData;

    public GetSourceScreenshotRequest(String sourceName, String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality) {
        super(Type.GetSourceScreenshot);

        this.requestData = Data.builder().sourceName(sourceName).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String sourceName;
        @NonNull
        private final String imageFormat;
        private final Integer imageWidth; // optional
        private final Integer imageHeight; // optional
        private final Integer imageCompressionQuality; // optional
    }
}
