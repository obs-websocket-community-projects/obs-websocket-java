package net.twasi.obsremotejava.message.request;

import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.request.general.GetStudioModeEnabled;
import net.twasi.obsremotejava.message.request.general.GetVersion;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.scenes.GetSceneList;

import java.util.UUID;

public abstract class Request extends Message {
    protected Type requestType;
    protected String requestId;

    public Request(Type type) {
        super(Message.Type.Request);

        this.requestType = type;
        this.requestId = UUID.randomUUID().toString();
    }

    public Type getRequestType() {
        return this.requestType;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public enum Type {
        // General
        GetVersion(net.twasi.obsremotejava.message.request.general.GetVersion.class, net.twasi.obsremotejava.message.response.general.GetVersion.class),
        GetStudioModeEnabled(net.twasi.obsremotejava.message.request.general.GetStudioModeEnabled.class, net.twasi.obsremotejava.message.response.general.GetStudioModeEnabled.class),

        // Scenes
        GetSceneList(net.twasi.obsremotejava.message.request.scenes.GetSceneList.class, net.twasi.obsremotejava.message.response.scenes.GetSceneList.class),
        ;

        private final Class<? extends Request> requestClass;
        private final Class<? extends RequestResponse> requestResponseClass;

        Type(Class<? extends Request> requestClass, Class<? extends RequestResponse> requestResponseClass) {
            this.requestClass = requestClass;
            this.requestResponseClass = requestResponseClass;
        }

        public Class<? extends Request> getRequestClass() {
            return this.requestClass;
        }

        public Class<? extends RequestResponse> getRequestResponseClass() {
            return this.requestResponseClass;
        }
    }
}
