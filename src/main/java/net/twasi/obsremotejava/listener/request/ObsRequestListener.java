package net.twasi.obsremotejava.listener.request;

import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestBatch;
import net.twasi.obsremotejava.message.response.RequestResponse;

public interface ObsRequestListener {
  void onRequest(Request request);
  void onRequestBatch(RequestBatch requestBatch);
  void onRequestResponse(RequestResponse requestResponse);
}
