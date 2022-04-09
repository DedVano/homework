package lesson33.homework.service.impl;

import lesson33.homework.service.ConverterService;
import lesson33.homework.service.FindValute;
import lesson33.homework.service.ParseData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Data
@Slf4j
public class ConverterServiceImpl implements ConverterService {

    private final ParseData parseData;
    private final FindValute findValute;

    @Override
    public List<String> getValutesList() {
        log.info("Запрошен список валют");
        List<String> codesList = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : parseData.parseDataFromSource().entrySet()) {
            codesList.add(entry.getKey());
        }
        return codesList;
    }

    @Override
    public BigDecimal getValuteRate(String valuteCharCode) {
        log.info("Запрошен обменный курс для " + valuteCharCode);
        return findValute.getValue(valuteCharCode);
    }
}
