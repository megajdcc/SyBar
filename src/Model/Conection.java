/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
/**
 *
 * @author Jhonatan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conection {
    private String user, driver, driverUrl,key;
    private int idtemporary;
    private boolean closec;
    private Connection con = null;

    //Builders of the class connection
    public Conection(){
        this.Conf_database();
        this.connect();
        
    };
    public Conection(int idtemporary){
        this.idtemporary = idtemporary;
        try {
           this.usersesion();
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Conf_database();
        this.connect();
    }
//  Methodos Setter y Getters ... 
    public void setIdtemporal(int idtemporary){
        this.idtemporary = idtemporary;
    }
    public int getIdtemporal(){
        return this.idtemporary;
    }
    public Connection getConec(){
        return con;
    }
    private void Conf_database() {
        this.driver = "com.mysql.jdbc.Driver";
        this.driverUrl = "jdbc:mysql://localhost:3306/barberq?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
        int a;
        try {
            String sentenciaSql = "SELECT id_temporal()";
            this.usersesion();
            this.runQuery(sentenciaSql);
            sen = con.createStatement();
            a = sen.executeUpdate(sql);
            return a;
        } catch (SQLException e) {
            System.out.println("Error en Ejecutar actualización: "+e.getMessage());
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
    private void usersesion() throws SQLException{
        Statement sen;
        ResultSet rs;
        try
        {
            String sentenciaSQL = "SELECT table_temporal()";
            sen = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = sen.executeQuery(sentenciaSQL);
            if (rs.next()) {
                rs.beforeFirst();
            }else{
                System.out.println("Error! problem crating the temporary table");
            }
        } catch(SQLException ex)
        {
           // System.out.println("Error: "+ex.getMessage());
        }
    }
    public boolean verificar(String sql) {
        Statement sen;
        boolean exists;
        ResultSet rs;
        try {
            sen = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = sen.executeQuery(sql);
            if (rs.next()) {
                rs.beforeFirst();
                exists = true;
            } else {
                exists = false;
            }
        return exists;
        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
             return false;
        }
    }
    public void closec() {
      if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
    }
    private Connection getCon() {
        return con;
    }
    private void setConnectString(String driverUrl) {
        this.driverUrl = driverUrl;
    }
}
