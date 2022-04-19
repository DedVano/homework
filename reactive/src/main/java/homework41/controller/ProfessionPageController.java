package homework41.controller;

import homework41.dto.ProfessionDto;
import homework41.mapper.ProfessionMapper;
import homework41.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller
@Validated
@RequiredArgsConstructor
public class ProfessionPageController {

    private final ProfessionRepository professionRepository;
    private final ProfessionMapper professionMapper;

    @GetMapping("/professions")
    public String index() {
        return "profession/professions";
    }

    @GetMapping("/profession/add")
    public String newProfession() {
        return "profession/profession";
    }

    @GetMapping("/profession/edit")
    public String editCurrentProfession(@RequestParam("code") Integer professionCode, Model model) {
        model.addAttribute("profession", professionRepository.findById(professionCode));
        return "profession/profession";
    }

    @PostMapping("/profession/save")
    public Mono<String> saveProfession(@Valid ProfessionDto profession, String lang) {
        return professionRepository.save(professionMapper.toEntity(profession)).map(prof -> "redirect:/professions?lang=" + lang);
    }
}
