package com.perry.service;

import com.perry.model.entity.Image;
import com.perry.repository.StorageRepository;
import com.perry.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile multipartFile) throws IOException {
        Image image = storageRepository.save(Image.builder()
                .name(multipartFile.getOriginalFilename())
                .type(multipartFile.getContentType())
                .imageData(ImageUtil.compressImage(multipartFile.getBytes())).build()
        );
        if (image != null) {
            return "file uploaded successfully : " + multipartFile.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<Image> dbImageData = storageRepository.findByName(fileName);
        byte[] images=ImageUtil.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}