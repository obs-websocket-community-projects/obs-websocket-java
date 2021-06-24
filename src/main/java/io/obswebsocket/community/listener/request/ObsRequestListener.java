package io.obswebsocket.community.listener.request;

import java.util.function.Consumer;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.request.RequestBatch;
import io.obswebsocket.community.message.response.RequestBatchResponse;
import io.obswebsocket.community.message.response.RequestResponse;

public interface ObsRequestListener {
  void registerRequest(Request request, Consumer callback);
  void onRequestResponse(RequestResponse requestResponse);
  void registerRequestBatch(RequestBatch requestBatch, Consumer callback);
  void onRequestBatchResponse(RequestBatchResponse requestBatchResponse);
}
