package lesson33.homework.service;

import java.math.BigDecimal;
import java.util.List;

public interface ConverterService {

    List<String> getValutesList();

    BigDecimal getValuteRate(String valuteCharCode);
}
