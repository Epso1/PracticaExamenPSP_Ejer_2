package com.example.practica_5_ejer_1;

import javafx.util.Pair;

import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        URLCollector collector = new URLCollector();
        DownloaderAndZipper downloaderAndZipper = new DownloaderAndZipper();

        collector.addObserver(downloaderAndZipper);

        Scanner scanner = new Scanner(System.in);
        System.out.println("***** URL Collector *****");
        System.out.println("Introduce '0' para salir del programa.");

        boolean exit = false;

        while (!exit) {
            System.out.println("Introduce una URL:");
            String url = scanner.nextLine();
            if (url.equals("0")) {
                System.out.println("Saliendo del programa...");
                exit = true;
            } else if (url.isEmpty()) {
                CompletableFuture.runAsync(() -> {
                    downloaderAndZipper.downloadFiles(collector.getUrls());
                }).thenRun(() -> {
                    downloaderAndZipper.zipFiles("urls.zip");
                });
            } else {
                collector.addURL(url);
            }
        }
        for (Pair<String, String> urlPair : collector.getUrls()) {
            System.out.println(urlPair.getKey() + " encolado como " + urlPair.getValue());
        }
    }
}