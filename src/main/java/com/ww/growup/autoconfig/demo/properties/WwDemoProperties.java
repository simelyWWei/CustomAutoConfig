package com.ww.growup.autoconfig.demo.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@Data
@ConfigurationProperties(prefix = "externalutils")
public class WwDemoProperties {

    private Boolean enabled;
}
