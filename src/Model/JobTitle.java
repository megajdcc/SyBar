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
public class JobTitle {
    
    // Fields of class
    
    private String jobName;
    private int id, idposition;
    public boolean registry,update,delete;
    private final Conection conexion;
    
    public JobTitle(){
        conexion = new Conection();
    }
    
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdposition() {
        return idposition;
    }

    public void setIdposition(int idposition) {
        this.idposition = idposition;
    }
    
    
    //Methods of my
    
     /**
     * 
     * @return Returns a boolean to indicate that the statement was executed succesfully or not.
     */
    public boolean insertJob(){
       registry = false;
        
        String sql = "INSERT INTO job_tittle (name,work_position_id) "
                + "values('"+this.jobName+"',"+this.idposition+")";
        System.out.println(sql);
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
    public boolean updateJob(){
         update = false;
        String sql = "UPDATE job_tittle set name = '"+this.jobName+"',work_position_id = "+this.idposition+" "
                + "where id = "+this.id+"";
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
    public boolean deleteJob(){
        delete = false;
        String sql = "DELETE from job_tittle where id ="+this.id+"";
        int result = conexion.runUpdate(sql);
        if(result !=0){
            delete = true;
        }
        return delete;
    }   
    public String[][] consultList(){
       
           
            String sentenciaSQL = "select j.name as job, w.name as position from job_tittle as j "
                    + "join work_position as w on j.WORK_POSITION_ID = w.ID";

            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);

            if(resultadoConsulta == null){
               String Error = "error";
               return null;
            }
            
            int i = 0;
            try {
                while(resultadoConsulta.next()) i++;
                String[][] datos = new String[i][2];
                i = 0;
                resultadoConsulta.beforeFirst();
                while(resultadoConsulta.next()){
                   datos[i][0] = resultadoConsulta.getString("job");
                   datos[i][1] = resultadoConsulta.getString("position");

                    i++;
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    public boolean consultModel(String job){
       
            boolean statusConsulta=false;
            String sentenciaSQL = "select j.id, j.name as job, w.name as position,w.id as idposition from job_tittle as j \n" +
"	join work_position as w on j.WORK_POSITION_ID = w.ID\n" +
"	where j.name = '"+job+"'";
           
            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultadoConsulta!=null){
                    resultadoConsulta.next();
                    setId(resultadoConsulta.getInt("id"));
                    setJobName(resultadoConsulta.getString("job"));
                    setIdposition(resultadoConsulta.getInt("idposition"));
                    statusConsulta=true;
                }else{
                    statusConsulta=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsulta;
            
        }
    public String capturarName(int idjob) {
        
        String name = "";
        String sql = "select name from job_tittle where id = "+idjob+"";
    
        ResultSet result = conexion.runQuery(sql);
        
        if(result!=null){
            try {
                result.next();
                name = result.getString("name");
            } catch (SQLException ex) {
                Logger.getLogger(JobTitle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return name;     
    }
    public int capturarId(String name){
        int idd = 0 ;
        
        String sql = "select id from job_tittle where name = '"+name+"'";
        ResultSet resultado = conexion.runQuery(sql);
        
        if(resultado !=null){
            try {
                resultado.next();
                idd = resultado.getInt("id");
            } catch (SQLException ex) {
                Logger.getLogger(JobTitle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idd;
    }
    
}