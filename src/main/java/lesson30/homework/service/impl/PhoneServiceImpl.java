package lesson30.homework.service.impl;

import lesson30.homework.model.PhoneCode;
import lesson30.homework.repository.PhoneRepository;
import lesson30.homework.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public PhoneCode findFirstByCode(Integer code) {
        return phoneRepository.findFirstByCode(code);
    }
}
