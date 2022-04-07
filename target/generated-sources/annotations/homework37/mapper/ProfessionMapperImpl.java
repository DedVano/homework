package homework37.mapper;

import homework37.dto.ProfessionDto;
import homework37.model.Profession;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-07T12:07:43+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProfessionMapperImpl implements ProfessionMapper {

    @Override
    public ProfessionDto toDto(Profession entity) {
        if ( entity == null ) {
            return null;
        }

        ProfessionDto professionDto = new ProfessionDto();

        professionDto.setCode( entity.getCode() );
        professionDto.setName( entity.getName() );

        return professionDto;
    }

    @Override
    public Profession toEntity(ProfessionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Profession profession = new Profession();

        profession.setCode( dto.getCode() );
        profession.setName( dto.getName() );

        return profession;
    }
}
