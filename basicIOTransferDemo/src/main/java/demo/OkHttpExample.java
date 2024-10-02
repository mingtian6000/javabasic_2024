package demo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
public class OkHttpExample {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        String url = "https://www.bing.com/";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();

            int statusCode = response.code();
            System.out.println("Response Status Code: " + statusCode);

            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                String responseBodyString = responseBody.string();
                System.out.println("Response Body: " + responseBodyString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
