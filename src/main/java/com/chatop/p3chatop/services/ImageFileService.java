package com.chatop.p3chatop.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ImageFileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Value("${server.servlet.context-path}")
    private String contextPath;



    public String uploadImage (MultipartFile image) {
        try {
            return saveImage(image);
        } catch (IOException e) {
            return null;
        }


    }

    private String saveImage (MultipartFile image) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectory(uploadPath);
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String originalFileName = image.getOriginalFilename();
        String fileName = timestamp + "_" + originalFileName;

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        String url = "http://localhost:8080" + contextPath + "/";

        return (url +  filePath);
    }
}
