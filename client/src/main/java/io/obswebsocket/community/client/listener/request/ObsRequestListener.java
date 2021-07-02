package io.obswebsocket.community.client.listener.request;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestBatch;
import io.obswebsocket.community.client.message.response.RequestBatchResponse;
import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.function.Consumer;

public interface ObsRequestListener {

  void registerRequest(Request request, Consumer callback);

  void onRequestResponse(RequestResponse requestResponse);

  void registerRequestBatch(RequestBatch requestBatch, Consumer callback);

  void onRequestBatchResponse(RequestBatchResponse requestBatchResponse);
}
