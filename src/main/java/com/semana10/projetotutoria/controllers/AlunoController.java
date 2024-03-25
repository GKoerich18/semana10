package com.semana10.projetotutoria.controllers;

import com.semana10.projetotutoria.entities.AlunoEntity;
import com.semana10.projetotutoria.repository.AlunoRepository;
import com.semana10.projetotutoria.services.AlunoService;
import jakarta.websocket.server.PathParam;
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
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunoService aluno;

    @GetMapping
    public List<AlunoEntity> get(){
        return aluno.getAll();
    }
    @GetMapping("/{id}")
    public Optional<AlunoEntity> getById(@PathVariable Long id){
        return aluno.getById(id);
    }

    @PostMapping
    public AlunoEntity post (@RequestBody AlunoEntity alunoEntity){
        return aluno.post(alunoEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return aluno.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestParam String nome){
        return aluno.update(id, nome);
    }


}
