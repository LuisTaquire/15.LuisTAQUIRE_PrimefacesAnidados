/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author taquire
 */
public class Persona {

    private Integer IDPER;
    private Integer DNIPER;
    private String NOMPER;
    private String APEPER;
    private String DIRPER;
    private Integer CELPER;
    private Integer IDPAI;
    private Integer IDDEP;
    private Integer IDPRO;
    private Integer IDDIS;
    
    private Pais pais;
    private Departamento departamento;
    private Provincia provincia;
    private Distrito distrito;
    
    //JOIN
    private String PNOMPAI;
    private String PNOMDEP;
    private String PNOMPRO;
    private String PNOMDIS;
    
    
    
     public Persona() { 
        pais = new Pais();
        departamento= new Departamento();
        provincia= new Provincia();
        distrito= new Distrito();
    }
     
    //GETS SETS

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    
    public Integer getIDPER() {
        return IDPER;
    }

    public void setIDPER(Integer IDPER) {
        this.IDPER = IDPER;
    }

    public Integer getDNIPER() {
        return DNIPER;
    }

    public void setDNIPER(Integer DNIPER) {
        this.DNIPER = DNIPER;
    }

    public String getNOMPER() {
        return NOMPER;
    }

    public void setNOMPER(String NOMPER) {
        this.NOMPER = NOMPER;
    }

    public String getAPEPER() {
        return APEPER;
    }

    public void setAPEPER(String APEPER) {
        this.APEPER = APEPER;
    }

    public String getDIRPER() {
        return DIRPER;
    }

    public void setDIRPER(String DIRPER) {
        this.DIRPER = DIRPER;
    }

    public Integer getCELPER() {
        return CELPER;
    }

    public void setCELPER(Integer CELPER) {
        this.CELPER = CELPER;
    }

    public Integer getIDPAI() {
        return IDPAI;
    }

    public void setIDPAI(Integer IDPAI) {
        this.IDPAI = IDPAI;
    }

    public Integer getIDDEP() {
        return IDDEP;
    }

    public void setIDDEP(Integer IDDEP) {
        this.IDDEP = IDDEP;
    }

    public Integer getIDPRO() {
        return IDPRO;
    }

    public void setIDPRO(Integer IDPRO) {
        this.IDPRO = IDPRO;
    }

    public Integer getIDDIS() {
        return IDDIS;
    }

    public void setIDDIS(Integer IDDIS) {
        this.IDDIS = IDDIS;
    }

    public String getPNOMPAI() {
        return PNOMPAI;
    }

    public void setPNOMPAI(String PNOMPAI) {
        this.PNOMPAI = PNOMPAI;
    }

    public String getPNOMDEP() {
        return PNOMDEP;
    }

    public void setPNOMDEP(String PNOMDEP) {
        this.PNOMDEP = PNOMDEP;
    }

    public String getPNOMPRO() {
        return PNOMPRO;
    }

    public void setPNOMPRO(String PNOMPRO) {
        this.PNOMPRO = PNOMPRO;
    }

    public String getPNOMDIS() {
        return PNOMDIS;
    }

    public void setPNOMDIS(String PNOMDIS) {
        this.PNOMDIS = PNOMDIS;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
}
