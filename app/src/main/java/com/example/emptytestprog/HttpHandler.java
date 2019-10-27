package com.example.emptytestprog;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class HttpHandler {

    private final String LOG_TAG = "Meteo [HttpHandler]";
    private final String ACCESS_TOKEN = "Y[pUXKJKTM/]H3[xbS4FKD9Js:5[&+8J6nUum\\7X\"5,s_Ka}-+";


    public final String makeServerCall(String download_url) {

        String response = new String();


        try {
            URL url = new URL(download_url);
            URLConnection var10000 = url.openConnection();
            if (var10000 == null) {

            } else {
                HttpURLConnection connection = (HttpURLConnection)var10000;
                connection.setRequestMethod("GET");
                BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
                response = this.convertStreamToString(inputStream);
                return response;
            }
        } catch (MalformedURLException var6) {

        } catch (ProtocolException var7) {

        } catch (Exception var8) {
            Log.e("MTS", "@");
            var8.printStackTrace();
        }
        return response;
    }

    private final String convertStreamToString(BufferedInputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader((Reader)(new InputStreamReader((InputStream)inputStream)));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        for(line = reader.readLine(); line != null; line = reader.readLine()) {
            stringBuilder.append(line).append('\n');
        }

        inputStream.close();
        String var10000 = stringBuilder.toString();
        return var10000;
    }
}
