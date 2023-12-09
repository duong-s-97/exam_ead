package com.example.exam_java.service;

import com.example.exam_java.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductEntity createProduct(ProductEntity productEntity);
    ProductEntity updateProduct(ProductEntity productEntity);
    void deleteProduct(Long id);
    List<ProductEntity> getAllProduct();
    ProductEntity getProductByID(Long id);
    List<ProductEntity> getProductByName(String name);
    Page<ProductEntity> findPaginated(Pageable pageable);
}
