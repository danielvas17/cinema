package com.cinema.client.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Aspect
@Component
public class ClientEndpointLogger {

    @Before("execution(* com.cinema.client.controllers..*(..))")
    public void log(final JoinPoint joinPoint) throws Throwable {
	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
			.currentRequestAttributes())
			.getRequest();

	final String className = joinPoint.getSignature().getDeclaringTypeName();
	Logger.getLogger(className).log(Level.INFO, String.format("%s %s {%s}", request.getMethod(),
			request.getRequestURI(),
			request.getReader().lines().collect(Collectors.joining(System.lineSeparator()))));
    }

}
