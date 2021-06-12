package net.twasi.obsremotejava;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import net.twasi.obsremotejava.events.EventType;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.MessageDeserializer;
import net.twasi.obsremotejava.message.authentication.Authenticator;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import net.twasi.obsremotejava.message.authentication.Identify;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.event.EventDeserializer;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestDeserializer;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.RequestResponseDeserializer;
import net.twasi.obsremotejava.objects.throwables.InvalidResponseTypeError;
import net.twasi.obsremotejava.requests.Authenticate.AuthenticateRequest;
import net.twasi.obsremotejava.requests.Authenticate.AuthenticateResponse;
import net.twasi.obsremotejava.requests.GetAudioMonitorType.GetAudioMonitorTypeRequest;
import net.twasi.obsremotejava.requests.GetAudioMonitorType.GetAudioMonitorTypeResponse;
import net.twasi.obsremotejava.requests.GetAuthRequired.GetAuthRequiredRequest;
import net.twasi.obsremotejava.requests.GetAuthRequired.GetAuthRequiredResponse;
import net.twasi.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileRequest;
import net.twasi.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileResponse;
import net.twasi.obsremotejava.requests.GetCurrentScene.GetCurrentSceneRequest;
import net.twasi.obsremotejava.requests.GetCurrentScene.GetCurrentSceneResponse;
import net.twasi.obsremotejava.requests.GetMute.GetMuteRequest;
import net.twasi.obsremotejava.requests.GetMute.GetMuteResponse;
import net.twasi.obsremotejava.requests.GetPreviewScene.GetPreviewSceneRequest;
import net.twasi.obsremotejava.requests.GetPreviewScene.GetPreviewSceneResponse;
import net.twasi.obsremotejava.requests.GetSceneItemProperties.GetSceneItemPropertiesRequest;
import net.twasi.obsremotejava.requests.GetSceneItemProperties.GetSceneItemPropertiesResponse;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListRequest;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import net.twasi.obsremotejava.requests.GetSourceFilterInfo.GetSourceFilterInfoRequest;
import net.twasi.obsremotejava.requests.GetSourceFilterInfo.GetSourceFilterInfoResponse;
import net.twasi.obsremotejava.requests.GetSourceFilters.GetSourceFiltersRequest;
import net.twasi.obsremotejava.requests.GetSourceFilters.GetSourceFiltersResponse;
import net.twasi.obsremotejava.requests.GetSourceSettings.GetSourceSettingsRequest;
import net.twasi.obsremotejava.requests.GetSourceSettings.GetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.GetSourcesList.GetSourcesListRequest;
import net.twasi.obsremotejava.requests.GetSourcesList.GetSourcesListResponse;
import net.twasi.obsremotejava.requests.GetSpecialSources.GetSpecialSourcesRequest;
import net.twasi.obsremotejava.requests.GetSpecialSources.GetSpecialSourcesResponse;
import net.twasi.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusRequest;
import net.twasi.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusResponse;
import net.twasi.obsremotejava.requests.GetStudioModeEnabled.GetStudioModeEnabledRequest;
import net.twasi.obsremotejava.requests.GetStudioModeEnabled.GetStudioModeEnabledResponse;
import net.twasi.obsremotejava.requests.GetTransitionDuration.GetTransitionDurationRequest;
import net.twasi.obsremotejava.requests.GetTransitionDuration.GetTransitionDurationResponse;
import net.twasi.obsremotejava.requests.GetTransitionList.GetTransitionListRequest;
import net.twasi.obsremotejava.requests.GetTransitionList.GetTransitionListResponse;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionRequest;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;
import net.twasi.obsremotejava.requests.GetVolume.GetVolumeRequest;
import net.twasi.obsremotejava.requests.GetVolume.GetVolumeResponse;
import net.twasi.obsremotejava.requests.ListProfiles.ListProfilesRequest;
import net.twasi.obsremotejava.requests.ListProfiles.ListProfilesResponse;
import net.twasi.obsremotejava.requests.NextMedia.NextMediaRequest;
import net.twasi.obsremotejava.requests.NextMedia.NextMediaResponse;
import net.twasi.obsremotejava.requests.PlayPauseMedia.PlayPauseMediaRequest;
import net.twasi.obsremotejava.requests.PlayPauseMedia.PlayPauseMediaResponse;
import net.twasi.obsremotejava.requests.PreviousMedia.PreviousMediaRequest;
import net.twasi.obsremotejava.requests.PreviousMedia.PreviousMediaResponse;
import net.twasi.obsremotejava.requests.RefreshBrowserSource.RefreshBrowserSourceRequest;
import net.twasi.obsremotejava.requests.RefreshBrowserSource.RefreshBrowserSourceResponse;
import net.twasi.obsremotejava.requests.ResponseBase;
import net.twasi.obsremotejava.requests.RestartMedia.RestartMediaRequest;
import net.twasi.obsremotejava.requests.RestartMedia.RestartMediaResponse;
import net.twasi.obsremotejava.requests.SaveReplayBuffer.SaveReplayBufferRequest;
import net.twasi.obsremotejava.requests.SaveReplayBuffer.SaveReplayBufferResponse;
import net.twasi.obsremotejava.requests.SetAudioMonitorType.SetAudioMonitorTypeRequest;
import net.twasi.obsremotejava.requests.SetAudioMonitorType.SetAudioMonitorTypeResponse;
import net.twasi.obsremotejava.requests.SetCurrentProfile.SetCurrentProfileRequest;
import net.twasi.obsremotejava.requests.SetCurrentProfile.SetCurrentProfileResponse;
import net.twasi.obsremotejava.requests.SetCurrentScene.SetCurrentSceneRequest;
import net.twasi.obsremotejava.requests.SetCurrentScene.SetCurrentSceneResponse;
import net.twasi.obsremotejava.requests.SetCurrentTransition.SetCurrentTransitionRequest;
import net.twasi.obsremotejava.requests.SetCurrentTransition.SetCurrentTransitionResponse;
import net.twasi.obsremotejava.requests.SetMute.SetMuteRequest;
import net.twasi.obsremotejava.requests.SetMute.SetMuteResponse;
import net.twasi.obsremotejava.requests.SetPreviewScene.SetPreviewSceneRequest;
import net.twasi.obsremotejava.requests.SetPreviewScene.SetPreviewSceneResponse;
import net.twasi.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesRequest;
import net.twasi.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesResponse;
import net.twasi.obsremotejava.requests.SetSourceFilterSettings.SetSourceFilterSettingsRequest;
import net.twasi.obsremotejava.requests.SetSourceFilterSettings.SetSourceFilterSettingsResponse;
import net.twasi.obsremotejava.requests.SetSourceFilterVisibility.SetSourceFilterVisibilityRequest;
import net.twasi.obsremotejava.requests.SetSourceFilterVisibility.SetSourceFilterVisibilityResponse;
import net.twasi.obsremotejava.requests.SetSourceSettings.SetSourceSettingsRequest;
import net.twasi.obsremotejava.requests.SetSourceSettings.SetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.SetStudioModeEnabled.SetStudioModeEnabledRequest;
import net.twasi.obsremotejava.requests.SetStudioModeEnabled.SetStudioModeEnabledResponse;
import net.twasi.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationRequest;
import net.twasi.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationResponse;
import net.twasi.obsremotejava.requests.SetVolume.SetVolumeRequest;
import net.twasi.obsremotejava.requests.SetVolume.SetVolumeResponse;
import net.twasi.obsremotejava.requests.StartRecording.StartRecordingRequest;
import net.twasi.obsremotejava.requests.StartRecording.StartRecordingResponse;
import net.twasi.obsremotejava.requests.StartReplayBuffer.StartReplayBufferRequest;
import net.twasi.obsremotejava.requests.StartReplayBuffer.StartReplayBufferResponse;
import net.twasi.obsremotejava.requests.StartStreaming.StartStreamingRequest;
import net.twasi.obsremotejava.requests.StartStreaming.StartStreamingResponse;
import net.twasi.obsremotejava.requests.StopMedia.StopMediaRequest;
import net.twasi.obsremotejava.requests.StopMedia.StopMediaResponse;
import net.twasi.obsremotejava.requests.StopRecording.StopRecordingRequest;
import net.twasi.obsremotejava.requests.StopRecording.StopRecordingResponse;
import net.twasi.obsremotejava.requests.StopReplayBuffer.StopReplayBufferRequest;
import net.twasi.obsremotejava.requests.StopReplayBuffer.StopReplayBufferResponse;
import net.twasi.obsremotejava.requests.StopStreaming.StopStreamingRequest;
import net.twasi.obsremotejava.requests.StopStreaming.StopStreamingResponse;
import net.twasi.obsremotejava.requests.TakeSourceScreenshot.TakeSourceScreenshotRequest;
import net.twasi.obsremotejava.requests.TakeSourceScreenshot.TakeSourceScreenshotResponse;
import net.twasi.obsremotejava.requests.ToggleMute.ToggleMuteRequest;
import net.twasi.obsremotejava.requests.ToggleMute.ToggleMuteResponse;
import net.twasi.obsremotejava.requests.TransitionToProgram.TransitionToProgramRequest;
import net.twasi.obsremotejava.requests.TransitionToProgram.TransitionToProgramResponse;
import net.twasi.obsremotejava.requests.TriggerHotkeyByName.TriggerHotkeyByNameRequest;
import net.twasi.obsremotejava.requests.TriggerHotkeyByName.TriggerHotkeyByNameResponse;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Slf4j
@WebSocket(maxTextMessageSize = 1024 * 1024, maxIdleTime = 360000000)
public class OBSCommunicator {

