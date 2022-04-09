package lesson30.homework.service;

import lesson30.homework.model.RegionCode;

public interface RegionCodeService {
    RegionCode findFirstByCode(Integer code);
}
