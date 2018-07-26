
package Controller;

import View.Vuser;
import View.Vemployee;
import View.Ruser;
import View.Principal;
import Model.Employee;
import Model.User;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.commons.codec.digest.DigestUtils;

public class ControllerUsers implements ActionListener, KeyListener,MouseListener{
    
    DefaultTableModel dm;
    private Vuser vUser; 
    private User model;
    private Employee employeeModel;
    private Ruser use;
    private Principal principal;
    private Ruser user;
    private String name;
    private Vemployee employee;
    //Constructors of Class...
    public ControllerUsers(Vuser list){
        this.vUser = list;
        model = new User();
        employeeModel = new Employee();
        user = new Ruser(principal, true);
        
        employee = new Vemployee(principal,true);
        this.Tolist(1);
    }
    
    public ControllerUsers(Ruser use){
        this.use = user;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object event = ae.getSource();

        
        if(event.equals(vUser.getNewBtt())){
            vUser.setVisible(false);
           
            user.getDelete().setEnabled(false);
            user.getDelete().setVisible(false);
            user.getLabelnewpass().setVisible(false);
            user.getNewPassword().setVisible(false);
            user.setControllerUser(this);
            user.getPassword().removeKeyListener(this);
            user.setVisible(true);
            vUser.setVisible(false);
            vUser.dispose();
        }else if(event.equals(user.getExituser())){
            user.setVisible(false);
            user.dispose();
            vUser = new Vuser(principal,true);
            vUser.setVisible(true);
        }else if(event.equals(user.getRegister())){
            this.validate();
        }else if(event.equals(user.getSearchEmployee())){
            employee.setControllerUser(this);
            this.Tolist(2);
            employee.getNewBtt().setEnabled(false);
            employee.setVisible(true);
        }else if(event.equals(user.getDelete())){
            this.delete();
        }  
    }
    private void delete(){
        int opt = JOptionPane.showConfirmDialog(principal,"Be sure to delete the user?"+user.getTextuser().getText(), "Delete user",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(opt <1){
            boolean result = model.deleteUser();
        if(result){
           
            user.dispose();
            user.setVisible(false);
            
            vUser = new Vuser(principal, true);
            vUser.setControllerUsers(this);
            this.Tolist(1);
            vUser.setVisible(true);
            
        }else{
            String err = "The user could not be deleted";
            user.getComment().setText(err);
        }
        }
        
    }
    
    private void Tolist(int whereTo){
        if(whereTo == 1){
             String[][] info =  model.resultList();
        vUser.getTableUser().setModel(new javax.swing.table.DefaultTableModel(
        info,
        new String [] {"Phone","Name","Users"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    vUser.getTableUser().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }else if(whereTo == 2){
            String[][] info =  employeeModel.resultList();
            employee.getEmployeeTable().setModel(new javax.swing.table.DefaultTableModel(
            info,
            new String [] {"Phone","Name","Last Name"}) {
            boolean[] canEdit = new boolean [] {
                false,false,false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
    });
        employee.getEmployeeTable().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
       
    }
    public void Listsearch(String query, JTable jTableSearch){
        dm = (DefaultTableModel) jTableSearch.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        jTableSearch.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    public void captureData(long phone, String opt){

           if(opt.equals("user")){
           boolean found = model.matchingModel(phone);
           if (found){
                vUser.dispose();
                vUser.setVisible(false);
                
                user.getTextuser().setText(model.getUser());
                user.getId().setText(String.valueOf(model.getId()));
                user.getNamee().setText(model.getName());
                user.getLastName().setText(model.getLastname());
               
                user.getNewPassword().setEnabled(false);
                user.getPassword().addKeyListener(this);
                user.getDelete().setEnabled(true);
                user.getDelete().setVisible(true);
                user.getSearchEmployee().setEnabled(false);
                user.setControllerUser(this);
                user.setVisible(true);}
               

           }else if(opt.equals("employee")){
               boolean found = employeeModel.matchingModel(phone);
           if (found){
               employee.setVisible(false);
               employee.dispose();
               
               user.getId().setText(String.valueOf(employeeModel.getIdemployee()));
               user.getNamee().setText(employeeModel.getName());
               user.getLastName().setText(employeeModel.getLastname());
               
                        
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","User",JOptionPane.INFORMATION_MESSAGE);
            }
           }
       }

    private void validate(){
         if (user.getTextuser().getText().isEmpty()) {
               String err = "could not register an empty user";
               user.getComment().setText(err);
               user.getComment().setForeground(Color.RED);
             }else if(user.getPassword().getPassword().length < 1){
                 String err = "You can not register multiple spaces in whites o behalf of user or in password";
                    user.getComment().setText(err);
                    user.getComment().setForeground(Color.ORANGE);
            }else if(user.getTextuser().getText().length() < 4){
                String err = "Make sure that the username fields are not less than 4 characters!";
                user.getComment().setText(err);
                user.getComment().setForeground(Color.ORANGE);
            }else if(user.getPassword().getPassword().length < 5){
                String err = "Make sure that the password fields are not less than 4 characters!";
                user.getComment().setText(err);
                user.getComment().setForeground(Color.ORANGE);
            }else if(user.getId().getText().isEmpty()){
                String err = "You can not register or modify a user if it is not associated with any employee";
                user.getComment().setText(err);
                user.getSearchEmployee().setFocusable(true);
            }else{
                record();
            }
    }
    private void record(){
        if(model.getId()!=0){
           model.setUser(user.getTextuser().getText()); 
           if(user.getNewPassword().getPassword().length < 1){
               model.setPassword(model.getPassword());
           }else{
                model.setPassword(capturePass(user.getNewPassword()));
           }
        
           
          Boolean Result = model.updateUser();
          if(Result){
              String success = "You have succesfully modified the user "+user.getTextuser().getText();
              user.getComment().setText(success);
              user.getComment().setForeground(Color.BLACK);
               user.dispose();
            user.setVisible(false);
            model.setId(0);
            model.setPhone(0);
            vUser = new Vuser(principal, true);
            vUser.setControllerUsers(this);
            this.Tolist(1);
            vUser.setVisible(true);
          }else{
              String err = "You didn't modified the user, "+user.getTextuser().getText()+" check.";
              user.getComment().setText(err);
              user.getComment().setForeground(Color.RED);
          }
            
        }else if(model.getId() < 1){
            model.setIdentificationEmployee(employeeModel.getIdemployee());
            model.setPassword(capturePass(user.getPassword()));
            model.setUser(user.getTextuser().getText());
            
            boolean result = model.insertUser();
            if(result){
                String success = "User succesfully registered "+user.getTextuser().getText();
                user.getComment().setText(success);
                user.setVisible(false);
            model.setId(0);
            model.setPhone(0);
            vUser = new Vuser(principal, true);
            vUser.setControllerUsers(this);
            this.Tolist(1);
            vUser.setVisible(true);
            }else{
                 String err = "User didn't registered, "+user.getTextuser().getText()+" Check.";
              user.getComment().setText(err);
              user.getComment().setForeground(Color.RED);
            }
        }
    }
    private String capturePass(JPasswordField pass){
        String password;
          int count = pass.getPassword().length;
            String against = "";
            char[] with = pass.getPassword();
            for(int i = 0; i< count; i++){
                against = against+with[i];
            }
           password = DigestUtils.shaHex(against);
        return password;
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        Object keyEvent = ke.getSource();
        if(keyEvent.equals(vUser.getTableUser())){
            char b = ke.getKeyChar();
            if(vUser.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        Object origin = ke.getSource();
        if(origin.equals(vUser.getTextSearch())){
            String search = vUser.getTextSearch().getText();
            Listsearch(search,vUser.getTableUser());
        }else if(origin.equals(employee.getTextSearch())){
            String search = employee.getTextSearch().getText();
            Listsearch(search,employee.getEmployeeTable());
        }else if(origin.equals(user.getPassword())){
            char against[] = user.getPassword().getPassword();
            String password = "";
            for(int i = 0; i<against.length; i++){
              password += ""+against[i];
            }
           password = DigestUtils.shaHex(password);
            
           if(password.equals(model.getPassword())){
               user.getNewPassword().setEnabled(true);
           }else{
               user.getNewPassword().setEnabled(false);
           }
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Object mouseEvent = me.getSource();
        if(mouseEvent.equals(vUser.getTableUser())){
            if (me.getClickCount() == 2) {
            try{
                int row = vUser.getTableUser().getSelectedRow();
                int row1 = vUser.getTableUser().convertRowIndexToModel(row);
                DefaultTableModel tableModel=(DefaultTableModel) vUser.getTableUser().getModel();
                long capture = Long.parseLong((String)tableModel.getValueAt(row1, 0));
                captureData(capture,"user");
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(mouseEvent.equals(employee.getEmployeeTable())){
              if (me.getClickCount() == 2) {
            try{
                int row = employee.getEmployeeTable().getSelectedRow();
                int row1 = employee.getEmployeeTable().convertRowIndexToModel(row);
                DefaultTableModel tableModel=(DefaultTableModel) employee.getEmployeeTable().getModel();
                long capture = Long.parseLong((String) tableModel.getValueAt(row1, 0));
                captureData(capture,"employee");
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }
       
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    public User getModel(){
        return model;
    }
    
}
