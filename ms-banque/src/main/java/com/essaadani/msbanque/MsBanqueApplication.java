package com.essaadani.msbanque;

import com.essaadani.msbanque.repositories.ClientRepository;
import com.essaadani.msbanque.repositories.CompteRepository;
import com.essaadani.msbanque.entities.Client;
import com.essaadani.msbanque.entities.Compte;
import com.essaadani.msbanque.entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            ClientRepository clientRepository,
                            RepositoryRestConfiguration repositoryRestConfiguration){
        return args ->  {
            Client mohamed = clientRepository.save(new Client(null, "Essaadani Mohamed", null));

            Client hicham = clientRepository.save(new Client(null, "Essaadani hicham", null));

            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, mohamed));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, mohamed));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, hicham));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, hicham));

            compteRepository.findAll()
                    .forEach(cpt -> {
                        System.out.println(cpt.getSolde());
                    });

            repositoryRestConfiguration.exposeIdsFor(Compte.class);
        };
    }
}
