package Model;


import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import View.*;

public class Meeting {
    
    private final Conection connection;
    
    
    private String date;
    private String time;
    private long id,id_Employee,id_Client,id_Haircut,id_User;
    private Double totalPrice;
    private int completedWork, discount;
    private Date dateTime;
    private ArrayList meetserv; 
    private Principal principal;
    //Construct 
    public Meeting(){
        connection = new Conection();
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_Employee() {
        return id_Employee;
    }

    public void setId_Employee(long id_Employee) {
        this.id_Employee = id_Employee;
    }

    public long getId_Client() {
        return id_Client;
    }

    public void setId_Client(long id_Client) {
        this.id_Client = id_Client;
    }

    public long getId_Haircut() {
        return id_Haircut;
    }

    public void setId_Haircut(long id_Haircut) {
        this.id_Haircut = id_Haircut;
    }

    public long getId_User() {
        return id_User;
    }

    public void setId_User(long id_User) {
        this.id_User = id_User;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCompletedWork() {
        return completedWork;
    }

    public void setCompletedWork(int completedWork) {
        this.completedWork = completedWork;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    public String[][] meetingList(){
        
        
        
        try {
        	String sql = "select p.phone,p.name, p.last_name, m.date from person as p\r\n" + 
            		"join client as c on p.phone = c.phone\r\n" + 
            		"JOIN meeting as m on c.ID = m.CLIENT_ID\r\n" + 
            		"where m.COMPLETEDWORK = 0 order by m.date";
            ResultSet rs = connection.runQuery(sql);

            if(rs == null){
               String Error = "error en la consulta";
               return null;
            }
            
            int i = 0;
            while(rs.next()) i++;
            String[][] data = new String[i][5];
            i = 0;
            rs.beforeFirst();
            while(rs.next()){
                Date date = rs.getTimestamp("date");
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                DateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
               data[i][0] = rs.getString("phone");
               data[i][1] = rs.getString("name");
               data[i][2] = rs.getString("last_name");
               data[i][3] = dateFormat2.format(date);
               data[i][4] = dateFormat.format(date);
               i++;
            }
            return data;
        }catch (SQLTimeoutException ex) {
            JOptionPane.showMessageDialog(principal,"Error: "+ ex.getMessage());
            return null;
       } catch(SQLException ex1) {
        	 JOptionPane.showMessageDialog(principal,"Error: "+ ex1.getMessage());
        	 return null;
        } 
    }
    
    public boolean searchModelByPhone(long phone){
        
        boolean flag=false;
        String sql = "select m.id,m.date,m.EMPLOYEE_SUPPORT as id_Employee, m.CLIENT_ID as id_Client, m.COMPLETEDWORK  as COMPLETE,\n" +
"m.DISCOUNT, m.HAIRCUT, m.TOTALPRICE, m.USER_ID from meeting as m\n" +
"join client as c on m.CLIENT_ID = c.ID\n" +
"join person as p on c.phone = p.phone\n" +
"where p.phone = "+phone+" and m.completedwork = 0";
        
        ResultSet rs = connection.runQuery(sql);
         try {
          
            if(rs!=null){
                rs.next();
                setId(rs.getInt("id"));
                Date fecha = rs.getTimestamp("date");  
                setDateTime(fecha);
                setDate(fecha.toString());
                setId_Employee(rs.getLong("id_Employee"));
                setId_Client(rs.getLong("id_Client"));
                setCompletedWork(rs.getInt("COMPLETE"));
                setDiscount(rs.getInt("discount"));
                setId_Haircut(rs.getLong("Haircut"));
                setTotalPrice(rs.getDouble("totalprice"));
                setId_User(rs.getLong("user_id"));
                
                flag=true;
            }else{
                flag=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return flag;
   
    
    }
    
 public boolean insertMeeting(){
        
        boolean registry = false;
        
        String sql = "insert into meeting(date,client_id,user_id,completedwork,employee_support, Haircut,totalprice)"
                + " values('"+this.date+"',"+this.id_Client+","+this.id_User+","+this.completedWork+","+this.id_Employee+", "+id_Haircut+","+this.totalPrice+")";

        int result = connection.runUpdate(sql);
        if (result !=0){
            String sql4 = "select max(id) as id from meeting";
            ResultSet rs = connection.runQuery(sql4);
            if(rs != null){
                
                try {
                    rs.next();
                    setId(rs.getLong("id"));
                } catch (SQLException ex) {
                    Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
                }
                Object[] list = this.meetserv.toArray();
                        if(list.length > 0){
                             for (int i = 0; i < list.length; i++) {
                                  String sql3  = "select id from service where name ='"+(String)list[i]+"'";
                                  ResultSet rs2 = connection.runQuery(sql3);
                                  if(rs2 != null){
                                      long id_s = 0;
                                      try {
                                          rs2.next();
                                          id_s = rs2.getLong("id");
                                      } catch (SQLException ex) {
                                          Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
                                      }
                                       String sql2 = "insert into meetserv(ids,idm) values("+id_s+","+this.getId()+")";
                                       
                                       int resq = connection.runUpdate(sql2);
                                       if(resq > 0){
                                           registry = true;
                                       }
                                  }               
                            }
                    }
            }
            
            
            registry = true;
        }
        return registry;
    }
 
 public boolean completedMeeting(){
     boolean registry = false;
     
     String sql = "update meeting set completedwork = 1, totalprice = "+this.getTotalPrice()+", discount = "+this.getDiscount()+" "
             + "where id = "+this.getId()+"";
             int regis = connection.runUpdate(sql);
             if(regis > 0){
                 registry = true;
             }
             return registry;
 }
 
 public boolean updateMeeting(){
     boolean register = false;
     
         String sql = "update meeting set employee_support = "+this.getId_Employee()+", Haircut = "+this.getId_Haircut()+", "
                 + "     user_id = "+this.getId_User()+", completedwork = "+this.getCompletedWork()+",date= '"+this.date+"'"
                 + "     where id = "+this.getId()+"";
       
         int result = connection.runUpdate(sql);
             if(result > 0){
                 String sqlDelete = "delete from meetserv where idm= "+this.getId()+"";
                 int inResult = connection.runUpdate(sqlDelete);
                 
                     Object[] list = this.meetserv.toArray();
                     if(list.length > 0){
                          for (int i = 0; i < list.length; i++) {
                               String sql3  = "select id from service where name ='"+(String)list[i]+"'";
                               ResultSet resultado = connection.runQuery(sql3);
                               if(resultado != null){
                                   long id_s = 0;
                                   try {
                                       resultado.next();
                                       id_s = resultado.getLong("id");
                                   } catch (SQLException ex) {
                                       Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
                                   }
                                    String sql2 = "insert into meetserv(ids,idm) values("+id_s+","+this.getId()+")";
                                    
                                    int resq = connection.runUpdate(sql2);
                                    if(resq > 0){
                                        register = true;
                                    }
                               }
                              
                         }
                        
                     
                   
                 }
                 register = true;
             }
     return register;
 }
 
 public boolean updateOpc(){
     boolean updateOp = false;
         String sql = "update meeting set date = '"+this.getDate()+"' where id = "+this.getId()+"";
         int result = connection.runUpdate(sql);
         if(result > 0 ){
             updateOp = true;
         }
     return updateOp;
 }
 
 public boolean delete(){
     boolean deletem = false;
     String sql = "delete from meeting where id = "+this.id+" AND completedwork = 0";
     int result = connection.runUpdate(sql);
     
     if(result > 0){
         deletem = true;
     }
     return deletem;
 }
 
 public void setMeetserv(ArrayList<String> list){
     this.meetserv = list;
     
 } 
 
 public boolean verify(){
     boolean verify = false;
     
     String sql = "select id from meeting where client_id = "+this.getId_Client()+" and completedwork = 0";
     ResultSet rs = connection.runQuery(sql);
     
     if(rs !=null){
    
         verify = true;
     }
     return verify;
 }
 
 public ArrayList<String> MeeServ(){
     meetserv = new ArrayList();
     
    
     
    
         try {
        	 
        	 String sql = "select s.id,s.name,s.price from service as s\n" +
                     "join meetserv as me on s.ID = me.ids\n" +
                     "where me.idm =  "+this.id+"";
         
         ResultSet rs = connection.runQuery(sql);
         if(rs != null){
             while(rs.next()){
                   meetserv.add(rs.getString("name"));
             }
        	 }
         } catch (SQLException ex) {
        	 JOptionPane.showMessageDialog(principal, "Error: "+ ex.getMessage());
             Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
         }
     
     
     return meetserv;
     
 }
}
