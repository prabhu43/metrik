package fourkeymetrics.resource

import fourkeymetrics.model.MetricUnit
import fourkeymetrics.resource.metrics.MetricsApplicationService
import fourkeymetrics.resource.metrics.representation.FourKeyMetricsResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class MetricsResource {
    @Autowired
    private lateinit var metricsApplicationService: MetricsApplicationService

    @GetMapping("/api/metrics")
    fun getFourKeyMetrics(
        @RequestParam dashboardId: String,
        @RequestParam pipelineId: String,
        @RequestParam targetStage: String,
        @RequestParam startTime: Long,
        @RequestParam endTime: Long,
        @RequestParam unit: MetricUnit
    ): FourKeyMetricsResponse {
        return metricsApplicationService.retrieve4KeyMetrics(
            dashboardId,
            pipelineId,
            targetStage,
            startTime,
            endTime,
            unit
        )
    }
}
