package demo.http;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class ConnectionPoolMetrics {
    private final PoolingHttpClientConnectionManager connectionManager;
    private final MeterRegistry meterRegistry;

    public ConnectionPoolMetrics(PoolingHttpClientConnectionManager connectionManager, MeterRegistry meterRegistry) {
        this.connectionManager = connectionManager;
        this.meterRegistry = meterRegistry;
        registerMetrics();
    }

    private void registerMetrics() {
        meterRegistry.gauge("httpclient.connections.leased",  connectionManager.getTotalStats().getLeased());
        meterRegistry.gauge("httpclient.connections.available", connectionManager.getTotalStats().getAvailable());
        meterRegistry.gauge("httpclient.connections.max", connectionManager.getMaxTotal());
    }
}
