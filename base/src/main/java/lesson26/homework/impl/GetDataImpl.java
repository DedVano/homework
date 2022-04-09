package lesson26.homework.impl;

import lesson26.homework.interfaces.GetData;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

@RequiredArgsConstructor
public class GetDataImpl implements GetData {

    private final String dataSource;

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
        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Произошла ошибка при формировании запроса к источнику данных.");
        } catch (IOException e) {
            System.out.println("При запросе данных из внешнего источника произошла ошибка ввода-вывода.");
        }
        return result.toString();
    }
}
