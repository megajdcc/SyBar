package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cut {
    
    
    private int id;
    private String style;
    private double price;
    private char gender;
    
    public boolean registry,delete,update;
    
    private final Conection connection;
    

    public Cut(){
        connection = new Conection();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getGender() {
        return gender;
    }

   public void setGender(char gender) {
        this.gender = gender;
    }
    
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean deleteCut() {
        delete = false;
        
        String sql = "DELETE from haircut_type where id = "+this.id+"";
        int result = connection.runUpdate(sql);
        
        if(result != 0){
            delete = true;
        }
        return delete;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean updateCut() {
         update = false;
        String sql = "UPDATE haircut_type set style = '"+this.style+"',price = "+this.price+", gender = '"+this.gender+"' where id = "+this.id+"";
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
    public boolean insertCut() {
         registry = false;
        
        String sql = "INSERT INTO haircut_type(style,price,gender)"
                + "values('"+this.style+"',"+this.price+",'"+this.gender+"')";
        int result = connection.runUpdate(sql);
        
        if(result != 0){
            registry = true;
        }
        return registry;
    }
    public String[][] cutList(){
       
            boolean flag = false;
           
            String sql = "select style,price,gender from haircut_type";

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
                   data[i][0] = result.getString("style");
                   data[i][1] = result.getString("price");
                   data[i][2] = result.getString("gender");

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
            String sql = "select * from haircut_type where style = '"+name+"'";
          
            ResultSet result = connection.runQuery(sql);
             try {
              
                if(result!=null){
                    result.next();
                    setId(result.getInt("id"));
                    setStyle(result.getString("style"));
                    setPrice(result.getDouble("price"));
                    String genderr = result.getString("gender");
                    char gener = genderr.charAt(0);
                    setGender(gener);
                    flag=true;
                }else{
                    flag=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return flag;
            
        }
    public boolean validateStyle(String name){
         boolean flag = false;
            String sql = "select id from haircut_type where style = '"+name+"'";
            ResultSet result = connection.runQuery(sql);
            
            if(result != null){
                flag = true;
            }
         return flag;
     }
    public double capturePrice(){
        double price = 0;
        
        String sql = "select price from haircut_type where style = '"+this.style+"'";
        ResultSet result = connection.runQuery(sql);
        
        if(result!=null){
            try {
                result.next();
                price = result.getFloat("price");
            } catch (SQLException ex) {
                Logger.getLogger(Cut.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return price;
    }
    public boolean matchingIdModel(long id ){
       
            boolean flag=false;
            String sql = "select * from haircut_type where id= "+id+"";
          
            ResultSet result = connection.runQuery(sql);
             try {
              
                if(result!=null){
                    result.next();
                    setId(result.getInt("id"));
                    setStyle(result.getString("style"));
                    setPrice(result.getDouble("price"));
                    String genderr = result.getString("gender");
                    char gener = genderr.charAt(0);
                    setGender(gener);
                    flag=true;
                }else{
                    flag=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return flag;
            
        }
    public String[][] listHairCut(Long idMeeting){

            String sql = "select h.style,h.price from haircut_type as h \n" +
"join meeting as m on h.ID =m.HAIRCUT\n" +
"	where m.ID = "+idMeeting+"";

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
                   data[i][0] = resultQuery.getString("style");
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
