package com.fekadu.onlinegebeya.service.serviceImpl;

import com.fekadu.onlinegebeya.domain.*;
import com.fekadu.onlinegebeya.repository.CategoryRepo;
import com.fekadu.onlinegebeya.repository.PictureRepo;
import com.fekadu.onlinegebeya.repository.ProductOrderRepo;
import com.fekadu.onlinegebeya.repository.ProductRepo;
import com.fekadu.onlinegebeya.service.PictureService;
import com.fekadu.onlinegebeya.service.ProductService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductOrderRepo productOrderRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    PictureRepo pictureRepo;

    @Autowired
    PictureService pictureService;

    public ProductOrder saveOrder(ProductOrder po){
        return productOrderRepo.save(po);
    }

    @Override
    public Category getCategoryById(Long i) {
        Optional<Category> cc = categoryRepo.findById(i);
        if(cc.isPresent())
            return cc.get();
        else
            return null;
    }

    @Override
    public List<Product> getProductByAds(boolean b) {
        return productRepo.findByAnAdd(b);
    }

    @Override
    public List<Product> getProducts() {
        return (List) productRepo.findAll();
    }

    @Override
    public List<ProductOrder> getAllProductOrderByBuyer(Buyer buyer) {
        return productOrderRepo.getAllByBuyer(buyer);
    }

    @Override
    public void deleteProductOrder(ProductOrder productOrder) {
        productOrderRepo.delete(productOrder);
    }

    @Override
    public ProductOrder findProductOrderById(Long id) {
        return productOrderRepo.getOne(id);
    }

    @Override
    public Product save(Product product){

        Product savedProduct =  productRepo.save(product);

        if(savedProduct!=null && product.getPictures()!=null && product.getPictures().size() > 0){
            for(MultipartFile file : product.getPictures()){
                String currentFileName = file.getOriginalFilename();
                String fileName = FilenameUtils.getBaseName(currentFileName) + "_" + System.currentTimeMillis()+"."+FilenameUtils.getExtension(currentFileName);
                File storeFile = pictureService.getFilePath(fileName, "images");

                if(storeFile!=null){
                    try {
                        FileUtils.writeByteArrayToFile(storeFile, file.getBytes());
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

                Picture pictures = new Picture();

                pictures.setFileExtension(FilenameUtils.getExtension(fileName));
                pictures.setFileName(fileName);
                pictures.setProduct(savedProduct);

                pictureRepo.save(pictures);
            }
        }

        return savedProduct;
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).get();
    }
}
