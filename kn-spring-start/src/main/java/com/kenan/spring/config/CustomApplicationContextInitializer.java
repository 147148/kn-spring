package com.kenan.spring.config;

import com.kenan.spring.util.ComponentUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 这是整个spring容器在刷新之前初始化ConfigurableApplicationContext的回调接口，
 * 简单来说，就是在容器刷新之前调用此类的initialize方法。这个点允许被用户自己扩展。
 * 可以在整个spring容器还没被初始化之前做一些事情。例如 版本检测，字节码注入等操作。
 *
 * @author kenan
 */
public class CustomApplicationContextInitializer implements ApplicationContextInitializer {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ComponentUtils.assertSpringVersion();
    }
}
