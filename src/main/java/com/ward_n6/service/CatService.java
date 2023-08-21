package com.ward_n6.service;

import com.ward_n6.entity.pets.Cat;
import com.ward_n6.enums.PetsSex;
import com.ward_n6.enums.PetsType;
import com.ward_n6.repository.CatsCrud;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {

    @Resource
    private CatsCrud catsCrud;

    public CatService(CatsCrud catsCrud) {
        this.catsCrud = catsCrud;
    }


    public void addCat(PetsSex petsSex, PetsType petsType, Cat cat) {
        cat.setPetsType(petsType);
        cat.setPetsSex(petsSex);
        catsCrud.save(cat);
    }

    public Cat findCat(long id) {
        Optional<Cat> byId = catsCrud.findById(id);
        return byId.orElse(null);
    }

    public Cat deleteCat(long id) {
        Cat cat = findCat(id);
        if (cat != null) catsCrud.deleteById(id);
        return cat;
    }


    public List<Cat> allCats() {
        return catsCrud.findAll();
    }

    public Cat change(long id, PetsSex petsSex, PetsType petsType, Cat cat) {
        cat.setId(id);
        cat.setPetsSex(petsSex);
        cat.setPetsType(petsType);
        return catsCrud.save(cat);
    }
}

