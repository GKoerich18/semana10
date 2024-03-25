package com.semana10.projetotutoria.services;

import com.semana10.projetotutoria.entities.TutorEntity;
import com.semana10.projetotutoria.repository.TutorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data

public class TutorService {

    @Autowired
    TutorRepository tutorRepository;

    public List<TutorEntity> getAll(){
        return tutorRepository.findAll();
    }
    public Optional<TutorEntity> getById(Long id){
        return tutorRepository.findById(id);
    }

    public TutorEntity post(TutorEntity tutorEntity){
        return tutorRepository.save(tutorEntity);
    }

    public ResponseEntity delete(Long id){
        if (tutorRepository.existsById(id)){
            tutorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O tutor com o id:" + id + " não foi encontrado");
        }
    }

    public ResponseEntity update(Long id, String nome, String especialidade){
        if(tutorRepository.existsById(id)){
            tutorRepository.updateTutor(id, nome, especialidade);
            return ResponseEntity.ok(tutorRepository.findById(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O tutor com o id:" + id + " não foi encontrado");
        }
    }
}
