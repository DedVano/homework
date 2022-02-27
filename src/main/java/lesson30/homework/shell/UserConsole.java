package lesson30.homework.shell;

import lesson30.homework.model.City;
import lesson30.homework.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@Slf4j
@ShellComponent
@RequiredArgsConstructor
public class UserConsole {

    private final CityService cityService;

    @ShellMethod(value = "Поиск по точному русскому имени", key = {"find-rus", "fr"})
    public void findByRussianName(@ShellOption(value = {"-n"}, help = "Имя города на русском языке") String name) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся найти города по русскому имени '" + name + "'...", AnsiColor.DEFAULT));
        List<City> cities = cityService.findByNameInRussian(name);
        printFoundCities(cities);
    }

    @ShellMethod(value = "Поиск по точному английскому имени", key = {"find-en", "fe"})
    public void findByEnglishName(@ShellOption(value = {"-n"}, help = "Имя города на английском языке") String name) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся найти города по русскому имени '" + name + "'...", AnsiColor.DEFAULT));
        List<City> cities = cityService.findByNameInEnglish(name);
        printFoundCities(cities);
    }

    @ShellMethod(value = "Поиск по части русского имени", key = {"find-part-rus", "fpr"})
    public void findByPartOfRussianName(@ShellOption(value = {"-n"}, help = "Часть имени города на русском языке") String name) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся найти города по части русского имени...", AnsiColor.DEFAULT));
        List<City> cities = cityService.findByNameInRussianContains(name);
        printFoundCities(cities);
    }

    @ShellMethod(value = "Поиск по части английского имени", key = {"find-part-en", "fpe"})
    public void findByPartOfEnglishName(@ShellOption(value = {"-n"}, help = "Часть имени города на английском языке") String name) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся найти города по части английского имени...", AnsiColor.DEFAULT));
        List<City> cities = cityService.findByNameInEnglishContains(name);
        printFoundCities(cities);
    }

    @ShellMethod(value = "Поиск по численности населения в пределах от минимального до максимального значения", key = {"find-pop", "fpop"})
    public void findByPopulation(@ShellOption(value = {"-pmin"}, help = "Нижняя граница численности") Long minPopulation,
                                 @ShellOption(value = {"-pmax"}, help = "Верхняя граница численности") Long maxPopulation) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся найти города по численности населения от " + minPopulation
                + " до " + maxPopulation + "...", AnsiColor.DEFAULT));
        List<City> cities = cityService.findByPopulationSizeIsBetween(minPopulation, maxPopulation);
        printFoundCities(cities);
    }

    @ShellMethod(value = "Поиск по коду города", key = {"find-phone-code", "fphone"})
    public void findByPhoneCode(@ShellOption(value = {"-c"}, help = "Телефонный код города") Integer code) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся найти города по телефонному коду "
                + code + "...", AnsiColor.DEFAULT));
        List<City> cities = cityService.findByPhoneCodeContaining(code);
        printFoundCities(cities);
    }

    @ShellMethod(value = "Поиск по коду региона", key = {"find-region-code", "fregion"})
    public void findByRegionCode(@ShellOption(value = {"-c"}, help = "Код региона") Integer code) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся найти города по коду региона "
                + code + "...", AnsiColor.DEFAULT));
        List<City> cities = cityService.findByRegionCodeContaining(code);
        printFoundCities(cities);
    }

    @ShellMethod(value = "Добавление нового города в справочник", key = {"create-city", "cc"})
    public void createNewCity(@ShellOption(value = {"-rn"}, help = "Русское название") String russianName,
                              @ShellOption(value = {"-re"}, help = "Английское название") String englishName,
                              @ShellOption(value = {"-p"}, help = "Численность населения") Long population,
                              @ShellOption(value = {"-pc"}, help = "Телефонный код города") Integer phoneCode,
                              @ShellOption(value = {"-rc"}, help = "Код региона") Integer regionCode) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся добавить новый город...", AnsiColor.DEFAULT));
        City city = cityService.addNew(russianName, englishName, population, phoneCode, regionCode);
        if (city != null) {
            System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Город добавлен.", AnsiColor.DEFAULT));
            System.out.println(city);
            log.info("В справочник добавлен город {}", city.getNameInRussian());
        } else {
            System.out.println(AnsiOutput.toString(AnsiColor.RED, "Город не добавлен.", AnsiColor.DEFAULT));
        }
    }

    @ShellMethod(value = "Добавление нового телефонного кода города", key = {"add-phone-code", "apc"})
    public void addNewPhoneCode(@ShellOption(value = {"-rn"}, help = "Русское название") String russianName,
                                @ShellOption(value = {"-pc"}, help = "Телефонный код города") Integer phoneCode) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся добавить новый код...", AnsiColor.DEFAULT));
        City foundCity = cityService.findFirstByNameInRussian(russianName);
        if (foundCity != null) {
            foundCity = cityService.addPhoneCode(foundCity, phoneCode);
            if (foundCity != null) {
                System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Код города добавлен.", AnsiColor.DEFAULT));
                System.out.println(foundCity);
                log.info("В город {} добавлен новый телефонный код города {}", russianName, phoneCode);
            } else {
                System.out.println(AnsiOutput.toString(AnsiColor.RED, "Код города не добавлен.", AnsiColor.DEFAULT));
            }
        } else {
            System.out.println(AnsiOutput.toString(AnsiColor.RED, "Город не найден.", AnsiColor.DEFAULT));
        }
    }

    @ShellMethod(value = "Добавление нового кода региона города", key = {"add-region-code", "arc"})
    public void addNewRegionCode(@ShellOption(value = {"-rn"}, help = "Русское название") String russianName,
                                 @ShellOption(value = {"-rc"}, help = "Код региона города") Integer regionCode) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся добавить новый код...", AnsiColor.DEFAULT));
        City foundCity = cityService.findFirstByNameInRussian(russianName);
        if (foundCity != null) {
            foundCity = cityService.addRegionCode(foundCity, regionCode);
            if (foundCity != null) {
                System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Код региона добавлен.", AnsiColor.DEFAULT));
                System.out.println(foundCity);
                log.info("В город {} добавлен новый код региона {}", russianName, regionCode);
            } else {
                System.out.println(AnsiOutput.toString(AnsiColor.RED, "Код региона не добавлен.", AnsiColor.DEFAULT));
            }
        } else {
            System.out.println(AnsiOutput.toString(AnsiColor.RED, "Город не найден.", AnsiColor.DEFAULT));
        }
    }

    @ShellMethod(value = "Удаление телефонного кода города", key = {"del-phone-code", "dpc"})
    public void deletePhoneCode(@ShellOption(value = {"-rn"}, help = "Русское название") String russianName,
                                @ShellOption(value = {"-pc"}, help = "Телефонный код города") Integer phoneCode) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся удалить код...", AnsiColor.DEFAULT));
        City foundCity = cityService.findFirstByNameInRussian(russianName);
        if (foundCity != null) {
            if (cityService.deletePhoneCode(foundCity, phoneCode)) {
                System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Код города удален.", AnsiColor.DEFAULT));
                System.out.println(foundCity);
                log.info("Из города {} удален телефонный код города {}", russianName, phoneCode);
            } else {
                System.out.println(AnsiOutput.toString(AnsiColor.RED, "Код города не удален.", AnsiColor.DEFAULT));
            }
        } else {
            System.out.println(AnsiOutput.toString(AnsiColor.RED, "Город не найден.", AnsiColor.DEFAULT));
        }
    }

    @ShellMethod(value = "Удаление кода региона города", key = {"del-region-code", "drc"})
    public void deleteRegionCode(@ShellOption(value = {"-rn"}, help = "Русское название") String russianName,
                                 @ShellOption(value = {"-pc"}, help = "Код региона города") Integer regionCode) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся удалить код...", AnsiColor.DEFAULT));
        City foundCity = cityService.findFirstByNameInRussian(russianName);
        if (foundCity != null) {
            if (cityService.deleteRegionCode(foundCity, regionCode)) {
                System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Код региона удален.", AnsiColor.DEFAULT));
                System.out.println(foundCity);
                log.info("Из города {} удален код региона {}", russianName, regionCode);
            } else {
                System.out.println(AnsiOutput.toString(AnsiColor.RED, "Код региона не удален.", AnsiColor.DEFAULT));
            }
        } else {
            System.out.println(AnsiOutput.toString(AnsiColor.RED, "Город не найден.", AnsiColor.DEFAULT));
        }
    }

    @ShellMethod(value = "Удаление города", key = {"del-city", "dc"})
    public void deleteRegionCode(@ShellOption(value = {"-rn"}, help = "Русское название") String russianName) {
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Пытаемся удалить город...", AnsiColor.DEFAULT));
        if (cityService.deleteByNameInRussian(russianName)) {
            log.info("Город {} удален из справочника", russianName);
        }
    }

    private void printFoundCities(List<City> cities) {
        if (cities.size() > 0) {
            System.out.println(AnsiOutput.toString(AnsiColor.GREEN, "Найдены следующие города:", AnsiColor.DEFAULT));
            System.out.println(cities);
        } else {
            System.out.println(AnsiOutput.toString(AnsiColor.RED, "По заданным критериям ни одного города не найдено.", AnsiColor.DEFAULT));
        }
    }
}
