package green.seagull.observability.lab

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerRequest

@Configuration
class PizzaRouter {

    @Bean
    fun route(pizzaMenuHandler: PizzaMenuHandler) =
        RouterFunctions
            .route(
                RequestPredicates.GET("/menu")
                    .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                { request: ServerRequest ->
                    pizzaMenuHandler.menu(request)
                })

}