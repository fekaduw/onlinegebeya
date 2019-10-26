package com.fekadu.onlinegebeya.service;

import com.fekadu.onlinegebeya.domain.Buyer;
import com.fekadu.onlinegebeya.domain.Category;
import com.fekadu.onlinegebeya.domain.Product;
import com.fekadu.onlinegebeya.domain.ProductOrder;

import java.util.List;

public interface ProductService {

    public Product save(Product p);

    public ProductOrder saveOrder(ProductOrder po);

    //public Category saveCategory(Category c);

    public Category getCategoryById(Long id);

    //public Image saveImage(Image i);

    public List<Product> getProductByAds(boolean b);

    public List<Product> getProducts();

    List<Product> getAll();

    void delete(Long id);

    public Product findById(Long id);

    public List<ProductOrder> getAllProductOrderByBuyer(Buyer buyer);

    public void deleteProductOrder(ProductOrder productOrder);

    public ProductOrder findProductOrderById(Long id);
}
