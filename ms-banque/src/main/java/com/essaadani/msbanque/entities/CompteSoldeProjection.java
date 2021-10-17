package com.essaadani.msbanque.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde", types = Compte.class)
public interface CompteSoldeProjection {
    public double getSolde();
}
