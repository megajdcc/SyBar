
package Controller;

import View.Principal;
import View.Rperson;
import View.Vperson;
import java.awt.event.*;
import Model.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ControllerPerson implements ActionListener, KeyListener, MouseListener{
    DefaultTableModel dm;
    private Vperson personlist; 
    
    private Rperson vperson;
    private final Person model;
    private Employee employee;
    private Client client; 
    private Principal principal;
    private String name;
    
    public ControllerPerson(Vperson person){
        this.personlist = person;
        model = new Person();
        employee = new Employee();
        client = new Client();
        
        this.Tolist();
    }
    
    public Person getModel(){
        return model;
    }
    private void Tolist(){
        String[][] info =  model.resultList();
        personlist.getTablePerson().setModel(new javax.swing.table.DefaultTableModel(
        info,
        new String [] {"Type","Name","Last Name","Phone"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    personlist.getTablePerson().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void Searhlist(String query, JTable jTableSearch){
     
        dm = (DefaultTableModel) jTableSearch.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        jTableSearch.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public void captureData(long phone,String type){
           if(type.equals("Employee")){
           boolean found = model.matchingModel(phone);
           if (found){
                personlist.dispose ();
                personlist.setVisible(false);
                vperson = new Rperson(principal,true); 
                vperson.getId().setText(String.valueOf(model.getId()));
                vperson.getId().setEnabled(false);
                vperson.getNameP().setText(model.getName());
                vperson.getLastName().setText(model.getLastname());
                vperson.getPhone().setText(String.valueOf(model.getPhone()));
                vperson.getTypeperson().setSelectedItem(model.getTypeperson());
                vperson.getTypeperson().setEnabled(false);
                char gender = model.getGender();
                if(gender == 'F'){
                    vperson.getWom().setSelected(true);
                }else if(gender == 'M'){
                    vperson.getMan().setSelected(true);
                }
                
                    vperson.getDelete().setEnabled(true);
                    vperson.getDelete().setVisible(true);
                    vperson.setControllerPerson(this);
                    vperson.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","Person",JOptionPane.INFORMATION_MESSAGE);
            }
           }else if(type.equals("Client")){
           boolean found = model.matchingModel(phone);
           if (found){
                personlist.dispose ();
                personlist.setVisible(false);
                vperson = new Rperson(principal,true); 
                vperson.getId().setText(String.valueOf(model.getId()));
                vperson.getId().setEnabled(false);
                vperson.getNameP().setText(model.getName());
                vperson.getLastName().setText(model.getLastname());
                vperson.getPhone().setText(String.valueOf(model.getPhone()));
                vperson.getTypeperson().setSelectedItem(model.getTypeperson());
                vperson.getTypeperson().setEnabled(false);
                char gender = model.getGender();
                if(gender == 'F'){
                    vperson.getWom().setSelected(true);
                }else if(gender == 'M'){
                    vperson.getMan().setSelected(true);
                }
                
                    vperson.getDelete().setEnabled(true);
                    vperson.getDelete().setVisible(true);
                    vperson.setControllerPerson(this);
                    vperson.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","Person",JOptionPane.INFORMATION_MESSAGE);
            }
           }
           
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object event = ae.getSource();
        if(event.equals(personlist.getNewPerson())){
            personlist.setVisible(false);
            personlist.dispose();
            model.setId(0);
            vperson = new Rperson(principal,true);        
            vperson.getDelete().setVisible(false);
            vperson.setControllerPerson(this);
            vperson.setVisible(true);
        }else if(event.equals(vperson.getExit())){
            vperson.setVisible(false);
            vperson.dispose();
            personlist = new Vperson(principal,true);
            personlist.setControllerPerson(this);
            model.setId(0);
            this.Tolist();
            personlist.setVisible(true);
        }else if(event.equals(vperson.getRegister())){
            this.validate();
        }else if(event.equals(vperson.getDelete())){
            
            int opt = JOptionPane.showConfirmDialog(principal, "Confirm elimination", "Delete Person", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(opt != 0){
                
            }else{
               boolean del = model.delete();
                if(del){
                    vperson.dispose();
                    vperson.setVisible(false);
                    personlist = new Vperson(principal,true);
            personlist.setControllerPerson(this);
            this.Tolist();
            personlist.setVisible(true);
                }else{
                    String err = "The person could not be deleted";
                    vperson.getComment().setText(err);
                    vperson.getComment().setForeground(Color.RED);
                } 
            }
            
        }
    }
    private void validate(){
         if (vperson.getTypeperson().getSelectedItem().equals("Select")) {
               String err = "Check the type of person selection";
               vperson.getComment().setText(err);
               vperson.getComment().setForeground(Color.RED);
             }else if(vperson.getNameP().getText().length() < 2){
                    String err = "Verify that the name is not empty and that it contains no less than  2 characters";
                    vperson.getComment().setText(err);
                    vperson.getComment().setForeground(Color.RED);
            }else if(vperson.getLastName().getText().length() < 2){
                    String err = "Verify that the surname is not empty and that it does not contain less than 2 characters";
                    vperson.getComment().setText(err);
                    vperson.getComment().setForeground(Color.RED);
                    vperson.getLastName().setFocusable(true);
            }else if(!vperson.getGender().isSelected(vperson.getMan().getModel()) && !vperson.getGender().isSelected(vperson.getWom().getModel())){
                String err = "You must select a gender";
                vperson.getComment().setText(err);
                vperson.getMan().setFocusable(true);
            }else if(vperson.getPhone().getText().trim().length() < 7){
                    String err = "Verify the phone number";
                    vperson.getComment().setText(err);
                    vperson.getComment().setForeground(Color.RED);
                   
            }else{
                record();
            }
    }
    private void record(){
        String name = vperson.getNameP().getText();
        String lastname = vperson.getLastName().getText();
        if(model.getId() != 0){
                       

                if(vperson.getTypeperson().getSelectedItem().equals("Employee")){
                    employee.setPhone(Long.parseLong(vperson.getPhone().getText().trim()));
                    employee.setTypeperson(vperson.getTypeperson().getSelectedItem().toString());
                    employee.setName(vperson.getNameP().getText());
                    employee.setLastname(vperson.getLastName().getText());
                    employee.setGender(captureGender().charAt(0));
                    employee.setId(model.getId());
                    boolean update = employee.update();
                    if(update){
                        String success = "Has succesfully modified "+name + " "+lastname;
                        vperson.getComment().setText(success);
                    }else{
                         String err = "Not modified "+name + " "+lastname + ", Please check";
                        vperson.getComment().setText(err);
                        vperson.getComment().setForeground(Color.RED);
                    }
                }else if(vperson.getTypeperson().getSelectedItem().equals("Client")){
                    client.setPhone(Long.parseLong(vperson.getPhone().getText().trim()));
                    client.setTypeperson(vperson.getTypeperson().getSelectedItem().toString());
                    client.setName(vperson.getNameP().getText());
                    client.setLastname(vperson.getLastName().getText());
                    client.setGender(captureGender().charAt(0));
                    client.setId(model.getId());
                    boolean update = client.update();
                    if(update){
                        String success = "Has succesfully modified "+name + " "+lastname;
                        vperson.getComment().setText(success);
                    }else{
                         String err = "Not modified "+name + " "+lastname + ", Please check";
                        vperson.getComment().setText(err);
                        vperson.getComment().setForeground(Color.RED);
                    }
                }
            
            
                
        }else if(model.getId() < 1 ){
           
            if(vperson.getTypeperson().getSelectedItem().equals("Employee")){
                employee.setPhone(Long.parseLong(vperson.getPhone().getText().trim()));
                employee.setName(vperson.getNameP().getText());
                employee.setLastname(vperson.getLastName().getText());
                employee.setGender(captureGender().charAt(0));
                employee.setTypeperson(vperson.getTypeperson().getSelectedItem().toString());
                boolean verifyPhone = employee.phoneVerification();
                if(verifyPhone){
                    String err  = "The phone number already has another person can not have two identical.";
                    vperson.getComment().setText(err);
                }else{
                    
                
                boolean update = employee.insert();
                if(update){
                    String success = "You have succesfully registered to "+name + " "+lastname;
                    vperson.getComment().setText(success);
                }else{
                     String err = "Could not register to "+name + " "+lastname + ", Please check. ";
                    vperson.getComment().setText(err);
                    vperson.getComment().setForeground(Color.RED);
                }
            }
            }else if(vperson.getTypeperson().getSelectedItem().equals("Client")){
                client.setPhone(Long.parseLong(vperson.getPhone().getText().trim()));
                client.setName(vperson.getNameP().getText());
                client.setLastname(vperson.getLastName().getText());
                client.setGender(captureGender().charAt(0));
                client.setTypeperson(vperson.getTypeperson().getSelectedItem().toString());
                boolean verifyPhone = client.phoneVerification();
                if(verifyPhone){
                    String err  = "The phone number already has another person can not have two identical.";
                    vperson.getComment().setText(err);
                }else{
                    
                
                boolean update = client.insertClient();
                if(update){
                    String success = "You have succesfully registered to "+name + " "+lastname;
                    vperson.getComment().setText(success);
                }else{
                     String err = "Could not register to "+name + " "+lastname + ", Please check. ";
                    vperson.getComment().setText(err);
                    vperson.getComment().setForeground(Color.RED);
                }
            }
            }
                
        }
    }
    private String captureGender(){
         String gender = null;
         
          for (Enumeration<AbstractButton > buttons = vperson.getGender().getElements(); buttons.hasMoreElements();)
            {
                   AbstractButton button = buttons.nextElement();
                  if(button.isSelected())
                    {
                       gender = button.getText();

                   }
             } 
          return gender;
     }
    @Override
    public void mouseClicked(MouseEvent me) {
       Object mouseEvent = me.getSource();
        if(mouseEvent.equals(personlist.getTablePerson())){
            if (me.getClickCount() == 2) {
            try{
                int row = personlist.getTablePerson().getSelectedRow();
                int row1 = personlist.getTablePerson().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) personlist.getTablePerson().getModel();
                Long capture = Long.parseLong((String)modelotabla.getValueAt(row1, 3));
                String type = (String) modelotabla.getValueAt(row1,0);
                captureData(capture,type);
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

    @Override
    public void keyTyped(KeyEvent ke) {
          Object keyEvent = ke.getSource();
        if(keyEvent.equals(personlist.getTablePerson())){
            char b = ke.getKeyChar();
            if(personlist.getTextSearch().getText().length()>50){
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
        if(origin.equals(personlist.getTextSearch())){
            String search = personlist.getTextSearch().getText();
            Searhlist(search,personlist.getTablePerson());
        }
    }
    
}
