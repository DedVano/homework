package lesson22.homework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.URL;

public class WeatherAPIRunnerTest {

    @SneakyThrows
    @Test
    public void shouldReturnWeather() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String mockString = "{\"coord\":{\"lon\":30.2642,\"lat\":59.8944},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"пасмурно\",\"icon\":\"04n\"}],\"base\":\"stations\",\"main\":{\"temp\":-3.86,\"feels_like\":-3.86,\"temp_min\":-4.35,\"temp_max\":-3.86,\"pressure\":1002,\"humidity\":90},\"visibility\":10000,\"wind\":{\"speed\":0.45,\"deg\":349,\"gust\":0.89},\"clouds\":{\"all\":100},\"dt\":1643408227,\"sys\":{\"type\":2,\"id\":197864,\"country\":\"RU\",\"sunrise\":1643437178,\"sunset\":1643465053},\"timezone\":10800,\"id\":498817,\"name\":\"Санкт-Петербург\",\"cod\":200}";
        ObjectMapper mock = Mockito.mock(ObjectMapper.class);
        Mockito.when(mock.readValue(Mockito.any(URL.class), JsonNode.class)).thenReturn(mapper.readValue(mockString, JsonNode.class));
        Assert.assertTrue(WeatherAPIRunner.getWeatherInfoFromApi("http://api.openweathermap.org/data/2.5/weather"));
    }
}
