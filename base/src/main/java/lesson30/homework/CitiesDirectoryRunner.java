package lesson30.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CitiesDirectoryRunner {
    public static void main(String[] args) {

        final ConfigurableApplicationContext applicationContext = SpringApplication.run(CitiesDirectoryRunner.class, args);
    }
}
