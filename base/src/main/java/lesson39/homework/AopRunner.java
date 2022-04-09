package lesson39.homework;

import lesson18.dto.Person;
import lesson39.homework.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class AopRunner {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(AopRunner.class, args);
        final PersonService personService = applicationContext.getBean(PersonService.class);
        final Person moriarty = personService.getByName("Moriarty");
        final Person holmes = personService.getByName("Holmes");
        log.info("Имя персоны {}", personService.getName());
    }
}
