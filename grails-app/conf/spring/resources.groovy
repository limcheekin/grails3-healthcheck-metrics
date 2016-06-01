import org.springframework.boot.actuate.health.DataSourceHealthIndicator
import org.springframework.boot.actuate.health.DiskSpaceHealthIndicatorProperties
import grails3.healthcheck.metrics.UrlHealthIndicator

beans = {

	// REF: https://dzone.com/articles/grails-goodness-adding-health
    urlHealthCheck(UrlHealthIndicator, 'http://intranet', 2000)
            
    // Configure data source health indicator based
    // on the dataSource in the application context.
    databaseHealthCheck(DataSourceHealthIndicator, dataSource)

    diskSpaceHealthIndicatorProperties(DiskSpaceHealthIndicatorProperties) {
        threshold = 250 * 1024 * 1024 // 250MB, default 10MB
    }	
}
