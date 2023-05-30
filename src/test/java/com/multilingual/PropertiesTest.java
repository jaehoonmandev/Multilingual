package com.multilingual;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@SpringBootTest
public class PropertiesTest {

    @Test
    public void PropertiesLoad() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("language/messages");
        messageSource.setDefaultEncoding("UTF-8");
        System.out.println(messageSource.getMessage("msg.001", null, Locale.KOREA));
    }
}
