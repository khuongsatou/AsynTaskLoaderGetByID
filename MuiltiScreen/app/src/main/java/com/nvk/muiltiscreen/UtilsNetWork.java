package com.nvk.muiltiscreen;

import android.net.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class UtilsNetWork {
    //public static final String BASE_URL = "http://khuongsatou.club/api/linh_vuc/";//wiless
    public static final String BASE_URL_GENNY = "http://10.0.3.2:8000/api/linh_vuc/";//genny
    public static final String BASE_URL_GENNY1 = "http://10.0.3.2:8000/api/cau_hoi/";//genny
    //public static final String BASE_URL_ANDROID = "http://10.0.2.2:8000/api/linh_vuc/";//android
    public static String connect(){
        String json=null;
        Uri uri = Uri.parse(BASE_URL_GENNY).buildUpon().build();
        try {
            //kết nối
            URL url = new URL(uri.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            //đọc
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line =null;
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            //đóng
            if (reader != null && connection!=null){
                reader.close();
                connection.disconnect();
            }
            //gán
            json = stringBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static String connect(String nameParams, String valueParams){
        String json=null;
        Uri.Builder builder = Uri.parse(BASE_URL_GENNY1+valueParams).buildUpon();
        //builder.appendQueryParameter(nameParams,valueParams);
        Uri uri = builder.build();
        try {
            //kết nối
            URL url = new URL(uri.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            //đọc
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line =null;
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            //đóng
            if (reader != null && connection!=null){
                reader.close();
                connection.disconnect();
            }
            //gán
            json = stringBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

}
