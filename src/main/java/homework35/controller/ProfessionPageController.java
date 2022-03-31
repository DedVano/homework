package homework35.controller;

import homework35.dto.ProfessionDto;
import homework35.dto.ProfessionPageDto;
import homework35.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Controller
@Validated
@RequiredArgsConstructor
public class ProfessionPageController {

    private final ProfessionService professionService;

    @GetMapping("/professions")
    public String index(Model model,
                        @PositiveOrZero @RequestParam(required = false, defaultValue = "0") Integer page,
                        @Positive @RequestParam(required = false, defaultValue = "5") Integer size) {
        ProfessionPageDto pageOfProfessionsList = professionService.getPage(PageRequest.of(page, size));
        model.addAttribute("professions", pageOfProfessionsList);
        return "homework35/profession/professions";
    }

    @GetMapping("/profession/add")
    public String newProfession(Model model) {
        return "homework35/profession/profession";
    }

    @GetMapping("/profession/edit")
    public String editCurrentProfession(@RequestParam("code") Integer professionCode, Model model) {
        ProfessionDto currentProfession = professionService.getByCode(professionCode)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find profession"));
        model.addAttribute("profession", currentProfession);
        return "homework35/profession/profession";
    }

    @PostMapping("/profession/save")
    public String saveProfession(ProfessionDto profession) {
        professionService.save(profession);
        return "redirect:/professions";
    }
}
