package org.oreilly.com.spring_and_spring_boot_course;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringAndSpringBootCourseApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertNotNull(context);
        int count = context.getBeanDefinitionCount();
        System.out.println("There is " + count + " beans in the application context");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        assertFalse(context.containsBean("restTemplate"));
        assertTrue(context.containsBean("restTemplateBuilder"));
    }

    @Test @Disabled
    void getBean() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> context.getBean(RestTemplate.class));
    }


}
