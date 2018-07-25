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
public class Cut {
    
    //Fields of class
    
    private int id;
    private String Stile;
    private double price;
    private char gender;
    
    public boolean registry,delete,update;
    
    private final Conection conexion;
    
    
    /**
     *  
     */
    public Cut(){
        conexion = new Conection();
        
    }
    
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStile() {
        return Stile;
    }

    public void setStile(String Stile) {
        this.Stile = Stile;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getGender() {
        return gender;
    }

   public void setGender(char gender) {
        this.gender = gender;
    }
    
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean deleteCut() {
        delete = false;
        
        String sql = "DELETE from haircut_type where id = "+this.id+"";
        int result = conexion.runUpdate(sql);
        
        if(result != 0){
            delete = true;
        }
        return delete;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean updateCut() {
         update = false;
        String sql = "UPDATE haircut_type set style = '"+this.Stile+"',price = "+this.price+", gender = '"+this.gender+"' where id = "+this.id+"";
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
    public boolean insertCut() {
         registry = false;
        
        String sql = "INSERT INTO haircut_type(style,price,gender)"
                + "values('"+this.Stile+"',"+this.price+",'"+this.gender+"')";
        int result = conexion.runUpdate(sql);
        
        if(result != 0){
            registry = true;
        }
        return registry;
    }
    public String[][] consultList(){
       
            boolean statusConsulta = false;
           
            String sentenciaSQL = "select style,price,gender from haircut_type";

            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);

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
                   datos[i][0] = resultadoConsulta.getString("style");
                   datos[i][1] = resultadoConsulta.getString("price");
                   datos[i][2] = resultadoConsulta.getString("gender");

                    i++;
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    public boolean consultModel(String name){
       
            boolean statusConsult=false;
            String sentenciaSQL = "select * from haircut_type where style = '"+name+"'";
          
            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultadoConsulta!=null){
                    resultadoConsulta.next();
                    setId(resultadoConsulta.getInt("id"));
                    setStile(resultadoConsulta.getString("style"));
                    setPrice(resultadoConsulta.getDouble("price"));
                    String genderr = resultadoConsulta.getString("gender");
                    char gener = genderr.charAt(0);
                    setGender(gener);
                    statusConsult=true;
                }else{
                    statusConsult=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsult;
            
        }
    public boolean verifyStyle(String name){
         boolean validado = false;
            String sql = "select id from haircut_type where style = '"+name+"'";
            ResultSet resultado = conexion.runQuery(sql);
            
            if(resultado != null){
                validado = true;
            }
         return validado;
     }
    public double captureprice(){
        double pricee = 0;
        
        String sql = "select price from haircut_type where style = '"+this.Stile+"'";
        ResultSet result = conexion.runQuery(sql);
        
        if(result!=null){
            try {
                result.next();
                pricee = result.getFloat("price");
            } catch (SQLException ex) {
                Logger.getLogger(Cut.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pricee;
    }
    public boolean consultModel(long id ){
       
            boolean statusConsult=false;
            String sentenciaSQL = "select * from haircut_type where id= "+id+"";
          
            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultadoConsulta!=null){
                    resultadoConsulta.next();
                    setId(resultadoConsulta.getInt("id"));
                    setStile(resultadoConsulta.getString("style"));
                    setPrice(resultadoConsulta.getDouble("price"));
                    String genderr = resultadoConsulta.getString("gender");
                    char gener = genderr.charAt(0);
                    setGender(gener);
                    statusConsult=true;
                }else{
                    statusConsult=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsult;
            
        }
    public String[][] consultHaircut(Long idmeeting){
       

           
            String sentenciaSQL = "select h.style,h.price from haircut_type as h \n" +
"join meeting as m on h.ID =m.HAIRCUT\n" +
"	where m.ID = "+idmeeting+"";

            ResultSet resultQuery = conexion.runQuery(sentenciaSQL);

            if(resultQuery == null){
               String Error = "error";
               return null;
            }
            
            int i = 0;
            try {
                while(resultQuery.next()) i++;
                String[][] datos = new String[i][2];
                i = 0;
                resultQuery.beforeFirst();
                while(resultQuery.next()){
                   datos[i][0] = resultQuery.getString("style");
                   datos[i][1] = resultQuery.getString("price");
              
                    i++;
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
}
