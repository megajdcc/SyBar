package Model;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;


public class Service {
        
    private int id;
    private double price;
    private String service;
    public boolean registry,update,delete;
    private final Conection connection;
    private ArrayList prices;                
    private long duration;
   
    public Service(){
      connection = Conection.Conec();
        
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getService() {
        return service;
    }
    
    
    public void setService(String service) {
        this.service = service;
    }

    public ArrayList getPrices() {
        return prices;
    }

    public void setPrices(ArrayList prices) {
        this.prices = prices;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean insertService() {
         registry = false;
        
        String sql = "INSERT INTO Service(price,name,duration)"
                + "values("+this.price+",'"+this.service+"',"+this.duration+")";
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
    public boolean updateService() {
      update = false;
        String sql = "UPDATE service set price = "+this.price+",name = '"+this.service+"', duration = "+this.duration+"" 
                + " where id = "+this.id+"";
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
    public boolean deleteService() {
        delete = false;
        
        String sql = "DELETE from service where id = "+this.id+"";
        int result = connection.runUpdate(sql);
        
        if(result != 0){
            delete = true;
        }
        return delete;
    }
    public String[][] serviceList(){
           
            String sqlStatement = "select name, price, duration from service";

            ResultSet result = connection.runQuery(sqlStatement);

            if(result == null){
               return null;
            }
            
            int i = 0;
            try {
                 Calendar du = Calendar.getInstance();
                while(result.next()) i++;
                String[][] data = new String[i][3];
                i = 0;
                result.beforeFirst();
                while(result.next()){
                     int hrs = du.get(Calendar.HOUR_OF_DAY);
                   int mins = du.get(Calendar.MINUTE);
                   int sec = du.get(Calendar.SECOND);
                   du.add(Calendar.HOUR_OF_DAY, -hrs);
                   du.add(Calendar.MINUTE, -mins);
                   du.add(Calendar.SECOND, -sec);
                   du.add(Calendar.MILLISECOND, +result.getInt("Duration"));
                   data[i][0] = result.getString("name");
                   data[i][1] = result.getString("price");
                   Time dur = Time.valueOf(du.get(Calendar.HOUR_OF_DAY)+":"+du.get(Calendar.MINUTE)+":"+du.get(Calendar.SECOND));
                   data[i][2] = dur.toString();
                    i++;
                }
                return data;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    public boolean matchingModel(String name){
       
            boolean flag=false;
            String sql = "select * from service where name = '"+name+"'";
           
            ResultSet result = connection.runQuery(sql);
             try {
               Calendar du = Calendar.getInstance();
                if(result!=null){
                    result.next();
                    setId(result.getInt("id"));
                    setService(result.getString("name"));
                    setPrice(result.getDouble("price"));
                    setDuration(result.getLong("duration"));
                    flag=true;
                }else{
                    flag=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return flag;
            
        }
    public void listServices(JList list){
      String sql = "SELECT s.name from service as s";
      ResultSet result  = connection.runQuery(sql);
      if(result != null){
        try {
         int i = 0 ;
          DefaultListModel myList = new DefaultListModel();
          
          while(result.next()){              
               myList.addElement(result.getString("name"));
          }
          list.setCursor(new Cursor(Cursor.HAND_CURSOR));
          list.setModel(myList);
        } catch (SQLException ex) {
          Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      }
    }
    public void chackPrice(ListModel<String> model) throws SQLException{
        
       int leng = model.getSize();
       
       prices = new ArrayList();
        for (int i = 0; i < leng; i++) {
            String sql = "select price from service where name = '"+ model.getElementAt(i) +"'";
            ResultSet result = connection.runQuery(sql);
            if(result!= null){
                result.next();
                prices.add(result.getDouble("price"));
            }
        }  
    }
    public String[][] list2Services(Long idMeeting){

            String sql = "select s.name,s.price from service as s \n" +
"	join meetserv as me on s.ID = me.ids\n" +
"	where me.idm = "+idMeeting+"";

            ResultSet resultQuery = connection.runQuery(sql);

            if(resultQuery == null){
               String Error = "error";
               return null;
            }
            
            int i = 0;
            try {
                while(resultQuery.next()) i++;
                String[][] data = new String[i][2];
                i = 0;
                resultQuery.beforeFirst();
                while(resultQuery.next()){
                   data[i][0] = resultQuery.getString("name");
                   data[i][1] = resultQuery.getString("price");
              
                    i++;
                }
                return data;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
}
