package green.seagull.observability.lab.config

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
class MetricsConfig {

    @Bean
    fun requestsTimer(meterRegistry: MeterRegistry): Timer =
        Timer.builder("observability.lab.requests.duration")
        .publishPercentiles(0.5, 0.99)
        .publishPercentileHistogram()
        .minimumExpectedValue(Duration.ofMillis(1))
        .maximumExpectedValue(Duration.ofSeconds(10))
        .register(meterRegistry)
}