package com.semana10.projetotutoria.controllers;

import com.semana10.projetotutoria.entities.MaterialEntity;
import com.semana10.projetotutoria.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class MaterialController {
    @Autowired
    MaterialService material;

    @GetMapping
    public List<MaterialEntity> get(){
        return material.getAll();
    }
    @GetMapping("/{id}")
    public Optional<MaterialEntity> getById(@PathVariable Long id){
        return material.getById(id);
    }

    @PostMapping
    public MaterialEntity post (@RequestBody MaterialEntity materialEntity){
        return material.post(materialEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return material.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestParam String descricao){
        return material.update(id, descricao);
    }


}


