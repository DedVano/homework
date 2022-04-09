package lesson30;

import lesson30.model.Author;
import lesson30.service.AuthorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaRunner {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(JpaRunner.class, args);
        final AuthorService authorService = applicationContext.getBean(AuthorService.class);
        Author author = new Author("Виталий", "Иванов");
        System.out.println(author);
        authorService.save(author);
        System.out.println(author);
    }
}
