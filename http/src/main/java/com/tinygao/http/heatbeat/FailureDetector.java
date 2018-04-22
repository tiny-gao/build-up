package com.tinygao.http.heatbeat;

public interface FailureDetector {
    State getState(HostAddress hostAddress);
    enum State
    {
        UNKNOWN,
        ALIVE,
        GONE,
        UNRESPONSIVE,
    }
}
