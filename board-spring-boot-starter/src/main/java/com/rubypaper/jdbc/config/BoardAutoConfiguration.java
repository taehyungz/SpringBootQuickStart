package com.rubypaper.jdbc.config;

import com.rubypaper.jdbc.util.JDBCConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class) //활성화 할 프로퍼티 클래스 지정
public class BoardAutoConfiguration {
    @Autowired
    private JDBCConnectionManagerProperties properties;

    @Bean
    @ConditionalOnMissingBean //등록하려는 빈이 메모리에 없는 경우에만 빈 등록
    public JDBCConnectionManager getJDBCConnectionManager() {
        JDBCConnectionManager manager = new JDBCConnectionManager();
        manager.setDriverClass(properties.getDriverClass());
        manager.setUrl(properties.getUrl());
        manager.setUsername(properties.getUsername());
        manager.setPassword(properties.getPassword());
        return manager;
    }
}

