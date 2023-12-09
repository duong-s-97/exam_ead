package com.example.exam_java.service.Imp;

import com.example.exam_java.entity.SaleEntity;
import com.example.exam_java.repository.SaleRepository;
import com.example.exam_java.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepository saleRepository;
    @Override
    public SaleEntity createSale(SaleEntity saleEntity) {
        SaleEntity categoryEntity = saleRepository.save(saleEntity);
        return categoryEntity;
    }

    @Override
    public SaleEntity updateSale(SaleEntity saleEntity) {
        saleRepository.save(saleEntity);
        return saleEntity;
    }

    @Override
    public void deleteSale(Long id) {
        SaleEntity categoryEntity = getSaleByID(id);
        saleRepository.delete(categoryEntity);
    }

    @Override
    public List<SaleEntity> getAllCategory() {
        return saleRepository.findAll();
    }

    @Override
    public SaleEntity getSaleByID(Long id) {
        return saleRepository.findById(id).get();
    }

    @Override
    public List<SaleEntity> getCategoryByName(String name) {
        return saleRepository.findNameCustom(name);
    }

    @Override
    public Page<SaleEntity> findPaginated(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }
}
