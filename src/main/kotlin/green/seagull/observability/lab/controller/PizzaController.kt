package green.seagull.observability.lab.controller

import green.seagull.observability.lab.service.PizzaService
import io.micrometer.core.instrument.Timer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PizzaController {

    @Autowired
    private lateinit var requestsTimer: Timer

    @Autowired
    private lateinit var pizzaService: PizzaService

    @GetMapping("/api/pizzas")
    fun getPizzasAvailable(): List<String> {
        return requestsTimer.recordCallable {
            Thread.sleep(100) // Add some lag
            pizzaService.pizzaMenu()
        }
    }
}