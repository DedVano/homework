package lesson35.mapper;

import javax.annotation.processing.Generated;
import lesson35.dto.GenreDto;
import lesson35.model.Genre;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-31T01:59:11+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDto toDto(Genre entity) {
        if ( entity == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        genreDto.setName( entity.getName() );
        genreDto.setCode( entity.getCode() );

        return genreDto;
    }

    @Override
    public Genre toEntity(GenreDto dto) {
        if ( dto == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setName( dto.getName() );
        genre.setCode( dto.getCode() );

        return genre;
    }
}
