package homework41.mapper;

import homework41.dto.ProfessionDto;
import homework41.model.Profession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProfessionMapper {

    @Mapping(target = "code", source = "entity.code")
    @Mapping(target = "name", source = "entity.name")
    ProfessionDto toDto(Profession entity);

    @Mapping(target = "code", source = "dto.code")
    @Mapping(target = "name", source = "dto.name")
    Profession toEntity(ProfessionDto dto);
}