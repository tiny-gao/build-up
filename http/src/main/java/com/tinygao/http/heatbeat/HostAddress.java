package com.tinygao.http.heatbeat;

import lombok.Data;

@Data
public class HostAddress {
    private final String host;
    private final int port;
}
