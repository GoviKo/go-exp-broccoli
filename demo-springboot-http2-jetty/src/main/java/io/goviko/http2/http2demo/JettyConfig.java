package io.goviko.http2.http2demo;

import org.springframework.context.annotation.*;
import org.eclipse.jetty.server.*;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;

@Configuration
public class JettyConfig {

    @Bean
    JettyServerCustomizer disableSniHostCheck() {
        return (server) -> {
            for (Connector connector : server.getConnectors()) {
                if (connector instanceof ServerConnector serverConnector) {
                    HttpConnectionFactory connectionFactory = serverConnector
                        .getConnectionFactory(HttpConnectionFactory.class);
                    if (connectionFactory != null) {
                        SecureRequestCustomizer secureRequestCustomizer = connectionFactory.getHttpConfiguration()
                            .getCustomizer(SecureRequestCustomizer.class);
                        if (secureRequestCustomizer != null) {
                            secureRequestCustomizer.setSniHostCheck(false);
                        }
                    }
                }
            }
        };
    }
}
