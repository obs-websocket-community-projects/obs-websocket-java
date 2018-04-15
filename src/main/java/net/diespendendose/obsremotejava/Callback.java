package net.diespendendose.obsremotejava;

import net.diespendendose.obsremotejava.requests.ResponseBase;

public interface Callback {

    void run(ResponseBase response);

}
