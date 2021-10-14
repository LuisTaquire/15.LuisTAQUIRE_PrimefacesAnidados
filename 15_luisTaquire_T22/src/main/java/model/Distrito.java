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
public class Distrito {

    private Integer IDDIS;
    private String NOMDIS;
    private Integer IDPRO;
    
    private Set<Persona> personas = new HashSet<Persona>(0);
    //SETS GETS

    public Integer getIDDIS() {
        return IDDIS;
    }

    public void setIDDIS(Integer IDDIS) {
        this.IDDIS = IDDIS;
    }

    public String getNOMDIS() {
        return NOMDIS;
    }

    public void setNOMDIS(String NOMDIS) {
        this.NOMDIS = NOMDIS;
    }

    public Integer getIDPRO() {
        return IDPRO;
    }

    public void setIDPRO(Integer IDPRO) {
        this.IDPRO = IDPRO;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }
    
}
