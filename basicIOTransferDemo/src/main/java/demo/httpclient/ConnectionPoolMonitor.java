package demo.httpclient;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.Timer;
import java.util.TimerTask;

public class ConnectionPoolMonitor {
    public int totalConnections;
    public int leasedConnections;
    public int maxConnections;
    public int getTotalConnections() {
        return connectionManager.getTotalStats().getAvailable();
    }

    public int getLeasedConnections() {
        return connectionManager.getTotalStats().getLeased();
    }

    public int getMaxConnections() {
        return connectionManager.getMaxTotal();
    }

    private final PoolingHttpClientConnectionManager connectionManager;
    public ConnectionPoolMonitor(PoolingHttpClientConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        startMonitoring();
    }

    private void startMonitoring() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logConnectionPoolStats();
            }
        }, 0, 5000); // Log every 5 seconds
    }

    private void logConnectionPoolStats() {
        System.out.printf("Total Connections: %d, Leased Connections: %d, Max Connections: %d%n",
                this.getTotalConnections(), this.getLeasedConnections(), this.getMaxConnections());
    }
}
