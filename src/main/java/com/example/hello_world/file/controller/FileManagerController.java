package com.example.hello_world.file.controller;

import com.example.hello_world.file.service.ByteStorageService;
import com.example.hello_world.file.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/auth")
public class FileManagerController {

    @Autowired
    private FileStorageService fileStorageService;


    private static final Logger log = Logger.getLogger(FileManagerController.class.getName());

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam(value= "file", required = false) MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            log.log(Level.WARNING, "No file selected for upload.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No file selected for upload.");
        }

        System.out.println("File name: " + file.getOriginalFilename());
        byte[] fileContent = file.getBytes();
        fileStorageService.saveFileUsingBytes(fileContent, file.getOriginalFilename());
        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully.");

    }
    /*  System.out.println("File name: "+file.getOriginalFilename());
      byte[] fileContent = file.getBytes();
      MultipartFile copiedFile = new MockMultipartFile(
              file.getName(),
              file.getOriginalFilename(),
              file.getContentType(),
              fileContent

      );

      fileStorageService.saveFile(copiedFile);
      return  ResponseEntity.status(HttpStatus.CREATED).build();
      */


    @Autowired
    private ByteStorageService byteStorageService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/byte-upload-file")
    public ResponseEntity<String> uploadFileUsingBytes(@RequestBody byte[] fileBytes) {
        if (fileBytes == null || fileBytes.length == 0) {
            log.log(Level.WARNING, "No file selected for upload.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No file selected for upload.");
        }

        try {
            String savedFilePath = byteStorageService.saveFileUsingBytes(fileBytes);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + savedFilePath);
        } catch (Exception e) {
            log.log(Level.SEVERE, "File upload failed.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during file upload.");
        }
    }




}
