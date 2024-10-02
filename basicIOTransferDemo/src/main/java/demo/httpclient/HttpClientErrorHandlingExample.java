package demo.httpclient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientErrorHandlingExample {
    public static void main(String[] args) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setRedirectsEnabled(true) // Enable redirects
                .setMaxRedirects(5) // Maximum redirects allowed
                .build();

/*           For a successful response: Use http://httpbin.org/status/200.
            For a client error: Use http://httpbin.org/status/404.
            For a server error: Use http://httpbin.org/status/500.*/
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build()) {

            HttpGet request = new HttpGet("http://httpbin.org/status/500"); // Example URL for testing
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    String responseBody = EntityUtils.toString(response.getEntity());
                    System.out.println("Response Body: " + responseBody);
                } else {
                    System.out.println("Error: Received status code " + statusCode);
                    String errorBody = EntityUtils.toString(response.getEntity());
                    System.out.println("Error Body: " + errorBody);
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
