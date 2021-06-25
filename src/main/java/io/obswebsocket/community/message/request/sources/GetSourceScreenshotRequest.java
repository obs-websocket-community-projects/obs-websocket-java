package io.obswebsocket.community.message.request.sources;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceScreenshotRequest extends SourceScreenshotRequest {
    private final Data requestData;

    @Builder
    private GetSourceScreenshotRequest(String sourceName, String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality) {
        super(Type.GetSourceScreenshot);

        this.requestData = Data.builder().sourceName(sourceName).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build();
    }
}
