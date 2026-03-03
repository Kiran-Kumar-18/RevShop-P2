package com.rev.app.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {
    String uploadFile(MultipartFile file);
}
