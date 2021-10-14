package controller;

import dao.ICRUD;
import dao.PersonaImpl;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import model.Departamento;
import model.Distrito;
import model.Persona;
import model.Provincia;
import model.Pais;


@Named(value = "personaC")
@SessionScoped
public class personaC implements Serializable{

    private List<Persona> listar;
    private Persona persona;
    
    private List<SelectItem> listPaises;
    private List<SelectItem> listDeptos;
    private List<SelectItem> listProvincias;
    private List<SelectItem> listDistritos;

    public personaC() {
        persona = new Persona();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListar() throws Exception {
        
        ICRUD eDao = new PersonaImpl();
        listar = eDao.mostrarPersonas();
        return listar;
    }

    public void preparNuevaPersona(ActionEvent actionEvent) {
        persona = new Persona();
    }

    public void nuevaPersona() throws Exception {

        persona.setIDPAI(persona.getPais().getIDPAI());
        persona.setIDDEP(persona.getDepartamento().getIDDEP());
        persona.setIDPRO(persona.getProvincia().getIDPRO());
        persona.setIDDIS(persona.getDistrito().getIDDIS());
        ICRUD eDao = new PersonaImpl();
        eDao.nuevaPersona(persona);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se guardó satisfactoriamente"));
    }

    public void modificarPersona() throws Exception {

        persona.setIDPAI(persona.getPais().getIDPAI());
        persona.setIDDEP(persona.getDepartamento().getIDDEP());
        persona.setIDPRO(persona.getProvincia().getIDPRO());
        persona.setIDDIS(persona.getDistrito().getIDDIS());

        ICRUD eDao = new PersonaImpl();
        eDao.modificarPersona(persona);
        persona = new Persona();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se actualizó satisfactoriamente"));
    }

    public void eliminarPersona() throws Exception {
        ICRUD eDao = new PersonaImpl();
        eDao.eliminarPersona(persona);
        persona = new Persona();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se eliminó satisfactoriamente"));
    }

    public List<SelectItem> getListPaises() throws Exception {
        this.listPaises = new ArrayList<SelectItem>();
        ICRUD eDao = new PersonaImpl();
        List<Pais> p = eDao.listarPaises();
        listPaises.clear();

        for (Pais pais : p) {
            SelectItem paisItem = new SelectItem(pais.getIDPAI(), pais.getNOMPAI());
            this.listPaises.add(paisItem);
        }

        return listPaises;
    }

    public List<SelectItem> getListDeptos() throws Exception {
        this.listDeptos = new ArrayList<SelectItem>();
        ICRUD eDao = new PersonaImpl();
        List<Departamento> d = eDao.listarDepartamentos(this.persona);
        listDeptos.clear();

        for (Departamento depto : d) {
            SelectItem departamentosItem = new SelectItem(depto.getIDDEP(), depto.getNOMDEP());
            this.listDeptos.add(departamentosItem);
        }
        return listDeptos;
    }

    public List<SelectItem> getListProvincias() throws Exception {
        this.listProvincias = new ArrayList<SelectItem>();
        ICRUD eDao = new PersonaImpl();
        List<Provincia> m = eDao.listarProvincias(this.persona);
        listProvincias.clear();

        for (Provincia mun : m) {
            SelectItem provinciasItem = new SelectItem(mun.getIDPRO(), mun.getNOMPRO());
            this.listProvincias.add(provinciasItem);
        }
        return listProvincias;
    }

    public List<SelectItem> getListDistritos() throws Exception {
        this.listDistritos = new ArrayList<SelectItem>();
        ICRUD eDao = new PersonaImpl();
        List<Distrito> m = eDao.listarDistritos(this.persona);
        listDistritos.clear();

        for (Distrito mun : m) {
            SelectItem distritosItem = new SelectItem(mun.getIDDIS(), mun.getNOMDIS());
            this.listDistritos.add(distritosItem);
        }
        return listDistritos;
    }

    public void cancelar() {
        persona = new Persona();
    }
    
    
}
