package lesson6;

import okhttp3.*;
import java.io.IOException;

public class lesson6
{
    public static void main(String[] args) throws IOException
    {
        OkHttpClient okHttpClient = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/5day/294021")
                .addQueryParameter("apikey", "Gyf6AizxgdqMkaaFAfbAgUwVmiqBDa40")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "false")
                .addQueryParameter("details", "false")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.isSuccessful());
        String responseBody = response.body().string();
        System.out.println(responseBody);
    }
}
