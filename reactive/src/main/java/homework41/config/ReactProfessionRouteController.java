package homework41.config;

import homework41.model.Profession;
import homework41.repository.ProfessionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Configuration
public class ReactProfessionRouteController {
    @Bean
    public RouterFunction<ServerResponse> composedRoutes(ProfessionRepository professionRepository) {
        return route()
                .GET("/api/professions", accept(APPLICATION_JSON),
                        request -> ok().contentType(APPLICATION_JSON).body(professionRepository.findAll(), Profession.class)
                )
                .DELETE("/api/professions/{code}",
                        request -> professionRepository.deleteById(Integer.valueOf(request.pathVariable("code"))).flatMap(v -> ok().build())
                ).build();
    }
}