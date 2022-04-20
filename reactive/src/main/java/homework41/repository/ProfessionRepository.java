package homework41.repository;

import homework41.model.Profession;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProfessionRepository extends ReactiveMongoRepository<Profession, Integer> {
}
