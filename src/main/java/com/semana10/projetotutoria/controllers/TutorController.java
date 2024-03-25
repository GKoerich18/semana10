package com.semana10.projetotutoria.controllers;


import com.semana10.projetotutoria.entities.TutorEntity;
import com.semana10.projetotutoria.services.TutorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Data
@RestController
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    TutorService tutor;

    @GetMapping
    public List<TutorEntity> get(){
        return tutor.getAll();
    }
    @GetMapping("/{id}")
    public Optional<TutorEntity> getById(@PathVariable Long id){
        return tutor.getById(id);
    }

    @PostMapping
    public TutorEntity post (@RequestBody TutorEntity tutorEntity){
        return tutor.post(tutorEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return tutor.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestParam String nome, @RequestParam String especialidade){
        return tutor.update(id, nome, especialidade);
    }



}
