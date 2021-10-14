/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Departamento;
import model.Distrito;
import model.Pais;
import model.Persona;
import model.Provincia;


/**
 *
 * @author taquire
 */
public interface ICRUD {
    //Metodo para mostra lista de empleados
    public List<Persona> mostrarPersonas() throws Exception;    
    public void nuevaPersona (Persona persona)throws Exception;
    public void modificarPersona (Persona persona) throws Exception;
    public void eliminarPersona (Persona persona) throws Exception;
    
           
    //metodos para llenar dinamicamente los selectonemenus
    public List<Pais> listarPaises() throws Exception;
    public List<Departamento> listarDepartamentos(Persona persona) throws Exception;
    public List<Provincia> listarProvincias (Persona persona) throws Exception;
    public List<Distrito> listarDistritos(Persona persona) throws Exception;
    
}
