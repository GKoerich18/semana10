package com.semana10.projetotutoria.services;

import com.semana10.projetotutoria.entities.AlunoEntity;
import com.semana10.projetotutoria.repository.AlunoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data

public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public List<AlunoEntity> getAll(){
        return alunoRepository.findAll();
    }
    public Optional<AlunoEntity> getById(Long id){
        return alunoRepository.findById(id);
    }

    public AlunoEntity post(AlunoEntity alunoEntity){
        return alunoRepository.save(alunoEntity);
    }

    public ResponseEntity delete(Long id){
        if (alunoRepository.existsById(id)){
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O aluno com o id:" + id + " não foi encontrado");
        }
    }

    public ResponseEntity update(Long id, String nome){
        if(alunoRepository.existsById(id)){
            alunoRepository.updateAluno(id, nome);
            return ResponseEntity.ok(alunoRepository.findById(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O aluno com o id:" + id + " não foi encontrado");
        }
    }
}
