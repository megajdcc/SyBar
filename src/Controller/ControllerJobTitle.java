/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.JobTitle;
import Model.Position;
import View.Principal;
import View.Rjobtitle;
import View.Vjobtitle;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jnatn'h
 */
public class ControllerJobTitle implements ActionListener,KeyListener,MouseListener {

    DefaultTableModel dm;
    private Vjobtitle vjob;
    private Rjobtitle jobtitle;
    private JobTitle model;
    private Position modelposition;
    private Principal principal;
    public ControllerJobTitle(Vjobtitle v){
        this.vjob = v;
        model = new JobTitle();
        modelposition = new Position();
        
        this.Tolist();
      
    }
    private void listarpositiones(DefaultComboBoxModel modeloCombo){
        boolean result= false;
        result = modelposition.listPosition(modeloCombo);
     
     }
      private void Tolist(){
        String[][] information =  model.consultList();
        vjob.getCatjobtitle().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Job Title","Position"}) {
        boolean[] canEdit = new boolean [] {
            false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    vjob.getCatjobtitle().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void ListadoBusqueda(String consulta, JTable JTableBuscar){
     
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void Capturedata(String name){
     
           boolean encontrado = model.consultModel(name);
           if (encontrado){
                vjob.dispose();
                vjob.setVisible(false);
                    jobtitle = new Rjobtitle(principal, true);
                    jobtitle.setController(this);
                    DefaultComboBoxModel cb = (DefaultComboBoxModel) jobtitle.getPosition().getModel();
                    this.listarpositiones(cb);
                    modelposition.capturarName(model.getIdposition());
                    jobtitle.getPosition().setSelectedItem(modelposition.getPosition());
                    jobtitle.getJobtitle().setText(model.getJobName());
                
                    jobtitle.getDelete().setEnabled(true);
                    jobtitle.getDelete().setVisible(true);
                    jobtitle.getPrint().setVisible(false);
                    jobtitle.setController(this);
                    jobtitle.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Job Title",JOptionPane.INFORMATION_MESSAGE);
            }
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        if(evento.equals(vjob.getNuevo())){
            vjob.setVisible(false);
            vjob.dispose();
            jobtitle = new Rjobtitle(principal, true);
            jobtitle.setController(this);
            DefaultComboBoxModel cm = (DefaultComboBoxModel) jobtitle.getPosition().getModel();
            this.listarpositiones(cm);
            jobtitle.getPrint().setVisible(false);
            jobtitle.getDelete().setVisible(false);
            jobtitle.setVisible(true);
        }else if(evento.equals(jobtitle.getExit())){
            jobtitle.setVisible(false);
            jobtitle.dispose();
            jobtitle.getPosition().removeAllItems();
            
            
            vjob = new Vjobtitle(principal,true);
            vjob.setController(this);
            this.Tolist();
            vjob.setVisible(true);
            
        }else if(evento.equals(jobtitle.getDelete())){
            this.delete();
        }else if(evento.equals(jobtitle.getGrabar())){
            this.validar();
        }
    }
    private void validar(){
        String jobtitl = jobtitle.getJobtitle().getText().toString();
        if(jobtitle.getPosition().getSelectedItem().toString().equalsIgnoreCase("Select")){
                String leyend = "You must select a work position";
                jobtitle.getLeyenda().setText(leyend);
            }else if(jobtitl.length()<4){
                String leyend = "The job title must not be empty or less than 4 characters";
                jobtitle.getLeyenda().setText(leyend);
            }else{
                this.grabar();
            }
    }
    private void grabar(){
        if(model.getId() >0){
            model.setJobName(jobtitle.getJobtitle().getText().trim());
            int idposition = modelposition.captureId(jobtitle.getPosition().getSelectedItem().toString());
            if(idposition !=0){
                model.setIdposition(idposition);
                  boolean result = model.updateJob();
              if(result){
                  String leyend = "The job title has been modified successfully";
                  model.setId(0);
                  jobtitle.getLeyenda().setText(leyend);
                  jobtitle.getPosition().setSelectedItem("Seleccione");
                  jobtitle.getJobtitle().setText("");
                  jobtitle.getDelete().setVisible(false);
              }  
              }else{
                  String leyend = "The job title has not been modified successfully";
                  jobtitle.getLeyenda().setText(leyend);
                  jobtitle.getLeyenda().setForeground(Color.RED);
              }
        }else{
            model.setJobName(jobtitle.getJobtitle().getText().trim());
            int idposition = modelposition.captureId(jobtitle.getPosition().getSelectedItem().toString());
            if(idposition !=0){
                model.setIdposition(idposition);
                  boolean result = model.insertJob();
              if(result){
                  String leyend = "The job title has been succesfully registered";
                  
                  jobtitle.getLeyenda().setText(leyend);
                  jobtitle.getPosition().setSelectedItem("Seleccione");
                  jobtitle.getJobtitle().setText("");
                  jobtitle.getDelete().setVisible(false);
              }  
              }else{
                  String leyend = "The job title has not been succesfully registered";
                  jobtitle.getLeyenda().setText(leyend);
                  jobtitle.getLeyenda().setForeground(Color.RED);
              }
        }
    }
    private void delete(){
          boolean result = model.deleteJob();
          if(result){
              jobtitle.setVisible(false);
              jobtitle.dispose();
              vjob.dispose();
              vjob = new Vjobtitle(principal,true);
              vjob.setController(this);
              this.Tolist();
              vjob.setVisible(true);
          }else{
              String leyend = "Can not be deleted "+ jobtitle.getJobtitle().getText() + ", is being used somewhere else";
          }
    }
    @Override
    public void keyTyped(KeyEvent ke) {
          Object kevent = ke.getSource();
        if(kevent.equals(vjob.getCatjobtitle())){
            char b = ke.getKeyChar();
            if(vjob.getTextbusqueda().getText().length()>50){
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
        if(origin.equals(vjob.getTextbusqueda())){
            String search = vjob.getTextbusqueda().getText();
            ListadoBusqueda(search,vjob.getCatjobtitle());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       Object Mevent = me.getSource();
        if(Mevent.equals(vjob.getCatjobtitle())){
            if (me.getClickCount() == 2) {
            try{
                int row = vjob.getCatjobtitle().getSelectedRow();
                int row1 = vjob.getCatjobtitle().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) vjob.getCatjobtitle().getModel();
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
