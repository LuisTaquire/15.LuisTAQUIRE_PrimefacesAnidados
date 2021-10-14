package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Departamento;
import model.Distrito;
import model.Pais;
import model.Persona;
import model.Provincia;

/**
 *
 * @author taquire
 */
public class PersonaImpl implements ICRUD {

    @Override
    public List<Persona> mostrarPersonas() throws Exception {
        List<Persona> listarPersonas = new ArrayList<>();
        Persona tbper;
//        Pais pa = null;
//        Departamento dep = null;
//        Provincia pro = null;
//        Distrito dis = null;
        String sql = "SELECT e.IDPER,e.DNIPER ,e.NOMPER,e.APEPER ,e.DIRPER, e.CELPER ,e.IDPAI ,e.IDDEP ,e.IDPRO ,e.IDDIS , p.NOMPAI , d.NOMDEP ,pr.NOMPRO,di.NOMDIS \n"
                + "FROM PERSONA e\n"
                + "INNER JOIN PAIS p ON p.IDPAI = e.IDPAI\n"
                + "INNER JOIN DEPARTAMENTO d ON d.IDDEP = e.IDDEP\n"
                + "INNER JOIN PROVINCIA pr ON pr.IDPRO = e.IDPRO\n"
                + "INNER JOIN DISTRITO di ON di.IDDIS = e.IDDIS";

        try {
            Statement st = Conexion.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tbper = new Persona();
                tbper.setIDPER(rs.getInt("IDPER"));
                tbper.setDNIPER(rs.getInt("DNIPER"));
                tbper.setNOMPER(rs.getString("NOMPER"));
                tbper.setAPEPER(rs.getString("APEPER"));
                tbper.setDIRPER(rs.getString("DIRPER"));
                tbper.setCELPER(rs.getInt("CELPER"));
                tbper.setPNOMPAI(rs.getString("NOMPAI"));
                tbper.setPNOMDEP(rs.getString("NOMDEP"));
                tbper.setPNOMPRO(rs.getString("NOMPRO"));
                tbper.setPNOMDIS(rs.getString("NOMDIS"));
                
                tbper.setIDPAI(rs.getInt("IDPAI"));
//                pa.setIDPAI(rs.getInt("IDPAI"));
                tbper.setIDDEP(rs.getInt("IDDEP"));
//                 dep.setIDDEP(rs.getInt("IDDEP"));
                tbper.setIDPRO(rs.getInt("IDPRO"));
//                 pro.setIDPRO(rs.getInt("IDPRO"));
                tbper.setIDDIS(rs.getInt("IDDIS"));
//                 dis.setIDDIS(rs.getInt("IDDIS"));

                listarPersonas.add(tbper);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la listado Per Dao " + e.getMessage());
        } finally {
            Conexion.cerrarCnx();
        }
        return listarPersonas;
    }

