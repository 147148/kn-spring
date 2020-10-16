package com.kenan.spring.config;

import com.kenan.spring.bean.CustomRefreshScopeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.Objects;
import java.util.Set;


/**
 * @author kenan
 */
@Configuration
public class CustomRefreshScopeBeanConfig implements InitializingBean, ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomRefreshScopeBeanConfig.class);

    public static final String CUSTOM_REFRESH_SCOPE_BEAN = "customRefreshScopeBean";

    private ApplicationContext context;

    @Bean(name = CUSTOM_REFRESH_SCOPE_BEAN)
    @RefreshScope
    @Description("自定义customRefreshScopeBean")
    public CustomRefreshScopeBean customRefreshScopeBean() {
        return new CustomRefreshScopeBean();
    }

    @Bean
    public static CustomRefresher customRefresher() {
        return new CustomRefresher();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("kn-spring-start项目加载customRefreshScopeBean成功.....");

        CustomRefreshScopeBean bean = (CustomRefreshScopeBean) context.getBean(CUSTOM_REFRESH_SCOPE_BEAN);
        LOGGER.info("kn-spring-start项目中postProcessBeanFactory修改customRefreshScopeBean之后的内容 custom{},msg{}", bean.getCustom(), bean.getMsg());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static class CustomRefresher implements BeanDefinitionRegistryPostProcessor,
            ApplicationContextAware, ApplicationListener<EnvironmentChangeEvent> {

        private BeanDefinitionRegistry beanDefinitionRegistry;

        private ApplicationContext applicationContext;


        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            this.beanDefinitionRegistry = registry;
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(CUSTOM_REFRESH_SCOPE_BEAN);

            //为什么要获取getOriginatingBeanDefinition，是因为代理吗？
            BeanDefinition originatingBeanDefinition = beanDefinition.getOriginatingBeanDefinition();
            if (originatingBeanDefinition != null) {
                MutablePropertyValues propertyValues = originatingBeanDefinition.getPropertyValues();
                propertyValues.add("custom", "custom")
                        .add("msg", "msg");
            }
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
        }

        @Override
        public void onApplicationEvent(EnvironmentChangeEvent event) {
            String prefix = "spring.custom.refresh.bean.";
            Set<String> changeKeySet = event.getKeys();
            for (String changeKey : changeKeySet) {
                if (!changeKey.startsWith(prefix)) {
                    continue;
                }
                if (!beanDefinitionRegistry.containsBeanDefinition(CUSTOM_REFRESH_SCOPE_BEAN)) {
                    break;
                }
                BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(CUSTOM_REFRESH_SCOPE_BEAN);
                BeanDefinition originatingBeanDefinition = beanDefinition.getOriginatingBeanDefinition();

                if (originatingBeanDefinition != null && "refresh".equals(originatingBeanDefinition.getScope())) {
                    org.springframework.cloud.context.scope.refresh.RefreshScope refreshScope;
                    refreshScope = applicationContext.getBean("refreshScope", org.springframework.cloud.context.scope.refresh.RefreshScope.class);
                    refreshScope.refresh(CUSTOM_REFRESH_SCOPE_BEAN);
                    break;
                }
            }
        }
    }

}
