package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Employee extends Person {
    
    // Fields of class
    
    private long id;
    private int jobId;
    private ArrayList workday;
    private Conection connection;
    private String position = null;
    private String entrytime,departure;
 
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



    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
    
    public ArrayList getWorkday() {
        return workday;
    }

    public void setWorkday(ArrayList workday) {
        this.workday = workday;
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
            
            String sql1 = "insert into employee(person_id,job_tittle_id,entrytime,departuretime) values((select max(id) from person),"+this.getJobId()+","
                    + "'"+this.getEntrytime()+"','"+this.getDeparture()+"')";
           
            int result2 = connection.runUpdate(sql1);
            if(result2 > 0){
                register = true;
                 Iterator df = workday.iterator();
                while(df.hasNext()){
                    String sql4 = "select id from workdays where days = '"+df.next().toString()+"'";
            
                    ResultSet resul = connection.runQuery(sql4);
                    if(resul != null){
                        try {
                            resul.next();
                            int idwork = resul.getInt("id");
                            String sql5 = "INSERT INTO empwork(idemployee,idwork) values((select max(id) from employee),"+idwork+")";
                              
                            int res = connection.runUpdate(sql5);
                            if(res > 0){
                                register = true;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
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
     * @throws java.sql.SQLException
     */
    public boolean updateEmployee() throws SQLException{
         boolean flag = false;
      
     
            Connection conec = connection.getConec();

           
            String updateperson = "UPDATE person set name = ?, last_name= ?, phone= ? ,gender = ? where id = ? ";
            String updateemployee ="UPDATE employee set job_tittle_id = ? ,ENTRYTIME = ?, DEPARTURETIME = ? where person_id = ? ";
            String deleteupwork = "DELETE FROM empwork where  idemployee = ?";
            String sql4 = "select id from workdays where days = ?";
            String sql5 = "INSERT INTO empwork(idemployee,idwork) values(?,?)";
            PreparedStatement person = null, employee = null, upworkdele = null, dayssel = null, empwor = null;
            
            try {
                 conec.setAutoCommit(false);
                person = conec.prepareStatement(updateperson);
                person.setString(1,this.getName());
                person.setString(2,this.getLastname());
                person.setLong(3,this.getPhone());
                person.setString(4,String.valueOf(this.getGender()));
                person.setLong(5,this.getId());
           
                int resu = person.executeUpdate();
                
                employee = conec.prepareStatement(updateemployee);
                employee.setInt(1,this.getJobId());
                employee.setString(2,this.entrytime);
                employee.setString(3,this.departure);
                employee.setLong(4,this.getId());
               
                employee.executeUpdate();
                
                upworkdele = conec.prepareStatement(deleteupwork);
                upworkdele.setLong(1, this.getIdemployee());
                
                 int result  = upworkdele.executeUpdate();
                if(result > 0){
                      Iterator df = workday.iterator();
                       while(df.hasNext()){
                           
                            dayssel = conec.prepareStatement(sql4);
                            dayssel.setString(1, df.next().toString());
                            ResultSet dayselect = dayssel.executeQuery();     
                            
                            if(dayselect.next()){
                                    int idwork = dayselect.getInt("id");
                                   empwor = conec.prepareStatement(sql5);
                                    empwor.setLong(1,this.getIdemployee());
                                    empwor.setInt(2,idwork);
                                    
                                    empwor.executeUpdate();
                            }
                        }
                }
                
              
                
                conec.commit();
                flag = true;
            } catch (SQLException e) {
                e.printStackTrace();
                conec.rollback();
            } finally{
                if(person != null){
                    person.close();
                }
                if(employee != null){
                    employee.close();
                }
                
                if(upworkdele != null){
                    upworkdele.close();
                }
                if(dayssel != null){
                    dayssel.close();
                }
                if(empwor != null){
                    empwor.close();
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
            
             String sql1 = "DELETE from empwork where idemployee = "+this.id+"";
            int resul = connection.runUpdate(sql1);
            if(resul > 0){
                flag = true;
            }else{
                flag = false;
            }
            
        }
        return flag;
    }

    public String[][] resultList(String nameday){
 
    	   String sql = "select emp.id as idemployee, p.phone, p.name,p.last_name, emp.ENTRYTIME, emp.DEPARTURETIME from person as p\n" +
"join employee as emp on p.id = emp.PERSON_ID\n" +
"join empwork as empw on emp.ID = empw.idemployee\n" +
"join workdays as w on empw.idwork = w.id\n" +
"	where w.days = '"+nameday+"'";

            ResultSet result = connection.runQuery(sql);

            if(result == null){

               return null;
            }
            
            int i = 0;
            try {
                
                while(result.next()) i++;
                String[][] data = new String[i][5];
                i = 0;
                result.beforeFirst();
                while(result.next()){
                   data[i][0] = result.getString("phone");
                   data[i][1] = result.getString("name");
                   data[i][2] = result.getString("last_name");
                   data[i][3] = result.getString("ENTRYTIME");
                    data[i][4] = result.getString("DEPARTURETIME");
                    i++;
                }
                
                return data;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    @Override
    public String[][] resultList(){
 
    	   String sql = "select emp.id as idemployee, p.phone, p.name,p.last_name, emp.ENTRYTIME, emp.DEPARTURETIME from person as p\n" +
"join employee as emp on p.id = emp.PERSON_ID";

            ResultSet result = connection.runQuery(sql);

            if(result == null){

               return null;
            }
            
            int i = 0;
            try {
                
                while(result.next()) i++;
                String[][] data = new String[i][5];
                i = 0;
                result.beforeFirst();
                while(result.next()){
                   data[i][0] = result.getString("phone");
                   data[i][1] = result.getString("name");
                   data[i][2] = result.getString("last_name");
                   data[i][3] = result.getString("ENTRYTIME");
                    data[i][4] = result.getString("DEPARTURETIME");
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
                    + "as jobId, emp.entrytime, emp.departuretime \n" +
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
                    setEntrytime(result.getString("entrytime"));
                    setDeparture(result.getString("departuretime"));
                    flag=true;
                    
                    String sql1 = "select w.days from person as p\n" +
                                "   join employee as emp on p.ID = emp.PERSON_ID\n" +
                                "   join empwork as empw on emp.ID = empw.idemployee\n" +
                                "   join workdays as w on empw.idwork = w.id\n" +
                                "   where p.PHONE = "+phoneIdent+"";
                    
                    ResultSet res = connection.runQuery(sql1);
                    if(res !=null){
                           workday = new ArrayList();
                         while(res.next()){
                             workday.add(res.getString("days"));
                         }
                        
                    }
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
        
        String sql = "select p.name, emp.id as idemployee, emp.ENTRYTIME, emp.DEPARTURETIME from person as p \n" +
"               join employee as emp on p.id = emp.person_id\n" +
"                where p.phone = "+phone+"";
       
        ResultSet result = connection.runQuery(sql);
        
        if(result != null){
            enc = true;
            try {
                result.next();
                setName(result.getString("name"));
                setIdemployee(result.getLong("idemployee"));
                setEntrytime(result.getString("entrytime"));
                 setDeparture(result.getString("departuretime"));
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        return enc;
    }

}
