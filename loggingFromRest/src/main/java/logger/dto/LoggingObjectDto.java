package logger.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@Data
@RequiredArgsConstructor
public class LoggingObjectDto {
    private final String initiatorName;
    private final String proxyName;
    private final String className;
    private final String methodName;
    private final Collection<String> arguments;
}
