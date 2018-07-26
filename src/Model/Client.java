package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client extends Person{
    
    // Fields of class
    
    private long id;
    private String email;
    private final Conection connection;

    public Client(){
        connection = new Conection();
    }

    @Override
    public long getId() {
        return id;
    }
    public long getIdperson(){
        return super.getId();
    }
    public void setIdclient(long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was execute successfully or not.
     */
    public boolean insertClient(){
        
        boolean register = false;
        
        String sql = "insert into person(name,last_name,phone,gender,typeperson) values"
                + "('"+this.getName()+"','"+this.getLastname()+"',"+this.getPhone()+",'"+this.getGender()+"',"
                + "'Client')";

        int result = connection.runUpdate(sql);
        if(result > 0){
            
                String sql2;
     
                    sql2 = "insert into client(phone,email) values("+this.getPhone()+",'"+this.getEmail()+"')";

                System.out.println(sql2);
                int result2 = connection.runUpdate(sql2);
                if(result2 > 0 ){
                    register = true;
                }
                
            }
        
        
        return register;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was execute successfully or not.
     */
    public boolean updateClient(){
        update = false;
        boolean flag = update();
        if(flag){
                String sql = "UPDATE client set email = '"+this.email+"' where id = "+this.getId()+"";
                int result = connection.runUpdate(sql);
                if(result != 0){
                update = true;
            }
        }
        return update;
    }
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.. 
     */
    @Override
    public boolean update(){
        update = false;
        String sql = "UPDATE person set name = '"+getName()+"', last_name = '"+getLastname()+"',"
                + "gender='"+getGender()+"', phone = "+this.getPhone()+""
                + " where id ="+getIdperson()+"";
        System.out.println(sql);
        int result = connection.runUpdate(sql);
        if(result !=0){
            update = true;
        }
        return update;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was execute successfully or not.
     */
    public boolean deleteClient(){
        delete = false;
        String sql = "DELETE from person where id ="+this.getIdperson()+"";
        int result = connection.runUpdate(sql);
        if(result != 0){
            delete = true;
            System.out.println(sql);

        }
        return delete;
    }   

    @Override
    public String[][] resultList(){
 
           
            String sql = "select p.phone,p.name,p.last_name from person as p \n" +
"join	client as c on p.PHONE = c.PHONE";

            ResultSet resultQuery = connection.runQuery(sql);

            if(resultQuery == null){
               String Error = "error";
               return null;
            }
            
            int i = 0;
            try {
                while(resultQuery.next()) i++;
                String[][] data = new String[i][3];
                i = 0;
                resultQuery.beforeFirst();
                while(resultQuery.next()){
                   data[i][0] = resultQuery.getString("phone");
                   data[i][1] = resultQuery.getString("name");
                   data[i][2] = resultQuery.getString("last_name");
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
            String sql = "select p.id as idperson, p.name, p.last_name, p.gender, c.id as idclient, c.phone, c.email from person as p\n" +
                                    "join	client as c on p.phone = c.PHONE\n" +
                                "where p.phone = "+phone+"";
           
            ResultSet resultQuery = connection.runQuery(sql);
             try {
              
                if(resultQuery!=null){
                    resultQuery.next();
                    setIdclient(resultQuery.getLong("idclient"));
                    setName(resultQuery.getString("NAME"));
                    setLastname(resultQuery.getString("LAST_NAME"));
                    setPhone(resultQuery.getLong("PHONE"));
                    setGender(resultQuery.getString("GENDER").charAt(0));
                    super.setId(resultQuery.getLong("idperson"));
                    setEmail(resultQuery.getString("email"));
                    flag=true;
                }else{
                    flag=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return flag;
            
        }
    

    public boolean captureClient(long id){
        boolean exits = false;
        
        String sql = "select c.id, p.phone, p.name,p.last_name from person as p \n" +
"join client as c on p.phone = c.PHONE\n" +
"join meeting as m on c.id = m.client_id \n" +
"where m.client_id = "+id+" and m.completedwork = 0";
        
      
        ResultSet result = connection.runQuery(sql);
        if(result!=null){
            try {
                result.next();
                setId(result.getLong("id"));
                setPhone(result.getLong("phone"));   
                setName(result.getString("name"));
                setLastname(result.getString("last_name"));
                exits = true;
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return exits;
    }  

    public boolean validatePhone(long phone){
        boolean flag = false;
        
        String sql = "select * from client where phone = "+phone+"";
        ResultSet result = connection.runQuery(sql);
        
        if(result != null){
            flag = true;
        }
        return flag;
    }
}
