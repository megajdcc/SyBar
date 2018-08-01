
package Model;

import java.sql.Connection; // interface 
import java.sql.DriverManager;// class
import java.sql.ResultSet; // interface 
import java.sql.SQLException; // exception
import java.sql.SQLTimeoutException;
import java.sql.Statement; // statemment sql prepare.
import java.util.logging.Level;
import java.util.logging.Logger; // axis de conect optional ofr necesary 
import javax.swing.JOptionPane; // frame Object Dialog 

public class Conection {
    private String user, driver, driverUrl,key;
    private int tempId;
    private boolean cClose;
    private Connection con = null; 


    /*
     * @description Constructor of the class not parameter .... 
     */
    public Conection(){
    	
        this.Conf_database(); // conf of database //
        this.connect();
        
    };

//  Methods Setter y Getters ... 
    public void setIdtemporal(int tempId){
        this.tempId = tempId;
    }
    public int getIdtemporal(){
        return this.tempId;
    }
    public Connection getConec(){
        return con;
    }
    
    /*
     * 
     */
    private void Conf_database() {
        this.driver = "com.mysql.jdbc.Driver";
        // url of bd driver jdbc mysql... 
        this.driverUrl = "jdbc:mysql://localhost:3306/barber2?"
        		+ "useUnicode=true"
        		+ "&useJDBCCompliantTimezoneShift=true&"
        		+ "useLegacyDatetimeCode=false&"
        		+ "serverTimezone=UTC&"
        		+ "character_set_server=ISO8859_8&"
        		+ "characterEncoding=UTF-8";
        this.user = "megajdcc";
        this.key = "20464273jd";
    }
    /**
     * 
     * @return a connection to the database
     */
    private Connection connect(){
        try {

           con = DriverManager.getConnection( driverUrl, user, key);
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
         
        }
        return con;
    } 
   
    public int runUpdate(String sql) {
        Statement sen;
        int a ;
        try {

            sen = con.createStatement(); // prepare connection for sentence . 
            a = sen.executeUpdate(sql); // execute sentence. except sentence of consult SELect
            return a;
        } catch (SQLException e) {
            System.out.println("error on sentence: "+e.getMessage());
            return 0;
        }
    }
    public ResultSet runQuery(String sql) {
        Statement sen;
        ResultSet rs;
        try {
            sen = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = sen.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                return rs;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }


}
