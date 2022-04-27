package homework43.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

/**
 *  Индикатор отслеживает время работы приложения и при превышении заданного отрезка времени
 *  показывавет статус DOWN, требуя перезагрузки
 */
@RequiredArgsConstructor
@Component
public class UptimeHealthIndicator implements HealthIndicator {

    private final ApplicationProperties applicationProperties;
    private final MetricsEndpoint metricsEndpoint;
    @Value("${spring.application.name}")
    private String appName;

    @Override
    public Health health() {
        MetricsEndpoint.MetricResponse response = metricsEndpoint.metric("process.uptime", null);
        long uptimeInMilliseconds = (long) (response.getMeasurements().get(0).getValue() * 1000);
        long millisecondsInUptime = uptimeInMilliseconds % 1000;
        long secondsInUptime = (uptimeInMilliseconds / 1000) % 60;
        long minutesInUptime = (uptimeInMilliseconds / 1000 / 60) % 60;
        long hoursInUptime = (uptimeInMilliseconds / 1000 / 60 / 60) % 24;
        long daysInUptime = uptimeInMilliseconds / 1000 / 60 / 60 / 24;
        String formattedUptime = String.format("%d days %02d:%02d:%02d.%03d", daysInUptime, hoursInUptime,
                minutesInUptime, secondsInUptime, millisecondsInUptime);
        if ((uptimeInMilliseconds / 1000) < applicationProperties.getCriticalUptimeValue()) {
            return Health.up().withDetail("Application name", appName).withDetail("Uptime", formattedUptime)
                    .withDetail("Description", "Uptime is OK").build();
        } else {
            return Health.down().withDetail("Application name", appName).withDetail("Uptime", formattedUptime)
                    .withDetail("Description", "Uptime is too much! You need to restart this application").build();
        }
    }
}
