package homework35.service;

import homework35.dto.ProfessionDto;
import homework35.dto.ProfessionPageDto;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface ProfessionService {

    List<ProfessionDto> findAll();

    ProfessionPageDto getPage(Pageable pageable);

    Optional<ProfessionDto> getByCode(@NotEmpty Integer professionCode);

    ProfessionDto save(@Valid ProfessionDto profession);

    void deleteByCode(@NotEmpty Integer professionCode);
}
