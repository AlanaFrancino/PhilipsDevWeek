package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.Incidencia;
import com.dio_class.devweek.Entity.Incidencia;
import com.dio_class.devweek.Repo.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ControllerIncidencia {

    private final IncidenciaRepo Irepository;

    public ControllerIncidencia(IncidenciaRepo Irepository) {
        this.Irepository = Irepository;
    }

    @GetMapping("/incidencia")
    public List<Incidencia> getIncidencia(){
        return Irepository.findAll();

    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<Incidencia> findIncidenciaById(@PathVariable Long id){
        Optional<Incidencia> incidenciaOptional = Irepository.findById(id);
        if (incidenciaOptional.isPresent()){
            Incidencia regiaoUnid = incidenciaOptional.get();
            return new ResponseEntity<>(regiaoUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo/")
    public Incidencia putIncidencia(@RequestBody  Incidencia newIncidencia){
        return Irepository.save(newIncidencia);

    }

    public void deleteIncidencia(@PathVariable Long id){
        Irepository.deleteById(id);
    }

}
