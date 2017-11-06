package com.sample.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * Created by TaeHwan
 * 2017. 11. 5. PM 10:31
 */
@Configuration
public class H2ServerConfig {
    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer().start();
    }
}
