package homework41;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@EnableMongock
@SpringBootApplication
public class ReactiveProfessionDirectoryAppRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveProfessionDirectoryAppRunner.class, args);
    }
}
