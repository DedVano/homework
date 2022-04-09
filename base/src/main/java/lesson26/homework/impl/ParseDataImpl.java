package lesson26.homework.impl;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lesson26.homework.interfaces.ParseData;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ParseDataImpl implements ParseData {

    private final String sourceData;

    @Override
    public Map<String, BigDecimal> parseDataFromSource() {
        Map<String, BigDecimal> valutes = new HashMap<>();
        DocumentContext context = JsonPath.parse(sourceData);
        List<Map> results = context.read("$['Valute'][*]");
        for(Map item : results) {
            String charCode = String.valueOf(item.get("CharCode"));
            BigDecimal exchangeRate = new BigDecimal(String.valueOf(item.get("Value")));
            valutes.put(charCode, exchangeRate);
        }
        return valutes;
    }
}