    private final Gson gson;
    private final Authenticator authenticator;
    private final String password;

    private final CountDownLatch closeLatch = new CountDownLatch(1);
    public final Map<String, Class<? extends ResponseBase>> messageTypes = new HashMap<>();
    private final Map<Class<? extends ResponseBase>, Consumer> callbacks = new HashMap<>();
    private final Map<Class<? extends Event>, Consumer> eventListeners = new HashMap<>();

    private Session session;

    private Consumer<GetVersionResponse> onConnect;
    private Runnable onDisconnect;
    private BiConsumer<Integer, String> onClose;
    private Consumer<String> onConnectionFailed;
    private BiConsumer<String, Throwable> onError;

    private GetVersionResponse versionInfo;

    /**
     * All-args constructor used by the builder class.
     * @param gson GSON instance
     * @param authenticator Authenticator instance
     * @param password Password, nullable
     */
    public OBSCommunicator(
          Gson gson,
          Authenticator authenticator,
          String password) {
        this.gson = gson;
        this.authenticator = authenticator;
        this.password = password;
    }

    public static ObsCommunicatorBuilder builder() {
        return new ObsCommunicatorBuilder();
    }

    // Old constructor, debug is not used anymore and has hard-coded instantiation. To remove.
    public OBSCommunicator(boolean debug, String password) {
        this.password = password;
        this.gson = ObsCommunicatorBuilder.GSON();
        this.authenticator = ObsCommunicatorBuilder.AUTHENTICATOR();
    }

