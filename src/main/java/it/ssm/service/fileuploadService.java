package it.ssm.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface fileuploadService {
    public Boolean fileuploadAction(MultipartFile file) throws IOException;
}
