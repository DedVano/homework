package lesson30.homework.service.impl;

import lesson30.homework.model.City;
import lesson30.homework.model.PhoneCode;
import lesson30.homework.model.RegionCode;
import lesson30.homework.repository.CityRepository;
import lesson30.homework.service.CityService;
import lesson30.homework.service.PhoneService;
import lesson30.homework.service.RegionCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final PhoneService phoneService;
    private final RegionCodeService regionCodeService;

    @Override
    public City addNew(String nameInRussian, String nameInEnglish, long populationSize, int phoneCode, int regionCode) {
        if (cityRepository.existsByNameInRussian(nameInRussian)) {
            System.out.println("Такой город уже есть.");
            return null;
        } else {
            City newCity = cityRepository.save(new City(nameInRussian, nameInEnglish, populationSize));
            newCity = addPhoneCode(newCity, phoneCode);
            newCity = addRegionCode(newCity, regionCode);
            return newCity;
        }
    }

    @Override
    public City addPhoneCode(City city, int code) {
        if (phoneService.findFirstByCode(code) == null) {
            city.getPhoneCodes().add(new PhoneCode(code, city));
            city = cityRepository.save(city);
        } else {
            System.out.println("Такой код города уже существует.");
        }
        return city;
    }

    @Override
    public City addRegionCode(City city, int code) {
        if (regionCodeService.findFirstByCode(code) == null) {
            city.getRegionCodes().add(new RegionCode(code, city));
            city = cityRepository.save(city);
        } else {
            System.out.println("Такой код региона уже существует.");
        }
        return city;
    }

    @Override
    public boolean deletePhoneCode(City city, int code) {
        List<PhoneCode> phoneCodes = city.getPhoneCodes();
        boolean found = false;
        PhoneCode foundCode = null;
        for (PhoneCode eachCode : phoneCodes) {
            if (eachCode.getCode() == code) {
                found = true;
                foundCode = eachCode;
            }
        }
        if (found) {
            phoneCodes.remove(foundCode);
            cityRepository.save(city);
            return true;
        } else {
            System.out.println("Код города не найден.");
            return false;
        }
    }

    @Override
    public boolean deleteRegionCode(City city, int code) {
        List<RegionCode> regionCodes = city.getRegionCodes();
        boolean found = false;
        RegionCode foundCode = null;
        for (RegionCode eachCode : regionCodes) {
            if (eachCode.getCode() == code) {
                found = true;
                foundCode = eachCode;
            }
        }
        if (found) {
            regionCodes.remove(foundCode);
            cityRepository.save(city);
            System.out.println("Код региона удален.");
            return true;
        } else {
            System.out.println("Код региона не найден.");
            return false;
        }
    }

    @Override
    public boolean deleteByNameInRussian(String name) {
        City deletedCity = cityRepository.findFirstByNameInRussian(name);
        if (deletedCity != null) {
            cityRepository.delete(deletedCity);
            System.out.println("Город удален.");
            return true;
        } else {
            System.out.println("Город с таким именем не найден.");
            return false;
        }
    }

    @Override
    public City findFirstByNameInRussian(String name) {
        return cityRepository.findFirstByNameInRussian(name);
    }

    @Override
    public List<City> findByNameInRussian(String name) {
        return cityRepository.findByNameInRussian(name);
    }

    @Override
    public List<City> findByNameInEnglish(String name) {
        return cityRepository.findByNameInEnglish(name);
    }

    @Override
    public List<City> findByNameInRussianContains(String namePart) {
        return cityRepository.findByNameInRussianContains(namePart);
    }

    @Override
    public List<City> findByNameInEnglishContains(String namePart) {
        return cityRepository.findByNameInEnglishContains(namePart);
    }

    @Override
    public List<City> findByPopulationSizeIsBetween(long minValue, long maxValue) {
        return cityRepository.findByPopulationSizeIsBetween(minValue, maxValue);
    }

    @Override
    public List<City> findByPhoneCodeContaining(int phoneCode) {
        PhoneCode foundCode = phoneService.findFirstByCode(phoneCode);
        return foundCode != null ? cityRepository.findByPhoneCodesContaining(foundCode) : Collections.emptyList();
    }

    @Override
    public List<City> findByRegionCodeContaining(int regionCode) {
        RegionCode foundRegion = regionCodeService.findFirstByCode(regionCode);
        return foundRegion != null ? cityRepository.findByRegionCodesContaining(foundRegion) : Collections.emptyList();
    }
}