    public OBSCommunicator(boolean debug) {
        this(debug, null);
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    public void await() throws InterruptedException {
        this.closeLatch.await();
    }

    @OnWebSocketError
    public void onError(Session session, Throwable throwable) {
        // do nothing for now, this should at least repress "OnWebsocketError not registered" messages
        runOnConnectionFailed("Websocket error occurred with session " + session, throwable);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        log.info(String.format("Connection closed: %d - %s%n", statusCode, reason));
        runOnDisconnect();
        this.closeLatch.countDown(); // trigger latch
        runOnClosed(statusCode, reason);
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        try {
//            Future<Void> fut;
//            fut = this.sendMessage(this.gson.toJson(new GetVersionRequest(this)));
//            fut.get(2, TimeUnit.SECONDS);
            log.info("Connected to OBS at: " + session.getRemoteAddress());
        } catch (Throwable t) {
            runOnError("An error occurred while trying to get a session", t);
        }
    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
        log.debug("Received message << " + msg);
        if (msg == null) {
            log.debug("Ignored empty message");
            return;
        }

        try {
            // v 5.x
            Message message = this.gson.fromJson(msg, Message.class);
            if (message != null) {
                switch (message.getMessageType()) {
                    case Event:
                        Event event = (Event) message;
                        try {
                            if (this.eventListeners.containsKey(event.getClass())) {
                                this.eventListeners.get(event.getClass()).accept(event);
                            }
                        } catch (Throwable t) {
                            runOnError("Failed to execute callback for event: " + event.getEventType(), t);
                        }
                        break;

                    case RequestResponse:
                        // TODO RequestResponse
                        // processRequestResponse(message)
                        break;

                    case RequestBatchResponse:
                        // TODO RequestBatchResponse
                        // processRequestBatchResponse(message)
                        break;

                    case Hello:
                        onHello(session, (Hello) message);
                        break;

                    case Identified:
                        onIdentified(session, (Identified) message);
                        break;
                }
            }
            else {
                runOnError("Received message had unknown format", null);
            }

            // v 4.x
//            JsonElement jsonElement = JsonParser.parseString(msg);
//            if (jsonElement.isJsonObject()) {
//                JsonObject jsonObject = jsonElement.getAsJsonObject();
//
//                if (jsonObject.has("message-id")) {
//                    // Message is a Response
//                    Class<? extends ResponseBase> responseType = messageTypes.get(jsonObject.get("message-id").getAsString());
//                    log.trace(String.format("Trying to deserialize response with type %s and message '%s'", responseType, msg));
//                    ResponseBase responseBase = this.gson.fromJson(jsonObject, responseType);
//
//                    try {
//                        processIncomingResponse(responseBase, responseType);
//                    } catch (Throwable t) {
//                        runOnError("Failed to process response '" + responseType.getSimpleName() + "' from websocket", t);
//                    }
//                }
//            } else {
//                throw new IllegalArgumentException("Received message is not a JsonObject");
//            }
        } catch (Throwable t) {
            runOnError("Failed to process message from websocket", t);
        }
    }

//    private <T extends ResponseBase> void processIncomingResponse(T responseBase, Class<? extends ResponseBase> type) {
//        switch (type.getSimpleName()) {
//            case "GetVersionResponse":
//                versionInfo = (GetVersionResponse) responseBase;
//                log.info(String.format("Connected to OBS. Websocket Version: %s, Studio Version: %s\n", versionInfo.getObsWebsocketVersion(), versionInfo.getObsStudioVersion()));
//                this.sendMessage(this.gson.toJson(new GetAuthRequiredRequest(this)));
//                break;
//
//            case "GetAuthRequiredResponse":
//                GetAuthRequiredResponse authRequiredResponse = (GetAuthRequiredResponse) responseBase;
//                if (authRequiredResponse.isAuthRequired()) {
//                    log.info("Authentication is required.");
//                    authenticateWithServer(authRequiredResponse.getChallenge(), authRequiredResponse.getSalt());
//                } else {
//                    log.info("Authentication is not required. You're ready to go!");
//                    runOnConnect(versionInfo);
//                }
//                break;
//
//            case "AuthenticateResponse":
//                AuthenticateResponse authenticateResponse = (AuthenticateResponse) responseBase;
//
//                if ("ok".equals(authenticateResponse.getStatus())) {
//                    runOnConnect(versionInfo);
//                } else {
//                    runOnConnectionFailed("Failed to authenticate with password. Error: " + authenticateResponse.getError(), null);
//                }
//
//                break;
//
//            default:
//                if (!callbacks.containsKey(type)) {
//                    log.warn("Invalid type received: " + type.getName());
//                    runOnError("Invalid response type received", new InvalidResponseTypeError(type.getName()));
//                    return;
//                }
//
//                try {
//                    callbacks.get(type).accept(responseBase);
//                } catch (Throwable t) {
//                    runOnError("Failed to execute callback for response: " + type, t);
//                }
//        }
//    }

    /**
     * First response from server when reached; contains authentication info if required to connect.
     */
    public void onHello(Session session, Hello hello) {

        // Build the identify response
        Identify.IdentifyBuilder identifyBuilder = Identify.builder()
          .rpcVersion(hello.getRpcVersion());
        // Others?

        if(hello.isAuthenticationRequired()) {
            // Build the authentication string
            String authentication = authenticator.computeAuthentication(
              password,
              hello.getAuthentication().getSalt(),
              hello.getAuthentication().getChallenge()
            );
            identifyBuilder.authentication(authentication);
        }

        // Send the response
        String message = this.gson.toJson(identifyBuilder.build());
        sendMessage(message);

    }



    /**
     * Sent from server on successful authentication/connection
     */
    public void onIdentified(Session session, Identified identified) {
        log.info("Connected to OBS, ready to accept requests");
        log.info(identified.toString());
//        this.getVersion(res -> {
//            log.info(String.format("Using OBS %s and Websockets version %s",
//              res.getObsStudioVersion(), res.getObsWebsocketVersion()));
//        });
    }

    public void sendMessage(String message) {
        log.debug("Sent message     >> " + message);
        session.getRemote().sendStringByFuture(message);
    }

//    private void authenticateWithServer(String challenge, String salt) {
//        if (password == null) {
//            runOnConnectionFailed("Authentication required by server but no password set by client", null);
//            return;
//        }
//
//        // Generate authentication response secret
//        String authResponse = authenticator.computeAuthentication(password, salt, challenge);
//
//        if (authResponse == null) {
//            return;
//        }
//
//        // Send authentication response secret to server
//        this.sendMessage(this.gson.toJson(new AuthenticateRequest(this, authResponse)));
//    }

    public <T extends Event> void registerEventListener(Class<T> eventType, Consumer<T> listener) {
        this.eventListeners.put(eventType, listener);
    }

    public void registerOnError(BiConsumer<String, Throwable> onError) {
        this.onError = onError;
    }

    public void registerOnConnect(Consumer<GetVersionResponse> onConnect) {
        this.onConnect = onConnect;
    }

    public void registerOnDisconnect(Runnable onDisconnect) {
        this.onDisconnect = onDisconnect;
    }

    public void registerOnClose(BiConsumer<Integer, String> closeCallback) {
        this.onClose = closeCallback;
    }

    public void registerOnConnectionFailed(Consumer<String> onConnectionFailed) {
        this.onConnectionFailed = onConnectionFailed;
    }

    public void getVersion(Consumer<GetVersionResponse> callback) {
        this.sendMessage(this.gson.toJson(new GetVersionRequest(this)));
        callbacks.put(GetVersionResponse.class, callback);
    }

    public void getScenes(Consumer<GetSceneListResponse> callback) {
        this.sendMessage(this.gson.toJson(new GetSceneListRequest(this)));
        callbacks.put(GetSceneListResponse.class, callback);
    }

    public void getSourcesList(Consumer<GetSourcesListResponse> callback) {
        this.sendMessage(this.gson.toJson(new GetSourcesListRequest(this)));
        callbacks.put(GetSourcesListResponse.class, callback);
    }

    public void setCurrentScene(String scene, Consumer<SetCurrentSceneResponse> callback) {
        this.sendMessage(this.gson.toJson(new SetCurrentSceneRequest(this, scene)));
        callbacks.put(SetCurrentSceneResponse.class, callback);
    }

    public void setCurrentTransition(String transition, Consumer<SetCurrentTransitionResponse> callback) {
        this.sendMessage(this.gson.toJson(new SetCurrentTransitionRequest(this, transition)));
        callbacks.put(SetCurrentTransitionResponse.class, callback);
    }

    public void setSourceVisiblity(String scene, String source, boolean visibility, Consumer<SetSceneItemPropertiesResponse> callback) {
        SetSceneItemPropertiesRequest request = new SetSceneItemPropertiesRequest(this, scene, source, visibility);
        log.debug(this.gson.toJson(request));
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetSceneItemPropertiesResponse.class, callback);
    }

