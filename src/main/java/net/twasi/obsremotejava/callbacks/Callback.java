package net.twasi.obsremotejava.callbacks;

import net.twasi.obsremotejava.requests.ResponseBase;

public interface Callback<ResponseType extends ResponseBase> {

    void run(ResponseType response);

}
