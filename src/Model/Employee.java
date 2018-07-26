package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Employee extends Person {
    
    // Fields of class
    
    private long id;
    private int jobId;
    
    private final Conection connection;
    private String position = null;

    public Employee(){
        connection = new Conection();
    }  
    //Methods of class

    public long getIdemployee() {
        return id;
    }

    public void setIdemployee(long identification) {
        this.id = identification;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int positionId) {
        this.jobId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean insertEmployee(){
        boolean register = false;
        
        String sql = "insert into person(name,last_name,phone,gender,typeperson) values("
                + "'"+this.getName()+"','"+this.getLastname()+"',"+this.getPhone()+",'"+this.getGender()+"','Employee')";
        
        int result = connection.runUpdate(sql);
        if(result != 0){
            
            String sql1 = "insert into employee(person_id,job_tittle_id) values((select max(id) from person),"+this.getJobId()+")";
           
            int result2 = connection.runUpdate(sql1);
            if(result2 > 0){
                register = true;
            }
        }
        return register;
    }
    @Override

    public boolean insert(){
        
        boolean flag = false;
        
        String sql = "insert into person(name,last_name,phone,gender,typeperson) values"
                + "('"+this.getName()+"','"+this.getLastname()+"',"+this.getPhone()+",'"+this.getGender()+"',"
                + "'"+this.getTypeperson()+"')";
      
        int result = connection.runUpdate(sql);
        if(result > 0){
            String sql1 = "select max(id) as id from person";
            ResultSet result2 = connection.runQuery(sql1);
            if(result2 !=null){
                long ultimateId = 0;
                try {
                	
                    result2.next();
                    ultimateId = result2.getLong("id");
                } catch (SQLException ex) {
                    Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                }
                String sql2;
                if(this.jobId == 0) {
                    sql2 = "insert into employee(person_id) values("+ultimateId+")";
                }else{
                    sql2 = "insert into employee(person_id, job_tittle_id) values("+ultimateId+","+this.jobId+")"; 
                }
             
                int resultad = connection.runUpdate(sql2);
                if(resultad > 0 ){
                    flag = true;
                    System.out.println("insert is success");
                }
            }
        }
        
        return flag;
    }
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean updateEmployee(){
        boolean flag = false;

        String sql = "UPDATE person set name = '"+this.getName()+"', last_name= '"+this.getLastname()+"', phone= "+this.getPhone()+""
                + ",gender = '"+this.getGender()+"' where id = "+this.getId()+"";       
        int result = connection.runUpdate(sql);
        if(result != 0){
            String sql2 = "UPDATE employee set job_tittle_id = "+this.getJobId()+" where person_id = "+this.getId()+"";
           
            int resultad = connection.runUpdate(sql2);
            if(resultad > 0 ){
                flag = true;
            }
           
        }
        return flag;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean deleteEmployee(){
        boolean flag = false;
        
        String sql = "DELETE from Employee where id = "+this.id+"";
        int result = connection.runUpdate(sql);
        
        if(result != 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public String[][] resultList(){
 
    	   String sql = "select emp.id as idemployee, p.phone, p.name,p.last_name from person as p\n" +
                                  "join employee as emp on p.id = emp.PERSON_ID";

            ResultSet result = connection.runQuery(sql);

            if(result == null){

               return null;
            }
            
            int i = 0;
            try {
                
                while(result.next()) i++;
                String[][] data = new String[i][3];
                i = 0;
                result.beforeFirst();
                while(result.next()){
                   data[i][0] = result.getString("phone");
                   data[i][1] = result.getString("name");
                   data[i][2] = result.getString("last_name");
                   

                    i++;
                }
                
                return data;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }


    @Override
    public boolean matchingModel(long phoneIdent){
       
            boolean flag = false;
            String sql = "select p.id as idperson,p.name,p.last_name,emp.id as idemployee, p.phone, p.gender, emp.job_tittle_id "
                    + "as jobId\n" +
"from person as p\n" +
"join employee as emp on p.id = emp.PERSON_ID\n" +
"where p.phone = "+phoneIdent+"";

            ResultSet result = connection.runQuery(sql);
             try {
              
                if(result!=null){
                    result.next();
                    this.setIdemployee(result.getLong("idemployee"));
                    setId(result.getLong("idperson"));
                    setName(result.getString("name"));
                    setLastname(result.getString("last_name"));
                    setPhone(result.getLong("phone"));
                    setJobId(result.getInt("jobId"));
                    setGender(result.getString("gender").charAt(0));

                    flag=true;
                }else{
                    flag=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return flag;
            
        }
    
    public boolean consultModel(long nident, String opc){
        
        boolean statusConsult=false;
        String sentenciaSQL = "select p.id as idperson,p.name,p.last_name,emp.id as idemployee, p.phone, p.gender, emp.job_tittle_id "
                + "as idjob\n" +
"from person as p\n" +
"join employee as emp on p.id = emp.PERSON_ID\n" +
"where emp.id = "+nident+"";

        ResultSet resultConsult = connection.runQuery(sentenciaSQL);
         try {
          
            if(resultConsult!=null){
                resultConsult.next();
                this.setIdemployee(resultConsult.getLong("idemployee"));
                setId(resultConsult.getLong("idperson"));
                setName(resultConsult.getString("name"));
                setLastname(resultConsult.getString("last_name"));
                setPhone(resultConsult.getLong("phone"));
                setJobId(resultConsult.getInt("idjob"));
                setGender(resultConsult.getString("gender").charAt(0));
////                setId(resultConsult.getLong("identification"));
//                setIdjob(resultConsult.getInt("jobtitle"));
               
           
                statusConsult=true;
            }else{
                statusConsult=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return statusConsult;
        
    }

    public boolean verify(long phone){
         boolean flag = false;
         
         String sql = "select COUNT(PERSON_ID) as quantity from employee as emp join person as p on "
                 + " emp.person_id = p.id where p.phone = "+phone+"";

         ResultSet result = connection.runQuery(sql);
         if(result!=null){
        
             try {
                 result.next();
                 long count = result.getLong("quantity");
                 if(count > 0){
                     flag = true;
                 }
                } catch (SQLException ex) {
                 Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return flag;
        }
    public boolean captureemployee(Long phone){
        boolean enc = false;
        
        String sql = "select p.name, emp.id as idemployee from person as p "
                + "join employee as emp on p.id = emp.person_id "
                + "where p.phone = "+phone+"";
        System.out.println(sql);
        ResultSet result = connection.runQuery(sql);
        
        if(result != null){
            enc = true;
            try {
                result.next();
                setName(result.getString("name"));
                setIdemployee(result.getLong("idemployee"));
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        return enc;
    }

}
