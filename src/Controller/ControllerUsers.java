/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Jnatn'h
 */
public class ControllerUsers implements ActionListener, KeyListener,MouseListener{
    
    DefaultTableModel dm;
    private Vuser list; 
    private User model;
    private Employee modelemployee;
    private Ruser use;
    private Principal principal;
    private Ruser user;
    private String name;
    private Vemployee employee;
    //Contruct of Class...
    public ControllerUsers(Vuser catalogo){
        this.list = catalogo;
        model = new User();
        modelemployee = new Employee();
        user = new Ruser(principal, true);
        
        employee = new Vemployee(principal,true);
        this.Tolist(1);
    }
    
    public ControllerUsers(Ruser use){
        this.use = user;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();

        
        if(evento.equals(list.getNuevo())){
            list.setVisible(false);
           
            user.getDelete().setEnabled(false);
            user.getDelete().setVisible(false);
            user.getPrint().setVisible(false);
            user.getLabelnewpass().setVisible(false);
            user.getNewpassword().setVisible(false);
            user.setController(this);
            user.getPassword().removeKeyListener(this);
            user.setVisible(true);
            list.setVisible(false);
        }else if(evento.equals(user.getExituser())){
            user.setVisible(false);
            user.dispose();
            list = new Vuser(principal,true);
            list.setVisible(true);
        }else if(evento.equals(user.getGrabar())){
            this.validate();
        }else if(evento.equals(user.getBuscperson())){
            employee.setController(this);
            this.Tolist(2);
            employee.getNuevo().setEnabled(false);
            employee.setVisible(true);
        }else if(evento.equals(user.getDelete())){
            this.delete();
        }  
    }
    private void delete(){
        int opc = JOptionPane.showConfirmDialog(principal,"Be sure to eliminate the user"+user.getTextuser().getText(), "Delete user",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(opc <1){
            boolean result = model.deleteUser();
        if(result){
           
            user.dispose();
            user.setVisible(false);
            
            list = new Vuser(principal, true);
            list.setController(this);
            this.Tolist(1);
            list.setVisible(true);
            
        }else{
            String leyend = "The user could not be deleted";
            user.getLeyenda().setText(leyend);
        }
        }
        
    }
    
    private void Tolist(int donde){
        if(donde == 1){
             String[][] information =  model.consultList();
        list.getCatusers().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Phone","Name","Users"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    list.getCatusers().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }else if(donde == 2){
            String[][] information =  modelemployee.consultList();
            employee.getCatemployee().setModel(new javax.swing.table.DefaultTableModel(
            information,
            new String [] {"Phone","Name","Last Name"}) {
            boolean[] canEdit = new boolean [] {
                false,false,false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
    });
        employee.getCatemployee().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
       
    }
    public void Listsearch(String consulta, JTable JTableBuscar){
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void Capturedata(long phone, String opc){
//           this.name = name;
           if(opc.equals("catuser")){
           boolean found = model.consultModel(phone);
           if (found){
                list.dispose();
                list.setVisible(false);
                
                user.getTextuser().setText(model.getUser());
                user.getId().setText(String.valueOf(model.getId()));
                user.getNamee().setText(model.getName());
                user.getLastname().setText(model.getLastname());
               
                user.getNewpassword().setEnabled(false);
                user.getPassword().addKeyListener(this);
                user.getDelete().setEnabled(true);
                user.getDelete().setVisible(true);
                user.getPrint().setVisible(false);
                user.getBuscperson().setEnabled(false);
                user.setController(this);
                user.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","User",JOptionPane.INFORMATION_MESSAGE);
            }
           }else if(opc.equals("catemployee")){
               boolean found = modelemployee.consultModel(phone);
           if (found){
               employee.setVisible(false);
               employee.dispose();
               
               user.getId().setText(String.valueOf(modelemployee.getIdemployee()));
               user.getNamee().setText(modelemployee.getName());
               user.getLastname().setText(modelemployee.getLastname());
               
                        
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","User",JOptionPane.INFORMATION_MESSAGE);
            }
           }
       }

    private void validate(){
         if (user.getTextuser().getText().isEmpty()) {
               String leyend = "I could not register an empty user";
               user.getLeyenda().setText(leyend);
               user.getLeyenda().setForeground(Color.RED);
             }else if(user.getPassword().getPassword().length < 1){
                 String leyend = "¡You can not register multiple spaces in whites o behalf of user or in password";
                    user.getLeyenda().setText(leyend);
                    user.getLeyenda().setForeground(Color.ORANGE);
            }else if(user.getTextuser().getText().length() < 4){
                String leyend = "Make sure that the username fields are not less than 4 characters!";
                user.getLeyenda().setText(leyend);
                user.getLeyenda().setForeground(Color.ORANGE);
            }else if(user.getPassword().getPassword().length < 5){
                String leyend = "Make sure that the password fields are not less than 4 characters!";
                user.getLeyenda().setText(leyend);
                user.getLeyenda().setForeground(Color.ORANGE);
            }else if(user.getId().getText().isEmpty()){
                String leyend = "You can not register or modify a user if it is not associated with any employee";
                user.getLeyenda().setText(leyend);
                user.getBuscperson().setFocusable(true);
            }else{
                record();
            }
    }
    private void record(){
        if(model.getId()!=0){
           model.setUser(user.getTextuser().getText()); 
           if(user.getNewpassword().getPassword().length < 1){
               model.setPassword(model.getPassword());
           }else{
                model.setPassword(capturepass(user.getNewpassword()));
           }
        
           
          Boolean Result = model.updateUser();
          if(Result){
              String leyend = "You have succesfully modified the user "+user.getTextuser().getText();
              user.getLeyenda().setText(leyend);
              user.getLeyenda().setForeground(Color.BLACK);
               user.dispose();
            user.setVisible(false);
            model.setId(0);
            model.setPhone(0);
            list = new Vuser(principal, true);
            list.setController(this);
            this.Tolist(1);
            list.setVisible(true);
          }else{
              String leyend = "You have not succesfully modified the user, "+user.getTextuser().getText()+" check.";
              user.getLeyenda().setText(leyend);
              user.getLeyenda().setForeground(Color.RED);
          }
            
        }else if(model.getId() < 1){
            model.setIdentificationemployee(modelemployee.getIdemployee());
            model.setPassword(capturepass(user.getPassword()));
            model.setUser(user.getTextuser().getText());
            
            boolean result = model.insertUser();
            if(result){
                String leyend = "He has succesfully registered "+user.getTextuser().getText();
                user.getLeyenda().setText(leyend);
                user.setVisible(false);
            model.setId(0);
            model.setPhone(0);
            list = new Vuser(principal, true);
            list.setController(this);
            this.Tolist(1);
            list.setVisible(true);
            }else{
                 String leyend = "You have no succesfully registered, "+user.getTextuser().getText()+" Check.";
              user.getLeyenda().setText(leyend);
              user.getLeyenda().setForeground(Color.RED);
            }
        }
    }
    private String capturepass(JPasswordField pass){
        String passs;
          int cant = pass.getPassword().length;
            String contra = "";
            char[] con = pass.getPassword();
            for(int i = 0; i< cant; i++){
                contra = contra+con[i];
            }
           passs = DigestUtils.sha1Hex(contra);
        return passs;
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        Object kevent = ke.getSource();
        if(kevent.equals(list.getCatusers())){
            char b = ke.getKeyChar();
            if(list.getTextbusqueda().getText().length()>50){
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
        if(origin.equals(list.getTextbusqueda())){
            String busqueda = list.getTextbusqueda().getText();
            Listsearch(busqueda,list.getCatusers());
        }else if(origin.equals(employee.getTextbusqueda())){
            String busqueda = employee.getTextbusqueda().getText();
            Listsearch(busqueda,employee.getCatemployee());
        }else if(origin.equals(user.getPassword())){
            char contra[] = user.getPassword().getPassword();
            String password = "";
            for(int i = 0; i<contra.length; i++){
              password += ""+contra[i];
            }
           password = DigestUtils.sha1Hex(password);
            
           if(password.equals(model.getPassword())){
               user.getNewpassword().setEnabled(true);
           }else{
               user.getNewpassword().setEnabled(false);
           }
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Object Mevent = me.getSource();
        if(Mevent.equals(list.getCatusers())){
            if (me.getClickCount() == 2) {
            try{
                int row = list.getCatusers().getSelectedRow();
                int row1 = list.getCatusers().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) list.getCatusers().getModel();
                long captura = Long.parseLong((String)modelotabla.getValueAt(row1, 0));
                Capturedata(captura,"catuser");
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(Mevent.equals(employee.getCatemployee())){
              if (me.getClickCount() == 2) {
            try{
                int row = employee.getCatemployee().getSelectedRow();
                int row1 = employee.getCatemployee().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) employee.getCatemployee().getModel();
                long captura = Long.parseLong((String) modelotabla.getValueAt(row1, 0));
                Capturedata(captura,"catemployee");
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
