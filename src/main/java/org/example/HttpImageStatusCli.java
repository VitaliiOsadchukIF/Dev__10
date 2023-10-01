package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {

    void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code: ");
        String input = scanner.nextLine();
        try {
            int code = Integer.parseInt(input);
            HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
            downloader.downloadStatusImage(code);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}
