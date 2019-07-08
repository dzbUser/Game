package com.aiwan.server.publicsystem.annotation;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义注解，用于定位协议类
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@Scope("prototype")
public @interface ProtocolAnnotation {
     String value() default "";
     int protocol() default -1;
}
