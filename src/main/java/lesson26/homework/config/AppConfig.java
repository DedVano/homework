package lesson26.homework.config;

import lesson26.homework.impl.InputInterfaceImpl;
import lesson26.homework.interfaces.FindValute;
import lesson26.homework.interfaces.GetData;
import lesson26.homework.interfaces.InputInterface;
import lesson26.homework.interfaces.ParseData;
import lesson26.homework.impl.FindValuteImpl;
import lesson26.homework.impl.GetDataImpl;
import lesson26.homework.impl.ParseDataImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public GetData dataFromSource() {
        return new GetDataImpl("https://www.cbr-xml-daily.ru/daily_json.js");
    }

    public ParseData parseData() {
        return new ParseDataImpl(dataFromSource().getDataFromSource());
    }

    @Bean("findValute")
    public FindValute findValute() {
        return new FindValuteImpl(parseData().parseDataFromSource());
    }

    @Bean("inputInterface")
    public InputInterface inputInterface() {
        return new InputInterfaceImpl();
    }
}
