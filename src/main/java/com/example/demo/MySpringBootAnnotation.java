package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)// 런타임까지 애노테이션 정보 유지
@Target(ElementType.TYPE)// 클래스, 인터페이스, Enum에 적용됨
@Configuration
@ComponentScan
public @interface MySpringBootAnnotation {
}
