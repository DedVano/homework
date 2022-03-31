package homework35.mapper;

import homework35.dto.ProfessionDto;
import homework35.model.Profession;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-31T01:59:11+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProfessionMapperImpl implements ProfessionMapper {

    @Override
    public ProfessionDto toDto(Profession entity) {
        if ( entity == null ) {
            return null;
        }

        ProfessionDto professionDto = new ProfessionDto();

        professionDto.setName( entity.getName() );
        professionDto.setCode( entity.getCode() );

        return professionDto;
    }

    @Override
    public Profession toEntity(ProfessionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Profession profession = new Profession();

        profession.setName( dto.getName() );
        profession.setCode( dto.getCode() );

        return profession;
    }
}
