package demo.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import java.util.concurrent.Future;
import org.apache.http.util.EntityUtils;
public class HttpClientAsyncExample {
    public static void main(String[] args) throws Exception {
        // CloseableHttpAsyncClient是apache在4.0后提供AIO操作的api
        try (CloseableHttpAsyncClient asyncHttpClient = HttpAsyncClients.createDefault()) {
            asyncHttpClient.start();

            HttpGet request = new HttpGet(HttpTestConstants.TESTURL_INTERNAL);
            Future<HttpResponse> future = asyncHttpClient.execute(request, null);
            HttpResponse response = future.get();
            String responseBody = EntityUtils.toString(response.getEntity());
            //in case you want to see full body, use entity util, no need to write by yourself
            System.out.println("Response Body: " + responseBody);
        }
    }

}
