package homework43.service.impl;

import homework43.dto.ProfessionDto;
import homework43.dto.ProfessionPageDto;
import homework43.mapper.ProfessionMapper;
import homework43.model.Profession;
import homework43.repository.ProfessionRepository;
import homework43.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements ProfessionService {

    private final ProfessionRepository professionRepository;
    private final ProfessionMapper professionMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProfessionDto> findAll() {
        return professionMapper.toDtos(professionRepository.findAll());
    }

    @Override
    public ProfessionPageDto getPage(Pageable pageable) {
        Page<Profession> currentPage = professionRepository.findAll(pageable);
        return new ProfessionPageDto(professionMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProfessionDto> getByCode(@NotEmpty Integer professionCode) {
        return professionMapper.toOptionalDto(professionRepository.findById(professionCode));
    }

    @Override
    @Transactional
    public ProfessionDto save(@Valid ProfessionDto profession) {
        return professionMapper.toDto(professionRepository.save(professionMapper.toEntity(profession)));
    }

    @Override
    @Transactional
    public void deleteByCode(@NotEmpty Integer professionCode) {
        professionRepository.deleteById(professionCode);
    }
}
