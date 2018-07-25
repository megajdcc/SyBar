/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.Rclient;
import View.Principal;
import Model.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import View.Vperson;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
/**
 *
 * @author Jnatn'h
 */
public class ControllerClient implements ActionListener, KeyListener, MouseListener{
    
    
    DefaultTableModel dm;
    private Vperson person;
    private final Client model;
    private Rclient client;
    private Principal principal;
    private boolean ofmeeting = false;

    public ControllerClient(Vperson person){
        
        this.person = person;
        model = new Client();
        
        Tolist();
    }
    public ControllerClient(Rclient client, Vperson person){
        ofmeeting = true;
        this.person = person;
        this.client = client;
        model = new Client();
        client = new Rclient(principal, true);
        Tolist();
    }
    private void Tolist(){
        String[][] informacion =  model.consultList();
        person.getCatperson().setModel(new javax.swing.table.DefaultTableModel(
        informacion,
        new String [] {"Phone","Name","Last Name"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    person.getCatperson().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void Searchlist(String consulta, JTable JTableBuscar){
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void capturedata(long phone){
           boolean encontrado = model.consultModel(phone);
           if (encontrado){
                person.dispose();
                person.setVisible(false);
                client = new Rclient(principal, true);
                client.getPhone().setText(String.valueOf(model.getPhone()));
                client.getPhone().setEnabled(false);
                client.getNamee().setText(model.getName());
                client.getLastname().setText(model.getLastname());
                client.getMail().setText(model.getEmail());
                client.getId().setText(String.valueOf(model.getId()));
                char gender = model.getGender();
                if(gender == 'F'){
                    client.getWom().setSelected(true);
                }else if(gender == 'M'){
                    client.getMan().setSelected(true);
                }    
                    client.getDelete().setEnabled(true);
                    client.getDelete().setVisible(true);
                    client.getPrint().setVisible(false);
                    client.setController(this);
                    client.setVisible(true);
               }else{
                JOptionPane.showMessageDialog(principal,"Record not found","Client",JOptionPane.INFORMATION_MESSAGE);
            }
       }
    private String capturargender(ButtonGroup bton){
         String sexo = null;
          for(Enumeration<AbstractButton > buttons = bton.getElements(); buttons.hasMoreElements();){
                   AbstractButton button = buttons.nextElement();
                  if(button.isSelected()){
                       sexo = button.getText();
                   }
            } 
          return sexo;
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        if(evento.equals(person.getNuevo())){
            person.dispose();
            person.setVisible(false);
            
            client = new Rclient(principal,true);
            model.setPhone(0);
            client.getPrint().setVisible(false);
            client.getDelete().setVisible(false);
            client.setController(this);
            client.setVisible(true);
        }else if(evento.equals(client.getExit())){
            
           
            if(ofmeeting){
                client.dispose();
                client.setVisible(false);
                
            }else{
                client.dispose();
                client.setVisible(false);
            
                person = new Vperson(principal,true);
                ImageIcon iconp = new ImageIcon(getClass().getResource("/View/img/header/Client.png"));
                person.getHeader().setIcon(iconp);
                person.setController(this);
                model.setPhone(0);
                this.Tolist();
                person.setVisible(true); 
            }  
        }else if(evento.equals(client.getDelete())){
            this.delete();
        }else if(evento.equals(client.getGrabar())){
            validate();
        }
    }
    private void validate(){
        String phon = client.getPhone().getText().trim();
            if(phon.length() < 7){
                    String leyenda = "verify the phone number";
                    client.getLeyenda().setText(leyenda);
                    client.getLeyenda().setForeground(Color.RED);    
            }else if(client.getNamee().getText().length() < 2){
                    String leyenda = "Verify that the name is not empty and that it contains no less tahn 2 character";
                    client.getLeyenda().setText(leyenda);
                    client.getLeyenda().setForeground(Color.RED);
            }else if(client.getLastname().getText().length() < 2){
                    String leyenda = "Verify that the last name is not empty and that it contains no less tahn 2 character";
                    client.getLeyenda().setText(leyenda);
                    client.getLeyenda().setForeground(Color.RED);
                    client.getLastname().setFocusable(true);
            }else if(!client.getGender().isSelected(client.getMan().getModel()) && !client.getGender().isSelected(client.getWom().getModel())){
                String leyenda = "you must select a gender";
                client.getLeyenda().setText(leyenda);
                client.getMan().setFocusable(true);
            }else if(model.getPhone() < 1 && model.validatephone(Long.parseLong(client.getPhone().getText()))){
                    String leyenda = "This phone number has another client";
                    client.getLeyenda().setText(leyenda);
                    client.getMan().setFocusable(true);
            }else{
                
                
             this.record();
            }
    }
    private void record(){
        if(model.getPhone() > 0){
            model.setPhone(Long.parseLong(client.getPhone().getText().trim()));
            model.setName(client.getNamee().getText());
            model.setLastname(client.getLastname().getText());
            model.setGender(capturargender(client.getGender()).charAt(0));
          
            model.setEmail(client.getMail().getText());
            
            if(!client.getMail().getText().contains("@")){
                 String leyend = "Please enter a valid email";
                client.getLeyenda().setText(leyend);
                client.getMail().setFocusable(true);
               
            }else{
                boolean result = model.updateClient();
            if(result){
                String leyend = "Has succesfully modified the client "+model.getName();
                client.getLeyenda().setText(leyend);
            }else{
                 String leyend = "Has not succesfully modified the client"+model.getName();
                client.getLeyenda().setText(leyend);
            }
            }
            
        }else if(model.getPhone() < 1){
            model.setPhone(Long.parseLong(client.getPhone().getText().trim()));
            model.setName(client.getNamee().getText());
            model.setLastname(client.getLastname().getText());
            model.setGender(capturargender(client.getGender()).charAt(0));
            
            model.setEmail(client.getMail().getText());
            if(!client.getMail().getText().contains("@")){
                 String leyend = "Please enter a valid email";
                client.getLeyenda().setText(leyend);
                client.getMail().setFocusable(true);
               
            }else{
                boolean result = model.insertarClient();
                if(result){
                    String leyend = "Has succesfully registered the client "+model.getName();
                    client.getLeyenda().setText(leyend);
                }else{
                     String leyend = "Has not succesfully registered the client "+model.getName();
                    client.getLeyenda().setText(leyend);
                }
            }
            
        }else{
             String leyend = "Can not register please check and get int touch with the developer";
            client.getLeyenda().setText(leyend);
        }
    }
   
    private void delete(){
        boolean result = model.deleteClient();
        if(result){
             client.dispose();
            client.setVisible(false);
            
            person = new Vperson(principal,true);
             ImageIcon iconp = new ImageIcon(getClass().getResource("/View/img/header/Client.png"));
            person.getHeader().setIcon(iconp);
            person.setController(this);
            model.setPhone(0);
            this.Tolist();
            person.setVisible(true);
        }else{
            String leyend = "the client could not be deleted";
            client.getLeyenda().setText(leyend);
        }
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        Object kevent = ke.getSource();
        if(kevent.equals(person.getCatperson())){
            char b = ke.getKeyChar();
            if(person.getTextsearch().getText().length()>50){
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
        if(origin.equals(person.getTextsearch())){
            String search = person.getTextsearch().getText();
            Searchlist(search,person.getCatperson());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    Object Mevent = me.getSource();
        if(Mevent.equals(person.getCatperson())){
            if (me.getClickCount() == 2) {
            try{
                int row = person.getCatperson().getSelectedRow();
                int row1 = person.getCatperson().convertRowIndexToModel(row);
                DefaultTableModel tablemodel=(DefaultTableModel) person.getCatperson().getModel();
                Long capture = Long.parseLong((String)tablemodel.getValueAt(row1, 0));
                capturedata(capture);
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
}
