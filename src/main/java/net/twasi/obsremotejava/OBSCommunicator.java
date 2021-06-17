package net.twasi.obsremotejava;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import net.twasi.obsremotejava.authenticator.Authenticator;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener.CodeReason;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import net.twasi.obsremotejava.message.authentication.Identify;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestBatch;
import net.twasi.obsremotejava.message.request.general.GetVersionRequest;
import net.twasi.obsremotejava.message.response.RequestBatchResponse;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.general.GetVersionResponse;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Slf4j
@WebSocket(maxTextMessageSize = 1024 * 1024, maxIdleTime = 360000000)
public class OBSCommunicator {

    private final CountDownLatch closeLatch = new CountDownLatch(1);

    private final Gson gson;
    private final Authenticator authenticator;

    private final ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners;
    private final ConcurrentHashMap<String, Consumer> requestListeners = new ConcurrentHashMap<>();


    private Session session;

    private final CommunicatorLifecycleListener communicatorLifecycleListener;

    /**
     * All-args constructor used by the builder class.
     * @param gson GSON instance
     * @param authenticator Authenticator instance; NoOpAuthenticator if no password, otherwise AuthenticatorImpl.
     */
    public OBSCommunicator(
            Gson gson,
            Authenticator authenticator,
            CommunicatorLifecycleListener communicatorLifecycleListener,
            ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners) {
        this.gson = gson;
        this.authenticator = authenticator;
        this.communicatorLifecycleListener = communicatorLifecycleListener;
        this.eventListeners = eventListeners == null ? new ConcurrentHashMap<>() : eventListeners;
    }

    public static ObsCommunicatorBuilder builder() {
        return new ObsCommunicatorBuilder();
    }

