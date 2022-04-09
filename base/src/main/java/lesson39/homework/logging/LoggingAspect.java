package lesson39.homework.logging;

import logger.dto.LoggingObjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Aspect
@Order
@Component
public class LoggingAspect {

    private final RestTemplate restTemplate;
    @Value("${spring.application.name}")
    private String applicationName;

    @Before("execution(* lesson39.homework.dao.impl.PersonDaoImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        LoggingObjectDto loggingObjectDto = new LoggingObjectDto(
                applicationName,
                joinPoint.getThis().getClass().getName(),
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                Arrays.stream(joinPoint.getArgs()).map(Objects::toString).collect(Collectors.toList()));
        ResponseEntity<LoggingObjectDto> responseEntity = restTemplate.postForEntity(UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8090)
                .path("/logEvent")
                .build(Map.of()), loggingObjectDto, LoggingObjectDto.class);
        log.info("Статус процесса удаленного логирования: " + responseEntity.getStatusCode().getReasonPhrase());
    }
}
