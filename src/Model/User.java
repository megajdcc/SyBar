/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jnatn'h
 */
public class User extends Employee{
    
    //Field of class
    
    private long id;
    private long identificacionemployee;
    private String user;
    private String password;
//    public boolean registry,update,delete;
    private Conection conexion;
    
    public User(){
        conexion = new Conection();
    }
    
 
//    public User(ArrayList datos, String opc){
//        conexion = new Conection();
//        
//        setId((Integer)datos.get(0));
//        setIdentificationemployee((Integer)datos.get(1));
//        setUser((String)datos.get(2));
//        setPassword((String)datos.get(3));
//        
//        switch (opc){
//            case "Insertar":
//                registry = this.insertUser();
//                break;
//            case "Update":
//                update = this.updateUser();
//                break;
//            case "Delete":
//                delete = this.deleteUser();
//                break;
//            default:
//                break;
//        }
//    }

    @Override
    public long getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIdentificationemployee() {
        return identificacionemployee;
    }

    public void setIdentificationemployee(long identificacionemployee) {
        this.identificacionemployee = identificacionemployee;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //Methods of class
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean insertUser(){
        registry = false;
        
        String sql = "INSERT INTO user(name,password,employee_id)"
                + "values ('"+this.user+"','"+this.password+"',"+this.identificacionemployee+")";
        int result = conexion.runUpdate(sql);
        
        if(result != 0){
            registry = true;
        }
        return registry;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean updateUser(){
            update = false;
        
        String sql = "UPDATE user set name ='"+this.user+"', password= '"+this.password+"'"
                + "where id = "+this.id+" AND employee_id= "+this.identificacionemployee+"";
        int result = conexion.runUpdate(sql);
        
        if(result != 0){
            update = true;
        }
        return update;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean deleteUser(){
        delete = false;
        
        String sql = "DELETE from user where id = "+this.id+" and name = '"+this.user+"'";
        int result = conexion.runUpdate(sql);
        
        if(result != 0){
            delete = true;
        }
        return delete;
    }

    //Methods propios
    public boolean validateuser(){
        boolean verificado = false;
        String verificar = "select us.id as iduser, us.name as usuario, emp.PERSON_DNI as dni \n" +
"	from user as us join employee as emp on(us.EMPLOYEE_ID = emp.ID)\n" +
"	where us.name = '"+this.getUser()+"' and us.PASSWORD = '"+this.getPassword()+"'";

       
        ResultSet verificacion = conexion.runQuery(verificar);
         try {
            if(verificacion !=null){
              verificacion.next();
                if(verificacion.getInt("iduser") != 0){
                                 
                    verificado =true;
                    setId(verificacion.getInt("iduser"));
                    setUser(verificacion.getString("usuario"));
                    super.setId(verificacion.getLong("dni"));
                   
                }  
            }
             
            } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());
                
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
    return verificado;
}
    public int captureid() throws SQLException{
        this.id = 0;
        String consultaid = "SELECT ID  from user where name = '"+this.user+"'";
        ResultSet consulta = conexion.runQuery(consultaid);
        if (consulta.next()) 
        {
            int idusers  = consulta.getInt("id");
            if (idusers != 0) 
            {
                id = idusers;
            }
        }
        return (int) id;
    }
    public boolean captureuser(int id){
        boolean captura = false;
        String consultar = "select us.name as usuario,emp.person_dni as dni, job.name "
                + "from user as us JOIN employee as emp ON us.EMPLOYEE_ID = emp.N_ID"
                + "JOIN job_tittle as job ON emp.JOB_TITTLE_ID = job.ID "
                + "where us.ID ="+this.id+"";
        ResultSet consulta = conexion.runQuery(consultar);
        try {
            if (consulta!=null)
            {
                consulta.next();
                setUser(consulta.getString("usuario"));
                setId(consulta.getInt("dni"));
                setPosition(consulta.getString("carg"));
                captura = true;
            }else
            {
                captura = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return captura;
    }
    @Override
    public String[][] consultList(){
       
            boolean statusConsulta = false;
           
            String sentenciaSQL = "select p.phone,p.name,us.name as users from person as p\n" +
"join employee as emp on p.id = emp.PERSON_DNI\n" +
"join user as us on emp.id = us.EMPLOYEE_ID";

            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);
            System.out.println(resultadoConsulta);
            if(resultadoConsulta == null){
               return null;
            }
            int i = 0;
            try {
                while(resultadoConsulta.next()) i++;
                String[][] datos = new String[i][3];
                i = 0;
                resultadoConsulta.beforeFirst();
                while(resultadoConsulta.next()){
                   datos[i][0] = resultadoConsulta.getString("phone");
                   datos[i][1] = resultadoConsulta.getString("name");
                   datos[i][2] = resultadoConsulta.getString("users");
                    i++;
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    @Override
    public boolean consultModel(long phone){
       
            boolean statusConsulta=false;
            String sentenciaSQL = "select p.id as idperson,p.name,p.LAST_NAME,us.name as user,us.ID, us.password, emp.id as idemployee\n" +
"from person as p \n" +
"JOIN employee as emp on p.id = emp.PERSON_DNI\n" +
"JOIN user as us on emp.id= us.EMPLOYEE_ID\n" +
"where p.phone = "+phone+"";
            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultadoConsulta!=null){
                    resultadoConsulta.next();
                    super.setId(resultadoConsulta.getLong("idperson"));
                    super.setName(resultadoConsulta.getString("name"));
                    super.setLastname(resultadoConsulta.getString("last_name"));
                    this.setIdentificationemployee(resultadoConsulta.getLong("idemployee"));
                    setUser(resultadoConsulta.getString("user"));
                    setId(resultadoConsulta.getInt("id"));
                    setPassword(resultadoConsulta.getString("password"));
                    
                    statusConsulta=true;
                }else{
                    statusConsulta=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsulta;
            
        }
    public void conexionClosed(){
         conexion.closec();
     }
    public boolean capturecarg(){
        boolean exist = false;
        
        String sql = "select job.name from job_tittle as job \n" +
"join employee as emp on job.id = emp.job_tittle_id\n" +
"join user as u on emp.ID = u.EMPLOYEE_ID\n" +
"where u.ID = "+this.getId()+"";
        System.out.println(sql);
        ResultSet result = conexion.runQuery(sql);
        if(result != null){
            try {
                exist = true;
                result.next();
                this.setPosition(result.getString("name"));
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exist;
    }
}
