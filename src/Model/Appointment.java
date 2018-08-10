/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Jnatn'h
 */
public class Appointment {
    
    //Class Field 
    
    private int id,iduser,idclient,cut,idemployee;
    private Date date;
    private Time time;
    
    public boolean registry,delete,update;
    
    private Conection conexion;
    
    public Appointment(){
       conexion = Conection.Conec(); 
    }
    /**
     * 
     * @param datos an object of type ArrayList with the necessary data to use within the class 
     * @param opc An objecto of the type string to indicate that it can be donde with the data entered in the previous parameter
     */
    public Appointment(ArrayList datos, String opc){
        
        conexion = new Conection();
        
        setId((Integer)datos.get(0));
        setIduser((Integer)datos.get(1));
        setIdclient((Integer)datos.get(2));
        setHaircut((Integer)datos.get(3));
        setDate((Date)datos.get(4));
        setTime((Time)datos.get(5));
        setIdemployee((Integer)datos.get(6));
        switch (opc){
            case "Insertar":
                registry = this.insertCite();
                break;
            case "Update":
                update = this.updateCite();
                break;
            case "Delete":
                delete = this.deleteCite();
                break;
            default:
                break;
        }
    }

    public int getIdemployee() {
        return idemployee;
    }
    private void setIdemployee(int idemployee) {
        this.idemployee = idemployee;
    }   
    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }
    public int getIduser() {
        return iduser;
    }
    private void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public int getIdclient() {
        return idclient;
    }
    private void setIdclient(int idclient){
        this.idclient = idclient;
    }
    public int getHaircut() {
        return cut;
    }
    private void setHaircut(int cut) {
        this.cut = cut;
    }
    public Date getDate() {
        return date;
    }
    private void setDate(Date date) {
        this.date = date;
    }
    public Time getTime() {
        return time;
    }
    private void setTime(Time time) {
        this.time = time;
    }  
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    private boolean insertCite() {
         registry = false;
        
        String sql = "INSERT INTO Cita(id,fecha,hora,iduser,idclient,cut,atencionemployee)"
                + "values("+this.id+",'"+this.date+"','"+this.time+"',"+this.iduser+","+this.idclient+","+this.cut+","
                + ""+this.idemployee+")";
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
    private boolean updateCite() {
        update = false;
        String sql = "UPDATE Cita set fecha = '"+this.date+", time ='"+this.time+"' where id ="+this.id+"";
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
    private boolean deleteCite() {
      delete = false;
        
        String sql = "DELETE Cita where id = "+this.id+"";
        int result = conexion.runUpdate(sql);
        
        if(result != 0){
            delete = true;
        }
        return delete;
    }
    
    
}