    public void getSceneItemProperties(String scene, String source, Consumer<GetSceneItemPropertiesResponse> callback) {
        GetSceneItemPropertiesRequest request = new GetSceneItemPropertiesRequest(this, scene, source);
        log.debug(this.gson.toJson(request));
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetSceneItemPropertiesResponse.class, callback);
    }

    public void getTransitionList(Consumer<GetTransitionListResponse> callback) {
        GetTransitionListRequest request = new GetTransitionListRequest(this);
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetTransitionListResponse.class, callback);
    }

    public void transitionToProgram(String transitionName, int duration, Consumer<TransitionToProgramResponse> callback) {
        TransitionToProgramRequest request = new TransitionToProgramRequest(this, transitionName, duration);
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(TransitionToProgramResponse.class, callback);
    }

    public void getSourceSettings(String sourceName, Consumer<GetSourceSettingsResponse> callback) {
        GetSourceSettingsRequest request = new GetSourceSettingsRequest(this, sourceName);
        log.debug(this.gson.toJson(request));
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetSourceSettingsResponse.class, callback);
    }

    public void setSourceSettings(String sourceName, Map<String, Object> settings, Consumer<SetSourceSettingsResponse> callback) {
        SetSourceSettingsRequest request = new SetSourceSettingsRequest(this, sourceName, settings);
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetSourceSettingsResponse.class, callback);
    }

    public void getSourceFilters(String sourceName, Consumer<GetSourceFiltersResponse> callback) {
        GetSourceFiltersRequest request = new GetSourceFiltersRequest(this, sourceName);
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetSourceFiltersResponse.class, callback);
    }

    public void getSourceFilterInfo(String sourceName, String filterName, Consumer<GetSourceFilterInfoResponse> callback) {
        GetSourceFilterInfoRequest request = new GetSourceFilterInfoRequest(this, sourceName, filterName);
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetSourceFilterInfoResponse.class, callback);
    }

    public void setSourceFilterVisibility(String sourceName, String filterName, boolean filterEnabled, Consumer<SetSourceFilterVisibilityResponse> callback) {
        SetSourceFilterVisibilityRequest request = new SetSourceFilterVisibilityRequest(this, sourceName, filterName, filterEnabled);
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetSourceFilterVisibilityResponse.class, callback);
    }

    public void setSourceFilterSettings(String sourceName, String filterName, Map<String, Object> settings, Consumer<SetSourceFilterSettingsResponse> callback) {
        SetSourceFilterSettingsRequest request = new SetSourceFilterSettingsRequest(this, sourceName, filterName, settings);
        log.debug(this.gson.toJson(request));
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetSourceFilterSettingsResponse.class, callback);
    }

    public void takeSourceScreenshot(String sourceName, String embedPictureFormat, String saveToFilePath, String fileFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
        TakeSourceScreenshotRequest request = new TakeSourceScreenshotRequest.Builder(sourceName)
                .toEmbed(embedPictureFormat)
                .toFile(saveToFilePath, fileFormat)
                .compressionQuality(compressionQuality)
                .width(width)
                .height(height)
                .build(this);
        log.debug(this.gson.toJson(request));
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(TakeSourceScreenshotResponse.class, callback);
    }

    public void takeSourceScreenshot(Consumer<TakeSourceScreenshotResponse> callback) {
        TakeSourceScreenshotRequest request = new TakeSourceScreenshotRequest.Builder().build(this);
        log.debug(this.gson.toJson(request));
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(TakeSourceScreenshotResponse.class, callback);
    }

    public void takeSourceScreenshotToEmbed(String sourceName, String embedPictureFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
        TakeSourceScreenshotRequest request = new TakeSourceScreenshotRequest.Builder(sourceName)
                .toEmbed(embedPictureFormat)
                .compressionQuality(compressionQuality)
                .width(width)
                .height(height)
                .build(this);
        log.debug(this.gson.toJson(request));
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(TakeSourceScreenshotResponse.class, callback);
    }

    public void takeSourceScreenshotToFile(String sourceName, String saveToFilePath, String fileFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
        TakeSourceScreenshotRequest request = new TakeSourceScreenshotRequest.Builder(sourceName)
                .toFile(saveToFilePath, fileFormat)
                .compressionQuality(compressionQuality)
                .width(width)
                .height(height)
                .build(this);
        log.debug(this.gson.toJson(request));
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(TakeSourceScreenshotResponse.class, callback);
    }

    public void startRecording(Consumer<StartRecordingResponse> callback) {
        StartRecordingRequest request = new StartRecordingRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(StartRecordingResponse.class, callback);
    }

    public void stopRecording(Consumer<StopRecordingResponse> callback) {
        StopRecordingRequest request = new StopRecordingRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(StopRecordingResponse.class, callback);
    }

    public void getStreamingStatus(Consumer<GetStreamingStatusResponse> callback) {
        GetStreamingStatusRequest request = new GetStreamingStatusRequest(this);
        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetStreamingStatusResponse.class, callback);
    }

    public void startStreaming(Consumer<StartStreamingResponse> callback) {
        StartStreamingRequest request = new StartStreamingRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(StartStreamingResponse.class, callback);
    }

    public void stopStreaming(Consumer<StopStreamingResponse> callback) {
        StopStreamingRequest request = new StopStreamingRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(StopStreamingResponse.class, callback);
    }

    public void listProfiles(Consumer<ListProfilesResponse> callback) {
        ListProfilesRequest request = new ListProfilesRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(ListProfilesResponse.class, callback);
    }

    public void getCurrentProfile(Consumer<GetCurrentProfileResponse> callback) {
        GetCurrentProfileRequest request = new GetCurrentProfileRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetCurrentProfileResponse.class, callback);
    }

    public void setCurrentProfile(String profile, Consumer<SetCurrentProfileResponse> callback) {
        SetCurrentProfileRequest request = new SetCurrentProfileRequest(this, profile);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetCurrentProfileResponse.class, callback);
    }

    public void getCurrentScene(Consumer<GetCurrentSceneResponse> callback) {
        GetCurrentSceneRequest request = new GetCurrentSceneRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetCurrentSceneResponse.class, callback);
    }

    public void getVolume(String source, Consumer<GetVolumeResponse> callback) {
        GetVolumeRequest request = new GetVolumeRequest(this, source);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetVolumeResponse.class, callback);
    }

    public void setVolume(String source, double volume, Consumer<SetVolumeResponse> callback) {
        SetVolumeRequest request = new SetVolumeRequest(this, source, volume);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetVolumeResponse.class, callback);
    }

    public void setMute(String source, boolean mute, Consumer<SetMuteResponse> callback) {
        SetMuteRequest request = new SetMuteRequest(this, source, mute);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetMuteResponse.class, callback);
    }

    public void getMute(String source, Consumer<GetMuteResponse> callback) {
        GetMuteRequest request = new GetMuteRequest(this, source);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetMuteResponse.class, callback);
    }

    public void toggleMute(String source, Consumer<ToggleMuteResponse> callback) {
        ToggleMuteRequest request = new ToggleMuteRequest(this, source);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(ToggleMuteResponse.class, callback);
    }

    public void getPreviewScene(Consumer<GetPreviewSceneResponse> callback) {
        GetPreviewSceneRequest request = new GetPreviewSceneRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetPreviewSceneResponse.class, callback);
    }

    public void setPreviewScene(String name, Consumer<SetPreviewSceneResponse> callback) {
        SetPreviewSceneRequest request = new SetPreviewSceneRequest(this, name);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetPreviewSceneResponse.class, callback);
    }

    public void getTransitionDuration(Consumer<GetTransitionDurationResponse> callback) {
        GetTransitionDurationRequest request = new GetTransitionDurationRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetTransitionDurationResponse.class, callback);
    }

    public void setTransitionDuration(int duration, Consumer<SetTransitionDurationResponse> callback) {
        SetTransitionDurationRequest request = new SetTransitionDurationRequest(this, duration);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetTransitionDurationResponse.class, callback);
    }

    public void startReplayBuffer(Consumer<StartReplayBufferResponse> callback) {
        StartReplayBufferRequest request = new StartReplayBufferRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(StartReplayBufferResponse.class, callback);
    }

    public void stopReplayBuffer(Consumer<StopReplayBufferResponse> callback) {
        StopReplayBufferRequest request = new StopReplayBufferRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(StopReplayBufferResponse.class, callback);
    }

    public void saveReplayBuffer(Consumer<SaveReplayBufferResponse> callback) {
        SaveReplayBufferRequest request = new SaveReplayBufferRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SaveReplayBufferResponse.class, callback);
    }

    public void getStudioModeEnabled(Consumer<GetStudioModeEnabledResponse> callback) {
        GetStudioModeEnabledRequest request = new GetStudioModeEnabledRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetStudioModeEnabledResponse.class, callback);
    }

    public void setStudioModeEnabled(boolean enabled, Consumer<SetStudioModeEnabledResponse> callback) {
        SetStudioModeEnabledRequest request = new SetStudioModeEnabledRequest(this, enabled);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetStudioModeEnabledResponse.class, callback);
    }

    public void playPauseMedia(String sourceName, Boolean playPause, Consumer<PlayPauseMediaResponse> callback) {
        PlayPauseMediaRequest request = new PlayPauseMediaRequest(this, sourceName, playPause);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(PlayPauseMediaResponse.class, callback);
    }

    public void restartMedia(String sourceName, Consumer<RestartMediaResponse> callback) {
        RestartMediaRequest request = new RestartMediaRequest(this, sourceName);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(RestartMediaResponse.class, callback);
    }

    public void stopMedia(String sourceName, Consumer<StopMediaResponse> callback) {
        StopMediaRequest request = new StopMediaRequest(this, sourceName);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(StopMediaResponse.class, callback);
    }

    public void nextMedia(String sourceName, Consumer<NextMediaResponse> callback) {
        NextMediaRequest request = new NextMediaRequest(this, sourceName);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(NextMediaResponse.class, callback);
    }

    public void previousMedia(String sourceName, Consumer<PreviousMediaResponse> callback) {
        PreviousMediaRequest request = new PreviousMediaRequest(this, sourceName);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(PreviousMediaResponse.class, callback);
    }

    public void refreshBrowserSource(String sourceName, Consumer<RefreshBrowserSourceResponse> callback) {
        RefreshBrowserSourceRequest request = new RefreshBrowserSourceRequest(this, sourceName);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(RefreshBrowserSourceResponse.class, callback);
    }

    public void getAudioMonitorType(String sourceName, Consumer<GetAudioMonitorTypeResponse> callback) {
        GetAudioMonitorTypeRequest request = new GetAudioMonitorTypeRequest(this, sourceName);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetAudioMonitorTypeResponse.class, callback);
    }

    public void setAudioMonitorType(String sourceName, GetAudioMonitorTypeResponse.MonitorType monitorType, Consumer<SetAudioMonitorTypeResponse> callback) {
        SetAudioMonitorTypeRequest request = new SetAudioMonitorTypeRequest(this, sourceName, monitorType);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(SetAudioMonitorTypeResponse.class, callback);
    }

    public void getSpecialSources(Consumer<GetSpecialSourcesResponse> callback) {
        GetSpecialSourcesRequest request = new GetSpecialSourcesRequest(this);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(GetSpecialSourcesResponse.class, callback);
    }

    public void triggerHotkeyByName(String hotkeyName, Consumer<TriggerHotkeyByNameResponse> callback) {
        TriggerHotkeyByNameRequest request = new TriggerHotkeyByNameRequest(this, hotkeyName);

        this.sendMessage(this.gson.toJson(request));
        callbacks.put(TriggerHotkeyByNameResponse.class, callback);
    }

    private void runOnError(String message, Throwable throwable) {
        log.debug("Running onError with message: " + message + " and exception:", throwable);
        if (onError == null) {
            log.debug("No onError callback was registered");
            return;
        }

        try {
            onError.accept(message, throwable);
        } catch (Throwable t) {
            log.error("Unable to run onError callback", t);
        }
    }

    private void runOnConnectionFailed(String message, Throwable throwable) {
        log.debug("Running onConnectionFailed, with message: " + message);
        if (onConnectionFailed == null) {
            log.debug("No onConnectionFailed callback was registered");
            return;
        }

        try {
            onConnectionFailed.accept(message);
        } catch (Throwable t) {
            log.error("Unable to run OnConnectionFailed callback", t);
        }
    }

    private void runOnConnect(GetVersionResponse versionInfo) {
        log.debug("Running onConnect with versionInfo: " + versionInfo);
        if (onConnect == null) {
            log.debug("No onConnect callback was registered");
            return;
        }

        try {
            onConnect.accept(versionInfo);
        } catch (Throwable t) {
            log.error("Unable to run OnConnect callback", t);
        }
    }

    void runOnDisconnect() {
        log.debug("Running onDisconnect");
        if (onDisconnect == null) {
            log.debug("No onDisconnect callback was registered");
            return;
        }

        try {
            onDisconnect.run();
        } catch (Throwable t) {
            log.error("Unable to run OnDisconnect callback", t);
        }
    }


    private void runOnClosed(int statusCode, String reason) {
        log.debug("Running onClose with statusCode " + statusCode + " and reason: " + reason);

        if (this.onClose == null) {
            log.debug("No onClose was registered.");
            return;
        }

        try {
            onClose.accept(statusCode, reason);
        } catch (Throwable t) {
            log.error("Unable to run onClose callback", t);
        }
    }
}
