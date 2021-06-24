package io.obswebsocket.community.message.response.inputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSpecialInputNamesResponse extends RequestResponse {
    private Data responseData;

    public GetSpecialInputNamesResponse() {
        super(Request.Type.GetSpecialInputNames);
    }

    @Getter
    @ToString
    public static class Data {
        @SerializedName("desktop-1")
        private String desktop1;
        @SerializedName("desktop-2")
        private String desktop2;
        @SerializedName("mic-1")
        private String mic1;
        @SerializedName("mic-2")
        private String mic2;
        @SerializedName("mic-3")
        private String mic3;
    }
}
