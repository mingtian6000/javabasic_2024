package demo.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientPoolingExample {
    public static void main(String[] args) throws Exception {
        // Utilize PoolingHttpClientConnectionManager to manage connections efficiently.
        //This allows you to reuse connections instead of creating new ones for each request.
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(100); // Maximum total connections
        connectionManager.setDefaultMaxPerRoute(20); // ConnPerRoute(1000):分配给同一个route(路由)最大的并发连接数,route为运行环境机器到目标机器的一条线路

        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .build()) {
            HttpGet request = new HttpGet(HttpTestConstants.TESTURL_INTERNAL);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                System.out.println("Response Status: " + response.getStatusLine());
            }
        }
    }
}
