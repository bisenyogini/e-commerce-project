package com.ecommerce.project.service.ServiceImpl;

import com.ecommerce.project.entity.CategoryType;
import com.ecommerce.project.exception.CategoryNotFoundException;
import com.ecommerce.project.repository.CatTypeRepo;
import com.ecommerce.project.service.CatTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
@Slf4j
public class CatTypeServiceImpl implements CatTypeService {
    @Autowired
    private CatTypeRepo catTypeRepo;
    @Override
    public Integer saveCatType(CategoryType categoryType) {
        return catTypeRepo.save(categoryType).getCatTypeId();
    }

    @Override
    public List<CategoryType> getAllCatType() {
        return catTypeRepo.findAll();
    }

    @Override
    public CategoryType  getOneCatTypeById(Integer catTypeId) {
       Optional<CategoryType>opt= catTypeRepo.findById(catTypeId);
       if(opt.isPresent())
       {

           return opt.get();
       }
       else
       {
           throw new CategoryNotFoundException(catTypeId+"  not found");
       }
    }

    @Override
    public void updateCatType(CategoryType categoryType) {
        catTypeRepo.save(categoryType);
    }

    @Override
    public void deleteCatType(Integer catTypeId) {
        catTypeRepo.delete(getOneCatTypeById(catTypeId));

    }

    @Override
    public Map<Integer, String> getCatTypeIdAndName() {
        List<Object[]>list= catTypeRepo.getCatTypeIdAndName();
        Map<Integer,String>map=new HashMap<>();
        for (Object[] ob : list) {
            map.put(
                    Integer.valueOf(ob[0].toString()),
                    ob[1].toString());
        }

        return map;

    }
}
