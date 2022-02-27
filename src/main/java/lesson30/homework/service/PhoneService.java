package lesson30.homework.service;

import lesson30.homework.model.PhoneCode;

public interface PhoneService {
    PhoneCode findFirstByCode(Integer code);
}
