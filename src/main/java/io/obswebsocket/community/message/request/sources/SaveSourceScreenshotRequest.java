package io.obswebsocket.community.message.request.sources;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SaveSourceScreenshotRequest extends SourceScreenshotRequest {
    private final Data requestData;

    @Builder
    private SaveSourceScreenshotRequest(String sourceName, String imageFilePath, String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality) {
        super(Type.SaveSourceScreenshot);

        this.requestData = Data.builder().sourceName(sourceName).imageFilePath(imageFilePath).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build();
    }

    @Getter
    @ToString
    @SuperBuilder
    static class Data extends SourceScreenshotRequest.Data {
        @NonNull
        private final String imageFilePath;
    }
}
