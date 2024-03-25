package com.semana10.projetotutoria.services;

import com.semana10.projetotutoria.entities.AgendaEntity;
import com.semana10.projetotutoria.entities.AlunoEntity;
import com.semana10.projetotutoria.entities.TutorEntity;
import com.semana10.projetotutoria.repository.AgendaRepository;
import com.semana10.projetotutoria.repository.AlunoRepository;
import com.semana10.projetotutoria.repository.TutorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@Data
public class AgendaService {
    @Autowired
    AgendaRepository agendaRepository;
    @Autowired
    AlunoEntity tutorEntity;
    @Autowired
    AlunoEntity alunoEntity;

    public List<AgendaEntity> getAll(){
        return agendaRepository.findAll();
    }
    public Optional<AgendaEntity> getById(Long id){
        return agendaRepository.findById(id);
    }

    public AgendaEntity post(AgendaEntity alunoEntity){
        return agendaRepository.save(alunoEntity);
    }

    public ResponseEntity delete(Long id){
        if (agendaRepository.existsById(id)){
            agendaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A agenda com o id:" + id + " não foi encontrado");
        }
    }

    public ResponseEntity update(Long id, String nome, TutorEntity tutorEntity, AlunoEntity alunoEntity, Date data, Enum status, String tema, String descricaoBreve){
        if(agendaRepository.existsById(id)){
            agendaRepository.updateAgenda(id, nome, tutorEntity, alunoEntity,data, status, tema, descricaoBreve);
            return ResponseEntity.ok(agendaRepository.findById(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A agenda com o id:" + id + " não foi encontrado");
        }
    }
}
