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
public class Departamento {

    private Integer IDDEP;
    private String NOMDEP;
    private Integer IDPAI;
    
    private Set<Persona> personas = new HashSet<Persona>(0);
     private Set<Provincia> provincias = new HashSet<Provincia>(0);

    public Departamento() {
    }
    //SETTS GETS

    public Integer getIDDEP() {
        return IDDEP;
    }

    public void setIDDEP(Integer IDDEP) {
        this.IDDEP = IDDEP;
    }

    public String getNOMDEP() {
        return NOMDEP;
    }

    public void setNOMDEP(String NOMDEP) {
        this.NOMDEP = NOMDEP;
    }

    public Integer getIDPAI() {
        return IDPAI;
    }

    public void setIDPAI(Integer IDPAI) {
        this.IDPAI = IDPAI;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }

    public Set<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(Set<Provincia> provincias) {
        this.provincias = provincias;
    }
    
    
}