    private int computeEventSubscription() {
        return this.eventListeners.keySet().stream().map(aClass -> {
            Event.Category category = Event.Category.None;
            try {
                Constructor<? extends Event> constructor = aClass.getDeclaredConstructor(null);
                constructor.setAccessible(true);
                Event instance = constructor.newInstance(null);
                category = instance.getCategory();
            } catch (Throwable t) {
                t.printStackTrace();
            }
            return category;
        }).mapToInt(Event.Category::getValue).reduce(Event.Category.None.getValue(), (a, b) -> a | b);
    }

//    // Old constructor, debug is not used anymore and has hard-coded instantiation. To remove.
//    @Deprecated
//    public OBSCommunicator(boolean debug, String password) {
//        this.gson = ObsCommunicatorBuilder.GSON();
//        this.authenticator = new AuthenticatorImpl(password);
//        this.eventSubscription = ObsCommunicatorBuilder.DEFAULT_SUBSCRIPTION;
//        this.communicatorLifecycleListener = new LoggingCommunicatorLifecycleListener();
//    }
//
//    // Old constructor, debug is not used anymore and has hard-coded instantiation. To remove.
//    @Deprecated
//    public OBSCommunicator(boolean debug) {
//        this.gson = ObsCommunicatorBuilder.GSON();
//        this.authenticator = new NoOpAuthenticator();
//        this.eventSubscription = ObsCommunicatorBuilder.DEFAULT_SUBSCRIPTION;
//        this.communicatorLifecycleListener = new LoggingCommunicatorLifecycleListener();
//    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    public void await() throws InterruptedException {
        this.closeLatch.await();
    }

    @OnWebSocketError
    public void onError(Session session, Throwable t) {
        this.communicatorLifecycleListener
          .onError(this, new ReasonThrowable(
            "Websocket error occurred with session " + session, t
          ));
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        this.communicatorLifecycleListener.onClose(this, new CodeReason(statusCode, reason));
        this.closeLatch.countDown();
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        try {
            log.info("Connected to OBS at: " + this.session.getRemoteAddress());
            this.communicatorLifecycleListener.onConnect(this, this.session);
        } catch (Throwable t) {
            this.communicatorLifecycleListener.onError(this, new ReasonThrowable(
              "An error occurred while trying to get a session", t
            ));
        }
    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
        log.debug("Received message <<\n" + msg);
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
                        this.onEvent((Event) message);
                        break;

                    case RequestResponse:
                        this.onRequestResponse((RequestResponse) message);
                        break;

                    case RequestBatchResponse:
                        this.onRequestBatchResponse((RequestBatchResponse) message);
                        break;

                    case Hello:
                        this.onHello((Hello) message);
                        break;

                    case Identified:
                        this.onIdentified((Identified) message);
                        break;

                    default:
                        this.communicatorLifecycleListener.onError(this, new ReasonThrowable(
                          "Invalid response type received", null
                        ));
                }
            }
            else {
                this.communicatorLifecycleListener
                  .onError(this, new ReasonThrowable(
                    "Received message was serializable but had unknown format", null
                  ));
            }
        } catch (JsonSyntaxException jsonSyntaxException) {
            this.communicatorLifecycleListener
              .onError(this, new ReasonThrowable(
                "Message received was not valid json: " + msg, jsonSyntaxException
              ));
        } catch (Throwable t) {
            this.communicatorLifecycleListener
              .onError(this, new ReasonThrowable(
                "Failed to process message from websocket due to unexpected exception", t
              ));
        }
    }

    private void onEvent(Event event) {
        try {
            if (this.eventListeners.containsKey(event.getClass())) {
                this.eventListeners.get(event.getClass()).accept(event);
            }
        } catch (Throwable t) {
            this.communicatorLifecycleListener
              .onError(this, new ReasonThrowable(
                "Failed to execute callback for Event: " + event.getEventType(), t
              ));
        }
    }

    private void onRequestResponse(RequestResponse requestResponse) {
        try {
            if (this.requestListeners.containsKey(requestResponse.getRequestId())) {
                this.requestListeners.get(requestResponse.getRequestId()).accept(requestResponse);
            }
        } catch (Throwable t) {
            this.communicatorLifecycleListener.onError(this, new ReasonThrowable(
              "Failed to execute callback for RequestResponse: " + requestResponse.getRequestType(), t
            ));
        }
        finally {
            this.requestListeners.remove(requestResponse.getRequestId());
        }
    }

    private void onRequestBatchResponse(RequestBatchResponse requestBatchResponse) {
        try {
            if (this.requestListeners.containsKey(requestBatchResponse.getRequestId())) {
                this.requestListeners.get(requestBatchResponse.getRequestId()).accept(requestBatchResponse);
            }
        } catch (Throwable t) {
            this.communicatorLifecycleListener.onError(this, new ReasonThrowable(
              "Failed to execute callback for RequestBatchResponse: " + requestBatchResponse, t
            ));
        }
        finally {
            this.requestListeners.remove(requestBatchResponse.getRequestId());
        }
    }

    /**
     * First response from server when reached; contains authentication info if required to connect.
     */
    public void onHello(Hello hello) {

        log.debug(String.format(
          "Negotiated Rpc version %s. Authentication is required: %s",
          hello.getRpcVersion(),
          hello.isAuthenticationRequired()
        ));

        // Build the identify response
        Identify.IdentifyBuilder identifyBuilder = Identify.builder()
          .rpcVersion(hello.getRpcVersion());

        // Add subscription
        identifyBuilder.eventSubscriptions(this.computeEventSubscription());

        // Add authentication, if required
        if(hello.isAuthenticationRequired()) {
            // Build the authentication string
            String authentication = this.authenticator.computeAuthentication(
              hello.getAuthentication().getSalt(),
              hello.getAuthentication().getChallenge()
            );
            identifyBuilder.authentication(authentication);
        }

        // Send the response
        String message = this.gson.toJson(identifyBuilder.build());
        this.communicatorLifecycleListener.onHello(this, hello);
        sendMessage(message);
    }

    /**
     * Sent from server on successful authentication/connection
     */
    public void onIdentified(Identified identified) {
        log.info("Identified by OBS, ready to accept requests");
        this.communicatorLifecycleListener.onIdentified(this, identified);

        this.sendRequest(new GetVersionRequest(), (GetVersionResponse getVersionResponse) -> {
            log.info(String.format("Using OBS %s and Websockets version %s",
                    getVersionResponse.getResponseData().getObsVersion(), getVersionResponse.getResponseData().getObsWebSocketVersion()));
        });
    }

    /**
     * An internal convenience method to centralize outbound calls to OBS
     * for e.g. logging purposes.
     * @param message message to send (e.g. a JSON object)
     */
    private void sendMessage(String message) {
        log.debug("Sent message     >>\n" + message);
        this.session.getRemote().sendStringByFuture(message);
    }

    public <R extends Request, RR extends RequestResponse> void sendRequest(R request, Consumer<RR> callback) {
        this.requestListeners.put(request.getRequestId(), callback);
        this.sendMessage(this.gson.toJson(request));
    }

    public void sendRequestBatch(RequestBatch requestBatch, Consumer<RequestBatchResponse> callback) {
        if (requestBatch.getRequests() != null && !requestBatch.getRequests().isEmpty()) {
            this.requestListeners.put(requestBatch.getRequestId(), callback);
            this.sendMessage(this.gson.toJson(requestBatch));
        }
    }

