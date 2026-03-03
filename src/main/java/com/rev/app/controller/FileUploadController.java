package com.rev.app.controller;

import com.rev.app.rest.ApiResponse;
import com.rev.app.service.IFileUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {
    private static final Logger logger = LogManager.getLogger(FileUploadController.class);
    private final IFileUploadService ifileUploadService;
    private final Path fileStorageLocation;

    public FileUploadController(IFileUploadService ifileUploadService) {
        this.ifileUploadService = ifileUploadService;
        this.fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();
    }

    @PostMapping("/image")
    public ResponseEntity<ApiResponse<String>> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body(ApiResponse.error("Failed to store empty file."));
        }
        try {
            String fileUrl = ifileUploadService.uploadFile(file);
            return ResponseEntity.ok(ApiResponse.success(fileUrl, "Image uploaded successfully"));
        } catch (Exception ex) {
            logger.error("Could not store uploaded file: {}", ex.getMessage());
            return ResponseEntity.internalServerError().body(ApiResponse.error("Could not store file: " + ex.getMessage()));
        }
    }

    @GetMapping("/images/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                String contentType = "image/jpeg"; // default
                if (fileName.toLowerCase().endsWith(".png")) contentType = "image/png";
                else if (fileName.toLowerCase().endsWith(".gif")) contentType = "image/gif";
                
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
