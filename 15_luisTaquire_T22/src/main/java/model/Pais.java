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
public class Pais {

    private Integer IDPAI;
    private String NOMPAI;
    
     private Set<Persona> personas = new HashSet<Persona>(0);
     private Set<Departamento> departamentos = new HashSet<Departamento>(0);
     
     public Pais() {
    }

	
    public Pais(String NOMPAI) {
        this.NOMPAI = NOMPAI;
    }
    
    //SETTS GETS

    
    public Integer getIDPAI() {
        return IDPAI;
    }

    public void setIDPAI(Integer IDPAI) {
        this.IDPAI = IDPAI;
    }

    public String getNOMPAI() {
        return NOMPAI;
    }

    public void setNOMPAI(String NOMPAI) {
        this.NOMPAI = NOMPAI;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }

    public Set<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Set<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    
}
