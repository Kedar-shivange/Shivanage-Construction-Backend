package com.sc.service;

import com.sc.entity.GalleryImage;
import java.util.List;
import java.util.Optional;

public interface GalleryImageService {
    List<GalleryImage> getAllImages();
    Optional<GalleryImage> getImageById(Long id);
    GalleryImage addImage(GalleryImage galleryImage);
    GalleryImage updateImage(Long id, GalleryImage galleryImage);
    void deleteImage(Long id);
}
