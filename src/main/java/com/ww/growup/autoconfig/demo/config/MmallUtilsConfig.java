package com.ww.growup.autoconfig.demo.config;

import com.ww.growup.autoconfig.demo.properties.WwDemoProperties;
import com.ww.growup.autoconfig.demo.utils.encrypt.MD5Util;
import com.ww.growup.autoconfig.demo.utils.encrypt.RSAUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(value = WwDemoProperties.class)
@ConditionalOnClass(WwDemoProperties.class)
public class MmallUtilsConfig {

    @Autowired
    private WwDemoProperties wwDemoProperties;

    @Bean
    @ConditionalOnMissingBean(MD5Util.class)
    public MD5Util md5Util(){
        log.info(">>>>> external autoconfig",wwDemoProperties.getEnabled());
        if (wwDemoProperties.getEnabled()){
            return new MD5Util();
        }else {
            return null;
        }
    }

    @Bean
    @ConditionalOnMissingBean(RSAUtils.class)
    @ConditionalOnProperty(name = "externalutils.enabled", havingValue = "true", matchIfMissing = true)
    public RSAUtils rsaUtils(){
        return new RSAUtils();
    }
}
