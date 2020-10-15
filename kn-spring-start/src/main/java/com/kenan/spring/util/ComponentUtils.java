package com.kenan.spring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * 常用工具类以及组件
 *
 * @author kenan
 */
public abstract class ComponentUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentUtils.class);

    /**
     * 如果 spring 版本升级,检查相应的自定义基础设施是否需要升级.
     * 通常情况是无需升级的,但仍需要此断言提醒后来者.
     */
    public static void assertSpringVersion() {
        String springVersion = ApplicationContext.class.getPackage().getImplementationVersion();
        LOGGER.info("kn-spring-start项目使用的Spring版本为[{}]", springVersion);

        assertEquals("Spring版本必须是5.1.3.RELEASE",springVersion, "5.1.3.RELEASE" );
    }

}
