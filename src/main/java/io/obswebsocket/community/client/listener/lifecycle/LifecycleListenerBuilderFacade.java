package io.obswebsocket.community.client.listener.lifecycle;

import io.obswebsocket.community.client.OBSRemoteControllerBuilder;
import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListenerBuilder;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import java.util.function.Consumer;
import org.eclipse.jetty.websocket.api.Session;

public class LifecycleListenerBuilderFacade {

  final OBSRemoteControllerBuilder obsRemoteControllerBuilder;
  final CommunicatorLifecycleListenerBuilder communicatorLifecycleListenerBuilder;
  final ControllerLifecycleListenerBuilder controllerLifecycleListenerBuilder;

  public LifecycleListenerBuilderFacade(
    OBSRemoteControllerBuilder obsRemoteControllerBuilder,
    CommunicatorLifecycleListenerBuilder communicatorLifecycleListenerBuilder,
    ControllerLifecycleListenerBuilder controllerLifecycleListenerBuilder) {
    this.obsRemoteControllerBuilder = obsRemoteControllerBuilder;
    this.communicatorLifecycleListenerBuilder = communicatorLifecycleListenerBuilder;
    this.controllerLifecycleListenerBuilder = controllerLifecycleListenerBuilder;
  }

  public LifecycleListenerBuilderFacade onConnect(
    Consumer<Session> onConnectCallback) {
    communicatorLifecycleListenerBuilder.onConnect(onConnectCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onHello(
    Consumer<Hello> onHelloCallback) {
    communicatorLifecycleListenerBuilder.onHello(onHelloCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onIdentified(
    Consumer<Identified> onIdentifiedCallback) {
    communicatorLifecycleListenerBuilder.onIdentified(onIdentifiedCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onReady(Runnable onReadyCallback) {
    communicatorLifecycleListenerBuilder.onReady(onReadyCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onClose(
    Consumer<WebSocketCloseCode> onCloseCallback) {
    communicatorLifecycleListenerBuilder.onClose(onCloseCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onDisconnect(
    Runnable onDisconnectCallback) {
    communicatorLifecycleListenerBuilder.onDisconnect(onDisconnectCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onCommunicatorError(
    Consumer<ReasonThrowable> onErrorCallback) {
    communicatorLifecycleListenerBuilder.onError(onErrorCallback);
    return this;
  }

  public LifecycleListenerBuilderFacade onControllerError(
    Consumer<ReasonThrowable> onErrorCallback) {
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

  public OBSRemoteControllerBuilder and() {
    return obsRemoteControllerBuilder;
  }

}
