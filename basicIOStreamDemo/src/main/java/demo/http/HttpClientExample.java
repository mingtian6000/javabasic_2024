package demo.http;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientExample {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClientBuilder.create().build();

        String url = "https://www.bing.com/";

        HttpGet httpGet = new HttpGet(url);

        try {
            HttpResponse response = httpClient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Response Status Code: " + statusCode);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                System.out.println("Response Body: " + responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
