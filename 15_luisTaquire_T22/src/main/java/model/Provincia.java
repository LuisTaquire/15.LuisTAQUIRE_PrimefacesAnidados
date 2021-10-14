/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author taquire
 */
public class Provincia {

    private Integer IDPRO;
    private String NOMPRO;
    private Integer IDDEP;
    
      
     private Set<Persona> personas = new HashSet<Persona>(0);
     private Set<Distrito> distritos = new HashSet<Distrito>(0);
     
    //SETTS GETS

    public Integer getIDPRO() {
        return IDPRO;
    }

    public void setIDPRO(Integer IDPRO) {
        this.IDPRO = IDPRO;
    }

    public String getNOMPRO() {
        return NOMPRO;
    }

    public void setNOMPRO(String NOMPRO) {
        this.NOMPRO = NOMPRO;
    }

    public Integer getIDDEP() {
        return IDDEP;
    }

    public void setIDDEP(Integer IDDEP) {
        this.IDDEP = IDDEP;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }

    public Set<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(Set<Distrito> distritos) {
        this.distritos = distritos;
    }
    
    
}
