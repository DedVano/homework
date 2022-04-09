package lesson33.homework.service.impl;

import lesson33.homework.service.FindValute;
import lesson33.homework.service.ParseData;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Data
public class FindValuteImpl implements FindValute {

    private final ParseData valutes;

    @Override
    public BigDecimal getValue(String valuteCharCode) {
        return valutes.parseDataFromSource().getOrDefault(valuteCharCode, null);
    }
}
