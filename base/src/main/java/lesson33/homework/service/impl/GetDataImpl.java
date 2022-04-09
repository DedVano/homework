package lesson33.homework.service.impl;

import lesson33.homework.service.GetData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@Service
@Slf4j
@Data
public class GetDataImpl implements GetData {

    private final String dataSource = "https://www.cbr-xml-daily.ru/daily_json.js";

    @Override
    public String getDataFromSource() {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URI(dataSource).toURL();
            URLConnection connection = url.openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine());
            }
            log.info("Произведено обращение к API " + dataSource);
        } catch (MalformedURLException | URISyntaxException e) {
            log.error("Произошла ошибка при формировании запроса к источнику данных.");
        } catch (IOException e) {
            log.error("При запросе данных из внешнего источника произошла ошибка ввода-вывода.");
        }
        return result.toString();
    }
}
