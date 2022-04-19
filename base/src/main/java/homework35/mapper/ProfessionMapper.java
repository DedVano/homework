package homework35.mapper;

import homework35.dto.ProfessionDto;
import homework35.model.Profession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface ProfessionMapper {

    @Mapping(target = "code", source = "entity.code")
    @Mapping(target = "name", source = "entity.name")
    ProfessionDto toDto(Profession entity);

    @Mapping(target = "code", source = "dto.code")
    @Mapping(target = "name", source = "dto.name")
    Profession toEntity(ProfessionDto dto);

    default List<ProfessionDto> toDtos(List<Profession> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<ProfessionDto> toOptionalDto(Optional<Profession> entity) {
        return entity.map(this::toDto);
    }
}
