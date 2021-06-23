package net.twasi.obsremotejava.listener.request;

import java.util.function.Consumer;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestBatch;
import net.twasi.obsremotejava.message.response.RequestBatchResponse;
import net.twasi.obsremotejava.message.response.RequestResponse;

public interface ObsRequestListener {
  void registerRequest(Request request, Consumer callback);
  void onRequestResponse(RequestResponse requestResponse);
  void registerRequestBatch(RequestBatch requestBatch, Consumer callback);
  void onRequestBatchResponse(RequestBatchResponse requestBatchResponse);
}
