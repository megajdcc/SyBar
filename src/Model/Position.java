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
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jnatn'h
 */
public class Position {
    
    //Fiels de class
    
    private int id;
    private String position;
    public boolean registry,update,delete;
    
    private final Conection conexion;
    
    public Position(){
        conexion = new Conection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    //Methods of my;
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean insertPosition(){
        registry = false;
        String sql = "INSERT INTO work_position (name) "
                + "values ('"+this.position+"')";
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
    public boolean updatePosition(){
        update = false;
         String sql = "UPDATE work_position set name = '"+this.position+"' where id = "+this.id+"";
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
    public boolean deletePosition(){
        delete = false;
         String sql = "DELETE from work_position where id = "+this.id+"";
        int result = conexion.runUpdate(sql);
        if(result != 0){
            delete = true;
        }
        return delete;
    }
    public String[][] consultList(){
       
            boolean statusConsulta = false;
           
            String sentenciaSQL = "select * from work_position";

            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);
            if(resultadoConsulta == null){
               return null;
            }
            int i = 0;
            try {
                while(resultadoConsulta.next()) i++;
                String[][] datos = new String[i][1];
                i = 0;
                resultadoConsulta.beforeFirst();
                while(resultadoConsulta.next()){
                   datos[i][0] = resultadoConsulta.getString("name");
                    i++;
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
    }
    public boolean consultModel(String name){
       
            boolean statusConsulta=false;
            String sentenciaSQL = "select * from work_position where name = '"+name+"'";
            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultadoConsulta!=null){
                    resultadoConsulta.next();
                    setPosition(resultadoConsulta.getString("name"));
                    setId(resultadoConsulta.getInt("id"));
                    
                    statusConsulta=true;
                }else{
                    statusConsulta=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsulta;
            
        }
    public boolean listPosition(DefaultComboBoxModel cb){
        boolean listado = false;
            String sql ="select * from work_position";
            ResultSet resultado = conexion.runQuery(sql);      
             if (resultado != null){		   
                try {
                    cb.addElement("Select");
                    while (resultado.next()) {
                        listado=true;
                        cb.addElement(resultado.getString("name"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        return listado;
    }
    public void capturarName(int id){
        String sql = "select name from work_position where id = "+id+"";
        ResultSet result = conexion.runQuery(sql);
        if(result!=null){
            try {
                result.next();
                setPosition(result.getString("name"));
            } catch (SQLException ex) {
                Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
                
        }
    }
    public int captureId(String name){
        int idd = 0;
        String sql = "SELECT id from work_position where name = '"+name+"'";
      
        ResultSet result = conexion.runQuery(sql);
        if(result!=null){
            try {
                result.next();
                idd= result.getInt("id");
            } catch (SQLException ex) {
                Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idd;
    }
}
