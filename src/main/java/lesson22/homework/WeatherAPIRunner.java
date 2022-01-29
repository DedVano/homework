package lesson22.homework;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPIRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название города: ");
        String cityName = scanner.nextLine();
        String adaptedCityName = cityName.replace(" ", "%20");

        String uriString = "http://api.openweathermap.org/data/2.5/weather?q="
                + adaptedCityName + "&units=metric&lang=ru&appid=" + System.getenv("weatherApiKey");

        System.out.println("Посмотрим, какая в городе " + cityName + " сейчас погода.\n");
        if (getWeatherInfoFromApi(uriString)) {
            System.out.println("\nЗапрос погоды выполнен успешно.");
        } else {
            System.out.println("\nЗапрос прошел неудачно, возможно, что-то не так с названием города.");
        }


    }

    private static boolean getWeatherInfoFromApi(String uriString) {
        try {
            URI uri = new URI(uriString);
            URL url = uri.toURL();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readValue(url, JsonNode.class);

            System.out.println("Название города: " + rootNode.get("name").asText());
            JsonNode weatherChildNode = rootNode.get("main");
            System.out.println("Текущая температура: " + weatherChildNode.get("temp").asText() + " \u2103");
            System.out.println("Ощущается как: " + weatherChildNode.get("feels_like").asText() + " \u2103");
            System.out.println("Атмосферное давление: " + weatherChildNode.get("pressure").asText() + " гПа");
            System.out.println("Скорость ветра: " + rootNode.get("wind").get("speed").asText() + " м/с");
            System.out.println("Облачность: " + rootNode.get("weather").findValue("description").asText());

        } catch (URISyntaxException e) {
            System.out.println("Ошибка в синтаксисе URI, что-то мы при составлении запроса напутали...");
            return false;
        } catch (MalformedURLException e) {
            System.out.println("Извините, при формировании ссылки на запрос что-то пошло не так.");
            return false;
        } catch (IOException e) {
            System.out.println("При обращении к сервису погоды произошла ошибка ввода-вывода. " +
                    "Возможно, Вы неправильно ввели название города, или у Вас отсутствует доступ к Интернету.");
            return false;
        }
        return true;
    }

}
