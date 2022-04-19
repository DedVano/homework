package homework35.controller.rest;

import homework35.dto.ResultDto;
import homework35.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfessionController {

    private final ProfessionService professionService;

    @DeleteMapping("/professions/{code}")
    public ResponseEntity<?> delete(@PathVariable("code") Integer professionCode) {
        professionService.deleteByCode(professionCode);
        return ResponseEntity.ok(new ResultDto());
    }
}

