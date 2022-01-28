package lesson22.homework;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class WeatherAPIRunner {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
        URI uri = null;
        try {
            uri = new URI("http://api.openweathermap.org/data/2.5/weather?q=Moscow&mode=xml&units=metric&lang=ru&appid=f5c26cee12a0aff7e6801dcec38dc926");
            URL url = uri.toURL();
            URLConnection urlConnection = url.openConnection();
//            urlConnection.addRequestProperty();
            urlConnection.connect();
            Scanner urlScanner = new Scanner(urlConnection.getInputStream());
            while (urlScanner.hasNextLine()) {
                System.out.println(urlScanner.nextLine());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
