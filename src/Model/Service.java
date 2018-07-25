/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author Jnatn'h
 */
public class Service {
    
    //Fiels of class
    
    private int id;
    private double price;
    private String service;
    public boolean registry,update,delete;
    private final Conection conection;
    

    public Service(){
        conection = new Conection();
        
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double montopagar) {
        this.price = montopagar;
    }

    public String getService() {
        return service;
    }
    
    
    public void setService(String servicio) {
        this.service = servicio;
    }

    public ArrayList getPrices() {
        return prices;
    }

    public void setPrices(ArrayList prices) {
        this.prices = prices;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean insertService() {
         registry = false;
        
        String sql = "INSERT INTO Service(price,name)"
                + "values("+this.price+",'"+this.service+"')";
        int result = conection.runUpdate(sql);
        
        if(result != 0){
            registry = true;
        }
        return registry;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean updateService() {
      update = false;
        String sql = "UPDATE service set price = "+this.price+",name = '"+this.service+"'"
                + " where id = "+this.id+"";
        int result = conection.runUpdate(sql);
        
        if(result != 0){
            update = true;
        }
        return update;
    }
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean deleteService() {
        delete = false;
        
        String sql = "DELETE from service where id = "+this.id+"";
        int result = conection.runUpdate(sql);
        
        if(result != 0){
            delete = true;
        }
        return delete;
    }
    public String[][] consultList(){
           
            String sentenciaSQL = "select name, price from service";

            ResultSet result = conection.runQuery(sentenciaSQL);

            if(result == null){
               return null;
            }
            
            int i = 0;
            try {
                while(result.next()) i++;
                String[][] datos = new String[i][2];
                i = 0;
                result.beforeFirst();
                while(result.next()){
                   datos[i][0] = result.getString("name");
                   datos[i][1] = result.getString("price");

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
            String sentenciaSQL = "select * from service where name = '"+name+"'";
           
            ResultSet result = conection.runQuery(sentenciaSQL);
             try {
              
                if(result!=null){
                    result.next();
                    setId(result.getInt("id"));
                    setService(result.getString("name"));
                    setPrice(result.getDouble("price"));
                    statusConsult=true;
                }else{
                    statusConsult=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsult;
            
        }
    public void listServices(JList lista){
      String query = "SELECT s.name from service as s";
      ResultSet consul  = conection.runQuery(query);
      if(consul != null){
        try {
         int i = 0 ;
          DefaultListModel milista = new DefaultListModel();
          
          while(consul.next()){              
               milista.addElement(consul.getString("name"));
          }
          lista.setCursor(new Cursor(Cursor.HAND_CURSOR));
          lista.setModel(milista);
        } catch (SQLException ex) {
          Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      }
    }
    public void capturePrice(ListModel<String> model) throws SQLException{
        
       int leng = model.getSize();
       
       prices = new ArrayList();
        for (int i = 0; i < leng; i++) {
            String sql = "select price from service where name = '"+ model.getElementAt(i) +"'";
            ResultSet result = conection.runQuery(sql);
            if(result!= null){
                result.next();
                prices.add(result.getDouble("price"));
            }
        }  
    }
    public String[][] consultServices(Long idmeeting){
       

           
            String sentenciaSQL = "select s.name,s.price from service as s \n" +
"	join meetserv as me on s.ID = me.ids\n" +
"	where me.idm = "+idmeeting+"";

            ResultSet resultQuery = conection.runQuery(sentenciaSQL);

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
                   datos[i][0] = resultQuery.getString("name");
                   datos[i][1] = resultQuery.getString("price");
              
                    i++;
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    private ArrayList prices;                
}
