package net.twasi.obsremotejava.requests.TakeSourceScreenshot;

import net.twasi.obsremotejava.requests.ResponseBase;

public class TakeSourceScreenshotResponse extends ResponseBase {
    private String sourceName;
    private String img;
    private String imageFile;

    @Override
    public String toString() {
        return "TakeSourceScreenshotResponse{"
          + super.toString()
          + "sourceName='" + sourceName + '\''
          + ", img='" + img + '\''
          + ", imageFile='" + imageFile + '\''
          + '}';
    }
}
