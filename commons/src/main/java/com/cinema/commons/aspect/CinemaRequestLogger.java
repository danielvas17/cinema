package com.cinema.commons.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CinemaRequestLogger {

    @Before("execution(* com.cinema.*.controller.*(..))")
    public void logRequest() {
	System.out.println("Entre");
    }
}
