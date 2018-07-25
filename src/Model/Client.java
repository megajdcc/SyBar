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
public class Client extends Person{
    
    // Field of class
    
    private long id;
    private String email;
    private final Conection conexion;

    public Client(){
        conexion = new Conection();
    }

    @Override
    public long getId() {
        return id;
    }
    public long getIdperson(){
        return super.getId();
    }
    public void setIdclient(long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //Own methods of the class
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was execute succesfully or not.
     */
    public boolean insertarClient(){
        
        boolean register = false;
        
        String sql = "insert into person(name,last_name,phone,gender,typeperson) values"
                + "('"+this.getName()+"','"+this.getLastname()+"',"+this.getPhone()+",'"+this.getGender()+"',"
                + "'Client')";

        int result = conexion.runUpdate(sql);
        if(result > 0){
            
                String sql2;
     
                    sql2 = "insert into client(phone,email) values("+this.getPhone()+",'"+this.getEmail()+"')";

                System.out.println(sql2);
                int resultad = conexion.runUpdate(sql2);
                if(resultad > 0 ){
                    register = true;
                    System.out.println("exito");
                }
                
            }
        
        
        return register;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was execute succesfully or not.
     */
    public boolean updateClient(){
        update = false;
        boolean resultado = update();
        if(resultado){
                String sql = "UPDATE client set email = '"+this.email+"' where id = "+this.getId()+"";
                int result = conexion.runUpdate(sql);
                if(result != 0){
                update = true;
            }
        }
        return update;
    }
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.. 
     */
    @Override
    public boolean update(){
        update = false;
        String sql = "UPDATE person set name = '"+getName()+"', last_name = '"+getLastname()+"',"
                + "gender='"+getGender()+"', phone = "+this.getPhone()+""
                + " where id ="+getIdperson()+"";
        System.out.println(sql);
        int result = conexion.runUpdate(sql);
        if(result !=0){
            update = true;
        }
        return update;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was execute succesfully or not.
     */
    public boolean deleteClient(){
        delete = false;
        String sql = "DELETE from person where id ="+this.getIdperson()+"";
        int result = conexion.runUpdate(sql);
        if(result != 0){
            delete = true;
        }
        return delete;
    }   

    @Override
    public String[][] consultList(){
       

           
            String sentenciaSQL = "select p.phone,p.name,p.last_name from person as p \n" +
"join	client as c on p.PHONE = c.PHONE";

            ResultSet resultQuery = conexion.runQuery(sentenciaSQL);

            if(resultQuery == null){
               String Error = "error";
               return null;
            }
            
            int i = 0;
            try {
                while(resultQuery.next()) i++;
                String[][] datos = new String[i][3];
                i = 0;
                resultQuery.beforeFirst();
                while(resultQuery.next()){
                   datos[i][0] = resultQuery.getString("phone");
                   datos[i][1] = resultQuery.getString("name");
                   datos[i][2] = resultQuery.getString("last_name");
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
       
            boolean statusQuery=false;
            String sentenciaSQL = "select p.id as idperson, p.name, p.last_name, p.gender, c.id as idclient, c.phone, c.email from person as p\n" +
                                    "join	client as c on p.phone = c.PHONE\n" +
                                "where p.phone = "+phone+"";
           
            ResultSet resultQuery = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultQuery!=null){
                    resultQuery.next();
                    setIdclient(resultQuery.getLong("idclient"));
                    setName(resultQuery.getString("NAME"));
                    setLastname(resultQuery.getString("LAST_NAME"));
                    setPhone(resultQuery.getLong("PHONE"));
                    setGender(resultQuery.getString("GENDER").charAt(0));
                    super.setId(resultQuery.getLong("idperson"));
                    setEmail(resultQuery.getString("email"));
                    statusQuery=true;
                }else{
                    statusQuery=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusQuery;
            
        }
    
    public long captureid(Long phone){
        long idd = 0;
        String sql = "select id from client where phone = "+phone+"";
        ResultSet resultado = conexion.runQuery(sql);
        
        if(resultado!=null){
            try {
                resultado.next();
                idd = resultado.getLong("id");
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
          return idd;
    }
    
    public boolean captureClient(long id){
        boolean exits = false;
        
        String sql = "select c.id, p.phone, p.name,p.last_name from person as p \n" +
"join client as c on p.phone = c.PHONE\n" +
"join meeting as m on c.id = m.client_id \n" +
"where m.client_id = "+id+" and m.completedwork = 0";
        
      
        ResultSet result = conexion.runQuery(sql);
        if(result!=null){
            try {
                result.next();
                setId(result.getLong("id"));
                setPhone(result.getLong("phone"));   
                setName(result.getString("name"));
                setLastname(result.getString("last_name"));
                exits = true;
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return exits;
    }
    public boolean validatephone(long phone){
        boolean valider = false;
        
        String sql = "select * from client where phone = "+phone+"";
        ResultSet result = conexion.runQuery(sql);
        
        if(result != null){
            valider = true;
        }
        return valider;
    }
}
