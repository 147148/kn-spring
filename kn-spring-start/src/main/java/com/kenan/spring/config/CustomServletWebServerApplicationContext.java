package com.kenan.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

/**
 * 在特定上下文子类中初始化其他特殊bean。其父类在此方法中调用createWebServer初始化tomcat，
 * 并在finishRefresh中调用startWebServer启动tomcat
 * <p>
 * 注意：目前无法重写，因为在org.springframework.boot.web.servlet.support.SpringBootServletInitializer#createRootApplicationContext(javax.servlet.ServletContext)
 * 写的是AnnotationConfigServletWebServerApplicationContext.class
 *
 * @author kenan
 */
public class CustomServletWebServerApplicationContext extends AnnotationConfigServletWebServerApplicationContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomServletWebServerApplicationContext.class);

    /**
     * 在初始化tomcat之后，执行一些操作
     **/
    @Override
    protected void onRefresh() {
        super.onRefresh();
        LOGGER.info("kn-spring-start项目tomcat初始化成功.....");
    }


    /**
     * 在初启动tomcat之后，执行一些操作
     **/
    @Override
    protected void finishRefresh() {
        super.finishRefresh();
        LOGGER.info("kn-spring-start项目tomcat启动成功.....");
    }
}
