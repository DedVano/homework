package lesson35.mapper;

import javax.annotation.processing.Generated;
import lesson35.dto.GenreDto;
import lesson35.model.Genre;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-31T00:24:26+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDto toDto(Genre entity) {
        if ( entity == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        genreDto.setCode( entity.getCode() );
        genreDto.setName( entity.getName() );

        return genreDto;
    }

    @Override
    public Genre toEntity(GenreDto dto) {
        if ( dto == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setCode( dto.getCode() );
        genre.setName( dto.getName() );

        return genre;
    }
}
