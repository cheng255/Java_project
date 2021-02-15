package com.cheng.downloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * URL下载
 * @author nuonuo
 * @create 2021-02-15 20:26
 */
public class DownloaderDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://static.hdslb.com/images/base/icons.png");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream is = httpURLConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("net/down.png");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        is.close();
    }
}
