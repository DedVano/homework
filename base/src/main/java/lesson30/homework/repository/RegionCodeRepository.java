package lesson30.homework.repository;

import lesson30.homework.model.RegionCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionCodeRepository extends JpaRepository<RegionCode, Long> {
    RegionCode findFirstByCode(Integer code);
}
