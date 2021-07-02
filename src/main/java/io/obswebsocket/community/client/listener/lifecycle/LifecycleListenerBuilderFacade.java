package io.obswebsocket.community.client.listener.lifecycle;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.ObsRemoteControllerBuilder;
import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListenerBuilder;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.jetty.websocket.api.Session;

public class LifecycleListenerBuilderFacade {

  final ObsRemoteControllerBuilder obsRemoteControllerBuilder;
  final CommunicatorLifecycleListenerBuilder communicatorLifecycleListenerBuilder;
  final ControllerLifecycleListenerBuilder controllerLifecycleListenerBuilder;

  public LifecycleListenerBuilderFacade(
    ObsRemoteControllerBuilder obsRemoteControllerBuilder,
    CommunicatorLifecycleListenerBuilder communicatorLifecycleListenerBuilder,
    ControllerLifecycleListenerBuilder controllerLifecycleListenerBuilder) {
    this.obsRemoteControllerBuilder = obsRemoteControllerBuilder;
    this.communicatorLifecycleListenerBuilder = communicatorLifecycleListenerBuilder;
    this.controllerLifecycleListenerBuilder = controllerLifecycleListenerBuilder;
  }

  public LifecycleListenerBuilderFacade onConnect(
    BiConsumer<OBSCommunicator, Session> onConnectCallback) {
    communicatorLifecycleListenerBuilder.onConnect(onConnectCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onHello(
    BiConsumer<OBSCommunicator, Hello> onHelloCallback) {
    communicatorLifecycleListenerBuilder.onHello(onHelloCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onIdentified(
    BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback) {
    communicatorLifecycleListenerBuilder.onIdentified(onIdentifiedCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onReady(Consumer<OBSCommunicator> onReadyCallback) {
    communicatorLifecycleListenerBuilder.onReady(onReadyCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onClose(
    BiConsumer<OBSCommunicator, WebSocketCloseCode> onCloseCallback) {
    communicatorLifecycleListenerBuilder.onClose(onCloseCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onDisconnect(
    Consumer<OBSCommunicator> onDisconnectCallback) {
    communicatorLifecycleListenerBuilder.onDisconnect(onDisconnectCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onCommunicatorError(
    BiConsumer<OBSCommunicator, ReasonThrowable> onErrorCallback) {
    communicatorLifecycleListenerBuilder.onError(onErrorCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onControllerError(
    BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback) {
    controllerLifecycleListenerBuilder.onError(onErrorCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade withCommunicatorDefaultLogging(boolean defaultLogging) {
    communicatorLifecycleListenerBuilder.withDefaultLogging(defaultLogging);
    return this;
  }

  public LifecycleListenerBuilderFacade withControllerDefaultLogging(boolean defaultLogging) {
    controllerLifecycleListenerBuilder.withDefaultLogging(defaultLogging);
    return this;
  }

  public ObsRemoteControllerBuilder and() {
    return obsRemoteControllerBuilder;
  }

}
