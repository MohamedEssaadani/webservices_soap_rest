package com.essaadani.msbanque.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = Compte.class)
public interface CompteMobileProjection {
    public double getSolde();
    public TypeCompte getType();
}
