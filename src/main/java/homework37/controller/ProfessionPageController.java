package homework37.controller;

import homework37.dto.ProfessionDto;
import homework37.dto.ProfessionPageDto;
import homework37.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import static homework37.security.UserPrincipal.ROLE_ADMIN;

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
        return "homework37/profession/professions";
    }

    @GetMapping("/profession/add")
    @Secured(ROLE_ADMIN)
    public String newProfession(Model model) {
        return "homework37/profession/profession";
    }

    @GetMapping("/profession/edit")
    @Secured(ROLE_ADMIN)
    public String editCurrentProfession(@RequestParam("code") Integer professionCode, Model model) {
        ProfessionDto currentProfession = professionService.getByCode(professionCode)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find profession"));
        model.addAttribute("profession", currentProfession);
        return "homework37/profession/profession";
    }

    @PostMapping("/profession/save")
    @Secured(ROLE_ADMIN)
    public String saveProfession(ProfessionDto profession) {
        professionService.save(profession);
        return "redirect:/professions";
    }
}
