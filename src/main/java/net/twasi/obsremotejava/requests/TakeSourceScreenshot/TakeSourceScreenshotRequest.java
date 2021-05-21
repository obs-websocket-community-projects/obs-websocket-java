package net.twasi.obsremotejava.requests.TakeSourceScreenshot;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class TakeSourceScreenshotRequest extends BaseRequest {
    private String sourceName;
    private String embedPictureFormat;
    private String saveToFilePath;
    private String fileFormat;
    private Integer compressionQuality;
    private Integer width;
    private Integer height;

    private TakeSourceScreenshotRequest(OBSCommunicator com, String sourceName, String embedPictureFormat, String saveToFilePath, String fileFormat, Integer compressionQuality, Integer width, Integer height) {
        super(RequestType.TakeSourceScreenshot);

        this.sourceName = sourceName;
        this.embedPictureFormat = embedPictureFormat;
        this.saveToFilePath = saveToFilePath;
        this.fileFormat = fileFormat;
        this.compressionQuality = compressionQuality;
        this.width = width;
        this.height = height;

        com.messageTypes.put(getMessageId(), TakeSourceScreenshotResponse.class);
    }

    public static class Builder {
        private String sourceName;
        private String embedPictureFormat;
        private String saveToFilePath;
        private String fileFormat;
        private Integer compressionQuality;
        private Integer width;
        private Integer height;

        public Builder() {}

        public Builder(String sourceName) {
            this.sourceName = sourceName;
        }

        public Builder toEmbed(String embedPictureFormat) {
            this.embedPictureFormat = embedPictureFormat;

            return this;
        }

        public Builder toFile(String saveToFilePath) {
            this.saveToFilePath = saveToFilePath;

            return this;
        }

        public Builder toFile(String saveToFilePath, String fileFormat) {
            this.saveToFilePath = saveToFilePath;
            this.fileFormat = fileFormat;

            return this;
        }

        public Builder compressionQuality(Integer compressionQuality) {
            this.compressionQuality = compressionQuality;

            return this;
        }

        public Builder width(Integer width) {
            this.width = width;

            return this;
        }

        public Builder height(Integer height) {
            this.height = height;

            return this;
        }

        public TakeSourceScreenshotRequest build(OBSCommunicator com) {
            return new TakeSourceScreenshotRequest(com, this.sourceName, this.embedPictureFormat, this.saveToFilePath, this.fileFormat, this.compressionQuality, this.width, this.height);
        }
    }
}
