package com.example.practica_5_ejer_1;

import javafx.collections.ListChangeListener;
import javafx.util.Pair;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

public class DownloaderAndZipper implements ListChangeListener<Pair<String, String>> {
    private List<String> downloadedFiles = new ArrayList<>();

    @Override
    public void onChanged(Change<? extends Pair<String, String>> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Pair<String, String> urlPair : change.getAddedSubList()) {
                    if (urlPair.getKey().isEmpty()) {
                        System.out.println("Se va a proceder a descargar y comprimir los ficheros");
                        downloadFiles(new ArrayList<>(change.getList()));
                        zipFiles("urls.zip");
                    } else {
                        System.out.println(urlPair.getKey() + " encolado como " + urlPair.getValue());
                    }
                }
            }
        }
    }

    public void downloadFiles(List<Pair<String, String>> urls) {
        for (Pair<String, String> urlPair : urls) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(urlPair.getKey()).openStream()));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(urlPair.getValue() + ".html"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
                downloadedFiles.add(urlPair.getValue() + ".html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void zipFiles(String zipFileName) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            for (String fileName : downloadedFiles) {
                zos.putNextEntry(new ZipEntry(fileName));
                Files.copy(Paths.get(fileName), zos);
                zos.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}