package com.example.hello_world.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    private static final String STORAGE_DIRECTORY = "D:/storage";

    @Autowired
    private AsyncFileStorageService asyncFileStorageService;

    private void ensureDirectoryExists() {
        File directory = new File(STORAGE_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
    @Async("taskExecutor")
    public void saveFileUsingBytes(byte[] fileBytes, String filename) throws IOException {
        ensureDirectoryExists();

        if (fileBytes == null || fileBytes.length == 0) {
            throw new IllegalArgumentException("File bytes are invalid!");
        }

        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename is invalid!");
        }

       File targetFile = new File(STORAGE_DIRECTORY + File.separator + filename);
        //int counter = 1;
        //while (targetFile.exists()) {
            //String newFileName = filename.substring(0, filename.lastIndexOf('.')) + "_" + counter + filename.substring(filename.lastIndexOf('.'));
            String newFileName = "pdf_"+ UUID.randomUUID().toString()+".pdf";
            targetFile = new File(STORAGE_DIRECTORY + File.separator + newFileName);
            //counter++;
        //}

        long startTime = System.currentTimeMillis();

        try (FileOutputStream fos = new FileOutputStream(targetFile)) {
            fos.write(fileBytes);

            long endTime = System.currentTimeMillis();
            System.out.println("File saved successfully to: " + targetFile.getAbsolutePath());
            System.out.println("Time taken to save file using bytes: " + (endTime - startTime) + " ms");

            asyncFileStorageService.printThreadPoolStatus();

        } catch (IOException e) {
            long endTime = System.currentTimeMillis();
            System.err.println("File save failed: " + e.getMessage());
            System.err.println("Time taken before error: " + (endTime - startTime) + " ms");
            throw e;
        }
    }
}
