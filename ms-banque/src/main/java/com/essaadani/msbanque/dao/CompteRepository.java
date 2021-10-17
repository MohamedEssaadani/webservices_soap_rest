package com.essaadani.msbanque.dao;

import com.essaadani.msbanque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
