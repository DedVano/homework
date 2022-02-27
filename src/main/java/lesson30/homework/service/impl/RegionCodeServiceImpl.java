package lesson30.homework.service.impl;

import lesson30.homework.model.RegionCode;
import lesson30.homework.repository.RegionCodeRepository;
import lesson30.homework.service.RegionCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionCodeServiceImpl implements RegionCodeService {

    private final RegionCodeRepository regionCodeRepository;

    @Override
    public RegionCode findFirstByCode(Integer code) {
        return regionCodeRepository.findFirstByCode(code);
    }
}
