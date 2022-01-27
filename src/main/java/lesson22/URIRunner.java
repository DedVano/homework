package lesson22;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URIRunner {

    public static void main(String[] args) throws URISyntaxException, IOException {
        URI uri = new URI("https://yandex.ru:443/news/story/SSHA_prigrozili_otvetom_napoyavlenie_vojsk_Rossii_naKube--2283cd64cff6e7006608126383486fa4?lang=ru&from=main_portal&fan=1&stid=UjMjucgdNuy3y7YZ6MJz&t=1643319877&persistent_id=178226016&lr=2&msid=1643320226539048-7759128870049147464-vla1-1931-vla-l7-balancer-8080-BAL-3227&mlid=1643319877.glob_225.2283cd64&utm_medium=topnews_news&utm_source=morda_desktop");
        System.out.println("Протокол: " + uri.getScheme());
        System.out.println("Хост: " + uri.getHost());
        System.out.println("Порт: " + uri.getPort());
        System.out.println("Путь: " + uri.getPath());
        System.out.println("Параметры: " + uri.getRawQuery());
        System.out.println("Фрагмент: " + uri.getFragment());

        System.out.println("--------------------------");
        URL url = uri.toURL();

        //        Scanner scanner = new Scanner(url.openStream());
        URLConnection urlConnection = url.openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:96.0) Gecko/20100101 Firefox/96.0");
        urlConnection.connect();
        Scanner scanner = new Scanner(urlConnection.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.readValue()
        System.out.println("-----------------------------------");
        URL resource = URIRunner.class.getResource("/data.csv");
        System.out.println("Протокол: " + resource.toURI().getScheme());
        System.out.println("Адрес ресурса: " + resource);
    }
}
