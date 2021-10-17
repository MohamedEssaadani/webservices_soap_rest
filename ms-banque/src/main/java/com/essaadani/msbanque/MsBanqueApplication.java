package com.essaadani.msbanque;

import com.essaadani.msbanque.dao.ClientRepository;
import com.essaadani.msbanque.dao.CompteRepository;
import com.essaadani.msbanque.entities.Client;
import com.essaadani.msbanque.entities.Compte;
import com.essaadani.msbanque.entities.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
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
            Client mohamed = new Client(null, "Essaadani Mohamed", null);
            clientRepository.save(mohamed);

            Client hicham = new Client(null, "Essaadani hicham", null);
            clientRepository.save(hicham);

            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, mohamed));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, mohamed));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, hicham));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, hicham));

            compteRepository.findAll()
                    .forEach(cpt -> {
                        System.out.println(cpt.toString());
                    });

            repositoryRestConfiguration.exposeIdsFor(Compte.class);
        };
    }
}
