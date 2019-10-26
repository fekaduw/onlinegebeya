package com.fekadu.onlinegebeya.service;
import com.fekadu.onlinegebeya.domain.Picture;

import java.io.File;
import java.util.List;

public interface PictureService {
    File getFilePath(String modifiedFileName, String path);

    List<Picture> findByProductId(Long productId);
}
