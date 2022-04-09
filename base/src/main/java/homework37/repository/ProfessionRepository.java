package homework37.repository;

import homework37.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("isAuthenticated()")
public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
