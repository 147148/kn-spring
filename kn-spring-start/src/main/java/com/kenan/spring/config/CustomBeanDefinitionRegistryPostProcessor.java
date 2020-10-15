package com.kenan.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Configuration;

import static com.kenan.spring.config.CustomConfig.CUSTOM_BEAN;

/**
 * @author kenan
 */
@Configuration
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomBeanDefinitionRegistryPostProcessor.class);

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        if (registry.containsBeanDefinition(CUSTOM_BEAN)) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(CUSTOM_BEAN);
            LOGGER.info("kn-spring-start项目加载CustomBeanDefinitionRegistryPostProcessor-postProcessBeanDefinitionRegistry-originatingBeanDefinition[{}]", beanDefinition);
        }
        LOGGER.info("kn-spring-start项目加载CustomBeanDefinitionRegistryPostProcessor-postProcessBeanDefinitionRegistry成功.....");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LOGGER.info("kn-spring-start项目加载CustomBeanDefinitionRegistryPostProcessor-postProcessBeanFactory成功.....");
    }
}
