package lesson30.homework.repository;

import lesson30.homework.model.PhoneCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneCode, Long> {
    PhoneCode findFirstByCode(Integer code);
}
