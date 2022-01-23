package tech.jhipster.beer.security.jwt.infrastructure.config;

import tech.jhipster.beer.technical.infrastructure.primary.exception.ExceptionTranslator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

@ControllerAdvice
public class SecurityExceptionTranslator extends ExceptionTranslator implements SecurityAdviceTrait {}
