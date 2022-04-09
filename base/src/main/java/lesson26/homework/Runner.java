package lesson26.homework;

import lesson26.homework.config.AppConfig;
import lesson26.homework.interfaces.FindValute;
import lesson26.homework.interfaces.InputInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        FindValute findValute = (FindValute) appContext.getBean("findValute");
        InputInterface inputInterface = (InputInterface) appContext.getBean("inputInterface");

        System.out.println("Введите код валюты для поиска её обменного курса к рублю.");
        System.out.println("Введите 'exit' для выхода.");
        String request;
        while (!(request = inputInterface.getRequest()).equals("exit")) {
            String requestInUpperCase = request.toUpperCase(Locale.ROOT);
            BigDecimal exchangeRate = findValute.getValue(requestInUpperCase);
            System.out.println(exchangeRate != null ? "Курс валюты с кодом " + requestInUpperCase + " равен " + exchangeRate :
                    "Извините, такой валюты не нашлось.");
            System.out.println("Введите новый код валюты для поиска или 'exit' для выхода.");
        }
        System.out.println("Всего доброго, спасибо, что воспользовались нашим справочником!");
    }
}
