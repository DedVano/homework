package lesson30.homework.service;

import lesson30.homework.model.City;

import java.util.List;

public interface CityService {

    City addNew(String nameInRussian, String nameInEnglish, long populationSize, int phoneCode, int RegionCode);

    City addPhoneCode(City city, int code);

    City addRegionCode(City city, int code);

    boolean deletePhoneCode(City city, int code);

    boolean deleteRegionCode(City city, int code);

    boolean deleteByNameInRussian(String name);

    City findFirstByNameInRussian(String name);

    List<City> findByNameInRussian(String name);

    List<City> findByNameInEnglish(String name);

    List<City> findByNameInRussianContains(String namePart);

    List<City> findByNameInEnglishContains(String namePart);

    List<City> findByPopulationSizeIsBetween(long minValue, long maxValue);

    List<City> findByPhoneCodeContaining(int phoneCode);

    List<City> findByRegionCodeContaining(int regionCode);
}
