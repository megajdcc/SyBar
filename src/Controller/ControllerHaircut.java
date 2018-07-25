/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Vhaircut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Model.*;
import View.Principal;
import View.Rhaircut;
import java.awt.HeadlessException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Jnatn'h
 */

public class ControllerHaircut implements ActionListener, KeyListener, MouseListener{

    
    DefaultTableModel dm;
    private Vhaircut hair;
    private Rhaircut haircut;
    private Cut model;
    private Principal principal;
    public ControllerHaircut(Vhaircut hair){
        this.hair = hair;
        model = new Cut();
       
        this.Tolist();
    }
    private void Tolist(){
        String[][] informacion =  model.consultList();
        hair.getCathaircut().setModel(new javax.swing.table.DefaultTableModel(
        informacion,
        new String [] {"Style","Price","Gender"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    hair.getCathaircut().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void ListingSearch(String consulta, JTable JTableBuscar){
     
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void Capturedata(String name){
     
           boolean found = model.consultModel(name);
           if (found){
               hair.dispose();
               hair.setVisible(false);
                haircut = new Rhaircut(principal,true);
               haircut.getStyle().setText(model.getStile());
               haircut.getPrice().setText(String.valueOf(model.getPrice()));
               char gender = model.getGender();
               if(gender == 'F'){
                   haircut.getFemale().setSelected(true);
               }else{
                   haircut.getMale().setSelected(true);
               }
               haircut.getPrint2().setVisible(false);
               haircut.setController(this);
               haircut.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not dound","Haircut",JOptionPane.INFORMATION_MESSAGE);
            }
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        
        if(evento.equals(hair.getNew())){
            hair.dispose();
            hair.setVisible(false);
             haircut = new Rhaircut(principal,true);
            haircut.getPrint2().setVisible(false);
            haircut.setController(this);
            haircut.setVisible(true);
        }else if(evento.equals(haircut.getExit())){
            haircut.dispose();
            haircut.setVisible(false);
            
            hair = new Vhaircut(principal,true);
            hair.setController(this);
            Tolist();
            hair.setVisible(true);
        }else if(evento.equals(haircut.getGrabar())){
            this.record();
        }else if(evento.equals(haircut.getDelete())){
            this.delete();
        }
    }
    private void delete(){
        boolean result = model.deleteCut();
        if(result){
            haircut.dispose();
            haircut.setVisible(false);
            
            hair = new Vhaircut(principal,true);
            Tolist();
            hair.setVisible(true);
        }else{
             String leyend = "The type of cut has not been successfully eliminated";
             haircut.getLeyenda().setText(leyend);
        }
    }
    private void record(){
        boolean result = validate();
        if(result && model.getId() > 0){
            model.setStile(haircut.getStyle().getText());
            model.setPrice(Double.parseDouble(haircut.getPrice().getText()));
            model.setGender(capturegender(haircut.getGender()).charAt(0));
            
            boolean resultt = model.updateCut();
            if(resultt){
                String leyend = "the type of cut was succesfully modified";
                haircut.getLeyenda().setText(leyend);
            }else{
                String leyend = "the type of cut was succesfully not modified";
                haircut.getLeyenda().setText(leyend);
            }
            
        }else if(result && model.getId() < 1){
            model.setStile(haircut.getStyle().getText());
            model.setPrice(Double.parseDouble(haircut.getPrice().getText()));
            model.setGender(capturegender(haircut.getGender()).charAt(0));
             
           
            if(model.verifyStyle(haircut.getStyle().getText())){
             String leyend = "The style you are entering already exist verify";
             haircut.getLeyenda().setText(leyend);
            }else{
                 boolean resulttt = model.insertCut();
                if(resulttt){
                String leyend = "the type of cut has been succesfully registered";
                haircut.getLeyenda().setText(leyend);
                }else{
                String leyend = "the type of cut has not been succesfully registered";
                haircut.getLeyenda().setText(leyend);
                }
            } 
        }
    }
    private String capturegender(ButtonGroup sex){
         String sexo = null;
         
          for (Enumeration<AbstractButton > buttons = sex.getElements(); buttons.hasMoreElements();)
            {
                   AbstractButton button = buttons.nextElement();
                  if(button.isSelected())
                    {
                       sexo = button.getText();
                   }
             } 
          return sexo;
     }
    private boolean validate(){
        boolean validate = false;
         if(haircut.getStyle().getText().contains("  ") || haircut.getStyle().getText().length() < 4){
                String leyend = "Remember that the style can not have less than 4 characters and or contain several blank spaces";
                haircut.getLeyenda().setText(leyend);
         }else if(haircut.getPrice().getText().isEmpty()){
             String leyend = "The price can not be empty";
                haircut.getLeyenda().setText(leyend);
         }else if(!haircut.getGender().isSelected(haircut.getFemale().getModel()) && !haircut.getGender().isSelected(haircut.getMale().getModel())){
             String leyend = "You must select a genre of style";
             haircut.getLeyenda().setText(leyend);
         }else{
             validate = true;
         }
        
        return validate;
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        Object kevent = ke.getSource();
        if(kevent.equals(hair.getCathaircut())){
            char b = ke.getKeyChar();
            if(hair.getTextsearch().getText().length()>50){
                ke.consume();
            }
        }else if(kevent.equals(haircut.getPrice())){
            char b = ke.getKeyChar();
            if(!Character.isDigit(b) || haircut.getPrice().getText().length() > 10){
                ke.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
      
    }

    @Override
    public void keyReleased(KeyEvent ke) {
         Object origen = ke.getSource();
        if(origen.equals(hair.getTextsearch())){
            String search = hair.getTextsearch().getText();
            ListingSearch(search,hair.getCathaircut());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
           Object Mevent = me.getSource();
        if(Mevent.equals(hair.getCathaircut())){
            if (me.getClickCount() == 2) {
            try{
                int row = hair.getCathaircut().getSelectedRow();
                int row1 = hair.getCathaircut().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) hair.getCathaircut().getModel();
                String captura = (String) modelotabla.getValueAt(row1, 0);
                Capturedata(captura);
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
