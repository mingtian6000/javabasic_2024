package demo.httpclient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientRedirectExample {
    public static void main(String[] args) throws Exception {
        RequestConfig requestConfig = RequestConfig.custom()
                .setRedirectsEnabled(true) // Enable redirects, default is false
                .setMaxRedirects(5) // Maximum redirects allowed
                .build();
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build()) {
            //HttpGet request = new HttpGet("http://httpbin.org/redirect/1"); //how can I find redirect url to test?
            HttpGet request = new HttpGet("https://httpbin.org/redirect-to?url=https://www.example.com");
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                System.out.println("Response Status: " + response.getStatusLine());
                System.out.println("Final URL: " + response.getEntity().toString());
            }
        }
    }
}
