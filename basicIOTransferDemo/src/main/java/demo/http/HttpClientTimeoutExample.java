package demo.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientTimeoutExample {
    public static void main(String[] args) {
        int connectionTimeout = 2000; // 2s
        int socketTimeout = 2000;
        int connectionRequestTimeout = 2000;

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectionTimeout) // Connection timeout
                .setSocketTimeout(socketTimeout) // Socket timeout
                .setConnectionRequestTimeout(connectionRequestTimeout) // Connection request timeout
                .build();

        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build()) {

            HttpGet request = new HttpGet("https://httpbin.org/delay/3"); // This URL simulates 3s delay
            // connection is built, this only for request itself, 3>2, so timeout happens!
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    String responseBody = EntityUtils.toString(response.getEntity());
                    System.out.println("Response Body: " + responseBody);
                } else {
                    System.out.println("Error: Received status code " + statusCode);
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