//    public void getSourcesList(Consumer<GetSourcesListResponse> callback) {
//        this.sendMessage(this.gson.toJson(new GetSourcesListRequest(this)));
//        callbacks.put(GetSourcesListResponse.class, callback);
//    }
//
//    public void setCurrentScene(String scene, Consumer<SetCurrentSceneResponse> callback) {
//        this.sendMessage(this.gson.toJson(new SetCurrentSceneRequest(this, scene)));
//        callbacks.put(SetCurrentSceneResponse.class, callback);
//    }
//
//    public void setCurrentTransition(String transition, Consumer<SetCurrentTransitionResponse> callback) {
//        this.sendMessage(this.gson.toJson(new SetCurrentTransitionRequest(this, transition)));
//        callbacks.put(SetCurrentTransitionResponse.class, callback);
//    }
//
//    public void setSourceVisiblity(String scene, String source, boolean visibility, Consumer<SetSceneItemPropertiesResponse> callback) {
//        SetSceneItemPropertiesRequest request = new SetSceneItemPropertiesRequest(this, scene, source, visibility);
//        log.debug(this.gson.toJson(request));
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetSceneItemPropertiesResponse.class, callback);
//    }
//
//    public void getSceneItemProperties(String scene, String source, Consumer<GetSceneItemPropertiesResponse> callback) {
//        GetSceneItemPropertiesRequest request = new GetSceneItemPropertiesRequest(this, scene, source);
//        log.debug(this.gson.toJson(request));
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetSceneItemPropertiesResponse.class, callback);
//    }
//
//    public void getTransitionList(Consumer<GetTransitionListResponse> callback) {
//        GetTransitionListRequest request = new GetTransitionListRequest(this);
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetTransitionListResponse.class, callback);
//    }
//
//    public void transitionToProgram(String transitionName, int duration, Consumer<TransitionToProgramResponse> callback) {
//        TransitionToProgramRequest request = new TransitionToProgramRequest(this, transitionName, duration);
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(TransitionToProgramResponse.class, callback);
//    }
//
//    public void getSourceSettings(String sourceName, Consumer<GetSourceSettingsResponse> callback) {
//        GetSourceSettingsRequest request = new GetSourceSettingsRequest(this, sourceName);
//        log.debug(this.gson.toJson(request));
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetSourceSettingsResponse.class, callback);
//    }
//
//    public void setSourceSettings(String sourceName, Map<String, Object> settings, Consumer<SetSourceSettingsResponse> callback) {
//        SetSourceSettingsRequest request = new SetSourceSettingsRequest(this, sourceName, settings);
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetSourceSettingsResponse.class, callback);
//    }
//
//    public void getSourceFilters(String sourceName, Consumer<GetSourceFiltersResponse> callback) {
//        GetSourceFiltersRequest request = new GetSourceFiltersRequest(this, sourceName);
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetSourceFiltersResponse.class, callback);
//    }
//
//    public void getSourceFilterInfo(String sourceName, String filterName, Consumer<GetSourceFilterInfoResponse> callback) {
//        GetSourceFilterInfoRequest request = new GetSourceFilterInfoRequest(this, sourceName, filterName);
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetSourceFilterInfoResponse.class, callback);
//    }
//
//    public void setSourceFilterVisibility(String sourceName, String filterName, boolean filterEnabled, Consumer<SetSourceFilterVisibilityResponse> callback) {
//        SetSourceFilterVisibilityRequest request = new SetSourceFilterVisibilityRequest(this, sourceName, filterName, filterEnabled);
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetSourceFilterVisibilityResponse.class, callback);
//    }
//
//    public void setSourceFilterSettings(String sourceName, String filterName, Map<String, Object> settings, Consumer<SetSourceFilterSettingsResponse> callback) {
//        SetSourceFilterSettingsRequest request = new SetSourceFilterSettingsRequest(this, sourceName, filterName, settings);
//        log.debug(this.gson.toJson(request));
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetSourceFilterSettingsResponse.class, callback);
//    }
//
//    public void takeSourceScreenshot(String sourceName, String embedPictureFormat, String saveToFilePath, String fileFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
//        TakeSourceScreenshotRequest request = new TakeSourceScreenshotRequest.Builder(sourceName)
//                .toEmbed(embedPictureFormat)
//                .toFile(saveToFilePath, fileFormat)
//                .compressionQuality(compressionQuality)
//                .width(width)
//                .height(height)
//                .build(this);
//        log.debug(this.gson.toJson(request));
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(TakeSourceScreenshotResponse.class, callback);
//    }
//
//    public void takeSourceScreenshot(Consumer<TakeSourceScreenshotResponse> callback) {
//        TakeSourceScreenshotRequest request = new TakeSourceScreenshotRequest.Builder().build(this);
//        log.debug(this.gson.toJson(request));
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(TakeSourceScreenshotResponse.class, callback);
//    }
//
//    public void takeSourceScreenshotToEmbed(String sourceName, String embedPictureFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
//        TakeSourceScreenshotRequest request = new TakeSourceScreenshotRequest.Builder(sourceName)
//                .toEmbed(embedPictureFormat)
//                .compressionQuality(compressionQuality)
//                .width(width)
//                .height(height)
//                .build(this);
//        log.debug(this.gson.toJson(request));
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(TakeSourceScreenshotResponse.class, callback);
//    }
//
//    public void takeSourceScreenshotToFile(String sourceName, String saveToFilePath, String fileFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
//        TakeSourceScreenshotRequest request = new TakeSourceScreenshotRequest.Builder(sourceName)
//                .toFile(saveToFilePath, fileFormat)
//                .compressionQuality(compressionQuality)
//                .width(width)
//                .height(height)
//                .build(this);
//        log.debug(this.gson.toJson(request));
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(TakeSourceScreenshotResponse.class, callback);
//    }
//
//    public void startRecording(Consumer<StartRecordingResponse> callback) {
//        StartRecordingRequest request = new StartRecordingRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(StartRecordingResponse.class, callback);
//    }
//
//    public void stopRecording(Consumer<StopRecordingResponse> callback) {
//        StopRecordingRequest request = new StopRecordingRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(StopRecordingResponse.class, callback);
//    }
//
//    public void getStreamingStatus(Consumer<GetStreamingStatusResponse> callback) {
//        GetStreamingStatusRequest request = new GetStreamingStatusRequest(this);
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetStreamingStatusResponse.class, callback);
//    }
//
//    public void startStreaming(Consumer<StartStreamingResponse> callback) {
//        StartStreamingRequest request = new StartStreamingRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(StartStreamingResponse.class, callback);
//    }
//
//    public void stopStreaming(Consumer<StopStreamingResponse> callback) {
//        StopStreamingRequest request = new StopStreamingRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(StopStreamingResponse.class, callback);
//    }
//
//    public void listProfiles(Consumer<ListProfilesResponse> callback) {
//        ListProfilesRequest request = new ListProfilesRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(ListProfilesResponse.class, callback);
//    }
//
//    public void getCurrentProfile(Consumer<GetCurrentProfileResponse> callback) {
//        GetCurrentProfileRequest request = new GetCurrentProfileRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetCurrentProfileResponse.class, callback);
//    }
//
//    public void setCurrentProfile(String profile, Consumer<SetCurrentProfileResponse> callback) {
//        SetCurrentProfileRequest request = new SetCurrentProfileRequest(this, profile);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetCurrentProfileResponse.class, callback);
//    }
//
//    public void getCurrentScene(Consumer<GetCurrentSceneResponse> callback) {
//        GetCurrentSceneRequest request = new GetCurrentSceneRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetCurrentSceneResponse.class, callback);
//    }
//
//    public void getVolume(String source, Consumer<GetVolumeResponse> callback) {
//        GetVolumeRequest request = new GetVolumeRequest(this, source);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetVolumeResponse.class, callback);
//    }
//
//    public void setVolume(String source, double volume, Consumer<SetVolumeResponse> callback) {
//        SetVolumeRequest request = new SetVolumeRequest(this, source, volume);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetVolumeResponse.class, callback);
//    }
//
//    public void setMute(String source, boolean mute, Consumer<SetMuteResponse> callback) {
//        SetMuteRequest request = new SetMuteRequest(this, source, mute);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetMuteResponse.class, callback);
//    }
//
//    public void getMute(String source, Consumer<GetMuteResponse> callback) {
//        GetMuteRequest request = new GetMuteRequest(this, source);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetMuteResponse.class, callback);
//    }
//
//    public void toggleMute(String source, Consumer<ToggleMuteResponse> callback) {
//        ToggleMuteRequest request = new ToggleMuteRequest(this, source);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(ToggleMuteResponse.class, callback);
//    }
//
//    public void getPreviewScene(Consumer<GetPreviewSceneResponse> callback) {
//        GetPreviewSceneRequest request = new GetPreviewSceneRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetPreviewSceneResponse.class, callback);
//    }
//
//    public void setPreviewScene(String name, Consumer<SetPreviewSceneResponse> callback) {
//        SetPreviewSceneRequest request = new SetPreviewSceneRequest(this, name);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetPreviewSceneResponse.class, callback);
//    }
//
//    public void getTransitionDuration(Consumer<GetTransitionDurationResponse> callback) {
//        GetTransitionDurationRequest request = new GetTransitionDurationRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetTransitionDurationResponse.class, callback);
//    }
//
//    public void setTransitionDuration(int duration, Consumer<SetTransitionDurationResponse> callback) {
//        SetTransitionDurationRequest request = new SetTransitionDurationRequest(this, duration);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetTransitionDurationResponse.class, callback);
//    }
//
//    public void startReplayBuffer(Consumer<StartReplayBufferResponse> callback) {
//        StartReplayBufferRequest request = new StartReplayBufferRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(StartReplayBufferResponse.class, callback);
//    }
//
//    public void stopReplayBuffer(Consumer<StopReplayBufferResponse> callback) {
//        StopReplayBufferRequest request = new StopReplayBufferRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(StopReplayBufferResponse.class, callback);
//    }
//
//    public void saveReplayBuffer(Consumer<SaveReplayBufferResponse> callback) {
//        SaveReplayBufferRequest request = new SaveReplayBufferRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SaveReplayBufferResponse.class, callback);
//    }
//
//    public void setStudioModeEnabled(boolean enabled, Consumer<SetStudioModeEnabledResponse> callback) {
//        SetStudioModeEnabledRequest request = new SetStudioModeEnabledRequest(this, enabled);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetStudioModeEnabledResponse.class, callback);
//    }
//
//    public void playPauseMedia(String sourceName, Boolean playPause, Consumer<PlayPauseMediaResponse> callback) {
//        PlayPauseMediaRequest request = new PlayPauseMediaRequest(this, sourceName, playPause);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(PlayPauseMediaResponse.class, callback);
//    }
//
//    public void restartMedia(String sourceName, Consumer<RestartMediaResponse> callback) {
//        RestartMediaRequest request = new RestartMediaRequest(this, sourceName);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(RestartMediaResponse.class, callback);
//    }
//
//    public void stopMedia(String sourceName, Consumer<StopMediaResponse> callback) {
//        StopMediaRequest request = new StopMediaRequest(this, sourceName);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(StopMediaResponse.class, callback);
//    }
//
//    public void nextMedia(String sourceName, Consumer<NextMediaResponse> callback) {
//        NextMediaRequest request = new NextMediaRequest(this, sourceName);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(NextMediaResponse.class, callback);
//    }
//
//    public void previousMedia(String sourceName, Consumer<PreviousMediaResponse> callback) {
//        PreviousMediaRequest request = new PreviousMediaRequest(this, sourceName);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(PreviousMediaResponse.class, callback);
//    }
//
//    public void refreshBrowserSource(String sourceName, Consumer<RefreshBrowserSourceResponse> callback) {
//        RefreshBrowserSourceRequest request = new RefreshBrowserSourceRequest(this, sourceName);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(RefreshBrowserSourceResponse.class, callback);
//    }
//
//    public void getAudioMonitorType(String sourceName, Consumer<GetAudioMonitorTypeResponse> callback) {
//        GetAudioMonitorTypeRequest request = new GetAudioMonitorTypeRequest(this, sourceName);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetAudioMonitorTypeResponse.class, callback);
//    }
//
//    public void setAudioMonitorType(String sourceName, GetAudioMonitorTypeResponse.MonitorType monitorType, Consumer<SetAudioMonitorTypeResponse> callback) {
//        SetAudioMonitorTypeRequest request = new SetAudioMonitorTypeRequest(this, sourceName, monitorType);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(SetAudioMonitorTypeResponse.class, callback);
//    }
//
//    public void getSpecialSources(Consumer<GetSpecialSourcesResponse> callback) {
//        GetSpecialSourcesRequest request = new GetSpecialSourcesRequest(this);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(GetSpecialSourcesResponse.class, callback);
//    }
//
//    public void triggerHotkeyByName(String hotkeyName, Consumer<TriggerHotkeyByNameResponse> callback) {
//        TriggerHotkeyByNameRequest request = new TriggerHotkeyByNameRequest(this, hotkeyName);
//
//        this.sendMessage(this.gson.toJson(request));
//        callbacks.put(TriggerHotkeyByNameResponse.class, callback);
//    }

}
