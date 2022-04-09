package logger.controller;

import logger.dto.LoggingObjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LogController {

    @Value("${spring.application.name}")
    private String application;

    @PostMapping("/logEvent")
    public ResponseEntity<?> logEvent(@RequestBody LoggingObjectDto object) {
        log.info(application + ": Приложение : " + object.getInitiatorName());
        log.info(application + ":   Прокси : " + object.getProxyName());
        log.info(application + ":   Класс : " + object.getClassName());
        log.info(application + ":   Вызов метода : " + object.getMethodName());
        log.info(application + ":   Аргументы метода : "
                + object.getArguments()
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", ")));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
