package com.sc.controller;

import com.sc.entity.GalleryImage;
import com.sc.service.GalleryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
public class GalleryImageController {

    @Autowired
    private GalleryImageService galleryImageService;

    @GetMapping
    public List<GalleryImage> getAllImages() {
        return galleryImageService.getAllImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GalleryImage> getImageById(@PathVariable Long id) {
        return galleryImageService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GalleryImage addImage(@RequestBody GalleryImage galleryImage) {
        return galleryImageService.addImage(galleryImage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GalleryImage> updateImage(@PathVariable Long id, @RequestBody GalleryImage galleryImage) {
        return ResponseEntity.ok(galleryImageService.updateImage(id, galleryImage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        galleryImageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
