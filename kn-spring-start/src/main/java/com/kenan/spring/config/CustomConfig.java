package com.kenan.spring.config;

import com.kenan.spring.bean.CustomBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * @author kenan
 */
@Configuration
public class CustomConfig implements InitializingBean {

    public static String CUSTOM_BEAN = "customBean";

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomConfig.class);

    @Bean("customBean")
    @Description("自定义customBean")
    public CustomBean customBean() {
        return new CustomBean();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("kn-spring-start项目加载CustomConfig成功.....");
    }
}
