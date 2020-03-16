package com.pch.firebase.demo.firebasedemo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@PropertySource("file:config/application.properties")
@Data
public class ApplicationPropertyValue {

    @Value("${app.firebase.key.path}")
    private String fireBaseKeyPath;

    @Value("${app.firebase.rtdb.url}")
    private String rtdbUrl;

    @Value("${app.firebase.rtdb.ref.order}")
    private String rtdbRefOrder;

    @Value("${app.firebase.rtdb.ref.cycle}")
    private String rtdbRefCycle;

    @Value("${app.firebase.rtdb.ref.reward}")
    private String rtdbRefReward;

}
