/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Jnatn'h
 */
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
        String[][] information =  model.consultList();
        personlist.getCatperson().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Type","Name","Last Name","Phone"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    personlist.getCatperson().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void Searhlist(String consulta, JTable JTableBuscar){
     
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

    public void Capturedata(long phone,String type){
           if(type.equals("Employee")){
           boolean found = model.consultModel(phone);
           if (found){
                personlist.dispose ();
                personlist.setVisible(false);
                vperson = new Rperson(principal,true); 
                vperson.getId().setText(String.valueOf(model.getId()));
                vperson.getId().setEnabled(false);
                vperson.getNamee().setText(model.getName());
                vperson.getLastname().setText(model.getLastname());
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
                    vperson.getPrint().setVisible(false);
                    vperson.setController(this);
                    vperson.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","Person",JOptionPane.INFORMATION_MESSAGE);
            }
           }else if(type.equals("Client")){
           boolean found = model.consultModel(phone);
           if (found){
                personlist.dispose ();
                personlist.setVisible(false);
                vperson = new Rperson(principal,true); 
                vperson.getId().setText(String.valueOf(model.getId()));
                vperson.getId().setEnabled(false);
                vperson.getNamee().setText(model.getName());
                vperson.getLastname().setText(model.getLastname());
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
                    vperson.getPrint().setVisible(false);
                    vperson.setController(this);
                    vperson.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","Person",JOptionPane.INFORMATION_MESSAGE);
            }
           }
           
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        if(evento.equals(personlist.getNuevo())){
            personlist.setVisible(false);
            personlist.dispose();
            model.setId(0);
            vperson = new Rperson(principal,true);        
            vperson.getDelete().setVisible(false);
            vperson.getPrint().setVisible(false);
            vperson.setController(this);
            vperson.setVisible(true);
        }else if(evento.equals(vperson.getExit())){
            vperson.setVisible(false);
            vperson.dispose();
            personlist = new Vperson(principal,true);
            personlist.setController(this);
            model.setId(0);
            this.Tolist();
            personlist.setVisible(true);
        }else if(evento.equals(vperson.getGrabar())){
            this.validate();
        }else if(evento.equals(vperson.getDelete())){
            
            int opc = JOptionPane.showConfirmDialog(principal, "Confirm elimination", "Delete Person", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(opc != 0){
                
            }else{
               boolean dele = model.delete();
                if(dele){
                    vperson.dispose();
                    vperson.setVisible(false);
                    personlist = new Vperson(principal,true);
            personlist.setController(this);
            this.Tolist();
            personlist.setVisible(true);
                }else{
                    String leyenda = "The person could not be deleted";
                    vperson.getLeyenda().setText(leyenda);
                    vperson.getLeyenda().setForeground(Color.RED);
                } 
            }
            
        }
    }
    private void validate(){
         if (vperson.getTypeperson().getSelectedItem().equals("Select")) {
               String leyenda = "Check the type of person selection";
               vperson.getLeyenda().setText(leyenda);
               vperson.getLeyenda().setForeground(Color.RED);
             }else if(vperson.getNamee().getText().length() < 2){
                    String leyenda = "Verify that the name is not empty and that it contains no less than  2 characters";
                    vperson.getLeyenda().setText(leyenda);
                    vperson.getLeyenda().setForeground(Color.RED);
            }else if(vperson.getLastname().getText().length() < 2){
                    String leyenda = "Verify that the surname is not empty and that it does not contain less than 2 characters";
                    vperson.getLeyenda().setText(leyenda);
                    vperson.getLeyenda().setForeground(Color.RED);
                    vperson.getLastname().setFocusable(true);
            }else if(!vperson.getGender().isSelected(vperson.getMan().getModel()) && !vperson.getGender().isSelected(vperson.getWom().getModel())){
                String leyenda = "You must select a gender";
                vperson.getLeyenda().setText(leyenda);
                vperson.getMan().setFocusable(true);
            }else if(vperson.getPhone().getText().trim().length() < 7){
                    String leyenda = "Verify the phone number";
                    vperson.getLeyenda().setText(leyenda);
                    vperson.getLeyenda().setForeground(Color.RED);
                   
            }else{
                record();
            }
    }
    private void record(){
        String name = vperson.getNamee().getText();
        String lastname = vperson.getLastname().getText();
        if(model.getId() != 0){
                       

                if(vperson.getTypeperson().getSelectedItem().equals("Employee")){
                    employee.setPhone(Long.parseLong(vperson.getPhone().getText().trim()));
                    employee.setTypeperson(vperson.getTypeperson().getSelectedItem().toString());
                    employee.setName(vperson.getNamee().getText());
                    employee.setLastname(vperson.getLastname().getText());
                    employee.setGender(capturegender().charAt(0));
                    employee.setId(model.getId());
                    boolean update = employee.update();
                    if(update){
                        String leyend = "Has succesfully modified "+name + " "+lastname;
                        vperson.getLeyenda().setText(leyend);
                    }else{
                         String leyend = "it has successfully modified "+name + " "+lastname + ", Please check";
                        vperson.getLeyenda().setText(leyend);
                        vperson.getLeyenda().setForeground(Color.RED);
                    }
                }else if(vperson.getTypeperson().getSelectedItem().equals("Client")){
                    client.setPhone(Long.parseLong(vperson.getPhone().getText().trim()));
                    client.setTypeperson(vperson.getTypeperson().getSelectedItem().toString());
                    client.setName(vperson.getNamee().getText());
                    client.setLastname(vperson.getLastname().getText());
                    client.setGender(capturegender().charAt(0));
                    client.setId(model.getId());
                    boolean update = client.update();
                    if(update){
                        String leyend = "Has succesfully modified "+name + " "+lastname;
                        vperson.getLeyenda().setText(leyend);
                    }else{
                         String leyend = "it has successfully modified "+name + " "+lastname + ", Please check";
                        vperson.getLeyenda().setText(leyend);
                        vperson.getLeyenda().setForeground(Color.RED);
                    }
                }
            
            
                
        }else if(model.getId() < 1 ){
           
            if(vperson.getTypeperson().getSelectedItem().equals("Employee")){
                employee.setPhone(Long.parseLong(vperson.getPhone().getText().trim()));
                employee.setName(vperson.getNamee().getText());
                employee.setLastname(vperson.getLastname().getText());
                employee.setGender(capturegender().charAt(0));
                employee.setTypeperson(vperson.getTypeperson().getSelectedItem().toString());
                boolean validephone = employee.validatephone();
                if(validephone){
                    String leyend  = "The phone number already has another person can not have two identical.";
                    vperson.getLeyenda().setText(leyend);
                }else{
                    
                
                boolean update = employee.insert();
                if(update){
                    String leyend = "You have succesfully registered to "+name + " "+lastname;
                    vperson.getLeyenda().setText(leyend);
                }else{
                     String leyend = "Could not register to "+name + " "+lastname + ", Please check. ";
                    vperson.getLeyenda().setText(leyend);
                    vperson.getLeyenda().setForeground(Color.RED);
                }
            }
            }else if(vperson.getTypeperson().getSelectedItem().equals("Client")){
                client.setPhone(Long.parseLong(vperson.getPhone().getText().trim()));
                client.setName(vperson.getNamee().getText());
                client.setLastname(vperson.getLastname().getText());
                client.setGender(capturegender().charAt(0));
                client.setTypeperson(vperson.getTypeperson().getSelectedItem().toString());
                boolean validephone = client.validatephone();
                if(validephone){
                    String leyend  = "The phone number already has another person can not have two identical.";
                    vperson.getLeyenda().setText(leyend);
                }else{
                    
                
                boolean update = client.insertarClient();
                if(update){
                    String leyend = "You have succesfully registered to "+name + " "+lastname;
                    vperson.getLeyenda().setText(leyend);
                }else{
                     String leyend = "Could not register to "+name + " "+lastname + ", Please check. ";
                    vperson.getLeyenda().setText(leyend);
                    vperson.getLeyenda().setForeground(Color.RED);
                }
            }
            }
                
        }
    }
    private String capturegender(){
         String sexo = null;
         
          for (Enumeration<AbstractButton > buttons = vperson.getGender().getElements(); buttons.hasMoreElements();)
            {
                   AbstractButton button = buttons.nextElement();
                  if(button.isSelected())
                    {
                       sexo = button.getText();

                   }
             } 
          return sexo;
     }
    @Override
    public void mouseClicked(MouseEvent me) {
       Object Mevent = me.getSource();
        if(Mevent.equals(personlist.getCatperson())){
            if (me.getClickCount() == 2) {
            try{
                int fila = personlist.getCatperson().getSelectedRow();
                int fila1 = personlist.getCatperson().convertRowIndexToModel(fila);
                DefaultTableModel modelotabla=(DefaultTableModel) personlist.getCatperson().getModel();
                Long captura = Long.parseLong((String)modelotabla.getValueAt(fila1, 3));
                String type = (String) modelotabla.getValueAt(fila1,0);
                Capturedata(captura,type);
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
          Object kevent = ke.getSource();
        if(kevent.equals(personlist.getCatperson())){
            char b = ke.getKeyChar();
            if(personlist.getTextsearch().getText().length()>50){
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
        if(origin.equals(personlist.getTextsearch())){
            String busqueda = personlist.getTextsearch().getText();
            Searhlist(busqueda,personlist.getCatperson());
        }
    }
    
}
