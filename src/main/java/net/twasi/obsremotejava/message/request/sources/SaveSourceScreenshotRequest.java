package net.twasi.obsremotejava.message.request.sources;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SaveSourceScreenshotRequest extends SourceRequest {
    private final Data requestData;

    public SaveSourceScreenshotRequest(String sourceName, String imageFilePath, String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality) {
        super(Type.SaveSourceScreenshot);

        this.requestData = Data.builder().sourceName(sourceName).imageFilePath(imageFilePath).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build();
    }

    @Getter
    @ToString
    static class Data extends SourceRequest.Data {
        @NonNull
        private final String imageFilePath;
        @NonNull
        private final String imageFormat;
        private final Integer imageWidth; // optional
        private final Integer imageHeight; // optional
        private final Integer imageCompressionQuality; // optional

        @Builder
        Data(String sourceName, String imageFilePath, String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality) {
            super(sourceName);

            this.imageFilePath = imageFilePath;
            this.imageFormat = imageFormat;
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
            this.imageCompressionQuality = imageCompressionQuality;
        }
    }
}
