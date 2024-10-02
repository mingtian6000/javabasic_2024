package demo.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
public class HttpClientWithBodyExample {
    public static void main(String[] args) {
        postDemo();
        System.out.println("################################");
        putDemo();
    }

    private static void postDemo(){
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(HttpTestConstants.POST_URL);
            String json = "{\"name\":\"John\", \"age\":30}";
            StringEntity entity = new StringEntity(json);
            entity.setContentType("application/json");
            post.setEntity(entity);

            try (CloseableHttpResponse response = httpClient.execute(post)) {
                int statusCode = response.getStatusLine().getStatusCode();
                String responseBody = EntityUtils.toString(response.getEntity());

                System.out.println("Response Code: " + statusCode);
                System.out.println("Response Body: " + responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void putDemo(){
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPut put = new HttpPut(HttpTestConstants.PUT_URL);

            String json = "{\"name\":\"John\", \"age\":31}";
            StringEntity entity = new StringEntity(json);
            entity.setContentType("application/json");
            put.setEntity(entity);

            try (CloseableHttpResponse response = httpClient.execute(put)) {
                int statusCode = response.getStatusLine().getStatusCode();
                String responseBody = EntityUtils.toString(response.getEntity());

                System.out.println("Response Code: " + statusCode);
                System.out.println("Response Body: " + responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
