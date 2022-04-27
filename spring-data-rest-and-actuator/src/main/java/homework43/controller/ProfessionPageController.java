package homework43.controller;

import homework43.dto.ProfessionDto;
import homework43.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Validated
@RequiredArgsConstructor
public class ProfessionPageController {

    private final ProfessionService professionService;

    @GetMapping("/professions")
    public String viewProfessions() {
        return "profession/professions";
    }

    @GetMapping("/profession/add")
    public String newProfession(Model model) {
        return "profession/profession";
    }

    @GetMapping("/profession/edit")
    public String editCurrentProfession(@RequestParam("code") Integer professionCode, Model model) {
        ProfessionDto currentProfession = professionService.getByCode(professionCode)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find profession"));
        model.addAttribute("profession", currentProfession);
        return "profession/profession";
    }

    @PostMapping("/profession/save")
    public String saveProfession(ProfessionDto profession) {
        professionService.save(profession);
        return "redirect:/professions";
    }
}
