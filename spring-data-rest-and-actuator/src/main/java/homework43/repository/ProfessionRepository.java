package homework43.repository;

import homework43.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "professions")  // не обязательна для указания, требуется только в случае переназначения endpoint'а
public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
