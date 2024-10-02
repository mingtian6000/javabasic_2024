package demo.httpclient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientConfigExample {
    public static void main(String[] args) throws Exception {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000) // Socket timeout 5s
                .setConnectTimeout(5000) // Connection timeout
                .build();

        // Create HttpClient with custom configuration
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build()) {

            HttpGet request = new HttpGet(HttpTestConstants.TESTURL_INTERNAL);
            request.addHeader("User-Agent", "MyApp/1.0");

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                System.out.println("Response Status: " + response.getStatusLine());
            }
        }
    }
}
