
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class User extends Employee{
    
    //Field of class
    
    private long id;
    private long identificationEmployee;
    private String user;
    private String password;
    private Conection connection;
    
    public User(){
        connection = new Conection();
    }

    @Override
    public long getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIdentificationEmployee() {
        return identificationEmployee;
    }

    public void setIdentificationEmployee(long identificationEmployee) {
        this.identificationEmployee = identificationEmployee;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //Methods of class
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean insertUser(){
        registry = false;
        
        String sql = "INSERT INTO user(name,password,employee_id)"
                + "values ('"+this.user+"','"+this.password+"',"+this.identificationEmployee+")";
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
    public boolean updateUser(){
            update = false;
        
        String sql = "UPDATE user set name ='"+this.user+"', password= '"+this.password+"'"
                + "where id = "+this.id+" AND employee_id= "+this.identificationEmployee+"";
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
    public boolean deleteUser(){
        delete = false;
        
        String sql = "DELETE from user where id = "+this.id+" and name = '"+this.user+"'";
        int result = connection.runUpdate(sql);
        
        if(result != 0){
            delete = true;
        }
        return delete;
    }

    
    public boolean validateUser(){
        boolean flag = false;
        String sql = "select us.id as iduser, us.name as user, emp.PERSON_ID as id \n" +
"	from user as us join employee as emp on(us.EMPLOYEE_ID = emp.ID)\n" +
"	where us.name = '"+this.getUser()+"' and us.PASSWORD = '"+this.getPassword()+"'";

       
        ResultSet result = connection.runQuery(sql);
         try {
            if(result !=null){
              result.next();
                if(result.getInt("iduser") != 0){
                                 
                    flag =true;
                    setId(result.getInt("iduser"));
                    setUser(result.getString("user"));
                    super.setId(result.getLong("id"));
                   
                }  
            }
             
            } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());
                
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
    return flag;
}


    @Override
    public String[][] resultList(){
       
            boolean flag = false;
           
            String sql = "select p.phone,p.name,us.name as users from person as p\n" +
"join employee as emp on p.id = emp.PERSON_ID\n" +
"join user as us on emp.id = us.EMPLOYEE_ID";

            ResultSet result = connection.runQuery(sql);
            System.out.println(result);
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
                   data[i][2] = result.getString("users");
                    i++;
                }
                return data;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    @Override
    public boolean matchingModel(long phone){
       
            boolean flag=false;
            String sql = "select p.id as idperson,p.name,p.LAST_NAME,us.name as user,us.ID, us.password, emp.id as idemployee\n" +
"from person as p \n" +
"JOIN employee as emp on p.id = emp.PERSON_ID\n" +
"JOIN user as us on emp.id= us.EMPLOYEE_ID\n" +
"where p.phone = "+phone+"";
            ResultSet result = connection.runQuery(sql);
             try {
              
                if(result!=null){
                    result.next();
                    super.setId(result.getLong("idperson"));
                    super.setName(result.getString("name"));
                    super.setLastname(result.getString("last_name"));
                    this.setIdentificationEmployee(result.getLong("idemployee"));
                    setUser(result.getString("user"));
                    setId(result.getInt("id"));
                    setPassword(result.getString("password"));
                    
                    flag=true;
                }else{
                    flag=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return flag;
            
        }

    public boolean capturePosition(){
        boolean exist = false;
        
        String sql = "select job.name from job_tittle as job \n" +
"join employee as emp on job.id = emp.job_tittle_id\n" +
"join user as u on emp.ID = u.EMPLOYEE_ID\n" +
"where u.ID = "+this.getId()+"";
        System.out.println(sql);
        ResultSet result = connection.runQuery(sql);
        if(result != null){
            try {
                exist = true;
                result.next();
                this.setPosition(result.getString("name"));
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exist;
    }
}
