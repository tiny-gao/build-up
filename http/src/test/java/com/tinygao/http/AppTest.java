package com.tinygao.http;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppTest {
    public static void main(String[] args) {
        Config config = ConfigFactory.load().getConfig("app");
        log.info("test: {}", config.getString("root"));
    }
}
