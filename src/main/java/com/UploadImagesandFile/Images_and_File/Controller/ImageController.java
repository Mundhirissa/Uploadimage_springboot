package com.UploadImagesandFile.Images_and_File.Controller;

import com.UploadImagesandFile.Images_and_File.Model.ImageEntity;
import com.UploadImagesandFile.Images_and_File.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("name") String name,
                                              @RequestParam("type") String type,
                                              @RequestParam("file") MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            imageService.saveImage(name, type, data);
            return ResponseEntity.ok("Image uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
        }
    }



    @GetMapping("/getAllImages")
    public ResponseEntity<List<ImageEntity>> getAllImages() {
        List<ImageEntity> allImages = imageService.getAllImages();

        if (!allImages.isEmpty()) {
            return ResponseEntity.ok(allImages);
        } else {
            return ResponseEntity.noContent().build();
        }
    }







}
