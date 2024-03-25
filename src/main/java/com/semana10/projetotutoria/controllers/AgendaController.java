package com.semana10.projetotutoria.controllers;


import com.semana10.projetotutoria.entities.AgendaEntity;
import com.semana10.projetotutoria.entities.AlunoEntity;
import com.semana10.projetotutoria.entities.TutorEntity;
import com.semana10.projetotutoria.services.AgendaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@Data
@RestController
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    AgendaService agenda;

    @GetMapping
    public List<AgendaEntity> get(){
        return agenda.getAll();
    }
    @GetMapping("/{id}")
    public Optional<AgendaEntity> getById(@PathVariable Long id){
        return agenda.getById(id);
    }

    @PostMapping
    public AgendaEntity post (@RequestBody AgendaEntity agendaEntity){
        return agenda.post(agendaEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return agenda.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestParam String nome, @RequestParam TutorEntity tutorEntity, @RequestParam AlunoEntity alunoEntity, @RequestParam Date data, @RequestParam Enum status, @RequestParam String tema, @RequestParam String descricaoBreve){
        return agenda.update(id, nome, tutorEntity, alunoEntity,data, status, tema, descricaoBreve);
    }


}