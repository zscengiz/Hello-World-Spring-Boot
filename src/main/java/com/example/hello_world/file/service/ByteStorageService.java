package com.example.hello_world.file.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class ByteStorageService {

    private static final String STORAGE_DIRECTORY = "D:/storage"; //

    private void ensureDirectoryExists() {
        File directory = new File(STORAGE_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Async("taskExecutor")
    public String saveFileUsingBytes(byte[] fileBytes) throws IOException {
        ensureDirectoryExists();

        if (fileBytes == null || fileBytes.length == 0) {
            throw new IllegalArgumentException("File bytes are invalid!");
        }

        String newFileName = "ud_" + UUID.randomUUID().toString() + ".pdf"; //
        File targetFile = new File(STORAGE_DIRECTORY + File.separator + newFileName);

        long startTime = System.currentTimeMillis();

        try (FileOutputStream fos = new FileOutputStream(targetFile)) {
            fos.write(fileBytes);

            long endTime = System.currentTimeMillis();
            System.out.println("File saved successfully to: " + targetFile.getAbsolutePath());
            System.out.println("Time taken to save file using bytes: " + (endTime - startTime) + " ms");

            return targetFile.getAbsolutePath();
        } catch (IOException e) {
            long endTime = System.currentTimeMillis();
            System.err.println("File save failed: " + e.getMessage());
            System.err.println("Time taken before error: " + (endTime - startTime) + " ms");
            throw e;
        }
    }
}
