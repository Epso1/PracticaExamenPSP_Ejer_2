package com.example.practica_5_ejer_1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;

import java.util.UUID;

public class URLCollector {
    private final ObservableList<Pair<String, String>> urls = FXCollections.observableArrayList();

    public void addObserver(DownloaderAndZipper observer) {
        urls.addListener(observer);
    }

    public void addURL(String url) {
        String uniqueString = UUID.randomUUID().toString().replace("-", "").substring(0, 20);
        urls.add(new Pair<>(url, uniqueString));
    }

    public ObservableList<Pair<String, String>> getUrls() {
        return urls;
    }
}