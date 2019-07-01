package com.cinema.movie.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@Aspect
@Component
public class ClientEndpointLogger {

    @Before("execution(* com.cinema.movie.controllers..*(..))")
    public void log(final JoinPoint joinPoint) throws Throwable {
	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
			.currentRequestAttributes())
			.getRequest();

	final String className = joinPoint.getSignature().getDeclaringTypeName();
	LoggerFactory.getLogger(className).info("{} {} [{}]", request.getMethod(),
			request.getRequestURI(),
			request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
    }

}
