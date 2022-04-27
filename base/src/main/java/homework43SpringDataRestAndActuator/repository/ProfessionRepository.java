package homework43SpringDataRestAndActuator.repository;

import homework43SpringDataRestAndActuator.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("isAuthenticated()")
@RepositoryRestResource(path = "professions")
public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
