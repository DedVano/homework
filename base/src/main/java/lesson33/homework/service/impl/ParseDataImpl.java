package lesson33.homework.service.impl;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lesson33.homework.service.GetData;
import lesson33.homework.service.ParseData;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Data
public class ParseDataImpl implements ParseData {

    private final GetData sourceData;

    @Override
    public Map<String, BigDecimal> parseDataFromSource() {
        Map<String, BigDecimal> valutes = new HashMap<>();
        DocumentContext context = JsonPath.parse(sourceData.getDataFromSource());
        List<Map> results = context.read("$['Valute'][*]");
        for(Map item : results) {
            String charCode = String.valueOf(item.get("CharCode"));
            BigDecimal exchangeRate = new BigDecimal(String.valueOf(item.get("Value")));
            valutes.put(charCode, exchangeRate);
        }
        return valutes;
    }
}
