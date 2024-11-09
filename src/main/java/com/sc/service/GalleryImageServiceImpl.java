package com.sc.service;

import com.sc.entity.GalleryImage;
import com.sc.repository.GalleryImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryImageServiceImpl implements GalleryImageService {

    @Autowired
    private GalleryImageRepository galleryImageRepository;

    @Override
    public List<GalleryImage> getAllImages() {
        return galleryImageRepository.findAll();
    }

    @Override
    public Optional<GalleryImage> getImageById(Long id) {
        return galleryImageRepository.findById(id);
    }

    @Override
    public GalleryImage addImage(GalleryImage galleryImage) {
        return galleryImageRepository.save(galleryImage);
    }

    @Override
    public GalleryImage updateImage(Long id, GalleryImage galleryImage) {
        galleryImage.setId(id);
        return galleryImageRepository.save(galleryImage);
    }

    @Override
    public void deleteImage(Long id) {
        galleryImageRepository.deleteById(id);
    }
}
