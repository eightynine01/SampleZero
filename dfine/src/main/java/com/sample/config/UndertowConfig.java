package com.sample.config;

import io.undertow.UndertowOptions;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by TaeHwan
 * 2017. 11. 5. PM 10:39
 */
@Configuration
public class UndertowConfig {
    @Bean
    public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        factory.addBuilderCustomizers(
                (UndertowBuilderCustomizer) builder ->
                        builder
                                .addHttpListener(8080, "0.0.0.0")
                                .setServerOption(UndertowOptions.ENABLE_HTTP2,true)
        );
        return factory;
    }
}
