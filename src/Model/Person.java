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

/**
 *
 * @author Jnatn'h
 */
public class Person {
    
    
    //Fields of class
    private String name,lastname,typeperson;
    private long phone;
    private char gender;
    private long id = 0;
    public boolean registry,update,delete;
    private Conection conexion;
    private Employee employee;
    private Client client;
    public Person(){
        conexion = new Conection(); 
    }
    public Person(ArrayList datos,String opc){
        
        
        setId((Integer)datos.get(0));
        setName((String)datos.get(1));
        setLastname((String)datos.get(2));
        setPhone((long)datos.get(3));
        setGender((char)datos.get(4));
        
        
        switch (opc) {
            case "InsertPerson":
                registry = this.insert();
                break;
            case "UpdatePerson":
                update = this.update();
                break;
            case "DeletePerson":
                delete = this.delete();
                break;
            default:
                break;
        }
        
    }
    //Getters y setters
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    public String getTypeperson() {
        return typeperson;
    }

    public void setTypeperson(String typeperson) {
        this.typeperson = typeperson;
    }
    
    
    
    // Methods my of class
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean insert(){
        boolean insert = false;
        String sql = "INSERT into person(name,last_name,phone,gender,typeperson) values('"+this.name+"'"
                    + ",'"+this.lastname+"',"+this.phone+",'"+this.gender+"','"+this.typeperson+"')";
        int result = conexion.runUpdate(sql);
                    if(result == 1 ){
                     insert = true;
                    }
        return insert;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.. 
     */
    public boolean update(){
        update = false;
        String sql = "UPDATE person set name = '"+this.name+"', last_name = '"+this.lastname+"',"
                + "phone = "+this.phone+",gender='"+this.gender+"', typeperson = '"+this.typeperson+"'"
                + " where id="+this.id+"";
        int result = conexion.runUpdate(sql);
        if(result !=0){
            update = true;
        }
        return update;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean delete(){
        delete = false;
        String sql = "DELETE from person where id = "+this.id+"";
        int result = conexion.runUpdate(sql);
        if(result != 0){
            delete = true;
        }
        return delete;
    }
    private ArrayList consult(){
        ArrayList datos = null;
        ResultSet rs;
        String sql = "SELECT * FROM Persona";
        ResultSet consulta = conexion.runQuery(sql);
        if(consulta != null){
            try {
                consulta.next();
                setName(consulta.getNString("name"));
                setLastname(consulta.getNString("last_name"));
                setPhone(consulta.getLong("phone"));
                String genero = consulta.getString("gender");
                setTypeperson(consulta.getString("typeperson"));
                setGender(genero.charAt(0));
                setId(consulta.getInt("id"));
            } catch (SQLException ex) {
                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            datos = new ArrayList(3);
            datos.add(getName());
            datos.add(getLastname());
            datos.add(getPhone());
            datos.add(getGender());
            datos.add(getTypeperson());
            datos.add(getId());    
        }
        return datos;   
    }  
    public String[][] consultList(){
                 
            String sentenciaSQL = "select p.typeperson,p.name,p.last_name,p.phone from person as p";

            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);

            if(resultadoConsulta == null){
               return null;
            }
            
            int i = 0;
            try {
                while(resultadoConsulta.next()) i++;
                String[][] datos = new String[i][4];
                i = 0;
                resultadoConsulta.beforeFirst();
                while(resultadoConsulta.next()){
                   datos[i][0] = resultadoConsulta.getString("typeperson");
                   datos[i][1] = resultadoConsulta.getString("name");
                   datos[i][2] = resultadoConsulta.getString("last_name");
                   datos[i][3] = resultadoConsulta.getString("phone");
                    i++;
                }
                return datos;
            } catch (SQLException ex) {

                    return null;
            }
        }
    public boolean consultModel(long phone){
       
            boolean statusConsulta=false;
            String sentenciaSQL = "select * from person where phone = "+phone+"";
            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultadoConsulta!=null){
                    resultadoConsulta.next();
                    setName(resultadoConsulta.getString("NAME"));
                    setLastname(resultadoConsulta.getString("LAST_NAME"));
                    setId(resultadoConsulta.getLong("id"));
                    setPhone(resultadoConsulta.getLong("PHONE"));
                    setGender(resultadoConsulta.getString("GENDER").charAt(0));
                    setTypeperson(resultadoConsulta.getString("typeperson"));
                  
                    statusConsulta=true;
                }else{
                    statusConsulta=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsulta;
            
        }//fin de consult
    public boolean validatephone(){
        boolean exist = false;
        String sql = "select * from person where phone = "+this.phone+"";
        ResultSet result = conexion.runQuery(sql);
        if(result != null){
            exist = true;
        }
        return exist;
    }
}
