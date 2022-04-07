package homework37.controller.rest;

import homework37.dto.ResultDto;
import homework37.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static homework37.security.UserPrincipal.ROLE_ADMIN;

@RestController
@RequiredArgsConstructor
public class ProfessionController {

    private final ProfessionService professionService;

    @DeleteMapping("/professions/{code}")
    @Secured(ROLE_ADMIN)
    public ResponseEntity<?> delete(@PathVariable("code") Integer professionCode) {
        professionService.deleteByCode(professionCode);
        return ResponseEntity.ok(new ResultDto());
    }
}

