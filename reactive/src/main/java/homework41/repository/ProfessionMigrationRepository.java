package homework41.repository;

import homework41.model.Profession;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProfessionMigrationRepository extends MongoRepository<Profession, Integer> {
}
