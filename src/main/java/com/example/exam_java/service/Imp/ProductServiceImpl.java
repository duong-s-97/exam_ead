package com.example.exam_java.service.Imp;

import com.example.exam_java.entity.ProductEntity;
import com.example.exam_java.repository.ProductRepository;
import com.example.exam_java.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepo;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        ProductEntity productEntity = productRepo.save(product);
        return productEntity;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        productRepo.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        ProductEntity productEntity = getProductByID(id);
        productRepo.delete(productEntity);
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity getProductByID(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<ProductEntity> getProductByName(String name) {
        return productRepo.findNameCustom(name);
    }

    @Override
    public Page<ProductEntity> findPaginated(Pageable pageable) {
        return productRepo.findAll(pageable);
    }
}
