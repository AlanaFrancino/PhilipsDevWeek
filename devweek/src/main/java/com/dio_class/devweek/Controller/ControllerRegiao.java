package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.Regiao;
import com.dio_class.devweek.Repo.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ControllerRegiao {

    private final RegiaoRepo repository;

    public ControllerRegiao(RegiaoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/regiao")
    public List<Regiao> getRegiao(){
        return repository.findAll();

    }

    @GetMapping("/regiao/{id}")
    public ResponseEntity<Regiao> findRegioesById(@PathVariable Long id){
        Optional<Regiao> regiaoOptional = repository.findById(id);
        if (regiaoOptional.isPresent()){
            Regiao regiaoUnid = regiaoOptional.get();
            return new ResponseEntity<>(regiaoUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo/")
    public Regiao putRegiao(@RequestBody  Regiao newRegiao){
       return repository.save(newRegiao);

    }

    public void deleteRegiao(@PathVariable Long id){
        repository.deleteById(id);
    }

}
