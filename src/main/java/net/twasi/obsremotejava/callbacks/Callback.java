package net.twasi.obsremotejava.callbacks;

import net.twasi.obsremotejava.requests.ResponseBase;

public interface Callback {

    void run(ResponseBase response);

}
