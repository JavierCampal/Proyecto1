package com.example.demo.controllers;

import com.example.demo.repositories.AlumnadoRepository;
import java.util.List;
import models.Alumnado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/alumnado")
public class AlumnadoController {
    @Autowired
    private AlumnadoRepository repositorio;
    
    @GetMapping()
    public List<Alumnado> list(){
        return repositorio.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Alumnado> get(@PathVariable Long id){
        if(repositorio.existsById(id)){
            return new ResponseEntity<Alumnado>(repositorio.findById(id).get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/suspensos/{modulo}")
    public List<Alumnado> getSuspensos(@PathVariable String modulo){
        if(modulo.equalsIgnoreCase("di")){
            return repositorio.getAlumnosSuspensosDI();
        } else if(modulo.equalsIgnoreCase("da")){
            return repositorio.getAlumnosSuspensosAD();
        }
        
        return List.of();
    }
}
