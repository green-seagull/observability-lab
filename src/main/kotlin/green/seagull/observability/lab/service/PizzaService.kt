package green.seagull.observability.lab.service

import org.springframework.stereotype.Service

@Service
class PizzaService {
    fun pizzaMenu() = listOf(
        "BBQ King mushroom",
        "Smokey beef brisket"
    )
}