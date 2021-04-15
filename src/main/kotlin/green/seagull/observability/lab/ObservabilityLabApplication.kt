package green.seagull.observability.lab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ObservabilityLabApplication

fun main(args: Array<String>) {
	runApplication<ObservabilityLabApplication>(*args)
}
