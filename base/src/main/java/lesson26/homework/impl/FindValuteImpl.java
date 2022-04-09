package lesson26.homework.impl;

import lesson26.homework.interfaces.FindValute;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@RequiredArgsConstructor
public class FindValuteImpl implements FindValute {

    private final Map<String, BigDecimal> valutes;

    @Override
    public BigDecimal getValue(String charcode) {
        return valutes.getOrDefault(charcode, null);
    }
}
