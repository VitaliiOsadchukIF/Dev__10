package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {

    void downloadStatusImage(int code) {
        HttpStatusChecker checker = new HttpStatusChecker();
        try {
            String imageUrl = checker.getStatusImage(code);
            URL url = new URL(imageUrl);
            String fileName = code + ".jpg";
            try (InputStream in = url.openStream();
                 FileOutputStream out = new FileOutputStream(fileName)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                System.out.println("Image downloaded successfully as " + fileName);
            } catch (IOException e) {
                System.out.println("Error downloading image: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
