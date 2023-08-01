package com.UploadImagesandFile.Images_and_File.Repository;

import com.UploadImagesandFile.Images_and_File.Model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
