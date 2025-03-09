package com.example.jwtprac.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER}) // ArgumentResolver 가 필요함
@Retention(RetentionPolicy.RUNTIME) // 표지판
public @interface Auth {
}
