package lesson33.homework.controller;

import lesson33.homework.dto.ValuteRateDto;
import lesson33.homework.dto.ValutesListDto;
import lesson33.homework.service.ConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/converter")
public class ConverterInputController {

    @Value("${spring.application.name}")
    private String application;

    private final ConverterService converterService;

    @PostMapping("/getList")
    public ValutesListDto getList() {
        return new ValutesListDto(application, converterService.getValutesList());
    }

    @PostMapping("/getRate")
    public ValuteRateDto getRate(@RequestParam("code") String valuteCharCode) {
        return new ValuteRateDto(application, converterService.getValuteRate(valuteCharCode));
    }
}
