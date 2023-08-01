package com.UploadImagesandFile.Images_and_File.Services;

import com.UploadImagesandFile.Images_and_File.Model.ImageEntity;
import com.UploadImagesandFile.Images_and_File.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void saveImage(String name, String type, byte[] data) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setName(name);
        imageEntity.setType(type);
        imageEntity.setData(data);

        imageRepository.save(imageEntity);
    }

    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }


}

