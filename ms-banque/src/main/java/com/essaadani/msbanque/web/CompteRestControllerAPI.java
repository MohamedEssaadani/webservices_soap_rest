package com.essaadani.msbanque.web;

import com.essaadani.msbanque.dao.CompteRepository;
import com.essaadani.msbanque.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/api/banque")
public class CompteRestControllerAPI {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/comptes")
    public List<Compte> getComptes(){
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte getCompteById(@PathVariable Long id){
        return compteRepository.findById(id).get();
    }

    @PostMapping("/comptes")
    public Compte save(@RequestBody  Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte update(@PathVariable Long id, Compte compte){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable Long id){
        compteRepository.deleteById(id);
    }
}
