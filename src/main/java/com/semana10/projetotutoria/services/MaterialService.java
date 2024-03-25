package com.semana10.projetotutoria.services;

import com.semana10.projetotutoria.entities.MaterialEntity;
import com.semana10.projetotutoria.repository.MaterialRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Data

public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    public List<MaterialEntity> getAll(){
        return materialRepository.findAll();
    }
    public Optional<MaterialEntity> getById(Long id){
        return materialRepository.findById(id);
    }

    public MaterialEntity post(MaterialEntity materialEntity){
        return materialRepository.save(materialEntity);
    }

    public ResponseEntity delete(Long id){
        if  (materialRepository.existsById(id)){
     materialRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O material com o id:" + id + " não foi encontrado");
        }
    }

    public ResponseEntity update(Long id, String nome){
        if (materialRepository.existsById(id)){
     materialRepository.updateMaterial(id, nome);
            return ResponseEntity.ok(materialRepository.findById(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O material com o id:" + id + " não foi encontrado");
        }
    }
}

