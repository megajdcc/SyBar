package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JobTitle {
        
    private String jobName;
    private int id, positionId;
    public boolean registry,update,delete;
    private final Conection connection;
    
    public JobTitle(){
        connection = new Conection();
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

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
    
    
    
     /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean insertJob(){
       registry = false;
        
        String sql = "INSERT INTO job_tittle (name,work_position_id) "
                + "values('"+this.jobName+"',"+this.positionId+")";
        int result = connection.runUpdate(sql);
        if(result != 0){
 
            registry = true;
        }
        return registry;
    }
    
     /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean updateJob(){
         update = false;
        String sql = "UPDATE job_tittle set name = '"+this.jobName+"',work_position_id = "+this.positionId+" "
                + "where id = "+this.id+"";
        int result = connection.runUpdate(sql);
        if(result != 0){
            update = true;
        }
        return update;
    }
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean deleteJob(){
        delete = false;
        String sql = "DELETE from job_tittle where id ="+this.id+"";
        int result = connection.runUpdate(sql);
        if(result !=0){
            delete = true;
        }
        return delete;
    }   
    public String[][] resultList(){
       
           
            String sql = "select j.name as job, w.name as position from job_tittle as j "
                    + "join work_position as w on j.WORK_POSITION_ID = w.ID";

            ResultSet result = connection.runQuery(sql);

            if(result == null){
               String Error = "error";
               return null;
            }
            
            int i = 0;
            try {
                while(result.next()) i++;
                String[][] data = new String[i][2];
                i = 0;
                result.beforeFirst();
                while(result.next()){
                   data[i][0] = result.getString("job");
                   data[i][1] = result.getString("position");

                    i++;
                }
                return data;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    public boolean matchingModel(String job){
       
            boolean flag=false;
            String sql = "select j.id, j.name as job, w.name as position,w.id as positionId from job_tittle as j \n" +
"	join work_position as w on j.WORK_POSITION_ID = w.ID\n" +
"	where j.name = '"+job+"'";
           
            ResultSet result = connection.runQuery(sql);
             try {
              
                if(result!=null){
                    result.next();
                    setId(result.getInt("id"));
                    setJobName(result.getString("job"));
                    setPositionId(result.getInt("positionId"));
                    flag=true;
                }else{
                    flag=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return flag;
            
        }
    public String checkName(int jobId) {
        
        String name = "";
        String sql = "select name from job_tittle where id = "+jobId+"";
    
        ResultSet result = connection.runQuery(sql);
        
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
    public int checkId(String name){
        int idC = 0 ;
        
        String sql = "select id from job_tittle where name = '"+name+"'";
        ResultSet result = connection.runQuery(sql);
        
        if(result !=null){
            try {
                result.next();
                idC = result.getInt("id");
            } catch (SQLException ex) {
                Logger.getLogger(JobTitle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idC;
    }
    
}