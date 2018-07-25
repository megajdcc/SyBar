/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jnatn'h
 */
public class Employee extends Person {
    
    // Fields of class
    
    private long id;
    private int idjob;
    
    private final Conection conexion;
    private String position = null;

    public Employee(){
        conexion = new Conection();
    }  
    //Methods of class

    public long getIdemployee() {
        return id;
    }

    public void setIdemployee(long identification) {
        this.id = identification;
    }

    public int getIdjob() {
        return idjob;
    }

    public void setIdjob(int idposition) {
        this.idjob = idposition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
    //Methods of my 
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean insertEmployee(){
        boolean register = false;
        
        String sql = "insert into person(name,last_name,phone,gender,typeperson) values("
                + "'"+this.getName()+"','"+this.getLastname()+"',"+this.getPhone()+",'"+this.getGender()+"','Employee')";
        
        int result = conexion.runUpdate(sql);
        if(result != 0){
            
            String sql1 = "insert into employee(person_dni,job_tittle_id) values((select max(id) from person),"+this.getIdjob()+")";
           
            int resulta = conexion.runUpdate(sql1);
            if(resulta > 0){
                register = true;
            }
        }
        return register;
    }
    @Override

    public boolean insert(){
        
        boolean register = false;
        
        String sql = "insert into person(name,last_name,phone,gender,typeperson) values"
                + "('"+this.getName()+"','"+this.getLastname()+"',"+this.getPhone()+",'"+this.getGender()+"',"
                + "'"+this.getTypeperson()+"')";
      
        int result = conexion.runUpdate(sql);
        if(result > 0){
            String sql1 = "select max(id) as id from person";
            ResultSet resulta = conexion.runQuery(sql1);
            if(resulta !=null){
                long ultimatedid = 0;
                try {
                    resulta.next();
                    ultimatedid = resulta.getLong("id");
                } catch (SQLException ex) {
                    Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                }
                String sql2;
                if(this.idjob == 0) {
                    sql2 = "insert into employee(person_dni) values("+ultimatedid+")";
                }else{
                    sql2 = "insert into employee(person_dni, job_tittle_dni) values("+ultimatedid+","+this.idjob+")"; 
                }
             
                int resultad = conexion.runUpdate(sql2);
                if(resultad > 0 ){
                    register = true;
                    System.out.println("exito");
                }
                
            }
        }
        
        return register;
    }
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean updateEmployee(){
        update = false;

        String sql = "UPDATE person set name = '"+this.getName()+"', last_name= '"+this.getLastname()+"', phone= "+this.getPhone()+""
                + ",gender = '"+this.getGender()+"' where id = "+this.getId()+"";       
        int result = conexion.runUpdate(sql);
        if(result != 0){
            String sql2 = "UPDATE employee set job_tittle_id = "+this.getIdjob()+" where person_dni = "+this.getId()+"";
           
            int resultad = conexion.runUpdate(sql2);
            if(resultad > 0 ){
                update = true;
            }
           
        }
        return update;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean deleteEmployee(){
        delete = false;
        
        String sql = "DELETE from Employee where id = "+this.id+"";
        int result = conexion.runUpdate(sql);
        
        if(result != 0){
            delete = true;
        }
        return delete;
    }
    
    
    /**
     * 
     * @param mensaje El paramenter permite detectar el mensaje que se va a enviar al destinatario es de tipo String...
     * @param idcliente El parameter permite identificar a quien se le va a enviar el mensaje es de tipo Integer.
     * @return Devuelve un booleano indicando si se envio o no el mensaje... 
     */
    public boolean sendMessage(String mensaje,int idcliente){
        boolean enviado = false;
        
        
        return enviado;
    }
    
    @Override
    public String[][] consultList(){
       
        
            boolean statusConsult = false;
           
            String sentenciaSQL = "select emp.id as idemployee, p.phone, p.name,p.last_name from person as p\n" +
"join employee as emp on p.id = emp.PERSON_DNI";

            ResultSet resultConsult = conexion.runQuery(sentenciaSQL);

            if(resultConsult == null){

               return null;
            }
            
            int i = 0;
            try {
                
                while(resultConsult.next()) i++;
                String[][] datos = new String[i][3];
                i = 0;
                resultConsult.beforeFirst();
                while(resultConsult.next()){
                   datos[i][0] = resultConsult.getString("phone");
                   datos[i][1] = resultConsult.getString("name");
                   datos[i][2] = resultConsult.getString("last_name");
                   

                    i++;
                }
                
                return datos;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }

    /**
     *
     * @param nident
     * @return
     */
    @Override
    public boolean consultModel(long nident){
       
            boolean statusConsult=false;
            String sentenciaSQL = "select p.id as idperson,p.name,p.last_name,emp.id as idemployee, p.phone, p.gender, emp.job_tittle_id "
                    + "as idjob\n" +
"from person as p\n" +
"join employee as emp on p.id = emp.PERSON_DNI\n" +
"where p.phone = "+nident+"";

            ResultSet resultConsult = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultConsult!=null){
                    resultConsult.next();
                    this.setIdemployee(resultConsult.getLong("idemployee"));
                    setId(resultConsult.getLong("idperson"));
                    setName(resultConsult.getString("name"));
                    setLastname(resultConsult.getString("last_name"));
                    setPhone(resultConsult.getLong("phone"));
                    setIdjob(resultConsult.getInt("idjob"));
                    setGender(resultConsult.getString("gender").charAt(0));
////                    setId(resultConsult.getLong("identification"));
//                    setIdjob(resultConsult.getInt("jobtitle"));
                   
               
                    statusConsult=true;
                }else{
                    statusConsult=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsult;
            
        }
 public boolean consultModel(long nident, String opc){
       
            boolean statusConsult=false;
            String sentenciaSQL = "select p.id as idperson,p.name,p.last_name,emp.id as idemployee, p.phone, p.gender, emp.job_tittle_id "
                    + "as idjob\n" +
"from person as p\n" +
"join employee as emp on p.id = emp.PERSON_DNI\n" +
"where emp.id = "+nident+"";

            ResultSet resultConsult = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultConsult!=null){
                    resultConsult.next();
                    this.setIdemployee(resultConsult.getLong("idemployee"));
                    setId(resultConsult.getLong("idperson"));
                    setName(resultConsult.getString("name"));
                    setLastname(resultConsult.getString("last_name"));
                    setPhone(resultConsult.getLong("phone"));
                    setIdjob(resultConsult.getInt("idjob"));
                    setGender(resultConsult.getString("gender").charAt(0));
////                    setId(resultConsult.getLong("identification"));
//                    setIdjob(resultConsult.getInt("jobtitle"));
                   
               
                    statusConsult=true;
                }else{
                    statusConsult=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsult;
            
        }
    public boolean verify(long phonee){
         boolean yes = false;
         
         String sql = "select COUNT(PERSON_DNI) as cantidad from employee as emp join person as p on "
                 + " emp.person_dni = p.id where p.phone = "+phonee+"";

         ResultSet consult = conexion.runQuery(sql);
         if(consult!=null){
        
             try {
                 consult.next();
                 long cant = consult.getLong("cantidad");
                 if(cant > 0){
                     yes = true;
                 }
                } catch (SQLException ex) {
                 Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return yes;
        }
    public boolean captureemployee(Long phone){
        boolean enc = false;
        
        String sql = "select p.name, emp.id as idemployee from person as p "
                + "join employee as emp on p.id = emp.person_dni "
                + "where p.phone = "+phone+"";
        System.out.println(sql);
        ResultSet result = conexion.runQuery(sql);
        
        if(result != null){
            enc = true;
            try {
                result.next();
                setName(result.getString("name"));
                setIdemployee(result.getLong("idemployee"));
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        return enc;
    }
}
