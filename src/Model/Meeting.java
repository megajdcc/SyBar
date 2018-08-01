/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import View.Principal;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jnatn'h
 */
public class Meeting {
    
    private final Conection conexion;
    
    // fiels de class
    
    private String date;
    private String time;
    private long id,employee,client,haircut,user;
    private Double totalprice;
    private int completedwork, discount;
    private Date datee;
    private Time hour;
    private ArrayList meetserv; 
    
    // getters y setters... 
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

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    public long getHaircut() {
        return haircut;
    }

    public void setHaircut(long haircut) {
        this.haircut = haircut;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public int getCompletedwork() {
        return completedwork;
    }

    public void setCompletedwork(int completedwork) {
        this.completedwork = completedwork;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getDatetime() {
        return datee;
    }

    public void setDatetime(Date datetime) {
        this.datee = datetime;
    }
    
     public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }
    
    //Construct 
    public Meeting(){
        conexion = new Conection();
    }

   // movent...
    
    public String[][] consultList(){
       
           
            String sentenciaSQL = "select p.phone,p.name, p.last_name, DATE(m.date) as date,TIME(m.DATE) as hour from person as p \n" +
"join client as c on p.phone = c.phone\n" +
"JOIN meeting as m on c.ID = m.CLIENT_ID\n" +
"where m.COMPLETEDWORK = 0 order by m.date";
            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);

            if(resultadoConsulta == null){
               String Error = "error en la consulta";
               return null;
            }
            
            int i = 0;
            try {
                while(resultadoConsulta.next()) i++;
                String[][] datos = new String[i][5];
                i = 0;
                resultadoConsulta.beforeFirst();
                while(resultadoConsulta.next()){
                    Date fech = resultadoConsulta.getDate("date");
                    String timee = resultadoConsulta.getString("hour");
                    DateFormat hourr = new SimpleDateFormat("kk:mm:ss");
                    DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
                   datos[i][0] = resultadoConsulta.getString("phone");
                   datos[i][1] = resultadoConsulta.getString("name");
                   datos[i][2] = resultadoConsulta.getString("last_name");
                   datos[i][3] = resultadoConsulta.getString("date");;
                   datos[i][4] = timee;
                   i++;
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    public boolean consultModel(long phone){
       
            boolean statusConsulta=false;
            String sentenciaSQL = "select m.id,DATE(m.date) as date,m.EMPLOYEE_SUPPORT as employee, m.CLIENT_ID as client, m.COMPLETEDWORK  as conplete,\n" +
"m.DISCOUNT,TIME(m.date) as hour, m.HAIRCUT, m.TOTALPRICE, m.USER_ID from meeting as m\n" +
"join client as c on m.CLIENT_ID = c.ID\n" +
"join person as p on c.phone = p.phone\n" +
"where p.phone = "+phone+" and m.completedwork = 0";
            
            ResultSet resultadoConsulta = conexion.runQuery(sentenciaSQL);
             try {
              
                if(resultadoConsulta!=null){
                    resultadoConsulta.next();
                    setId(resultadoConsulta.getInt("id"));
                    String date1 = resultadoConsulta.getString("date");  
                  

//                    Calendar date2 = new GregorianCalendar();
//                    date2.m mlk/m,.
                    setDatetime(new Date());
                    setDate(date1);
                    setEmployee(resultadoConsulta.getLong("employee"));
                    setClient(resultadoConsulta.getLong("client"));
                    setCompletedwork(resultadoConsulta.getInt("conplete"));
                    setDiscount(resultadoConsulta.getInt("discount"));
                    setHaircut(resultadoConsulta.getLong("haircut"));
                    setTotalprice(resultadoConsulta.getDouble("totalprice"));
                    setUser(resultadoConsulta.getLong("user_id"));
                    setHour(Time.valueOf(resultadoConsulta.getString("hour")));
                    
                    statusConsulta=true;
                }else{
                    statusConsulta=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return statusConsulta;
            
        }//fin de consultar  
    public boolean insertMeeting(){
        
        boolean registry = false;
        
        
        String sql = "insert into meeting(date,client_id,user_id,completedwork,employee_support, haircut,totalprice)"
                + " values('"+this.date+' '+this.hour+"',"+this.client+","+this.user+","+this.completedwork+","+this.employee+", "+haircut+","+this.totalprice+")";

        int result = conexion.runUpdate(sql);
        if (result !=0){
            String sql4 = "select max(id) as id from meeting";
            ResultSet resultt = conexion.runQuery(sql4);
            if(resultt != null){
                
                try {
                    resultt.next();
                    setId(resultt.getLong("id"));
                } catch (SQLException ex) {
                    Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
                }
                Object[] list = this.meetserv.toArray();
                        if(list.length > 0){
                             for (int i = 0; i < list.length; i++) {
                                  String sql3  = "select id from service where name ='"+(String)list[i]+"'";
                                  ResultSet resultado = conexion.runQuery(sql3);
                                  if(resultado != null){
                                      long id_s = 0;
                                      try {
                                          resultado.next();
                                          id_s = resultado.getLong("id");
                                      } catch (SQLException ex) {
                                          Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
                                      }
                                       String sql2 = "insert into meetserv(ids,idm) values("+id_s+","+this.getId()+")";
                                       
                                       int resq = conexion.runUpdate(sql2);
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
    public boolean completedMeeting() throws SQLException{
         boolean registry = false;
        Connection conec = conexion.getConec();
        String sql = "update meeting set completedwork = ?, totalprice = ?, discount = ?  where id = ?";
        PreparedStatement completed = null;
            
        try {
            conec.setAutoCommit(false);
            
            completed = conec.prepareStatement(sql);
            completed.setInt(1,1);
            completed.setDouble(2,this.totalprice);
            completed.setInt(3,this.getDiscount());
            completed.setLong(4,this.getId());
            
            completed.executeUpdate();
            conec.commit();
            registry = true;
        } catch (SQLException ex) {
            Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
            conec.rollback();
        } finally{
            if(completed != null){
                completed.close();
            }
        }
        return registry;
    }
    public boolean updateMeeting() throws SQLException{
            boolean register = false;
            Connection conec = conexion.getConec();
            String sql = "update meeting set employee_support = ?, haircut = ?, user_id = ?, completedwork = ?, date= ? "
                    + "where id = ?";
            String sqldele = "delete from meetserv where idm= ?";
            String sql3  = "select id from service where name = ?";
            String sql2 = "insert into meetserv(ids,idm) values(?,?)";
            PreparedStatement meetinupdate = null, meetservi = null , selidser = null, inserser = null;

        try {
            conec.setAutoCommit(false);
           
           
            meetinupdate = conec.prepareStatement(sql);
            meetinupdate.setLong(1,this.employee);
            meetinupdate.setLong(2,this.haircut);
            meetinupdate.setInt(3,Principal.getIdUser());
            meetinupdate.setInt(4,0);
            meetinupdate.setString(5, this.getDate()+ ' '+this.getHour());
            meetinupdate.setLong(6,this.id);
            meetinupdate.executeUpdate();
            meetservi = conec.prepareStatement(sqldele);
            meetservi.setLong(1,this.id);
            int result = meetservi.executeUpdate();
            if(result > 0){
                Object[] list = this.meetserv.toArray();
                if(list.length > 0){
                    for (int i = 0; i < list.length; i++) {
                        selidser = conec.prepareStatement(sql3);
                        selidser.setString(1,(String) list[i]);
                        
                        ResultSet result1 = selidser.executeQuery();
                        
                        if(result1  != null){
                            long id_s = 0;
                            try {
                                result1.next();
                                id_s = result1.getLong("id");
                            } catch (SQLException ex) {
                                Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            inserser = conec.prepareStatement(sql2);
                            inserser.setLong(1, id_s);
                            inserser.setLong(2, this.getId());
                            inserser.executeUpdate();
                        }
                        
                    }
                }
            }
           conec.commit();
           register = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            conec.rollback();
            
        } finally{
            if(meetinupdate != null){
                meetinupdate.close();
            }
            
            if(meetservi != null){
                meetservi.close();
            }
            
            if(selidser != null){
                selidser.close();
            }
            
        }
         return register;
    }
    public boolean updateopc(){
        boolean updateop = false;
            String sql = "update meeting set date = '"+this.getDate()+"' where id = "+this.getId()+"";
            int result = conexion.runUpdate(sql);
            if(result > 0 ){
                updateop = true;
            }
        return updateop;
    }
    public boolean delete(){
        boolean deletem = false;
        String sql = "delete from meeting where id = "+this.id+" AND completedwork = 0";
        int result = conexion.runUpdate(sql);
        
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
        
        String sql = "select id from meeting where client_id = "+this.getClient()+" and completedwork = 0";
        ResultSet result = conexion.runQuery(sql);
        
        if(result !=null){
       
            verify = true;
        }
        return verify;
    }
    public ArrayList<String> MeeServ(){
        meetserv = new ArrayList();
        
        String sql = "select s.id,s.name,s.price from service as s\n" +
                    "join meetserv as me on s.ID = me.ids\n" +
                    "where me.idm =  "+this.id+"";
        
        ResultSet result = conexion.runQuery(sql);
        
        
        if(result != null){
            try {
               
                while(result.next()){
                      meetserv.add(result.getString("name"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return meetserv;
        
    }
   
}