    @Override
    public void nuevaPersona(Persona persona) throws Exception {
        String sql = "insert into PERSONA "
                + "(DNIPER,NOMPER,APEPER,DIRPER,CELPER,IDPAI,IDDEP,IDPRO,IDDIS) values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            
            ps.setInt(1, persona.getDNIPER());
            ps.setString(2, persona.getNOMPER());
            ps.setString(3, persona.getAPEPER());
            ps.setString(4, persona.getDIRPER());
            ps.setInt(5, persona.getCELPER());
            
            ps.setInt(6, persona.getIDPAI());
            ps.setInt(7, persona.getIDDEP());
            ps.setInt(8, persona.getIDPRO());
            ps.setInt(9, persona.getIDDIS());
           
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrar Persona Dao" + e.getMessage());
        } finally {
            Conexion.cerrarCnx();
        }
    }

    @Override
    public void modificarPersona(Persona persona) throws Exception {

        try {
            String sql = "update PERSONA set "
                    + "DNIPER=?, NOMPER=?, APEPER=?, DIRPER=?, CELPER=? , IDPAI=?, IDDEP=?, IDPRO=?, IDDIS=? where IDPER=? ";
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
                     
            ps.setInt(1, persona.getDNIPER());
            ps.setString(2, persona.getNOMPER());
            ps.setString(3, persona.getAPEPER());
            ps.setString(4, persona.getDIRPER());
            ps.setInt(5, persona.getCELPER());
            ps.setInt(6, persona.getIDPAI());
            ps.setInt(7, persona.getIDDEP());
            ps.setInt(8, persona.getIDPRO());
            ps.setInt(9, persona.getIDDIS());
            ps.setInt(10, persona.getIDPER());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en Modificar Persona Dao" + e.getMessage());
        } finally {
            Conexion.cerrarCnx();
        }
    }

    @Override
    public void eliminarPersona(Persona persona) throws Exception {
        try {
            String sql = "delete from PERSONA where IDPER=?";
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, persona.getIDPER());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            Conexion.cerrarCnx();
        }
    }

    @Override
    public List<Pais> listarPaises() throws Exception {
        List<Pais> listaPaises = new ArrayList<>();
        Pais ubi;
        String sql = "SELECT * FROM PAIS";

        try {
            Statement st = Conexion.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ubi = new Pais();
                ubi.setIDPAI(rs.getInt("IDPAI"));
                ubi.setNOMPAI(rs.getString("NOMPAI"));

                listaPaises.add(ubi);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la listado Pais Dao " + e.getMessage());
        } finally {

            Conexion.cerrarCnx();
        }

        return listaPaises;
    }

    @Override
    public List<Departamento> listarDepartamentos(Persona persona) {
        List<Departamento> listaDeptos = new ArrayList<>();
        Departamento ubi;   
        String sql = "SELECT * FROM DEPARTAMENTO WHERE IDPAI = '" + persona.getPais().getIDPAI() + "'";

        try {
            Statement st = Conexion.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ubi = new Departamento();
                ubi.setIDDEP(rs.getInt("IDDEP"));
                ubi.setNOMDEP(rs.getString("NOMDEP"));

                listaDeptos.add(ubi);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la listado Dep Dao " + e.getMessage());
        } finally {
            try {
                Conexion.cerrarCnx();
            } catch (Exception ex) {
                Logger.getLogger(PersonaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaDeptos;
    }

    @Override
    public List<Provincia> listarProvincias(Persona persona) {
        List<Provincia> listaProvincias = new ArrayList<>();
        Provincia ubi;
        Integer sql2 = persona.getDepartamento().getIDDEP();
        String sql = "SELECT * FROM PROVINCIA WHERE IDDEP = " + sql2;
        System.out.println(sql);

        try {
            Statement st = Conexion.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ubi = new Provincia();
                ubi.setIDPRO(rs.getInt("IDPRO"));
                ubi.setNOMPRO(rs.getString("NOMPRO"));

                listaProvincias.add(ubi);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la listado PRov Dao " + e.getMessage());
        } finally {
            try {
                Conexion.cerrarCnx();
            } catch (Exception ex) {
                Logger.getLogger(PersonaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProvincias;
    }

      @Override
    public List<Distrito> listarDistritos(Persona persona) {
        List<Distrito> listaDistritos = new ArrayList<>();
        Distrito ubi;
        Integer sql2 = persona.getProvincia().getIDPRO();
        String sql = "SELECT * FROM DISTRITO WHERE IDPRO = " + sql2;
        System.out.println(sql);

        try {
            Statement st = Conexion.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ubi = new Distrito();
                ubi.setIDDIS(rs.getInt("IDDIS"));
                ubi.setNOMDIS(rs.getString("NOMDIS"));

                listaDistritos.add(ubi);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la listado DIST Dao " + e.getMessage());
        } finally {
            try {
                Conexion.cerrarCnx();
            } catch (Exception ex) {
                Logger.getLogger(PersonaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaDistritos;
    }

}
