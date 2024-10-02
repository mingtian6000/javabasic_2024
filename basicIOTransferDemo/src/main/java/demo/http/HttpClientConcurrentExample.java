package demo.http;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class HttpClientConcurrentExample {
/*
* demo for threading,
* some will timeout, but not concurrent exception..
* */
    private static final int THREAD_COUNT = 10;
    public static void main(String[] args) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(1000)
                .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(2);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)// else by default no pooling
                .build()) {

            for (int i = 0; i < THREAD_COUNT; i++) {
                final int requestId = i; // To use in the Runnable
                executorService.submit(() -> {
                    try {
                        HttpGet request = new HttpGet("https://httpbin.org/get?requestId=" + requestId);
                        try (CloseableHttpResponse response = httpClient.execute(request)) {
                            int statusCode = response.getStatusLine().getStatusCode();
                            String responseBody = EntityUtils.toString(response.getEntity());
                            System.out.println("Response for request " + requestId + ": " + statusCode + " - " + responseBody);
                        }
                    } catch (Exception e) {
                        System.err.println("Request " + requestId + " failed: " + e.getMessage());
                    }
                });
            }

            executorService.shutdown();
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (Exception e) {
            System.err.println("HttpClient initialization failed: " + e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}
