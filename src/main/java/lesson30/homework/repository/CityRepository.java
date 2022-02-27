package lesson30.homework.repository;

import lesson30.homework.model.City;
import lesson30.homework.model.PhoneCode;
import lesson30.homework.model.RegionCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    boolean existsByNameInRussian(String nameInRussian);

    City findFirstByNameInRussian(String name);

    List<City> findByNameInRussian(String name);

    List<City> findByNameInEnglish(String name);

    List<City> findByNameInRussianContains(String str);

    List<City> findByNameInEnglishContains(String str);

    List<City> findByPopulationSizeIsBetween(long minValue, long maxValue);

    List<City> findByPhoneCodesContaining(PhoneCode phoneCodes);

    List<City> findByRegionCodesContaining(RegionCode regionCode);

    City save(City city);

    void delete(City entity);
}
