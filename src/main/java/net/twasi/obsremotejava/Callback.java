package net.twasi.obsremotejava;

import net.twasi.obsremotejava.requests.ResponseBase;

public interface Callback {

    void run(ResponseBase response);

}
