package com.kenan.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author kenan
 * @email duanhaojie@jd.com
 * @date 2020/11/2 16:25
 */
public class BeanInitConfig
        implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, EnvironmentAware, InitializingBean {

    private ApplicationContext context;

    private BeanFactory beanFactory;

    private Environment env;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("name");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("afterPropertiesSet");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("environment");
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    public void it(){
        System.out.println("it");
    }
}
